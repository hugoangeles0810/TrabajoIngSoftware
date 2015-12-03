
/* global bModeloBusPaginacion, pathModeloBus */

function bModeloBusInicio() {
    if (bModeloBusPaginacion.page > 1){
        var pathBuscador = pathModeloBus + "buscador.html";
        $("#dialog-content-modelobus").load(pathBuscador + "?page=1&size=" + bModeloBusPaginacion.size + "&search" + bModeloBusPaginacion.search);
    }
}

function bModeloBusAnterior() {
    if (bModeloBusPaginacion.page > 1){
        bModeloBusPaginacion.page--;
        var pathBuscador = pathModeloBus + "buscador.html";
        $("#dialog-content-modelobus").load(pathBuscador + "?page=" + bModeloBusPaginacion.page + "&size=" + bModeloBusPaginacion.size + "&search" + bModeloBusPaginacion.search);
    }
}

function bModeloBusSiguiente() {
    if (bModeloBusPaginacion.page < bModeloBusPaginacion.totalPage){
        bModeloBusPaginacion.page++;
        var pathBuscador = pathModeloBus + "buscador.html";
        $("#dialog-content-modelobus").load(pathBuscador + "?page=" + bModeloBusPaginacion.page + "&size=" + bModeloBusPaginacion.size + "&search" + bModeloBusPaginacion.search);
    }
}

function bModeloBusFin() {
    if (bModeloBusPaginacion.page < bModeloBusPaginacion.totalPage){
        var pathBuscador = pathModeloBus + "buscador.html";
        $("#dialog-content-modelobus").load(pathBuscador + "?page=" + bModeloBusPaginacion.totalPage + "&size=" + bModeloBusPaginacion.size + "&search" + bModeloBusPaginacion.search);
    }
}

function bModeloBusSelected(id, nombre) {
   if (typeof bModeloBusCallback === 'function' ) bModeloBusCallback(id, nombre);
}

function bModeloBusShow(){
    $("#dialog-content-modelobus").load(pathModeloBus + "buscador.html");
    $("#dialogModeloBus").modal('show');
}

function bModeloBusHide(){
    $("#dialogModeloBus").modal('hide');
}