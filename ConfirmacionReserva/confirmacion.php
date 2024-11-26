<?php

    session_start();

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

    $op = $_REQUEST['option'];

    switch ($op) {

        case 1:

            $userMail = $_SESSION['mail'];

            $query = "SELECT * FROM usuarios WHERE mail = '" . $userMail . "';";
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

            $query = "SELECT * FROM alumnos WHERE fk_id_usuario = " . $id . ";";
            $output = conexion($query);
            $resultado = $output[0];
            $conn = $output[1];

            if (mysqli_num_rows($resultado) > 0) {
                
                while ($fila = mysqli_fetch_assoc($resultado)) {
    
                    $data[] = [

                        'nombre' => $fila['nombre_completo'],
                        'id' => $fila['id_alumno']

                    ];
    
                }

            } else {
    
                
    
            }
    
            mysqli_close($conn);

            echo json_encode($data);

        break;
        case 2:

            $userMail = $_SESSION['mail'];

            $query = "SELECT * FROM usuarios WHERE mail = '" . $userMail . "';";
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

            $total = $_REQUEST['total'];
            $date = $_REQUEST['date'];

            echo "TOTAL: " . $total;
 
            $query = "INSERT INTO pedidos (total, fecha, fk_id_usuario) VALUES (" . $total . ", '" . $date . "', " . $id .")";

            $output = conexion($query);
            $resultado = $output[0];
            $conn = $output[1];
    
            mysqli_close($conn);

            exit;

        break;

    }

?>