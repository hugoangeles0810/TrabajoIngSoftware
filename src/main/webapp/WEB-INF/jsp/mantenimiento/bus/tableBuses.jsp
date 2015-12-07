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
                <th>Modelo</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="bus" items="${paginacion.items}">
                <tr onclick="bBusSelected(${bus.id}, '${bus.placa}')" class="pointer">
                    <td>${bus.placa}</td>
                    <td>${bus.modeloBus.nombre}</td>
                    
                </tr>
            </c:forEach> 
        </tbody>
    </table>
    <div class="text-center">
        <nav>
            <ul class="pager">
                <li>
                    <a id="bLugarInicio" onclick="bBusInicio();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-fast-backward"></span>
                    </a>
                </li>
                <li>
                    <a id="bLugarAnterior" onclick="bBusAnterior();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-backward"></span>
                    </a>
                </li>
                <li>
                    &nbsp; ${paginacion.page} / ${paginacion.totalPage} <span class="page-text">paginas &nbsp;</span>
                </li>
                <li>
                    <a id="bLugarSiguiente" onclick="bBusSiguiente();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-forward"></span>
                    </a>
                </li>
                <li>
                    <a id="bLugarFin" onclick="bBusFin();" href="javascript:void(0);">
                        <span class="glyphicon glyphicon-fast-forward"></span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<script>
    var bBusPaginacion = {
        page: ${paginacion.page},
        size: ${paginacion.size},
        search: '${paginacion.search}',
        totalPage: ${paginacion.totalPage}
    }
</script>
