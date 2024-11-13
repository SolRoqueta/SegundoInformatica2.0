document.addEventListener('DOMContentLoaded', startEvents, false);

function startEvents() {

    getItems();

    var fil = document.getElementById('filter');
    fil.addEventListener('change', function() {
        getItems(fil.value);
    }, true);

}

var conexion_items;
function getItems(fil) {

    conexion_items = new XMLHttpRequest();
    conexion_items.onreadystatechange = processItems;
    conexion_items.open('GET', 'cargarCatalogo.php?filter=' + encodeURIComponent(fil), true);
    conexion_items.send();

}

function processItems() {

    var products = document.getElementById('products');

    if (conexion_items.readyState == 4 && conexion_items.status == 200) {
        // Parsear el JSON recibido
        var data = JSON.parse(conexion_items.responseText);
        products.innerHTML = "";  // Limpiar contenido previo

        // Construir tarjetas
        data.forEach(function(item) {
            var card = `
                <div class='card' style='width: 18rem;'>
                    <img src='https://dummyimage.com/150x150/000/fff' class='card-img-top' alt='${item.nombre}'>
                    <div class='card-body'>
                        <p class='card-text'>${item.nombre}</p>
                    </div>
                </div>
            `;
            products.innerHTML += card;
        });

    } else {
        products.innerHTML = "Cargando...";
    }

}