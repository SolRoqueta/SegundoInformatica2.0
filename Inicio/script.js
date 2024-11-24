// Espera a que el DOM esté completamente cargado
window.addEventListener("DOMContentLoaded", () => { 
    showLoader(); 
}) 

document.addEventListener('DOMContentLoaded', startEvents, true);

function startEvents() {

    getProducts();

}

var conection_fixedMenus
function getFixedMenus() {

    conection_fixedMenus = new XMLHttpRequest();
    conection_fixedMenus.onreadystatechange = proccessFixedMenus;
    conection_fixedMenus.open('GET', 'inicio.php?func=fixedMenus', true);
    conection_fixedMenus.send();

}

function proccessFixedMenus() {

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
    conection_products.onreadystatechange = proccessProducts;
    conection_products.open('GET', 'inicio.php?func=products', true);
    conection_products.send();

}

function proccessProducts() {

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