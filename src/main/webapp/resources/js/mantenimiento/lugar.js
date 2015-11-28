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
    
    $("#form-lugar").submit(function (e){
        e.preventDefault();
        if (isFormValid()){
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
                        alert("Operación exitosa.");
                        window.location.reload();
                    }

                    if(data.status === "error") {
                        alert(data.msg);
                    }
                }
            });
        }
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
    
    function fillForm(data){
        $("#id").val(data.id)
        $("#pais").val(data.pais);
        $("#estado").val(data.estado);
        $("#ciudad").val(data.ciudad);
        $("#distrito").val(data.distrito);
    }
    
    function isFormValid() {
        if ($("#pais").val().trim() === "") {
            showError("Debe ingresar el pais.");
            $("#pais").focus();
            return false;
        }
        
        if ($("#estado").val().trim() === "") {
            showError("Debe ingresar el estado.");
            $("#estado").focus();
            return false;
        }
        
        if ($("#ciudad").val().trim() === "") {
            showError("Debe ingresar la ciudad.");
            $("#ciudad").focus();
            return false;
        }
        
        if ($("#distrito").val().trim() === "") {
            showError("Debe ingresar el distrito.");
            $("#distrito").focus();
            return false;
        }
        
        return true;
    }
    
});