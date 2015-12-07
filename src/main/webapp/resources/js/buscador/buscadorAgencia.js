
/* global bAgenciaPaginacion, pathAgencia */

function bAgenciaInicio() {
    if (bAgenciaPaginacion.page > 1){
        var pathBuscador = pathAgencia + "buscador.html";
        $("#dialog-content-agencia").load(pathBuscador + "?page=1&size=" + bAgenciaPaginacion.size + "&search" + bAgenciaPaginacion.search);
    }
}

function bAgenciaAnterior() {
    if (bAgenciaPaginacion.page > 1){
        bAgenciaPaginacion.page--;
        var pathBuscador = pathAgencia + "buscador.html";
        $("#dialog-content-agencia").load(pathBuscador + "?page=" + bAgenciaPaginacion.page + "&size=" + bAgenciaPaginacion.size + "&search" + bAgenciaPaginacion.search);
    }
}

function bAgenciaSiguiente() {
    if (bAgenciaPaginacion.page < bAgenciaPaginacion.totalPage){
        bAgenciaPaginacion.page++;
        var pathBuscador = pathAgencia + "buscador.html";
        $("#dialog-content-agencia").load(pathBuscador + "?page=" + bAgenciaPaginacion.page + "&size=" + bAgenciaPaginacion.size + "&search" + bAgenciaPaginacion.search);
    }
}

function bAgenciaFin() {
    if (bAgenciaPaginacion.page < bAgenciaPaginacion.totalPage){
        var pathBuscador = pathAgencia + "buscador.html";
        $("#dialog-content-agencia").load(pathBuscador + "?page=" + bAgenciaPaginacion.totalPage + "&size=" + bAgenciaPaginacion.size + "&search" + bAgenciaPaginacion.search);
    }
}

function bAgenciaSelected(id, nombre) {
   if (typeof bAgenciaCallback === 'function' ) bAgenciaCallback(id, nombre);
}

function bAgenciaShow(){
    $("#dialog-content-agencia").load(pathAgencia + "buscador.html");
    $("#dialogAgencia").modal('show');
}

function bAgenciaHide(){
    $("#dialogAgencia").modal('hide');
}