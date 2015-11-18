$(document).ready(function(){
    
    $(".deleted").click(function(){
        var id = $(this).attr("regId");
        $.post(path + "borrar.json", {id: id}, function(data) {
            console.log(data);
            if (data.success){
                window.location.reload();
            } else {
                alert("Error al borrar el lugar");
            }
        });
    });
    
});