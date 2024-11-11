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

        $query = "SELECT * FROM menus WHERE diario = 0 LIMIT 4;";

        $output = conexion($query);
        $resultado = $output[0];
        $conn = $output[1];

        if (mysqli_num_rows($resultado) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado)) {

                $foto = base64_encode($fila['foto']);
                $tipoImagen = 'image/jpeg';

                $result = "
                    
                    <div class='fixed-menu-card'>
                        <div class='image-background'></div>
                        <div class='card-content'>
                            <p class='title'>" . $fila['nombre'] . "</p>
                            <p class='description'>" . $fila['descripcion'] . "</p>
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

        $query = "SELECT * FROM productos LIMIT 8;";

        $output = conexion($query);
        $resultado = $output[0];
        $conn = $output[1];

        if (mysqli_num_rows($resultado) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado)) {

                $foto = base64_encode($fila['foto']);
                $tipoImagen = 'image/jpeg';

                $result = "
                    
                    <div class='card card-producto'>
                    <img src='../img/ejemplo.PNG'/>
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