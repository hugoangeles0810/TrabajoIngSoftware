<%-- 
    Document   : index.jsp
    Created on : 22/11/2015, 12:20:30 AM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<div class="container">
    <h1>Estación de trabajo</h1>
    <hr />
    <div class="row">
        <div class="col-md-offset-1 col-md-3">
            <p id="error-message" class="alert alert-danger" style="display: none;"></p>
            <form id="form-estacion">
                <input id="id" type="hidden" name="id" />
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <input id="nombre" type="text" name="nombre" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="direccion">Dirección</label>
                    <input id="direccion" type="text" name="direccion" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="lugar">Lugar</label>
                    <div class="input-group">
                        <input id="lugarId" type="hidden" name="lugar" />
                        <input id="lugarNombre" type="text" class="form-control" placeholder="Lugar" disabled="true">
                        <span class="input-group-btn">
                            <button id="searchLugar" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
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
                            <th>Nombre</th>
                            <th>Dirección</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="estacion" items="${paginacion.items}">
                            <tr>
                                <td>${estacion.nombre}</td>
                                <td>${estacion.direccion}</td>
                                <td class="text-center">
                                    <span regId="${estacion.id}" class="glyphicon glyphicon-edit edited pointer"></span>
                                    <span regId="${estacion.id}" class="glyphicon glyphicon-remove deleted pointer"></span>
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
                            
<%@include file="../../buscador/lugar.jsp"  %>
                            
<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
    var path = '${cp}/mantenimiento/estaciontrabajo/';
    var pathLugar = '${cp}/mantenimiento/lugar/';
    var paginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    }
</script>
<script src="${cp}/resources/js/mantenimiento/estaciontrabajo.js"></script>
