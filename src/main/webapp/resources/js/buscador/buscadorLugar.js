
/* global bLugarPaginacion, pathLugar */

function bLugarInicio() {
    if (bLugarPaginacion.page > 1){
        var pathBuscador = pathLugar + "buscador.html";
        $("#dialog-content-lugar").load(pathBuscador + "?page=1&size=" + bLugarPaginacion.size + "&search" + bLugarPaginacion.search);
    }
}

function bLugarAnterior() {
    if (bLugarPaginacion.page > 1){
        bLugarPaginacion.page--;
        var pathBuscador = pathLugar + "buscador.html";
        $("#dialog-content-lugar").load(pathBuscador + "?page=" + bLugarPaginacion.page + "&size=" + bLugarPaginacion.size + "&search" + bLugarPaginacion.search);
    }
}

function bLugarSiguiente() {
    if (bLugarPaginacion.page < bLugarPaginacion.totalPage){
        bLugarPaginacion.page++;
        var pathBuscador = pathLugar + "buscador.html";
        $("#dialog-content-lugar").load(pathBuscador + "?page=" + bLugarPaginacion.page + "&size=" + bLugarPaginacion.size + "&search" + bLugarPaginacion.search);
    }
}

function bLugarFin() {
    if (bLugarPaginacion.page < bLugarPaginacion.totalPage){
        var pathBuscador = pathLugar + "buscador.html";
        $("#dialog-content-lugar").load(pathBuscador + "?page=" + bLugarPaginacion.totalPage + "&size=" + bLugarPaginacion.size + "&search" + bLugarPaginacion.search);
    }
}

function bLugarSelected(id, nombre) {
   if (typeof bLugarCallback === 'function' ) bLugarCallback(id, nombre);
}

function bLugarShow(){
    $("#dialog-content-lugar").load(pathLugar + "buscador.html");
    $("#dialogLugar").modal('show');
}

function bLugarHide(){
    $("#dialogLugar").modal('hide');
}