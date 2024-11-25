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

    $option = $_REQUEST['option'];

    switch ($option) {

        case 1:

            $currentName = $_REQUEST['currentName'];
            $newName = $_REQUEST['name'];

            $query = "SELECT * FROM usuarios WHERE nombre = '".$currentName."';";
            $output = conexion($query);
            $resultado = $output[0];
            $conn = $output[1];

            $id = null;

            if (mysqli_num_rows($resultado) > 0) {
                
                while ($fila = mysqli_fetch_assoc($resultado)) {
    
                    $id = $fila['id_usuario'];
    
                }

            } else {
    
                echo "No se pudo obtener el ID.";
    
            }
    
            mysqli_close($conn);

            $query = "UPDATE usuarios SET nombre = '".$newName."' WHERE id_usuario = ".$id.";";
            $output = conexion($query);
            $resultado = $output[0];
            $conn = $output[1];

            if ($resultado) {
                
                echo "Nombre modificado con exito!";

            } else {
    
                echo "No se puedieron actualizar los datos.";
    
            }
    
            mysqli_close($conn);

            break;
        case 2:



            break;

    }

?>