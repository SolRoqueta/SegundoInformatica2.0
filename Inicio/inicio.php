<?php

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

    switch ($_REQUEST['func']) {

        case "products":

            loadProducts();

            break;

        case "fixedMenus":

            fixedMenus();

            break;

    }

    function fixedMenus() {

        $query = "SELECT * FROM menus WHERE diario = 0 AND foto IS NOT NULL LIMIT 6;";

        $output = conexion($query);
        $resultado = $output[0];
        $conn = $output[1];

        if (mysqli_num_rows($resultado) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado)) {

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

                $result = "

                    <div class='card'>
                    <img class='card-img-top' src='data:".$tipoImagen.";base64,".$foto."' alt='Card image'>
                    <div class='card-body'>
                        <h4 class='card-title'>" . $fila['nombre'] . "</h4>
                        <h5 class='card-title price'>" . $fila['precio'] . "</h5>
                        <p class='card-text'>" . $fila['descripcion'] ."</p>
                    </div>
                    </div>

                ";


                echo $result;

            }
        } else {

            echo "No se encontraron resultados.";

        }

        // Cerrar la conexión
        mysqli_close($conn);

    }

    function loadProducts() {

        $query = "SELECT * FROM productos WHERE foto IS NOT NULL LIMIT 6;";

        $output = conexion($query);
        $resultado = $output[0];
        $conn = $output[1];

        if (mysqli_num_rows($resultado) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado)) {

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

                $foto = base64_encode($fotoDescomprimida);
                $tipoImagen = 'image/jpeg';

                $result = "
                    
                    <div class='card card-producto'>
                    <img src='data:".$tipoImagen.";base64,".$foto."'/>
                    <div class='info-producto'>
                        <h5 class='name-producto'>" . $fila['nombre'] . "</h5>
                        <h5 class='price-producto'>$" . $fila['precio'] . "</h5>
                        <p class='desc-producto'>" . $fila['descripcion'] . "</p> 
                    </div>
                    </div>
                ";


                echo $result;

            }
        } else {

            echo "No se encontraron resultados.";

        }

        // Cerrar la conexión
        mysqli_close($conn);

    }

?>