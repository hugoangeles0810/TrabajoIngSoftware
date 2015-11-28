<%-- 
    Document   : index
    Created on : 27/11/2015, 09:23:49 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<div class="container">
    <h1>Trabajador</h1>
    <hr />
    <div class="row">
        <div class="col-md-offset-1 col-md-3">
            <p id="error-message" class="alert alert-danger" style="display: none;"></p>
            <form id="form-trabajador">
                <input id="id" type="hidden" name="id" />
                <div class="form-group">
                    <label for="dni">DNI</label>
                    <input id="dni" type="text" name="dni" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input id="nombre" type="text" name="nombre" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="apellidos">Apellidos</label>
                    <input id="apellidos" type="text" name="apellidos" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="fechaNacimiento">Fecha Nacimiento</label>
                    <input id="fechaNacimiento" type="text" name="fechaNacimiento" class="form-control datepicker" />
                </div>
                <div class="form-group">
                    <label for="direccion">Dirección</label>
                    <input id="direccion" type="text" name="direccion" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="telefono">Telefono</label>
                    <input id="telefono" type="text" name="telefono" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="cargo">Cargo</label>
                    <div class="input-group">
                        <input id="cargoId" type="hidden" name="cargo" />
                        <input id="cargoNombre" type="text" class="form-control" placeholder="Cargo" disabled="true">
                        <span class="input-group-btn">
                            <a id="searchCargo" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></a>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="fechaIngreso">Fecha Ingreso</label>
                    <input id="fechaIngreso" type="text" name="fechaIngreso" class="form-control datepicker" />
                </div>
                <div class="form-group">
                    <label for="estacionTrabajo">Estación de trabajo</label>
                    <div class="input-group">
                        <input id="estacionId" type="hidden" name="estacion" />
                        <input id="estacionNombre" type="text" class="form-control" placeholder="Estación de trabajo" disabled="true">
                        <span class="input-group-btn">
                            <a id="searchEstacion" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></a>
                        </span>
                    </div>
                </div>
                <div class="text-center">
                    <input type="reset" value="Limpiar" class="btn btn-default" />
                    <input type="submit" value="Guardar" class="btn btn-success" />
                </div>
            </form>
        </div>
        <div class="col-md-offset-1 col-md-5">
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr class="info">
                            <th>DNI</th>
                            <th>Apellidos</th>
                            <th>Nombre</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="trabajador" items="${paginacion.items}">
                            <tr>
                                <td>${trabajador.persona.dni}</td>
                                <td>${trabajador.persona.apellidos}</td>
                                <td>${trabajador.persona.nombre}</td>
                                <td class="text-center pointer">
                                    <span regId="${trabajador.id}" class="glyphicon glyphicon-edit edited"></span>
                                    <span regId="${trabajador.id}" class="glyphicon glyphicon-remove deleted"></span>
                                </td>
                            </tr>
                        </c:forEach> 
                    </tbody>
                </table>
                <div class="text-center">
                    <nav>
                        <ul class="pager">
                            <li>
                                <a id="inicio" href="javascript:void(0);">
                                    <span class="glyphicon glyphicon-fast-backward"></span>
                                </a>
                            </li>
                            <li>
                                <a id="anterior" href="javascript:void(0);">
                                    <span class="glyphicon glyphicon-backward"></span>
                                </a>
                            </li>
                            <li>
                                &nbsp; ${paginacion.page} / ${paginacion.totalPage} <span class="page-text">paginas &nbsp;</span>
                            </li>
                            <li>
                                <a id="siguiente" href="javascript:void(0);">
                                    <span class="glyphicon glyphicon-forward"></span>
                                </a>
                            </li>
                            <li>
                                <a id="fin" href="javascript:void(0);">
                                    <span class="glyphicon glyphicon-fast-forward"></span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/jsp/buscador/cargo.jsp" %>
<%@include file="/WEB-INF/jsp/buscador/estacion.jsp" %>
<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
    var path = '${cp}/mantenimiento/trabajador/';
    var pathCargo = '${cp}/mantenimiento/cargo/';
    var pathEstacion = '${cp}/mantenimiento/estaciontrabajo/';
    var paginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    };
</script>
<script src="${cp}/resources/js/mantenimiento/trabajador.js"></script>
<script src="${cp}/resources/js/buscador/buscadorCargo.js"></script>
<script src="${cp}/resources/js/buscador/buscadorEstacion.js"></script>
