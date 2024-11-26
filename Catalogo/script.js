document.addEventListener('DOMContentLoaded', startEvents, false);

let actualPage = 1;
let itemsPerPage  = 16;
let maximumPages;

let userData;
let userName;
let userMail;

let currentFilter;

var data;

function startEvents() {

    getUser();
    getItems();
    putFooter();

    var catalogo = document.getElementById('catalogo');
    catalogo.classList.add("current-page");

}

function putFooter() {

    const footerContainer = document.getElementById('footer-container');

    // Usa fetch para cargar el archivo footer.html
    fetch('../footer/footer.html')

    .then(response => {

        if (!response.ok) {

            throw new Error('Error al cargar el footer');

        }

        return response.text();

    })
    .then(footer => {

        footerContainer.innerHTML = footer;

    })
    .catch(error => {

        console.error('Error:', error);

    });

}

var connection_user;
function getUser() {

  connection_user = new XMLHttpRequest();
  connection_user.onreadystatechange = processUser;
  connection_user.open('GET', 'session.php?option=1', true);
  connection_user.send();

}

var connection_closeUser;
function closeSession() {

  connection_closeUser = new XMLHttpRequest();
  connection_closeUser.onreadystatechange = location.reload();
  connection_closeUser.open('GET', 'session.php?option=2', true);
  connection_closeUser.send();

}

function processUser() {

  var profile = document.getElementById('profile');
  var dropdown = document.getElementById('profile-dropdown');

  if (connection_user.readyState == 4 && connection_user.status == 200) {

    if (connection_user.responseText != "") {

      userData = JSON.parse(connection_user.responseText);
  
      console.log("Nombre del usuario: " + userData[0].nombre);

      userName = userData[0].nombre;
      userMail = userData[0].mail;

      profile.innerHTML = userName;

      if (userName != "") {

        dropdown.innerHTML = `

          <li><a class="dropdown-item" href="../Perfil/Perfil_Usuario/perfil.html">Perfil</a></li>
          <li><a class="dropdown-item" href="../Perfil/Hijos/hijos.html">Hijos</a></li>
          <li><hr class="dropdown-divider"></li> 
          <li><a class="dropdown-item" onclick="closeSession()" href="#">Cerrar sesión</a></li>
                  
        `;

      }

    } else {

      dropdown.classList.remove("dropdown-menu");
      profile.addEventListener('click', (e)=> {

        e.preventDefault();
        window.location.href = "../Login/login.html";

      }, true);

    }

  }

}

function calculateOffset() {

    const offset = (actualPage - 1) * itemsPerPage ;
    return offset;

}

var conexion_items;
function getItems(fil) {

    conexion_items = new XMLHttpRequest();
    conexion_items.onreadystatechange = processItems;
    conexion_items.open('GET', `catalogo.php?filter=${currentFilter}`, true);
    conexion_items.send();

}

function processItems() {

    var products = document.getElementById('products');
    products.innerHTML = "";

    var pages = document.getElementById('pages');
    var buttonsHTML = "";

    if (conexion_items.readyState == 4 && conexion_items.status == 200) {

        data = JSON.parse(conexion_items.responseText);
        maximumPages = data[0].paginas;

        checkFirstPageAndLast();

        for (var i = 1; i <= data[0].paginas; i++) {

            if (i == actualPage) {

                buttonsHTML += `<li id='page-${i}'class="page-item active">

                                <a href="javascript:void(0)" onclick="pageSelect(${i})" class="page-link paginationButton">${i}</a>

                            </li>`;

            } else {

                buttonsHTML += `

                                <li id='page-${i}'class="page-item">

                                    <a href="javascript:void(0)" onclick="pageSelect(${i})" class="page-link paginationButton">${i}</a>

                                </li>
                            
                `;

            }

        }

        pages.innerHTML = buttonsHTML;

        // Construir tarjetas
        for (var i = calculateOffset()+1; i <= calculateOffset()+16; i++) {

            if (data[i] != null) {

                var card = `

                    <div id="item-${i}" class='card' style='width: 18rem;' onclick="grabAndSendData(${i})">

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

function grabAndSendData(id) {

    if (data[id]) {
        const datos = { tipo: data[id].tipo, id: data[id].id, tipoId: data[id].tipoId };
        const datosJSON = encodeURIComponent(JSON.stringify(datos));
        window.location.href = `../Detalles/detalles.html?datos=${datosJSON}`;
    } else {
        console.log("No hay datos para este ID");
    }

}

function pageSelect(pageNum) {

    actualPage = pageNum;
    processItems();
    goToTop();

}

function goToTop() {

    var heroPageElement = document.getElementById('heroPage');
    window.scrollTo(0, heroPageElement.offsetTop);

}

function nextPage() {
    
    if (actualPage < maximumPages) {

        actualPage++;
        processItems();

    }

    checkFirstPageAndLast();
    goToTop();

}

function previousPage() {

    if (actualPage > 1) {

        actualPage--;
        processItems();

    }

    checkFirstPageAndLast();
    goToTop();

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

function setFilter(filter_value) {

    currentFilter = filter_value;
    setFilterText(filter_value);
    getItems(filter_value);
    actualPage = 1;

}

function setFilterText(filter_value) {

    var title = '';

    switch (filter_value) {

        case 'all':

            title = 'Todos';

            break;

        case 'products':

            title = 'Productos';

            break;

        case 'daily-menus':

            title = 'Menús Diarios';

            break;

        case 'fixed-menus':

            title = 'Menús Fijos';
    
            break;

        default:
            
            title = 'Todos';

            break;

    }

    const filterText = document.getElementById('filter-tag');
    filterText.innerHTML = title;

}

window.addEventListener('scroll', () => {

    var catalogo = document.getElementById('catalogo');
    var contacto = document.getElementById('contacto');
  
      // Altura total de la página
      const pageHeight = document.documentElement.scrollHeight;
      // Altura visible de la ventana
      const viewportHeight = window.innerHeight;
      // Posición actual del desplazamiento
      const scrollPosition = window.scrollY;
  
      // Verificar si el usuario está al final
      if (scrollPosition + viewportHeight >= pageHeight) {
          
        catalogo.classList.remove('current-page');
        contacto.classList.add('current-page');
  
      } else {
  
        catalogo.classList.add('current-page');
        contacto.classList.remove('current-page');
  
      }
  
  });