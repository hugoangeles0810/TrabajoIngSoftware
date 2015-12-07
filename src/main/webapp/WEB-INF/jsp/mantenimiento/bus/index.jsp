<%-- 
    Document   : index
    Created on : 03/12/2015, 03:16:56 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<div class="container">
    <h1>Bus</h1>
    <hr />
    <div class="row">
        <div class="col-md-offset-1 col-md-3">
            <p id="error-message" class="alert alert-danger" style="display: none;"></p>
            <form id="form-bus">
                <input id="id" type="hidden" name="id" />
                <div class="form-group">
                    <label for="placa">Placa</label>
                    <input id="placa" type="text" name="placa" maxlength="8" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="anio">Año</label>
                    <input id="anio" type="text" name="anio" maxlength="4" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="estado">Estado</label>
                    <select id="estado" name="estado" class="form-control">
                        <option value="O">Ocupado</option>
                        <option value="D">Desocupado</option>
                        <option value="B">Baja</option>
                        <option value="A">Averiado</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="modelobus">Modelo de bus</label>
                    <div class="input-group">
                        <input id="modelobusId" type="hidden" name="modelobus" />
                        <input id="modelobusNombre" type="text" class="form-control" placeholder="Modelo de bus" disabled="true">
                        <span class="input-group-btn">
                            <button id="searchModelobus" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="agencia">Agencia</label>
                    <div class="input-group">
                        <input id="agenciaId" type="hidden" name="agencia" />
                        <input id="agenciaNombre" type="text" class="form-control" placeholder="Agencia" disabled="true">
                        <span class="input-group-btn">
                            <button id="searchAgencia" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
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
            <form id="form-filtrar">
                <div class="input-group">
                    <input id="search" type="text" class="form-control" placeholder="Placa" value="${paginacion.search}">
                    <span class="input-group-btn">
                        <button class="btn btn-info"><span class="glyphicon glyphicon-search"></span></button>
                    </span>
                </div>
            </form>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr class="info">
                            <th>Placa</th>
                            <th>Año</th>
                            <th>Modelo</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="bus" items="${paginacion.items}">
                            <tr>
                                <td>${bus.placa}</td>
                                <td>${bus.ano}</td>
                                <td>${bus.modeloBus.nombre}</td>
                                <td class="text-center pointer">
                                    <span regId="${bus.id}" class="glyphicon glyphicon-edit edited"></span>
                                    <span regId="${bus.id}" class="glyphicon glyphicon-remove deleted"></span>
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
<%@include file="/WEB-INF/jsp/buscador/modelobus.jsp" %>
<%@include file="/WEB-INF/jsp/buscador/agencia.jsp" %>
<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
    var path = '${cp}/mantenimiento/bus/';
    var pathModeloBus = '${cp}/mantenimiento/modelobus/';
    var pathAgencia = '${cp}/mantenimiento/agencia/';
    var paginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    };
</script>
<script src="${cp}/resources/js/mantenimiento/bus.js"></script>
<script src="${cp}/resources/js/buscador/buscadorModeloBus.js"></script>
<script src="${cp}/resources/js/buscador/buscadorAgencia.js"></script>
