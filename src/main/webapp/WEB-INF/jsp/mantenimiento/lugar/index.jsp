<%-- 
    Document   : index.jsp
    Created on : 05/11/2015, 12:16:36 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<div class="container">
    <h1>Lugar</h1>
    <hr />
    <div class="row">
        <div class="col-md-offset-1 col-md-3">
            <p id="error-message" class="alert alert-danger" style="display: none;"></p>
            <form id="form-lugar" method="POST">
                <input id="id" type="hidden" name="id" />
                <div class="form-group">
                    <label for="pais">Pais</label>
                    <input id="pais" type="text" name="pais" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="estado">Region/Estado</label>
                    <input id="estado" type="text" name="estado" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="ciudad">Ciudad</label>
                    <input id="ciudad" type="text" name="ciudad" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="distrito">Distrito</label>
                    <input id="distrito" type="text" name="distrito" class="form-control" />
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
                            <th>Pais</th>
                            <th>Region/Estado</th>
                            <th>Ciudad</th>
                            <th>Distrito</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="lugar" items="${paginacion.items}">
                            <tr>
                                <td>${lugar.pais}</td>
                                <td>${lugar.estado}</td>
                                <td>${lugar.ciudad}</td>
                                <td>${lugar.distrito}</td>
                                <td class="text-center pointer">
                                    <span regId="${lugar.id}" class="glyphicon glyphicon-edit edited"></span>
                                    <span regId="${lugar.id}" class="glyphicon glyphicon-remove deleted"></span>
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
    var path = '${cp}/mantenimiento/lugar/';
    var paginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    }
</script>
<script src="${cp}/resources/js/mantenimiento/lugar.js"></script>