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

        $data[] = [

            'nombre' => $fila['nombre'],
            'descripcion' => $fila['descripcion'],
            'precio' => $fila['precio']
            // 'foto' => 'data:image/jpeg;base64,' . base64_encode($fila['foto'])

        ];

    }

    echo json_encode($data);

?>