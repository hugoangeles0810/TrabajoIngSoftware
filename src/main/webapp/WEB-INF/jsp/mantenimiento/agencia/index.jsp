<%-- 
    Document   : index
    Created on : 28/11/2015, 01:59:45 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<div class="container">
    <h1>Agencia</h1>
    <hr />
    <div class="row">
        <div class="col-md-offset-1 col-md-3">
            <p id="error-message" class="alert alert-danger" style="display: none;"></p>
            <form id="form-agencia">
                <input id="id" type="hidden" name="id" />
                <div class="form-group">
                    <label for="estacionTrabajo">Estación de trabajo</label>
                    <div class="input-group">
                        <input id="estacionId" type="hidden" name="estacion" />
                        <input id="estacionNombre" type="text" class="form-control" placeholder="Estación de trabajo" disabled="true">
                        <span class="input-group-btn">
                            <button id="searchEstacion" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="aforo">Aforo</label>
                    <input id="aforo" type="number" min="0" step="1" name="aforo" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="capacidadbus">Capacidad de buses</label>
                    <input id="capacidadbus" type="number" min="0" step="1" name="capacidadbus" class="form-control" />
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
                            <th>Nombre</th>
                            <th>Aforo</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="agencia" items="${paginacion.items}">
                            <tr>
                                <td>${agencia.estacionTrabajo.nombre}</td>
                                <td>${agencia.aforo}</td>
                                <td class="text-center pointer">
                                    <span regId="${agencia.id}" class="glyphicon glyphicon-edit edited"></span>
                                    <span regId="${agencia.id}" class="glyphicon glyphicon-remove deleted"></span>
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
<%@include file="/WEB-INF/jsp/buscador/estacion.jsp" %>
<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
    var path = '${cp}/mantenimiento/agencia/';
    var pathEstacion = '${cp}/mantenimiento/estaciontrabajo/';
    var paginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    };
</script>
<script src="${cp}/resources/js/mantenimiento/agencia.js"></script>
<script src="${cp}/resources/js/buscador/buscadorEstacion.js"></script>
