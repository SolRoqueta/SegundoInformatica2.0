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

        $query = "SELECT count(*) AS count FROM menus WHERE diario = 0 AND foto IS NOT NULL;";
        $output = conexion($query);
        $fixedMenuQuantity = mysqli_fetch_assoc($output[0])['count'];
        mysqli_close($output[1]);

        $totalQuantity = $fixedMenuQuantity;
        $totalPages = ceil($totalQuantity / 16);

        $data[] = [

            'paginas' => $totalPages
        
        ];

        $query = "SELECT * FROM menus WHERE diario = 0 AND foto IS NOT NULL;";

        // Ejecutar la consulta
        $resultado = conexion($query);

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $fotoDescomprimida = gzdecode($fila['foto']);
        
                // Verificar si la descompresión fue exitosa
                if ($fotoDescomprimida === false) {

                    echo "Error al descomprimir la imagen.";
                    continue;  // Salta al siguiente registro si hay un error

                }

                // Codificar la foto en base64
                $foto = base64_encode($fotoDescomprimida);

                // Detectar el tipo MIME de la imagen
                $finfo = finfo_open(FILEINFO_MIME_TYPE);
                $tipoImagen = finfo_buffer($finfo, $fotoDescomprimida);
                finfo_close($finfo);

                $cad = 'data:'.$tipoImagen.';base64,'.$foto.'';

                $data[] = [
                    
                    'id' => $fila['id_menu'],
                    'tipoId' => "id_menu",
                    'tipo' => "menus",
                    'nombre' => $fila['nombre'],
                    'foto' => $cad
                
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

        $query = "SELECT count(*) AS count FROM menus WHERE diario = 1 AND foto IS NOT NULL;";
        $output = conexion($query);
        $dailyMenuQuantity = mysqli_fetch_assoc($output[0])['count'];
        mysqli_close($output[1]);

        $totalQuantity = $dailyMenuQuantity;
        $totalPages = ceil($totalQuantity / 16);

        $data[] = [

            'paginas' => $totalPages
        
        ];

        $query = "SELECT * FROM menus WHERE diario = 1 AND foto IS NOT NULL;";

        // Ejecutar la consulta
        $resultado = conexion($query);

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $fotoDescomprimida = gzdecode($fila['foto']);
        
                // Verificar si la descompresión fue exitosa
                if ($fotoDescomprimida === false) {

                    echo "Error al descomprimir la imagen.";
                    continue;  // Salta al siguiente registro si hay un error

                }

                // Codificar la foto en base64
                $foto = base64_encode($fotoDescomprimida);

                // Detectar el tipo MIME de la imagen
                $finfo = finfo_open(FILEINFO_MIME_TYPE);
                $tipoImagen = finfo_buffer($finfo, $fotoDescomprimida);
                finfo_close($finfo);

                $cad = 'data:'.$tipoImagen.';base64,'.$foto.'';

                $data[] = [

                    'id' => $fila['id_menu'],
                    'tipoId' => "id_menu",
                    'tipo' => "menus",
                    'nombre' => $fila['nombre'],
                    'foto' => $cad
                
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

        $query = "SELECT count(*) AS count FROM productos WHERE foto IS NOT NULL;";
        $output = conexion($query);
        $productQuantity = mysqli_fetch_assoc($output[0])['count'];
        mysqli_close($output[1]);

        $totalQuantity = $productQuantity;
        $totalPages = ceil($totalQuantity / 16);

        $data[] = [

            'paginas' => $totalPages
        
        ];

        $query = "SELECT * FROM productos WHERE foto IS NOT NULL";

        $resultado = conexion($query);

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $fotoDescomprimida = gzdecode($fila['foto']);
        
                // Verificar si la descompresión fue exitosa
                if ($fotoDescomprimida === false) {

                    echo "Error al descomprimir la imagen.";
                    continue;  // Salta al siguiente registro si hay un error

                }

                // Codificar la foto en base64
                $foto = base64_encode($fotoDescomprimida);

                // Detectar el tipo MIME de la imagen
                $finfo = finfo_open(FILEINFO_MIME_TYPE);
                $tipoImagen = finfo_buffer($finfo, $fotoDescomprimida);
                finfo_close($finfo);

                $cad = 'data:'.$tipoImagen.';base64,'.$foto.'';

                $data[] = [

                    'id' => $fila['id_producto'],
                    'tipoId' => "id_producto",
                    'tipo' => "productos",
                    'nombre' => $fila['nombre'],
                    'foto' => $cad
                
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

        $query = "SELECT count(*) AS count FROM productos WHERE foto IS NOT NULL;";
        $output = conexion($query);
        $productQuantity = mysqli_fetch_assoc($output[0])['count'];
        mysqli_close($output[1]);

        $query = "SELECT count(*) AS count FROM menus;";
        $output = conexion($query);
        $menusQuantity = mysqli_fetch_assoc($output[0])['count'];
        mysqli_close($output[1]);

        $totalQuantity = $productQuantity + $menusQuantity;
        $totalPages = ceil($totalQuantity / 16);

        $data[] = [

            'paginas' => $totalPages
        
        ];

        $query = "SELECT * FROM productos WHERE foto IS NOT NULL;";

        $resultado = conexion($query);

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $fotoDescomprimida = gzdecode($fila['foto']);
        
                // Verificar si la descompresión fue exitosa
                if ($fotoDescomprimida === false) {

                    echo "Error al descomprimir la imagen.";
                    continue;  // Salta al siguiente registro si hay un error

                }

                // Codificar la foto en base64
                $foto = base64_encode($fotoDescomprimida);

                // Detectar el tipo MIME de la imagen
                $finfo = finfo_open(FILEINFO_MIME_TYPE);
                $tipoImagen = finfo_buffer($finfo, $fotoDescomprimida);
                finfo_close($finfo);

                $cad = 'data:'.$tipoImagen.';base64,'.$foto.'';

                $data[] = [

                    'id' => $fila['id_producto'],
                    'tipoId' => "id_producto",
                    'tipo' => "productos",
                    'nombre' => $fila['nombre'],
                    'foto' => $cad
                
                ];

            }
        } else {

            echo "No se encontraron resultados.";

        }

        // Cerrar la conexión
        mysqli_close($resultado[1]);

        $query = "SELECT * FROM menus WHERE foto IS NOT NULL";

        // Ejecutar la consulta
        $resultado = conexion($query);

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $fotoDescomprimida = gzdecode($fila['foto']);
        
                // Verificar si la descompresión fue exitosa
                if ($fotoDescomprimida === false) {

                    echo "Error al descomprimir la imagen.";
                    continue;  // Salta al siguiente registro si hay un error

                }

                // Codificar la foto en base64
                $foto = base64_encode($fotoDescomprimida);

                // Detectar el tipo MIME de la imagen
                $finfo = finfo_open(FILEINFO_MIME_TYPE);
                $tipoImagen = finfo_buffer($finfo, $fotoDescomprimida);
                finfo_close($finfo);

                $cad = 'data:'.$tipoImagen.';base64,'.$foto.'';

                $data[] = [

                    'id' => $fila['id_menu'],
                    'tipoId' => "id_menu",
                    'tipo' => "menus",
                    'nombre' => $fila['nombre'],
                    'foto' => $cad
                
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