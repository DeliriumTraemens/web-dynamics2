$(document).ready(function(){
    $.get('/countryes', function(data){
        console.log(data);
        alert(data);
    })
});