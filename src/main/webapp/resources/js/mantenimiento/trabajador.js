$(document).ready(function(){
    
    $(".datepicker").datepicker();
    
    $(".deleted").click(function(){
        var r = confirm("¿Esta seguro de borrar el registro?");
        if (r){
            var id = $(this).attr("regId");
            $.post(path + "borrar.json", {id: id}, function(data) {
                if (data.success){
                    window.location.reload();
                } else {
                    alert("Error al borrar el trabajador.");
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
    
    $("#form-trabajador").submit(function(e){
        e.preventDefault();
        var id = $("#id").val();
        if (id) {
            persistirTrabajador("actualizar");
        } else {
            persistirTrabajador("guardar");
        }
    });
    
    $("#form-trabajador").on('reset', function(){
       $("#dni").prop("disabled", false);
    });
    
    $("#searchCargo").click(function(){
        bCargoShow();
    });
    
    $("#searchEstacion").click(function(){
        bEstacionShow();
    });
    
});

function fillForm(data) {
    $("#id").val(data.id);
    $("#dni").val(data.dni);
    $("#dni").prop("disabled", true);
    $("#nombre").val(data.nombre);
    $("#apellidos").val(data.apellidos);
    $("#direccion").val(data.direccion);
    $("#telefono").val(data.telefono);
    $("#fechaNacimiento").val(data.fechaNacimiento);
    $("#cargoId").val(data.cargo);
    $("#cargoNombre").val(data.cargoNombre);
    $("#fechaIngreso").val(data.fechaIngreso);
    $("#estacionId").val(data.estacion);
    $("#estacionNombre").val(data.estacionNombre);
    
}

function bCargoCallback(id, nombre) {
    $("#cargoId").val(id);
    $("#cargoNombre").val(nombre);
    bCargoHide();
}

function bEstacionCallback(id, nombre) {
    $("#estacionId").val(id);
    $("#estacionNombre").val(nombre);
    bEstacionHide();
}

function isFormValid() {
    return true;
}

function persistirTrabajador(action) {
    if (isFormValid()){
        var form = JSON.stringify($("#form-trabajador").jsonify());
        $.ajax({
                url: path + action + ".json",
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
}

