
document.querySelectorAll('.sidebar nav ul li').forEach(item => {
    item.addEventListener('click', () => {
        // Elimina la clase 'active' de todas las opciones
        document.querySelectorAll('.sidebar nav ul li').forEach(option => option.classList.remove('active'));

        // Añade la clase 'active' a la opción seleccionada
        item.classList.add('active');
    });
});
