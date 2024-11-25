document.addEventListener('DOMContentLoaded', startEvents, false);

function startEvents() {

    var button = document.getElementById('button');
    button.addEventListener('click', function() {

        closeSession();

    }, true);

}

var connection_closeSession;
function closeSession() {

    connection_closeSession = new XMLHttpRequest();
    connection_closeSession.onreadystatechange = processResult;
    connection_closeSession.open('GET', 'session.php', true);
    connection_closeSession.send();

}

function processResult() {

    var result = document.getElementById('result');

    if (connection_closeSession.readyState == 4 && connection_closeSession.status == 200) {

        result.innerHTML = "Sesion cerrada con exito!";

    }

}