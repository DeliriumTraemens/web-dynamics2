$(document).ready(function(){
    //Selectors
    // $('h2').css('border', 'solid 3px red');
    $('b').css('border', 'dashed 1px blue');
    $('p.lead').css('color', 'green');
    $('p:eq(2)').css('border', 'solid 2px red');
    $('h2:has(span)').css('border', 'solid 2px red');
    $('.box').css('border', 'solid 2px red');

//    Events
//     $('h2').click(function(){
//         alert('You clicked the Header H2')
//     });

    $('h2').hover(
        function() {
            $( this ).append( $( "<span>  Хуй</span>" ) );
        }, function() {
            $( this ).find( "span:last" ).remove();
        }
    );
//    Forms
    $('input').change(function(){
        $('#username').text(', ' + $(this).val());
    });

    $('#input2').keyup(function(){
        $('#user2').text(', ' + $(this).val());
    });


});