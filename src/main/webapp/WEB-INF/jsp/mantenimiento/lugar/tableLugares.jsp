<%-- 
    Document   : tableLugares
    Created on : 22/11/2015, 02:34:25 PM
    Author     : Hugo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="table-responsive">
    <table class="table table-bordered table-hover">
        <thead>
            <tr class="info">
                <th>Pais</th>
                <th>Region/Estado</th>
                <th>Ciudad</th>
                <th>Distrito</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="lugar" items="${paginacion.items}">
                <tr onclick="bLugarSelected(${lugar.id}, '${lugar.ciudad}')" class="pointer">
                    <td>${lugar.pais}</td>
                    <td>${lugar.estado}</td>
                    <td>${lugar.ciudad}</td>
                    <td>${lugar.distrito}</td>
                </tr>
            </c:forEach> 
        </tbody>
    </table>
    <div class="text-center">
        <nav>
            <ul class="pager">
                <li>
                    <a id="bLugarInicio" onclick="bLugarInicio();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-fast-backward"></span>
                    </a>
                </li>
                <li>
                    <a id="bLugarAnterior" onclick="bLugarAnterior();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-backward"></span>
                    </a>
                </li>
                <li>
                    &nbsp; ${paginacion.page} / ${paginacion.totalPage} <span class="page-text">paginas &nbsp;</span>
                </li>
                <li>
                    <a id="bLugarSiguiente" onclick="bLugarSiguiente();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-forward"></span>
                    </a>
                </li>
                <li>
                    <a id="bLugarFin" onclick="bLugarFin();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-fast-forward"></span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<script>
    var bLugarPaginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    }
</script>
