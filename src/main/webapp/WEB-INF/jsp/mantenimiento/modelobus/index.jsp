<%-- 
    Document   : index
    Created on : 01/12/2015, 01:36:39 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<div class="container">
    <h1>Modelo bus</h1>
    <hr />
    <div class="row">
        <div class="col-md-offset-1 col-md-3">
            <p id="error-message" class="alert alert-danger" style="display: none;"></p>
            
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
              <li role="presentation" class="active"><a href="#modelo" aria-controls="modelo" role="tab" data-toggle="tab">Modelo</a></li>
              <li role="presentation"><a href="#pisos" aria-controls="pisos" role="tab" data-toggle="tab">Pisos</a></li>
              <li role="presentation"><a href="#servicios" aria-controls="servicios" role="tab" data-toggle="tab">Servicios</a></li>
            </ul>
            
            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="modelo">
                    <br>
                    <form id="form-modelobus">
                        <input id="id" type="hidden" name="id" />
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input id="nombre" type="text" name="nombre" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label for="compartimientoComida">Compartimiento de comida</label>
                            <input id="compartimientoComida" type="checkbox" name="compartimientoComida" class="checkbox" />
                        </div>
                        <div class="form-group">
                            <label for="capacidadbodega">Capacidad de bodega</label>
                            <input id="capacidadbodega" min="0.00" step="0.01" type="number" name="capacidadbodega" class="form-control" />
                        </div>
                        <div class="text-center">
                            <input type="reset" value="Limpiar" class="btn btn-default" />
                            <input type="submit" value="Guardar" class="btn btn-success" />
                        </div>
                    </form>
                </div>
                <div role="tabpanel" class="tab-pane" id="pisos">
                    <br>
                    <div class="form-group">
                        <label for="numPiso">Piso</label>
                        <input id="numPiso" min="1" step="1" type="number" name="numPiso" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="numAsientos">Num. Asientos</label>
                        <input id="numAsientos" min="1" step="1" type="number" name="numAsientos" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="sshh">SSHH</label>
                        <input id="sshh" type="checkbox" name="sshh" class="checkbox" />
                    </div>
                    <div class="text-center">
                        <button id="agregar-piso" class="btn btn-default">Agregar</button>
                    </div>
                    <br>
                    <table class="table table-hover table-bordered">
                        <thead>
                            <tr class="info">
                                <th>Piso</th>
                                <th>Num. Asientos</th>
                                <th>SSHH</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="table-content-pisos">
                            
                        </tbody>
                    </table>
                </div>
                <div role="tabpanel" class="tab-pane" id="servicios">
                    <br>
                    Servicios
                </div>
            </div>
        </div>
        <div class="col-md-offset-1 col-md-5">
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr class="info">
                            <th>Nombre</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="modelo" items="${paginacion.items}">
                            <tr>
                                <td>${modelo.nombre}</td>
                                <td class="text-center pointer">
                                    <span regId="${modelo.id}" class="glyphicon glyphicon-edit edited"></span>
                                    <span regId="${modelo.id}" class="glyphicon glyphicon-remove deleted"></span>
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
<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
    var path = '${cp}/mantenimiento/modelobus/';
    var paginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    };
</script>
<script src="${cp}/resources/js/mantenimiento/modelobus.js"></script>
