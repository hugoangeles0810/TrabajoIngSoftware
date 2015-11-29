<%-- 
    Document   : index
    Created on : 28/11/2015, 05:41:20 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<div class="container">
    <h1>Usuario</h1>
    <hr />
    <div class="row">
        <div class="col-md-offset-1 col-md-3">
            <p id="error-message" class="alert alert-danger" style="display: none;"></p>
            <form id="form-usuario">
                <input id="id" type="hidden" name="id" />
                <div class="form-group">
                    <label for="searchTrabajador">Trabajador</label>
                    <div class="input-group">
                        <input id="trabajadorId" type="hidden" name="trabajador" />
                        <input id="trabajadorNombre" type="text" class="form-control" placeholder="Trabajador" disabled="true">
                        <span class="input-group-btn">
                            <button id="searchTrabajador" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="searchRol">Rol</label>
                    <div class="input-group">
                        <input id="rolId" type="hidden" name="rol" />
                        <input id="rolNombre" type="text" class="form-control" placeholder="Rol" disabled="true">
                        <span class="input-group-btn">
                            <button id="searchRol" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                        </span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="usuario">Usuario</label>
                    <input id="usuario" type="text" name="usuario" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="clave">Clave</label>
                    <input id="clave" type="password" name="clave" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="claveConfirma">Confirma clave</label>
                    <input id="claveConfirma" type="password" class="form-control" />
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
                            <th>Usuario</th>
                            <th>DNI</th>
                            <th>Apellidos</th>
                            <th>Nombre</th>
                            <th>Rol</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${paginacion.items}">
                            <tr>
                                <td>${usuario.usuario}</td>
                                <td>${usuario.trabajador.persona.dni}</td>
                                <td>${usuario.trabajador.persona.apellidos}</td>
                                <td>${usuario.trabajador.persona.nombre}</td>
                                <td>${usuario.rol.nombre}</td>
                                <td class="text-center">
                                    <span regId="${usuario.id}" class="glyphicon glyphicon-edit edited pointer"></span>
                                    <span regId="${usuario.id}" class="glyphicon glyphicon-remove deleted pointer"></span>
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
<%@include file="/WEB-INF/jsp/buscador/trabajador.jsp" %>                        
<%@include file="/WEB-INF/jsp/buscador/rol.jsp" %>                        
<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
    var path = '${cp}/mantenimiento/usuario/';
    var pathTrabajador = '${cp}/mantenimiento/trabajador/';
    var pathRol = '${cp}/mantenimiento/rol/';
    var paginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    }
</script>
<script src="${cp}/resources/js/mantenimiento/usuario.js"></script>
<script src="${cp}/resources/js/buscador/buscadorTrabajador.js"></script>
<script src="${cp}/resources/js/buscador/buscadorRol.js"></script>

