<%-- 
    Document   : programarviaje
    Created on : 04/12/2015, 02:09:11 AM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <h1>Programar viaje</h1>
    <hr />
    <div class="row">
        <div class="col-md-offset-1 col-md-3">
            <p id="error-message" class="alert alert-danger" style="display: none;"></p>
            <form id="form-programaviaje">
                <input id="id" type="hidden" name="id" />
                <div class="form-group">
                    <label for="origen">Origen</label>
                    <div class="input-group">
                        <input id="origenId" type="hidden" name="origenId" />
                        <input id="origenNombre" type="text" class="form-control" placeholder="Origen" disabled="true">
                        <span class="input-group-btn">
                            <button id="searchOrigen" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="destino">Destino</label>
                    <div class="input-group">
                        <input id="destinoId" type="hidden" name="destinoId" />
                        <input id="destinoNombre" type="text" class="form-control" placeholder="Destino" disabled="true">
                        <span class="input-group-btn">
                            <button id="searchDestino" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="precio">Precio</label>
                    <input id="precio" min="0.01" step="0.01" type="number" name="precio" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="fecha">Fecha</label>
                    <input id="fecha" type="text" name="fecha" class="form-control datepicker" />
                </div>
                <div class="form-group">
                    <label for="hora">Hora</label>
                    <div class="bootstrap-timepicker timepicker">
                        <input id="hora" type="time" name="hora" class="form-control input-small">
                    </div>
                </div>
                <div class="form-group">
                    <label for="bus">Bus</label>
                    <div class="input-group">
                        <input id="busId" type="hidden" name="busId" />
                        <input id="busNombre" type="text" class="form-control" placeholder="Origen" disabled="true">
                        <span class="input-group-btn">
                            <button id="searchBus" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
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
                            <th>Origen</th>
                            <th>Destino</th>
                            <th>Precio</th>
                            <th>Fecha</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="viaje" items="${paginacion.items}">
                            <tr>
                                <td>${viaje.origen.estacionTrabajo.nombre}</td>
                                <td>${viaje.destino.estacionTrabajo.nombre}</td>
                                <td>${viaje.precio}</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy hh:mm a" value="${viaje.partida}"  /></td>
                                <td class="text-center pointer">
                                    <!-- <span regId="${viaje.id}" class="glyphicon glyphicon-edit edited"></span> -->
                                    <span regId="${viaje.id}" class="glyphicon glyphicon-remove deleted"></span>
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
<%@include file="/WEB-INF/jsp/buscador/agencia.jsp" %>
<%@include file="/WEB-INF/jsp/buscador/bus.jsp" %>
<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
    var path = '${cp}/procesos/programarviaje/';
    var pathAgencia = '${cp}/mantenimiento/agencia/';
    var pathBus = '${cp}/mantenimiento/bus/';
    
    var paginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    };
    
</script>
<script src="${cp}/resources/js/procesos/programarviaje.js"></script>
<script src="${cp}/resources/js/buscador/buscadorAgencia.js"></script>
<script src="${cp}/resources/js/buscador/buscadorBus.js"></script>
 