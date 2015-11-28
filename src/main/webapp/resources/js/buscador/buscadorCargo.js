/* global bCargoPaginacion, pathCargo, bCargoCallback */

function bCargoInicio() {
    if (bCargoPaginacion.page > 1){
        var pathBuscador = pathCargo + "buscador.html";
        $("#dialog-content-cargo").load(pathBuscador + "?page=1&size=" + bCargoPaginacion.size + "&search" + bCargoPaginacion.search);
    }
}

function bCargoAnterior() {
    if (bCargoPaginacion.page > 1){
        bCargoPaginacion.page--;
        var pathBuscador = pathCargo + "buscador.html";
        $("#dialog-content-cargo").load(pathBuscador + "?page=" + bCargoPaginacion.page + "&size=" + bCargoPaginacion.size + "&search" + bCargoPaginacion.search);
    }
}

function bCargoSiguiente() {
    if (bCargoPaginacion.page < bCargoPaginacion.totalPage){
        bCargoPaginacion.page++;
        var pathBuscador = pathCargo + "buscador.html";
        $("#dialog-content-cargo").load(pathBuscador + "?page=" + bCargoPaginacion.page + "&size=" + bCargoPaginacion.size + "&search" + bCargoPaginacion.search);
    }
}

function bCargoFin() {
    if (bCargoPaginacion.page < bCargoPaginacion.totalPage){
        var pathBuscador = pathCargo + "buscador.html";
        $("#dialog-content-cargo").load(pathBuscador + "?page=" + bCargoPaginacion.totalPage + "&size=" + bCargoPaginacion.size + "&search" + bCargoPaginacion.search);
    }
}

function bCargoSelected(id, nombre) {
    if (typeof bCargoCallback === 'function' ) bCargoCallback(id, nombre);
}

function bCargoShow(){
    $("#dialog-content-cargo").load(pathCargo + "buscador.html");
    $("#dialogCargo").modal('show');
}

function bCargoHide(){
    $("#dialogCargo").modal('hide');
}