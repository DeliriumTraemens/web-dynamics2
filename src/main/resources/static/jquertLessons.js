function valid(){

    {
        var selector = "<label for='selector1'>Choice</label>" +
            "<select id='selector1' class='form-control'>" +
            "<option value='aa'>aa</option>" +
            "<option value='bb'>bb</option>" +
            "<option value='cc'>cc</option>" +
            "<option value='dd'>dd</option>" +
            "</select>";
    }



    var state = $('input[name="sex"]:checked').val();

    if(!state){

        $('#message').html('SHIT!!');
    //    Вставляемый текст пишем в скобках функции html

    } else
        $('#message').html(selector);

}

{
    var dropdown="<label for='selector1'>Choice</label>" +
        "<select id='selector1' class='form-control'>";
}
function selectorBuilder(){
    // alert(dropdown);
    var optionResult="";
    var selectorResult="";
    for(var i=0; i<25; i++){
        var optionCell= "<option value='  " + i + "  '>"+i+"</option>";
            optionResult += optionCell;
    }
    selectorResult=dropdown+optionResult+"</select>"
        // alert(selectorResult);
    $('#selector').html(selectorResult);

}
let cidx=0;
$.get('/countryes',function(data){

console.log(data[0]);
});
//Первичный список
function primaryCountryList(){
    $.get('/countryes',function (data){

        //alert('В списке стран '+data.length +' объекта');

//Country List
        for (let i = 0; i <data.length ; i++) {
            let countryOpt ="<option value='"+ data[i].id + "'> "+data[i].name+"</option>";
            $('#countryList').append(countryOpt);
        }

        // var comboCountrySel=$('#countryList').val();
        // alert(comboCountrySel);


        console.log(data[cidx]);

        $('#country').html(data[cidx].name);



        //Option tag String
        let stateOptionToAppend="<option value='"+ globalCounter + "'> "+globalCounter+"</option>";


        console.log(states);
        // alert(states[0].name);
        // alert(states[0].name);

        $('#states').html(states[cidx].name);
        // alert(data[0]);

    });

}

//Second Country Ver
function loadCountries(){
    let id = $('#countryList').val();
    $.get('/country/'+id,function(data){

        var states = data.states;
        // console.log(states);
        for (var i=0;i<states.length;i++) {
            console.log(states[i].name+' '+states[i].id);
        }
        //States List
        let selectStart = "<select name='state' id='statesList'>";
        let selectEnd ="</select>";
        for (let i = 0; i < states.length ; i++) {
            let stateopt = "<option value='"+ states[i].id + "'> "+states[i].name+"</option>";
            $('#statesList').append(stateopt);
        }

    });
}

//append study
let globalCounter=1;
let currentCounter;

function appendBlocks(){
    // alert('appendBlocks is pressed');
    let firstVarToInsert=" ХУЙ ";
    let secondVarToInsert=" БЛЯ ";

    let optionToAppend="<option value='"+ globalCounter + "'> "+globalCounter+"</option>";


    let blockToappend="<h4>Block to Append "+ firstVarToInsert +" is appended</h4>";
    let secondBlockToAppend="<h5 id='second_block'>Second, "+secondVarToInsert+"</h5>"
    // $('#div_1').append(blockToappend);
    // $('#div_2').append(secondBlockToAppend);
    $('#listSelecter').append(optionToAppend);
    globalCounter++;
}


    let card="<div id='cardIns' class='card'><div class='card-header'>Card header</div>" +
        "<div class='card-footer'> " +
        "<input type='button' value='Add a Card' " +
        "onclick='appendInnerCard()'></div> </div>";

function appendBlock(){
    $('#div-base').append(card);
}

function appendInnerCard(){
    $(this).appendTo($('#div-base'));
}