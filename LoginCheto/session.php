<?php

    header('Content-Type: application/json');

    session_start();

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

    $email = $_REQUEST['email'];
    $userType = $_REQUEST['userType'];

    $query = "SELECT * FROM usuarios WHERE mail = '".$email."';";

    $output = conexion($query);
    $resultado = $output[0];
    $conn = $output[1];

    if (mysqli_num_rows($resultado) > 0) {
        // Mostrar los resultados
        while ($fila = mysqli_fetch_assoc($resultado)) {

            $_SESSION["name"] = $fila['nombre'];
            $_SESSION["mail"] = $fila['mail'];

        }
    } else {

        echo "No se encontraron resultados.";

    }

    mysqli_close($conn);

?>