let tipo;
let id;
let tipoId;
var cad;

document.addEventListener('DOMContentLoaded', function() {

    startEvents();

}, false);

function startEvents() {

    getInfo();

}

function getInfo() {

    const urlParams = new URLSearchParams(window.location.search);
    const datos = JSON.parse(decodeURIComponent(urlParams.get('datos')));

    if (datos) {

        console.log("Si pasó");

        tipo = datos.tipo;
        id = datos.id;
        tipoId = datos.tipoId;
        getItem();

    } else {

        console.log("No paso");

        // document.getElementById('info').innerHTML = "Datos no disponibles.";
        getInfo();

    }

}

function returnData() {

    var cad = '';
    cad = 'tipo=' + tipo + '&id=' + id + '&tipoId=' + tipoId;
    return cad;

}

var item_connection;
function getItem() {

    item_connection = new XMLHttpRequest();
    item_connection.onreadystatechange = processItem;
    item_connection.open('POST', 'detalles.php', true);
    item_connection.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    item_connection.send(returnData());

}

function processItem() {

    var info = document.getElementById('container');

    if (item_connection.readyState == 4 && item_connection.status == 200) {

        var data = JSON.parse(item_connection.responseText);
        cad = `

                <img src="https://dummyimage.com/150x150/000/fff" alt="${data[0].nombre}" class="product-image">
            <div class="product-details">
                <h1 id="product-title" class="product-title">${data[0].nombre}</h1>
                <div class="product-price">$${data[0].precio}</div>
                <p class="product-description">
                    ${data[0].descripcion}
                </p>
                <button class="button">Comenzar pedido</button>
            </div>

        `;

        info.innerHTML = cad;

    }

}