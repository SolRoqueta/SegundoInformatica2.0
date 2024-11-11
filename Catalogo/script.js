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

        products.innerHTML = conexion_items.responseText;

    } else {

        products.innerHTML = "cargando...";

    }

}