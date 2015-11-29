/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function bServiciosInicio() {
    if (bServiciosPaginacion.page > 1) {
        var pathBuscador = pathServicios + "buscador.html";
        $("#dialog-content-servicios").load(pathBuscador + "?page=1&size=" + bServiciosPaginacion.size + "&search" + bServiciosPaginacion.search);
    }
}

function bServiciosAnterior() {
    if (bServiciosPaginacion.page > 1) {
        bServiciosPaginacion.page--;
        var pathBuscador = pathServicios + "buscador.html";
        $("#dialog-content-servicios").load(pathBuscador + "?page=" + bServiciosPaginacion.page + "&size=" + bServiciosPaginacion.size + "&search" + bServiciosPaginacion.search);
    }
}

function bServiciosSiguiente() {
    if (bServiciospaginacion.page < bServiciosPaginacion.totalPage) {
        bServiciosPaginacion.page++;
        var pathBuscador = pathServicios + "buscador.html";
        $("#dialog-content-servicios").load(pathBuscador + "?page=" + bServiciosPaginacion.page + "&size=" + bServiciosPaginacion.size + "&search" + bServiciosPaginacion.search);
    }
}

function bServiciosFin() {
    if (bServiciosPaginacion.page < bServiciosPaginacion.totalPage) {
        var pathBuscador = pathServicios + "buscador.html";
        $("#dialog-content-Servicios").load(pathBuscador + "?page=" + bServiciosaginacion.totalPage + "&size=" + bServiciosPaginacion.size + "&search" + bServiciosPaginacion.search);
    }
}

function bServiciosSelected(id, nombre) {
    if (typeof bServiciosCallback === 'function')
        bServiciosCallback(id, nombre);
}

function bServiciosShow() {
    $("#dialog-content-servicios").load(pathServicios + "buscador.html");
    $("#dialogServicios").modal('show');
}

function bServiciosHide() {
    $("#dialogServicios").modal('hide');
}

