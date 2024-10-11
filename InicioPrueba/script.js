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
