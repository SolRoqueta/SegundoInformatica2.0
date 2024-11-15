document.addEventListener('DOMContentLoaded', function() {

    startEvents();

}, false);

function startEvents() {

    var form = document.getElementById('productForm');
    form.addEventListener('submit', function(e) {

        e.preventDefault();
        addItem();

    }, false);

}

function returnData() {

    var cad = ``;
    var name = document.getElementById('nombre');
    var precio = document.getElementById('precio');
    var descripcion = document.getElementById('descripcion');
    cad = `name=${encodeURIComponent(name.value)}&price=${encodeURIComponent(precio.value)}&description=${encodeURIComponent(descripcion.value)}`;
    return cad;

}

var connection;
function addItem() {

    connection = new XMLHttpRequest();
    connection.onreadystatechange = processProduct;
    connection.open('POST', 'agregarProducto.php');
    connection.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    connection.send(returnData());

}

function processProduct() {

    var result = document.getElementById('result');

    if (connection.readyState == 4 && connection.status == 200) {

        var data = JSON.parse(connection.responseText);

        if (data[0].resultNum == "1") {

            result.classList.remove("badResult");
            result.classList.add("goodResult");

            result.innerHTML = data[0].resultado;

        } else {

            result.classList.remove("goodResult");
            result.classList.add("badResult");

            result.innerHTML = data[0].resultado;

        }

    }

}