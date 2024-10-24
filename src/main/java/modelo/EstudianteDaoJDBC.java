package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADALBERTO
 */
//encargada de hacer las operaciones de tipo crud
public class EstudianteDaoJDBC {

    // Consultas SQL para hacer las operaciones CRUD
    private static final String SQL_SELECT
            = "SELECT id_estudiante, nombre, apellido, email, telefono, edad FROM estudiante";
    private static final String SQL_SELECT_BY_ID
            = "SELECT id_estudiante, nombre, apellido, email, telefono, edad FROM estudiante WHERE id_estudiante=?";
    private static final String SQL_INSERT
            = "INSERT INTO estudiante(nombre, apellido, email, telefono, edad) values(?,?,?,?,?)";
    private static final String SQL_UPDATE
            = "UPDATE estudiante SET nombre=?, apellido=?, email=?, telefono=?, edad=? WHERE id_estudiante=?";
    private static final String SQL_DELETE
            = "DELETE FROM estudiante WHERE id_estudiante=?";

    // Método para obtener la lista completa de estudiantes
    public List<Estudiante> listar() {
        List<Estudiante> estudiantes = new ArrayList<>();
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_SELECT); ResultSet rs = stmt.executeQuery();) {

            while (rs.next()) {
                int idEstudiante = rs.getInt("id_estudiante");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double edad = rs.getDouble("edad");
                Estudiante estudiante = new Estudiante(idEstudiante, nombre, apellido, email, telefono, edad);
                estudiantes.add(estudiante);

            }
        } catch (Exception e) {

            System.out.println("Error al listar los estudiantes" + e.getMessage());
        }
        return estudiantes;
    }

    public Estudiante buscar(Estudiante estudiante) {
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_BY_ID);) {
            stmt.setInt(1, estudiante.getIdEstudiante());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String email = rs.getString("email");
                    String telefono = rs.getString("telefono");
                    double edad = rs.getDouble("edad");
                    estudiante.setNombre(nombre);
                    estudiante.setApellido(apellido);
                    estudiante.setEmail(email);
                    estudiante.setTelefono(telefono);
                    estudiante.setEdad(edad);
                    
                }
            }

        } catch (Exception e) {
            System.out.println("Error al buscar estudiante "+e.getMessage());
        }
        return estudiante;
    }
    
    public int insertar(Estudiante estudiante){
        int rows =0;
        try (Connection conn = Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)){
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setString(3, estudiante.getEmail());
            stmt.setString(4, estudiante.getTelefono());
            stmt.setDouble(5, estudiante.getEdad());
            
            rows = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al insertar estudiante");
        }
        return rows;
    }
    public int actualizar(Estudiante estudiante){
        int rows=0;
        try(Connection conn= Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {
            stmt.setString(1, estudiante.getNombre());
            stmt.setString(2, estudiante.getApellido());
            stmt.setString(3, estudiante.getEmail());
            stmt.setString(4, estudiante.getTelefono());
            stmt.setDouble(5, estudiante.getEdad());
            stmt.setInt(6, estudiante.getIdEstudiante());
            
            rows = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al actualizar el estudiante"+e.getMessage());
        }
        return rows;
    }
    public int eliminar(Estudiante estudiante){
        int rows = 0;
        try (Connection conn= Conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)){
            stmt.setInt(1, estudiante.getIdEstudiante());
            rows=stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar el estudiante"+e.getMessage());
        }
        return  rows;
    }
}
