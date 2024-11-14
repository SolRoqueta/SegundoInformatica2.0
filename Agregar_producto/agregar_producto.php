<?php

header('Content-Type: text/html; charset=utf-8');


function conexion($query) {
    $host = 'localhost';
    $usuario = 'root';
    $contraseña = 'root';
    $base_de_datos = 'cantina_daniela';

    // Crear la conexión
    $conn = mysqli_connect($host, $usuario, $contraseña, $base_de_datos);

    // Verificar si la conexión fue exitosa
    if (!$conn) {
        die("Conexión fallida: " . mysqli_connect_error());

    }

    // Ejecutar la consulta
    $resultado = mysqli_query($conn, $query);

    return array($resultado, $conn);
}


$nombre = $_REQUEST['nombre'];
$precio = $_REQUEST['precio'];
$descripcion = $_REQUEST['descripcion'];


$query = "INSERT INTO productos (nombre, precio, descripcion) VALUES ('$nombre', '$precio', '$descripcion');";


$output = conexion($query);
$resultado = $output[0];
$conn = $output[1];


if ($resultado) {
    echo "Producto agregado con éxito.";
} else {
    echo "Error al agregar el producto: " . mysqli_error($conn);
}


mysqli_close($conn);

?>
