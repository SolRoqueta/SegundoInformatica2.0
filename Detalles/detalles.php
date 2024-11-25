<?php

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

    $tipo = $_REQUEST['tipo'];
    $id = $_REQUEST['id'];
    $tipoId = $_REQUEST['tipoId'];

    $query = "SELECT * FROM ".$tipo." WHERE ".$tipoId." = ".$id.";";
    error_log("Query ejecutada: " . $query);
    $output = conexion($query);
    $resultado = $output[0];
    $conn = $output[1];

    if (mysqli_num_rows($resultado) > 0) {
        
        $fila = mysqli_fetch_assoc($resultado);

        $fotoDescomprimida = gzdecode($fila['foto']);
        
        // Verificar si la descompresión fue exitosa
        if ($fotoDescomprimida === false) {

            echo "Error al descomprimir la imagen.";

        }

        // Codificar la foto en base64
        $foto = base64_encode($fotoDescomprimida);

        // Detectar el tipo MIME de la imagen
        $finfo = finfo_open(FILEINFO_MIME_TYPE);
        $tipoImagen = finfo_buffer($finfo, $fotoDescomprimida);
        finfo_close($finfo);

        $cad = 'data:'.$tipoImagen.';base64,'.$foto.'';

        $data[] = [

            'nombre' => $fila['nombre'],
            'descripcion' => $fila['descripcion'],
            'precio' => $fila['precio'],
            'foto' => $cad

        ];

    }

    echo json_encode($data);

?>