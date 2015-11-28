/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global bLugarPaginacion, paginacion, pathLugar */

$(document).ready(function(){
    
    $(".deleted").click(function(){
        var r = confirm("¿Esta seguro de borrar el registro?");
        if (r){
            var id = $(this).attr("regId");
            $.post(path + "borrar.json", {id: id}, function(data) {
                if (data.success){
                    window.location.reload();
                } else {
                    alert("Error al borrar la estacion.");
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
    
    $("#form-estacion").submit(function(e){
        e.preventDefault();
        
        if (isFormValid()) {
            var form = $("#form-estacion").jsonify();
            form.lugar = {
              id: form.lugar  
            };
            $.ajax({
                url: path + "guardar.json",
                type: 'POST',
                dataType: 'json',
                data: JSON.stringify(form),
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
    
    // Buscador de lugar
    $("#searchLugar").click(function(){
       bLugarShow();
    });
    
});

function fillForm(data) {
    $("#id").val(data.id);
    $("#nombre").val(data.nombre);
    $("#direccion").val(data.direccion);
    $("#lugarId").val(data.lugar.id);
    $("#lugarNombre").val(data.lugar.ciudad);
    
}

function isFormValid(){
    if ($("#nombre").val().trim() === '') {
        showError("Debe ingresar el nombre.");
        $("#nombre").focus();
        return false;
    }
    
    if ($("#direccion").val().trim() === '') {
        showError("Debe ingresar la dirección.");
        $("#direccion").focus();
        return false;
    }
    
    if ($("#lugarId").val()  === undefined || $("#lugarId").val() === '') {
        showError("Debe seleccionar el lugar.");
        $("#searchLugar").focus();
        return false;
    }
    
    return true;
}

function bLugarCallback (id, nombre) {
    $("#lugarId").val(id);
    $("#lugarNombre").val(nombre);
    bLugarHide();
}
