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

        } else {

            // echo "Conectado correctamente a la base de datos.";

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

        default:
            
            all();

            break;

    }

    function dailyMenus() {

        $query = "SELECT * FROM menus";

        // Ejecutar la consulta
        $resultado = conexion($query);

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $foto = base64_encode($fila['foto']);
                $tipoImagen = 'image/jpeg';

                $result = "
                    
                    <div class='card' style='width: 18rem;'>
                        <img src='https://dummyimage.com/150x150/000/fff' class='card-img-top' alt='...'>
                        <div class='card-body'>
                            <p class='card-text'>" . $fila['nombre'] . "</p>
                        </div>
                    </div>
                ";


                echo $result;

            }
        } else {

            echo "No se encontraron resultados.";

        }

        // Cerrar la conexión
        mysqli_close($resultado[1]);

    }

    function products() {

        $query = "SELECT * FROM productos";

        $resultado = conexion($query);

        // Verificar si se obtuvo un resultado
        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $foto = base64_encode($fila['foto']);
                $tipoImagen = 'image/jpeg';

                $result = "
                    
                    <div class='card' style='width: 18rem;'>
                        <img src='https://dummyimage.com/150x150/000/fff' class='card-img-top' alt='...'>
                        <div class='card-body'>
                            <p class='card-text'>" . $fila['nombre'] . "</p>
                        </div>
                    </div>
                ";


                echo $result;

            }
        } else {

            echo "No se encontraron resultados.";

        }

        mysqli_close($resultado[1]);

    }

    function all() {

        $query = "SELECT * FROM productos";

        $resultado = conexion($query);

        // Verificar si se obtuvo un resultado
        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $foto = base64_encode($fila['foto']);
                $tipoImagen = 'image/jpeg';

                $result = "
                    
                    <div class='card' style='width: 18rem;'>
                        <img src='https://dummyimage.com/150x150/000/fff' class='card-img-top' alt='...'>
                        <div class='card-body'>
                            <p class='card-text'>" . $fila['nombre'] . "</p>
                        </div>
                    </div>
                ";


                echo $result;

            }
        } else {

            echo "No se encontraron resultados.";

        }

        mysqli_close($resultado[1]);

        $query = "SELECT * FROM menus";

        // Ejecutar la consulta
        $resultado = conexion($query);

        if (mysqli_num_rows($resultado[0]) > 0) {
            // Mostrar los resultados
            while ($fila = mysqli_fetch_assoc($resultado[0])) {

                $foto = base64_encode($fila['foto']);
                $tipoImagen = 'image/jpeg';

                $result = "
                    
                    <div class='card' style='width: 18rem;'>
                        <img src='https://dummyimage.com/150x150/000/fff' class='card-img-top' alt='...'>
                        <div class='card-body'>
                            <p class='card-text'>" . $fila['nombre'] . "</p>
                        </div>
                    </div>
                ";


                echo $result;

            }
        } else {

            echo "No se encontraron resultados.";

        }

        // Cerrar la conexión
        mysqli_close($resultado[1]);

    }

?>