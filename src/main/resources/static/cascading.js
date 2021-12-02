$(document).ready(function(){
    $('#comboBoxCountry').change(function(){
        var countryId=$(this).val();
        alert(countryId);
        $( 'headr' ).append( $( "<span>  Хуй</span>" ) );
    })



});

