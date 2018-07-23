$(document).ready(function () {

    validateInput();

    // GET REQUEST
    $("#search").click(function (event) {
        event.preventDefault();
        ajaxGet();
    });

    // DO GET
    function ajaxGet(origin, destination) {
        var origin = $("#origin").val();
        var destination = $("#destination").val();
        $.ajax({
            type: "GET",
            url: window.location + "searchflights/" + origin + "/" + destination,
            dataType: 'json',
            success: function (result) {
                $('#flightdetails ul').empty();
                if (result.length > 0) {
                    $.each(result, function (index, flightData) {
                        var flightDetail = "Origin = " + flightData.origin + "-> Destination = " + flightData.destination + "(" + flightData.departureTime + "->" + flightData.destinationTime + ")-$" + flightData.price + "<br>";
                        $('#flightdetails .list-group').append("<li>" + flightDetail + "</li>")
                    });
                } else {
                    var noFlightFound = "<strong>No Flights Found for " + origin + " -> " + destination + "</strong>"
                    $('#flightdetails .list-group').append("<li>" + noFlightFound + "</li>")
                }
                console.log("Success: ", result);
            },
            error: function (e) {
                $('#flightdetails .list-group').append("<strong>Error</strong>")
                console.log("ERROR: ", e);
            }
        });
    }

    function validateInput() {
        $('input').on('keypress', function (event) {
            var regex = new RegExp("^[a-zA-Z]+$");
            var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
            if (!regex.test(key)) {
                event.preventDefault();
                return false;
            }
        });
    }
})
