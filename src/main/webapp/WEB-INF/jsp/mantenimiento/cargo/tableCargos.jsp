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
                <th>Nombre</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cargo" items="${paginacion.items}">
                <tr onclick="bCargoSelected(${cargo.id}, '${cargo.nombre}')" class="pointer">
                    <td>${cargo.nombre}</td>
                </tr>
            </c:forEach> 
        </tbody>
    </table>
    <div class="text-center">
        <nav>
            <ul class="pager">
                <li>
                    <a id="bLugarInicio" onclick="bCargoInicio();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-fast-backward"></span>
                    </a>
                </li>
                <li>
                    <a id="bLugarAnterior" onclick="bCargoAnterior();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-backward"></span>
                    </a>
                </li>
                <li>
                    &nbsp; ${paginacion.page} / ${paginacion.totalPage} <span class="page-text">paginas &nbsp;</span>
                </li>
                <li>
                    <a id="bLugarSiguiente" onclick="bCargoSiguiente();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-forward"></span>
                    </a>
                </li>
                <li>
                    <a id="bLugarFin" onclick="bCargoFin();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-fast-forward"></span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<script>
    var bCargoPaginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    }
</script>
