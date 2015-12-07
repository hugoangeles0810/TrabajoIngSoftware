
/* global bBusPaginacion, pathBus */

function bBusInicio() {
    if (bBusPaginacion.page > 1){
        var pathBuscador = pathBus + "buscador.html";
        $("#dialog-content-bus").load(pathBuscador + "?page=1&size=" + bBusPaginacion.size + "&search" + bBusPaginacion.search);
    }
}

function bBusAnterior() {
    if (bBusPaginacion.page > 1){
        bBusPaginacion.page--;
        var pathBuscador = pathBus + "buscador.html";
        $("#dialog-content-bus").load(pathBuscador + "?page=" + bBusPaginacion.page + "&size=" + bBusPaginacion.size + "&search" + bBusPaginacion.search);
    }
}

function bBusSiguiente() {
    if (bBusPaginacion.page < bBusPaginacion.totalPage){
        bBusPaginacion.page++;
        var pathBuscador = pathBus + "buscador.html";
        $("#dialog-content-bus").load(pathBuscador + "?page=" + bBusPaginacion.page + "&size=" + bBusPaginacion.size + "&search" + bBusPaginacion.search);
    }
}

function bBusFin() {
    if (bBusPaginacion.page < bBusPaginacion.totalPage){
        var pathBuscador = pathBus + "buscador.html";
        $("#dialog-content-bus").load(pathBuscador + "?page=" + bBusPaginacion.totalPage + "&size=" + bBusPaginacion.size + "&search" + bBusPaginacion.search);
    }
}

function bBusSelected(id, nombre) {
   if (typeof bBusCallback === 'function' ) bBusCallback(id, nombre);
}

function bBusShow(){
    $("#dialog-content-bus").load(pathBus + "buscador.html");
    $("#dialogBus").modal('show');
}

function bBusHide(){
    $("#dialogBus").modal('hide');
}