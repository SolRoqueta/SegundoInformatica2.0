let userData;
let userName;
let userMail;

let lastMenu = 0;

let data;

document.addEventListener('DOMContentLoaded', startEvents, false);

function startEvents() {

  getFixedMenus();
  getUser();
  putFooter();

  var inicio = document.getElementById('inicio');
  inicio.classList.add("current-page");

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

var conection_fixedMenus
function getFixedMenus() {

  conection_fixedMenus = new XMLHttpRequest();
  conection_fixedMenus.onreadystatechange = processFixedMenus;
  conection_fixedMenus.open('GET', 'inicio.php?func=fixedMenus', true);
  conection_fixedMenus.send();

}

function processFixedMenus() {

  var fixedMenus = document.getElementById('fixedMenu');

  if (conection_fixedMenus.readyState == 4 && conection_fixedMenus.status == 200) {

    // fixedMenus.innerHTML = "";

    data = JSON.parse(conection_fixedMenus.responseText);

    for (var i = 0; i < data.length; i++) {

      var cad = `
      
          <div class='card' onclick="grabAndSendData(${i})">
          <img class='card-img-top' src="${data[i].foto}" alt='Card image'>
          <div class='card-body'>
              <h4 class='card-title'>${data[i].nombre}</h4>
              <h5 class='card-title price'>$${data[i].precio}</h5>
              <p class='card-text'>${data[i].descripcion}</p>
          </div>
          </div>

        `;

      lastMenu++;
      fixedMenus.innerHTML += cad;

    }

    getProducts();

  } else {

    // fixedMenus.innerHTML = "cargando...";

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

var conection_products
function getProducts() {

  conection_products = new XMLHttpRequest();
  conection_products.onreadystatechange = processProducts;
  conection_products.open('GET', 'inicio.php?func=products', true);
  conection_products.send();

}

function processProducts() {

  var products = document.getElementById('products');

  if (conection_products.readyState == 4 && conection_products.status == 200) {

    products.innerHTML = "";

    let data2 = JSON.parse(conection_products.responseText);

    data = [...data, ...data2];

    console.log(data);

    for (var i = lastMenu; i < data.length; i++) {

      var cad = `
      
          <div class='card' onclick="grabAndSendData(${i})">
          <img class='card-img-top' src="${data[i].foto}" alt='Card image'>
          <div class='card-body'>
              <h4 class='card-title'>${data[i].nombre}</h4>
              <h5 class='card-title price'>$${data[i].precio}</h5>
              <p class='card-text'>${data[i].descripcion}</p>
          </div>
          </div>

        `;

      products.innerHTML += cad;

    }

  } else {

    products.innerHTML = "cargando...";

  }

}

new Swiper('.card-wrapper', {
  spaceBetween: 20,

  // If we need pagination
  pagination: {
    el: '.swiper-pagination',
    clickable: true,
    dynamicBullets: true,
  },

  // Navigation arrows
  navigation: {
    nextEl: '.swiper-button-next',
    prevEl: '.swiper-button-prev',
  },

  breakpoints: {
    0: {
      slidesPerView: 1
    },
    768: {
      slidesPerView: 2
    },
  }
});

document.addEventListener("scroll", function () {

  const navbar = document.querySelector(".navbar");
  const heroPage = document.getElementById('hero-page');

  if (window.scrollY > 10) {

    navbar.classList.add("scrolled");
    navbar.classList.add("fixed-top");
    heroPage.classList.add("hero-section-plus");

  } else {

    navbar.classList.remove("scrolled");
    navbar.classList.remove("fixed-top");
    heroPage.classList.remove("hero-section-plus");

  }
});

window.addEventListener('scroll', () => {

  var inicio = document.getElementById('inicio');
  var contacto = document.getElementById('contacto');

  // Altura total de la página
  const pageHeight = document.documentElement.scrollHeight;
  // Altura visible de la ventana
  const viewportHeight = window.innerHeight;
  // Posición actual del desplazamiento
  const scrollPosition = window.scrollY;

  // Verificar si el usuario está al final
  if (scrollPosition + viewportHeight >= pageHeight) {

    inicio.classList.remove('current-page');
    contacto.classList.add('current-page');

  } else {

    inicio.classList.add('current-page');
    contacto.classList.remove('current-page');

  }

});