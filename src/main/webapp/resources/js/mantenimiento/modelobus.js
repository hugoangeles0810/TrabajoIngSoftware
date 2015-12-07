$(document).ready(function(){
    
     $(".deleted").click(function(){
        var r = confirm("¿Esta seguro de borrar el registro?");
        if (r){
            var id = $(this).attr("regId");
            $.post(path + "borrar.json", {id: id}, function(data) {
                if (data.success){
                    window.location.reload();
                } else {
                    alert("Error al borrar el modelo de bus.");
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
    
    $("#form-modelobus").submit(function(e){
        e.preventDefault();
        var id = $("#id").val();
        if (id) {
            persistirModeloBus("actualizar");
        } else {
            persistirModeloBus("guardar");
        }
    });
    
    $("#form-modelobus").on('reset', function(){
        $("#id").val("");
        $("#nombre").prop("readOnly", false);
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
    
});

function fillForm(data) {
    $("#id").val(data.id);
    $("#nombre").val(data.nombre);
    $("#nombre").prop("readOnly", true);
    $("#compartimientoComida").prop("checked" , data.compartimientoComida);
    $("#capacidadbodega").val(data.capacidadBodega);  
}

function isFormValid() {
    
    if (!isTextValid($("#nombre").val())) {
        showError("Debe ingresar el nombre.");
        $("#nombre").focus();
        return false;
    }
    
    if (!isNumber($("#capacidadbodega").val())) {
        showError("Debe ingresar un número en la capacidad de la bodega.");
        $("#capacidadbodega").focus();
        return false;
    }
    
    return true;
}

function persistirModeloBus(action) {
    if (isFormValid()){
        var form = $("#form-modelobus").jsonify();
        form.compartimientoComida = $("#compartimientoComida").is(":checked");
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
