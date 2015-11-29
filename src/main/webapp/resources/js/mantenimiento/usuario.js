$(document).ready(function(){
    
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
    
    $("#form-usuario").submit(function(e){
       e.preventDefault();
       var id = $("#id").val();
        if (id) {
            persistirUsuario("actualizar");
        } else {
            persistirUsuario("guardar");
        }
    });
    
    $("#form-usuario").on('reset', function(){
        $("#searchTrabajador").prop("disabled", false);
        $("#searchRol").prop("disabled", false);
        $("#usuario").prop("disabled", false);
    });
    
    $("#searchTrabajador").click(function(){
        bTrabajadorShow();
    });
    
    $("#searchRol").click(function(){
        bRolShow();
    });
});

function bTrabajadorCallback(id, nombre){
    $("#trabajadorId").val(id);
    $("#trabajadorNombre").val(nombre);
    bTrabajadorHide();
}

function bRolCallback(id, nombre){
    $("#rolId").val(id);
    $("#rolNombre").val(nombre);
    bRolHide();
}

function fillForm(data){
    $("#id").val(data.id);
    $("#trabajadorId").val(data.trabajador);
    $("#trabajadorNombre").val(data.trabajadorNombre);
    $("#rolId").val(data.rol);
    $("#rolNombre").val(data.rolNombre);
    $("#usuario").val(data.usuario);
    $("#clave").val(data.clave);
    $("#claveConfirma").val(data.clave);
    $("#searchTrabajador").prop("disabled", true);
    $("#searchRol").prop("disabled", true);
    $("#usuario").prop("disabled", true);
}

function isFormValid() {
    
    if (!isTextValid($("#trabajadorId").val())) {
        showError("Debe seleccionar el trabajador.");
        return false;
    }
    
    if (!isTextValid($("#rolId").val())) {
        showError("Debe seleccionar el rol.");
        return false;
    }
    
    if (!isTextValid($("#usuario").val())) {
        showError("Debe ingresar el usuario.");
        return false;
    }
    
    if (!isTextValid($("#clave").val())) {
        showError("Debe ingresar la clave.");
        return false;
    }
    
    if (!isTextValid($("#claveConfirma").val())) {
        showError("Debe confirmar la clave.");
        return false;
    }
    
    if ($("#claveConfirma").val() !== $("#clave").val()){
        showError("Las claves no coinciden.");
        return false;
    }
    
    return true;
}

function persistirUsuario(action) {
    if (isFormValid()){
        var form = JSON.stringify($("#form-usuario").jsonify());
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


