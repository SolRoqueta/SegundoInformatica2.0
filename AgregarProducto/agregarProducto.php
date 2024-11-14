<?php

    function conexion($query) {

        $host = 'localhost';
        $user = 'root';
        $password = 'root';
        $data_base = 'cantina_daniela';

        // Crear la conexión
        $conn = mysqli_connect($host, $user, $password, $data_base);

        // Verificar si la conexión fue exitosa
        if (!$conn) {

            die("Conexión fallida: " . mysqli_connect_error());

        }

        // Ejecutar la consulta
        $resultado = mysqli_query($conn, $query);

        return array($resultado, $conn);

    }


    $nombre = $_REQUEST['name'];
    $precio = $_REQUEST['price'];
    $descripcion = $_REQUEST['description'];


    $query = "INSERT INTO productos (nombre, precio, descripcion) VALUES ('$nombre', '$precio', '$descripcion');";


    $output = conexion($query);
    $resultado = $output[0];
    $conn = $output[1];


    $data = [];

    if ($resultado) {

        $data = [];

        $data[] = [

            'resultado' => "Producto agregado con éxito.",
            'resultNum' => "1"
        
        ];

    } else {

        $data = [];

        $data[] = [

            'resultado' => "Error al agregar el producto.",
            'resultNum' => "0"

        ];

    }

    mysqli_close($conn);

    echo json_encode($data);

?>
