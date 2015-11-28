/* global bEstacionPaginacion, pathEstacion, bEstacionCallback */

function bEstacionInicio() {
    if (bEstacionPaginacion.page > 1){
        var pathBuscador = pathEstacion + "buscador.html";
        $("#dialog-content-estacion").load(pathBuscador + "?page=1&size=" + bEstacionPaginacion.size + "&search" + bEstacionPaginacion.search);
    }
}

function bEstacionAnterior() {
    if (bEstacionPaginacion.page > 1){
        bEstacionPaginacion.page--;
        var pathBuscador = pathEstacion + "buscador.html";
        $("#dialog-content-estacion").load(pathBuscador + "?page=" + bEstacionPaginacion.page + "&size=" + bEstacionPaginacion.size + "&search" + bEstacionPaginacion.search);
    }
}

function bEstacionSiguiente() {
    if (bEstacionPaginacion.page < bEstacionPaginacion.totalPage){
        bEstacionPaginacion.page++;
        var pathBuscador = pathEstacion + "buscador.html";
        $("#dialog-content-estacion").load(pathBuscador + "?page=" + bEstacionPaginacion.page + "&size=" + bEstacionPaginacion.size + "&search" + bEstacionPaginacion.search);
    }
}

function bEstacionFin() {
    if (bEstacionPaginacion.page < bEstacionPaginacion.totalPage){
        var pathBuscador = pathEstacion + "buscador.html";
        $("#dialog-content-estacion").load(pathBuscador + "?page=" + bEstacionPaginacion.totalPage + "&size=" + bEstacionPaginacion.size + "&search" + bEstacionPaginacion.search);
    }
}

function bEstacionSelected(id, nombre) {
    if (typeof bEstacionCallback === 'function' ) bEstacionCallback(id, nombre);
}

function bEstacionShow(){
    $("#dialog-content-estacion").load(pathEstacion + "buscador.html");
    $("#dialogEstacion").modal('show');
}

function bEstacionHide(){
    $("#dialogEstacion").modal('hide');
}