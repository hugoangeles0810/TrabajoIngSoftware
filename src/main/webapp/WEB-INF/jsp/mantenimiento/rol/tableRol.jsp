<%-- 
    Document   : tableRoles
    Created on : 28/11/2015, 10:21:26 AM
    Author     : CARLOS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table-responsive">
    <table class="table table-bordered table-hover">
        <thead>
            <tr class="info">
                <th>Nombre</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="rol" items="${paginacion.items}">
                <tr onclick="bRolSelected(${rol.id}, '${rol.nombre}')" class="pointer">
                    <td>${rol.nombre}</td>
                </tr>
            </c:forEach> 
        </tbody>
    </table>
    <div class="text-center">
        <nav>
            <ul class="pager">
                <li>
                    <a id="bRolInicio" onclick="bRolInicio();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-fast-backward"></span>
                    </a>
                </li>
                <li>
                    <a id="bRolAnterior" onclick="bRolAnterior();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-backward"></span>
                    </a>
                </li>
                <li>
                    &nbsp; ${paginacion.page} / ${paginacion.totalPage} <span class="page-text">paginas &nbsp;</span>
                </li>
                <li>
                    <a id="bRolSiguiente" onclick="bRolSiguiente();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-forward"></span>
                    </a>
                </li>
                <li>
                    <a id="bRolFin" onclick="bRolFin();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-fast-forward"></span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<script>
    var bRolPaginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    }
</script>

