let userData;
let userName;
let userMail;

document.addEventListener('DOMContentLoaded', startEvents, false);

function startEvents() {

  getProducts();
  getUser();

  var inicio = document.getElementById('inicio');
  inicio.classList.add("current-page");

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

          <li><a class="dropdown-item" href="#" onclick="alert('Lleva a la configuracion del usuario')">Perfil</a></li>
          <li><a class="dropdown-item" href="#" onclick="alert('Lleva a los hijos del usuario dentro de la configuracion del mismo')">Hijos</a></li>
          <li><hr class="dropdown-divider"></li> 
          <li><a class="dropdown-item" onclick="closeSession()" href="#">Cerrar sesión</a></li>
                  
        `;

      }

    } else {

      dropdown.innerHTML = `

          <li><a class="dropdown-item" href="../Login/login.html">Iniciar sesión</a></li>
                  
        `;

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

      fixedMenus.innerHTML = conection_fixedMenus.responseText;

    } else {

      fixedMenus.innerHTML = "cargando...";

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

      products.innerHTML = conection_products.responseText;
      getFixedMenus();

    } else {

      products.innerHTML = "cargando...";

    }

}

new Swiper('.card-wrapper', {
  spaceBetween:20,

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
    if (window.scrollY > 10) { // Si se scrollea más de 50px
      navbar.classList.add("scrolled");
    } else {
      navbar.classList.remove("scrolled");
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