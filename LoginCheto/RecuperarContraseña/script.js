document.addEventListener('DOMContentLoaded', function() {

    startEvents();

}, false);

function startEvents() {

    var email = document.getElementById('email').value;
    var form = document.getElementById('form');
    form.addEventListener('submit', function(e) {

        e.preventDefault();

        if (email != null) {

            sendMail();

        }

    }, false);

}

function returnData() {

    var cad = '';
    var email = document.getElementById('email').value;
    cad = 'email=' + encodeURIComponent(email);
    return cad;

}

var connection;
function sendMail() {

    connection = new XMLHttpRequest();
    connection.onreadystatechange = processMail;
    connection.open('POST', 'recuperarContra.php', true);
    connection.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    connection.send(returnData());

}

function processMail() {

    var resultHTML = document.getElementById('result');
    resultHTML.innerHTML = "";

    if (connection.readyState == 4 && connection.status == 200) {

        var data = JSON.parse(connection.responseText);

        var pass = data[0].pass;
        var result = data[0].result;

        console.log("pass: " + pass + ", result: " + result);

        if (pass == 1) {

            resultHTML.classList.remove("errors");
            resultHTML.classList.add("non-error");
            resultHTML.innerHTML = result;

        } else {

            resultHTML.classList.remove("non-error");
            resultHTML.classList.add("errors");
            resultHTML.innerHTML = result;

        }

    }

}