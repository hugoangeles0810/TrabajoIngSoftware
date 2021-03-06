/* global bRolPaginacion, pathRol, bRolaginacion, bRolpaginacion, bRolCallback */

function bRolInicio() {
    if (bRolPaginacion.page > 1){
        var pathBuscador = pathRol + "buscador.html";
        $("#dialog-content-rol").load(pathBuscador + "?page=1&size=" + bRolPaginacion.size + "&search" + bRolPaginacion.search);
    }
}

function bRolAnterior() {
    if (bRolPaginacion.page > 1){
        bRolPaginacion.page--;
        var pathBuscador = pathRol + "buscador.html";
        $("#dialog-content-rol").load(pathBuscador + "?page=" + bRolPaginacion.page + "&size=" + bRolPaginacion.size + "&search" + bRolPaginacion.search);
    }
}

function bRolSiguiente() {
    if (bRolpaginacion.page < bRolPaginacion.totalPage){
        bRolPaginacion.page++;
        var pathBuscador = pathRol + "buscador.html";
        $("#dialog-content-rol").load(pathBuscador + "?page=" + bRolPaginacion.page + "&size=" + bRolPaginacion.size + "&search" + bRolPaginacion.search);
    }
}

function bRolFin() {
    if (bRolPaginacion.page < bRolPaginacion.totalPage){
        var pathBuscador = pathRol + "buscador.html";
        $("#dialog-content-rol").load(pathBuscador + "?page=" + bRolaginacion.totalPage + "&size=" + bRolPaginacion.size + "&search" + bRolPaginacion.search);
    }
}

function bRolSelected(id, nombre) {
    if (typeof bRolCallback === 'function' ) bRolCallback(id, nombre);
}

function bRolShow(){
    $("#dialog-content-rol").load(pathRol + "buscador.html");
    $("#dialogRol").modal('show');
}

function bRolHide(){
    $("#dialogRol").modal('hide');
}


