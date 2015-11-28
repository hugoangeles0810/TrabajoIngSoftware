$(document).ready(function(){
    
    $(".deleted").click(function(){
        var r = confirm("¿Esta seguro de borrar el registro?");
        if (r){
            var id = $(this).attr("regId");
            $.post(path + "borrar.json", {id: id}, function(data) {
                if (data.success){
                    window.location.reload();
                } else {
                    alert("Error al borrar la agencia.");
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
    
    $("#form-agencia").submit(function(e){
        e.preventDefault();
        var id = $("#id").val();
        if (id){
            persistirAgencia("actualizar");
        } else {
            persistirAgencia("guardar");
        }
    });
    
    $("#form-agencia").on('reset', function(){
        $("#searchEstacion").prop("disabled", false);
    });
    
    
    $("#searchEstacion").click(function(){
        bEstacionShow();
    });
    
});

function bEstacionCallback(id, nombre) {
    $("#estacionId").val(id);
    $("#estacionNombre").val(nombre);
    bEstacionHide();
}

function isFormValid() {
    if (!isTextValid($("#estacionId").val())) {
        showError("Debe seleccionar la estación de trabajo");
        return false;
    }
    
    if (!isNumber($("#aforo").val())) {
        showError("Debe ingresar un valor númerico en aforo");
        $("#aforo").focus();
        return false;
    }
    
    if (!isNumber($("#capacidadbus").val())) {
        showError("Debe ingresar un valor númerico en capacidad de buses.");
        $("#capacidadbus").focus();
        return false;
    }
    
    return true;
}

function fillForm(data){
    $("#id").val(data.id);
    $("#estacionId").val(data.estacion);
    $("#estacionNombre").val(data.estacionNombre);
    $("#aforo").val(data.aforo);
    $("#capacidadbus").val(data.capacidadbus);
    $("#searchEstacion").prop("disabled", true);
}

function persistirAgencia(action) {
    if (isFormValid()){
        var form = JSON.stringify($("#form-agencia").jsonify());
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