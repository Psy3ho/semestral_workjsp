$(document).ready(function () {
    $('#dates').on('click',function () {
        console.log('click');
        var date1 = document.getElementById("date1").value;
        var date2 = document.getElementById("date2").value;
        $.ajax({
            url: "postsArray.jsp?date1=" + date1 +"&date2="+ date2,
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            dataType: "html",
            success: function(res) {
                console.log(res);
                $('#postsContainer').html(res);
            }
        });
    })
});

$(document).ready(function(){
    var date_input=$('input[name="date1"]'); //our date input has the name "date"
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
    };
    date_input.datepicker(options);
});

$(document).ready(function(){
    var date_input=$('input[name="date2"]'); //our date input has the name "date"
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
    };
    date_input.datepicker(options);
});

