var ORIGEN = 1, DESTINO = 2;
$(document).ready(function(){
    $(".datepicker").datepicker({
        format: 'dd/mm/yyyy'
    });
    //$("#hora").timepicker();
    
    $(".deleted").click(function(){
        var r = confirm("¿Esta seguro de cancelar el viaje?");
        if (r){
            var id = $(this).attr("regId");
            $.post(path + "borrar.json", {id: id}, function(data) {
                if (data.success){
                    window.location.reload();
                } else {
                    alert("Error al cancelar el viaje");
                }
            });
        }
    });
    
    $("#form-programaviaje").submit(function(e){
        e.preventDefault();
        if (isFormValid()) {
            var form = JSON.stringify($(this).jsonify());
            $.ajax({
                url: path + "guardar.json",
                type: 'POST',
                dataType: 'json',
                data: form,
                beforeSend: function (xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: function (data) {
                    if(data.status === "success") {
                        alert(data.msg);
                        window.location.reload();
                    }

                    if(data.status === "error") {
                        alert(data.msg);
                    }
                }
            });
        }
    });
    
    $("#searchOrigen").click(function(e){
        e.preventDefault();
        opcion = ORIGEN;
        bAgenciaShow();
    });
    
    $("#searchDestino").click(function(e){
        e.preventDefault();
        opcion = DESTINO;
        bAgenciaShow();
    });
    
    $("#searchBus").click(function(e){
        e.preventDefault();
        bBusShow();
    }); 
    
});

// Paginacion
    $("#inicio").click(function(){
        if (paginacion.page > 1) {
            window.location.search = "page=1&size=" + paginacion.size + "&search=" + paginacion.search;
        }
    });
    
    $("#anterior").click(function(){
        if ((paginacion.page - 1) > 0) {
            paginacion.page--;
            window.location.search = "page=" + paginacion.page +"&size=" + paginacion.size + "&search=" + paginacion.search;
        }
    });
    
    $("#siguiente").click(function(){
        if ((paginacion.page + 1) <= paginacion.totalPage) {
            paginacion.page++;
            window.location.search = "page=" + paginacion.page +"&size=" + paginacion.size + "&search=" + paginacion.search;
        }
    });
    
    $("#fin").click(function(){
        if (paginacion.page < paginacion.totalPage) {
            window.location.search = "page=" + paginacion.totalPage +"&size=" + paginacion.size + "&search=" + paginacion.search;
        }
    });

function bAgenciaCallback(id, nombre) {
    if (opcion === ORIGEN) {
        $("#origenId").val(id);
        $("#origenNombre").val(nombre);
    } else if (opcion === DESTINO) {
        $("#destinoId").val(id);
        $("#destinoNombre").val(nombre);
    }
    bAgenciaHide();
}

function bBusCallback(id, placa) {
    $("#busId").val(id);
    $("#busNombre").val(placa);
    bBusHide();
}

function isFormValid() {
    
    if (!isTextValid($("#origenId").val())) {
        showError("Debe seleccionar la agencia de origen.");
        return false;
    }
    
    if (!isTextValid($("#destinoId").val())) {
        showError("Debe seleccionar la agencia de destino.");
        return false;
    }
    
    if (!isTextValid($("#fecha").val())) {
        showError("Debe ingresar la fecha del viaje.");
        return false;
    }
    
    if (!isTextValid($("#hora").val())) {
        showError("Debe ingresar la hora del viaje.");
        return false;
    }
    
    if (!isTextValid($("#busId").val())) {
        showError("Debe seleccionar el bus.");
        return false;
    }
    
    return true;
}