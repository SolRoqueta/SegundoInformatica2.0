// Espera a que el DOM esté completamente cargado
window.addEventListener("DOMContentLoaded", () => { 
    showLoader(); 
}) 

// Espera que carguen los estilos
window.addEventListener("load", () => { 
    setTimeout(() => { 
        hideLoader(); 
    }, 2000); // Oculta el loader después de 2 segundos
}) 

// Selecciona el elemento del loader
const loader = document.getElementById("loaderPagina"); 

// Función para mostrar el loader
const showLoader = () => { 
    loader.classList.add("show-loader"); 
} 

// Función para ocultar el loader
const hideLoader = () => { 
    loader.classList.remove("show-loader"); 
}

// Codigo Carousel MenuSemanal

const track = document.querySelector('.carousel-track');
const slides = Array.from(track.children);
const prevButton = document.getElementById('prev');
const nextButton = document.getElementById('next');

const slideWidth = slides[0].getBoundingClientRect().width;
const slidesToMove = 1.1; // Define how many slides to move with each click

// Arrange the slides next to one another
const setSlidePosition = (slide, index) => {
  slide.style.left = slideWidth * index + 'px';
};

slides.forEach(setSlidePosition);

let currentIndex = 0;

// Move to a specific slide
const moveToSlide = (track, currentSlide, targetIndex) => {
  track.style.transform = 'translateX(-' + slideWidth * targetIndex + 'px)';
  currentIndex = targetIndex; // Update the current index
};

// Update the buttons (disable if at the end/start)
const updateButtons = () => {
  prevButton.disabled = currentIndex === 0;
  nextButton.disabled = currentIndex >= slides.length - 3;
};

updateButtons();

// When you click next
nextButton.addEventListener('click', () => {
  const targetIndex = Math.min(currentIndex + slidesToMove, slides.length - 1.5); // Ensure we don't go past the last slide
  moveToSlide(track, slides[currentIndex], targetIndex);
  updateButtons();
});

// When you click previous
prevButton.addEventListener('click', () => {
  const targetIndex = Math.max(currentIndex - slidesToMove, 0); // Ensure we don't go before the first slide
  moveToSlide(track, slides[currentIndex], targetIndex);
  updateButtons();
});

//Funcion para la sobra/transparencia del scroll del loader
window.addEventListener('scroll', function() {
  const navbar = document.querySelector('.navbar');
  if (window.scrollY > 50) {
      navbar.classList.add('scrolled');
  } else {
      navbar.classList.remove('scrolled');
  }
});


//funcion para que se desplegue el boton en menu fijo 
function toggleText(id) {
  const content = document.getElementById(id);
  if (content.style.display === "none") {
      content.style.display = "block";
  } else {
      content.style.display = "none";
  }
}

