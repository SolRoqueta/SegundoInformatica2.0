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

// Variables del carrusel
const track = document.querySelector(".carousel-track");
const slides = Array.from(document.querySelectorAll(".carousel-slide"));
const nextButton = document.getElementById("next");
const prevButton = document.getElementById("prev");
const slideWidth = (slides[0].offsetWidth); 

// Función para mover el carrusel a la derecha
nextButton.addEventListener("click", () => {
    track.style.transition = "none";
    track.style.transform = `translateX(-${slideWidth}px)`;
    setTimeout(() => {
        track.style.transition = "transform 0.5s ease-in-out";
        track.style.transform = "translateX(0)";
    }, 0);
});

// // Función para mover el carrusel a la izquierda
prevButton.addEventListener("click", () => {
    track.insertBefore(track.lastElementChild, track.firstChild);
    track.style.transition = "none";
    track.style.transform = `translateX(${slideWidth}px)`;
    setTimeout(() => {
        track.style.transition = "transform 0.5s ease-in-out";
        track.style.transform = "translateX(0)";
    }, 0);
});

