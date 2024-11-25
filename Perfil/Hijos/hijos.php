<?php

    header('Content-Type: text/html; charset=utf-8');

    $data = [];

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

    $option = $_REQUEST['option'];

    switch ($option) {

        case 1:

            $userMail = $_REQUEST['mail'];

            $query = "SELECT * FROM usuarios WHERE mail = '".$userMail."';";
            $output = conexion($query);
            $resultado = $output[0];
            $conn = $output[1];

            $id = null;

            if (mysqli_num_rows($resultado) > 0) {
                
                while ($fila = mysqli_fetch_assoc($resultado)) {
    
                    $id = $fila['id_usuario'];
    
                }

            } else {
    
                echo "No se encontraron resultados.";
    
            }

            mysqli_close($conn);

            $query = "SELECT * FROM alumnos WHERE fk_id_usuario = ".$id.";";
            $output = conexion($query);
            $resultado = $output[0];
            $conn = $output[1];

            if (mysqli_num_rows($resultado) > 0) {
                
                while ($fila = mysqli_fetch_assoc($resultado)) {
    
                    $data[] = [

                        'nombreCompleto' => $fila['nombre_completo'],
                        'grupo' => $fila['grupo']

                    ];
    
                }

            } else {
    
                echo "No se encontraron resultados.";
    
            }

            mysqli_close($conn);

            echo json_encode($data);

        break;
        case 2:

            $userMail = $_REQUEST['mail'];
            $completeName = $_REQUEST['completeName'];
            $group = $_REQUEST['group'];

            $query = "SELECT * FROM usuarios WHERE mail = '".$userMail."';";
            $output = conexion($query);
            $resultado = $output[0];
            $conn = $output[1];

            $id = null;

            if (mysqli_num_rows($resultado) > 0) {
                
                while ($fila = mysqli_fetch_assoc($resultado)) {
    
                    $id = $fila['id_usuario'];
    
                }

            } else {
    
                echo "No se encontraron resultados.";
    
            }

            mysqli_close($conn);

            $query = "INSERT INTO alumnos (nombre_completo, fk_id_usuario, grupo) VALUES ('".$completeName."', ".$id.", '".$group."')";
            $output = conexion($query);
            $resultado = $output[0];
            $conn = $output[1];

        break;

    }

?>