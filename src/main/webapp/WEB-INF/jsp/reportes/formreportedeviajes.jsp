<%-- 
    Document   : formreportedeviajes
    Created on : 06/12/2015, 08:09:33 PM
    Author     : Hugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/include/header.jsp" %>
<div class="container">
    <h1>Reporte Viajes programados</h1>
    <hr />
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
            <p id="error-message" class="alert alert-danger" style="display: none;"></p>
            <form id="form-reporte" class="form-inline" action="reporteviajesprogramados.html">
                <div class="form-group">
                    <label for="desde">Desde</label>
                    <input id="desde" type="text" required="" name="desde" class="form-control datepicker" />
                </div>
                <div class="form-group">
                    <label for="hasta">Hasta</label>
                    <input id="hasta" type="text" required="" name="hasta" class="form-control datepicker" />
                </div>
                <br><br>
                <div class="text-center">
                    <input type="reset" value="Limpiar" class="btn btn-default" />
                    <input type="submit" value="Visualizar" class="btn btn-success" />
                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/jsp/include/footer.jsp" %>
<script>
    var path = '${cp}/reportes/';

</script>
<script src="${cp}/resources/js/reportes/viajesprogramados.js"></script>