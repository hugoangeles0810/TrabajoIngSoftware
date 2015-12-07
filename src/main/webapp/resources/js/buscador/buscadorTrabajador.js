/* global bTrabajadorPaginacion, pathTrabajador, bTrabajadorCallback */

function bTrabajadorInicio() {
    if (bTrabajadorPaginacion.page > 1){
        var pathBuscador = pathTrabajador + "buscador.html";
        $("#dialog-content-trabajador").load(pathBuscador + "?page=1&size=" + bTrabajadorPaginacion.size + "&search" + bTrabajadorPaginacion.search);
    }
}

function bTrabajadorAnterior() {
    if (bTrabajadorPaginacion.page > 1){
        bTrabajadorPaginacion.page--;
        var pathBuscador = pathTrabajador + "buscador.html";
        $("#dialog-content-trabajador").load(pathBuscador + "?page=" + bTrabajadorPaginacion.page + "&size=" + bTrabajadorPaginacion.size + "&search" + bTrabajadorPaginacion.search);
    }
}

function bTrabajadorSiguiente() {
    if (bTrabajadorPaginacion.page < bTrabajadorPaginacion.totalPage){
        bTrabajadorPaginacion.page++;
        var pathBuscador = pathTrabajador + "buscador.html";
        $("#dialog-content-trabajador").load(pathBuscador + "?page=" + bTrabajadorPaginacion.page + "&size=" + bTrabajadorPaginacion.size + "&search" + bTrabajadorPaginacion.search);
    }
}

function bTrabajadorFin() {
    if (bTrabajadorPaginacion.page < bTrabajadorPaginacion.totalPage){
        var pathBuscador = pathTrabajador + "buscador.html";
        $("#dialog-content-trabajador").load(pathBuscador + "?page=" + bTrabajadorPaginacion.totalPage + "&size=" + bTrabajadorPaginacion.size + "&search" + bTrabajadorPaginacion.search);
    }
}

function bTrabajadorSelected(id, nombre) {
    if (typeof bTrabajadorCallback === 'function' ) bTrabajadorCallback(id, nombre);
}

function bTrabajadorShow(){
    $("#dialog-content-trabajador").load(pathTrabajador + "buscador.html");
    $("#dialogTrabajador").modal('show');
}

function bTrabajadorHide(){
    $("#dialogTrabajador").modal('hide');
}