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

    $email = $_REQUEST['email'];
    $userType = $_REQUEST['userType'];

    $query = "SELECT * FROM usuarios WHERE tipo_usuario = '".$userType."';";

    $output = conexion($query);
    $resultado = $output[0];
    $conn = $output[1];

    $hasToShow = true;

    if (mysqli_num_rows($resultado) > 0) {
        // Mostrar los resultados
        while ($fila = mysqli_fetch_assoc($resultado)) {

            if ($fila['mail'] == $email) {

                mysqli_close($conn);
                $hasToShow = false;
                checkPassword();
                break;

            }

        }

        if ($hasToShow) {

            echo "El mail ingresado no existe.";

        }
    } else {

        echo "No se encontraron resultados.";

        mysqli_close($conn);

    }

    function checkPassword() {

        $email = $_REQUEST['email'];
        $password = $_REQUEST['password'];

        $query = "SELECT contrasenia FROM usuarios WHERE mail = '".$email."' LIMIT 1;";

        $output = conexion($query);
        $resultado = $output[0];
        $conn = $output[1];

        if (mysqli_num_rows($resultado) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado)) {
    
                if ($fila['contrasenia'] == $password) {
    
                    echo "pass";
                    break;
    
                } else {

                    echo "Contraseña incorrecta";

                }
    
            }
        } else {
    
            echo "No se encontraron resultados.";
    
            mysqli_close($conn);
    
        }

    }

?>