$(document).ready(function(){
    
    $(".deleted").click(function(){
        var r = confirm("¿Esta seguro de borrar el registro?");
        if (r){
            var id = $(this).attr("regId");
            $.post(path + "borrar.json", {id: id}, function(data) {
                if (data.success){
                    window.location.reload();
                } else {
                    alert("Error al borrar el lugar");
                }
            });
        }
    });
    
    $(".edited").click(function(){
        var id = $(this).attr("regId");
        $.get(path + "obtener/" + id + ".json", null, function (data) {
            if (data) {
               fillForm(data); 
            }
        });
    });
    
    $("#form-bus").submit(function(e){
        e.preventDefault();
        var id = $("#id").val();
        if (id) {
            persistirBus("actualizar");
        } else {
            persistirBus("guardar");
        }
    });
    
    $("#form-bus").on('reset', function(){
        $("#placa").prop("readOnly", false);
    });
    
    $("#searchModelobus").click(function(e){
        e.preventDefault();
        bModeloBusShow();
    });
    
    $("#searchAgencia").click(function(e){
        e.preventDefault();
        bAgenciaShow();
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
    
    $("#form-filtrar").submit(function(e){
        e.preventDefault();
        window.location.search = "page=1&size=" + paginacion.size + "&search=" + $("#search").val();
    });
    
});

function fillForm(data) {
    $("#id").val(data.id);
    $("#placa").val(data.placa);
    $("#anio").val(data.anio);
    $("#estado").val(data.estado);
    $("#modelobusId").val(data.modelobus);
    $("#modelobusNombre").val(data.modelobusNombre);
    $("#agenciaId").val(data.agencia);
    $("#agenciaNombre").val(data.agenciaNombre);
    $("#placa").prop("readOnly", true);
}

function bModeloBusCallback(id, nombre) {
    $("#modelobusId").val(id);
    $("#modelobusNombre").val(nombre);
    bModeloBusHide();
}

function bAgenciaCallback(id, nombre) {
    $("#agenciaId").val(id);
    $("#agenciaNombre").val(nombre);
    bAgenciaHide();
}

function isFormValid() {
    
    if (!isTextValid($("#placa").val())) {
        showError("Debe ingresar la placa.");
        $("#placa").focus();
        return false;
    }
    
    if (!isTextValid($("#anio").val())) {
        showError("Debe ingresar el año.");
        $("#anio").focus();
        return false;
    }
    
    if (!isNumber($("#anio").val())) {
        showError("El año debe ser un número.");
        $("#anio").focus();
        return false;
    }
    
    if (!isTextValid($("#estado").val())) {
        showError("Debe ingresar el estado.");
        $("#estado").focus();
        return false;
    }
    
    if (!isTextValid($("#modelobusId").val())) {
        showError("Debe seleccionar el modelo de bus.");
        return false;
    }
    
    if (!isTextValid($("#agenciaId").val())) {
        showError("Debe seleccionar la agencia.");
        return false;
    }
    
    return true;
}

function persistirBus(action) {
    if (isFormValid()) {
        var form = $("#form-bus").jsonify();
        console.log(form);
        $.ajax({
                url: path + action + ".json",
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(form),
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
}