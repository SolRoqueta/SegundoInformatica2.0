// Función que actualiza la imagen del perfil cuando se selecciona una nueva imagen
function updatePhoto() {
    const fileInput = document.getElementById('file-input');
    const photoPlaceholder = document.getElementById('photo-placeholder');
    
    // Verifica si se seleccionó un archivo
    if (fileInput.files && fileInput.files[0]) {
        const reader = new FileReader();

        reader.onload = function (e) {
            // Actualiza la imagen de la foto de perfil
            photoPlaceholder.style.backgroundImage = `url(${e.target.result})`;
            photoPlaceholder.style.backgroundSize = 'cover';  // Ajusta el tamaño de la imagen
        }

        reader.readAsDataURL(fileInput.files[0]);
    }
}

document.querySelectorAll('.sidebar nav ul li').forEach(item => {
    item.addEventListener('click', () => {
        // Elimina la clase 'active' de todas las opciones
        document.querySelectorAll('.sidebar nav ul li').forEach(option => option.classList.remove('active'));

        // Añade la clase 'active' a la opción seleccionada
        item.classList.add('active');
    });
});
