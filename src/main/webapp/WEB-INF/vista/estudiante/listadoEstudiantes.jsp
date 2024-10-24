><!-- permite hacer dos operaciones como si fuera java atraves del jsp -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es MX"/>

<section id="estudiantes" class="">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Estudiantes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thehead-dark">
                            <tr>
                                <th>N�</th>
                                <th>Nombre</th>
                                <th>Edad</th>
                            </tr>
                            
                        </thead>
                        <tbody>
                            <c:forEach var="estudiante" items="${estudiantes}" varStatus="status">
                                <tr>
                                    <td>${status.Count}</td>
                                    <td>${estudiante.nombre} ${estudiante.apellido}</td>
                                    <td><fmt:formatNumber value="${estudiante.edad}"/></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador? accion=editar&idEstudiante=${estudiante.idEstudiante}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right">Editar</i>
                                        </a>
                                        
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>                        
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Estudantes</h3>
                        <<h4 class="display-4">
                            <i class="fas fa-graduation-cap"></i>${totalEstudiantes}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="agregarEstudiante.jsp"/>

                        
                        