<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn nbtn-light btn-block">
                    <i class="fas fa-arrow-left"></i>Regresar al inicio
                </a>
            </div>
            <div>
                <div class="col-md-3">
                    <button type="submit" class="btn btn-success btn-block">
                        <i class="fas fa-check"></i>Guardar Estudiante
                    </button>
                </div>
                <div class="col-md-3">
                    <a href="${pageContext.request.conextPath}/ServletControlador?accion=eliminar&idEstudiante=${estudiante.idEstudiante}"
                       class="btn btn-danger btn-block">
                    </a>
                       <i class="fas fa-trash"></i>Eliminar Estudiante
                </div>
            </div>
        </div>
    </div>
    
</section>