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

    switch ($_REQUEST['filter']) {

        case 'all':

            all();

            break;

        case 'products':

            products();

            break;

        case 'daily-menus':

            dailyMenus();

            break;

        case 'fixed-menus':

            fixedMenus();
    
            break;

        default:
            
            all();

            break;

    }

    function fixedMenus() {

        $query = "SELECT * FROM menus WHERE diario = 0;";

        // Ejecutar la consulta
        $resultado = conexion($query);
        $data = [];

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $data[] = [

                    'nombre' => $fila['nombre'],
                    'foto' => 'data:image/jpeg;base64,' . base64_encode($fila['foto'])
                
                ];

            }
        } else {

            echo "No se encontraron resultados.";

        }

        // Cerrar la conexión
        mysqli_close($resultado[1]);
        echo json_encode($data);

    }

    function dailyMenus() {

        $query = "SELECT * FROM menus WHERE diario = 1;";

        // Ejecutar la consulta
        $resultado = conexion($query);
        $data = [];

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $data[] = [

                    'nombre' => $fila['nombre'],
                    'foto' => 'data:image/jpeg;base64,' . base64_encode($fila['foto'])
                
                ];

            }
        } else {

            echo "No se encontraron resultados.";

        }

        // Cerrar la conexión
        mysqli_close($resultado[1]);
        echo json_encode($data);

    }

    function products() {

        $query = "SELECT * FROM productos";

        $resultado = conexion($query);
        $data = [];

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $data[] = [

                    'nombre' => $fila['nombre'],
                    'foto' => 'data:image/jpeg;base64,' . base64_encode($fila['foto'])
                
                ];

            }
        } else {

            echo "No se encontraron resultados.";

        }

        // Cerrar la conexión
        mysqli_close($resultado[1]);
        echo json_encode($data);

    }

    function all() {

        $query = "SELECT * FROM productos";

        $resultado = conexion($query);
        $data = [];

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $data[] = [

                    'nombre' => $fila['nombre'],
                    'foto' => 'data:image/jpeg;base64,' . base64_encode($fila['foto'])
                
                ];

            }
        } else {

            echo "No se encontraron resultados.";

        }

        // Cerrar la conexión
        mysqli_close($resultado[1]);

        $query = "SELECT * FROM menus";

        // Ejecutar la consulta
        $resultado = conexion($query);

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $data[] = [

                    'nombre' => $fila['nombre'],
                    'foto' => 'data:image/jpeg;base64,' . base64_encode($fila['foto'])
                
                ];

            }
        } else {

            echo "No se encontraron resultados.";

        }

        // Cerrar la conexión
        mysqli_close($resultado[1]);
        echo json_encode($data);

    }

?>