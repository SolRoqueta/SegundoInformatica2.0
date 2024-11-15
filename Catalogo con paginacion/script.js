document.addEventListener('DOMContentLoaded', startEvents, false);

let actualPage = 1;
let itemsPerPage  = 16;
let maximumPages;

function startEvents() {

    getItems();

    var fil = document.getElementById('filter');
    fil.addEventListener('change', function() {
        getItems(fil.value);
        actualPage = 1;
    }, true);

}

function calculateOffset() {

    const offset = (actualPage - 1) * itemsPerPage ;
    return offset;

}

var conexion_items;
function getItems(fil) {

    conexion_items = new XMLHttpRequest();
    conexion_items.onreadystatechange = processItems;
    conexion_items.open('GET', `cargarCatalogo.php?filter=${encodeURIComponent(fil)}`, true);
    conexion_items.send();

}

function processItems() {

    var products = document.getElementById('products');
    products.innerHTML = "";

    var pages = document.getElementById('pages');
    var buttonsHTML = "";

    if (conexion_items.readyState == 4 && conexion_items.status == 200) {

        var data = JSON.parse(conexion_items.responseText);
        maximumPages = data[0].paginas;

        checkFirstPageAndLast();

        for (var i = 1; i <= data[0].paginas; i++) {

            if (i == actualPage) {

                buttonsHTML += `<li id='page-${i}'class="page-item active">

                                <a href="javascript:void(0)" onclick="pageSelect(${i})" class="page-link">${i}</a>

                            </li>`;

            } else {

                buttonsHTML += `<li id='page-${i}'class="page-item">

                                <a href="javascript:void(0)" onclick="pageSelect(${i})" class="page-link">${i}</a>

                            </li>`;

            }

        }

        pages.innerHTML = buttonsHTML;

        // Construir tarjetas
        for (var i = calculateOffset()+1; i <= calculateOffset()+16; i++) {

            if (data[i] != null) {

                var card = `

                    <div class='card' style='width: 18rem;'>

                        <img src='https://dummyimage.com/150x150/000/fff' class='card-img-top' alt='${data[i].nombre}'>

                        <div class='card-body'>

                            <p class='card-text'>${data[i].nombre}</p>

                        </div>

                    </div>

                `;

                products.innerHTML += card;

            }

        }


    } else {

        products.innerHTML = "Cargando...";

    }

}

function pageSelect(pageNum) {

    actualPage = pageNum;
    processItems();
    goToPagination();

}

function goToPagination() {

    var paginationElement = document.getElementById('pagination');
    window.scrollTo(0, paginationElement.offsetTop);

}

function nextPage() {
    
    if (actualPage < maximumPages) {

        actualPage++;
        processItems();

    }

    checkFirstPageAndLast();
    goToPagination();

}

function previousPage() {

    if (actualPage > 1) {

        actualPage--;
        processItems();

    }

    checkFirstPageAndLast();
    goToPagination();

}

function checkFirstPageAndLast() {

    var previousBtn = document.getElementById('previousBtn');
    var nextBtn = document.getElementById('nextBtn');

    if (actualPage == 1) {

        previousBtn.classList.add("disabled");

    } else {

        previousBtn.classList.remove("disabled");

    }

    if (actualPage == maximumPages) {

        nextBtn.classList.add("disabled");

    } else {

        nextBtn.classList.remove("disabled");

    }

}