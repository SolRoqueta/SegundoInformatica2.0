<?php

    session_start();

    use PHPMailer\PHPMailer\PHPMailer;
    use PHPMailer\PHPMailer\Exception;

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

        break;
        case 3:

            // Cargar las clases de PHPMailer
            require 'C:/xampp/htdocs/SegundoInformatica2.0/ConfirmacionReserva/Exception.php';
            require 'C:/xampp/htdocs/SegundoInformatica2.0/ConfirmacionReserva/PHPMailer.php';
            require 'C:/xampp/htdocs/SegundoInformatica2.0/ConfirmacionReserva/SMTP.php';


            $mail = new PHPMailer(true);

            try {
                // Configuración del servidor SMTP
                $mail->isSMTP();
                $mail->Host = 'smtp.gmail.com';
                $mail->SMTPAuth = true;
                $mail->Username = 'cantina.daniela.iep@gmail.com'; // Tu correo de Gmail
                $mail->Password = 'japt xbbi ugmy awwh'; // Contraseña de aplicación
                $mail->SMTPSecure = PHPMailer::ENCRYPTION_STARTTLS; // O PHPMailer::ENCRYPTION_SMTPS
                $mail->Port = 587; // O 465 si usas SMTPS

                // Configuración del correo
                $mail->setFrom('cantina.daniela.iep@gmail.com', 'Cantina Daniela'); // Correo y nombre del remitente
                $mail->addAddress($_SESSION['mail'], $_SESSION['name']); // Destinatario

                // Leer el contenido del archivo HTML
                $htmlContent = file_get_contents('email.html'); // Asegúrate de que el archivo esté en la misma carpeta o usa la ruta correcta

                $mail->isHTML(true);
                $mail->Subject = 'Reserva de la cantina de Daniela';
                $mail->Body = $htmlContent;
                $mail->AltBody = 'Recibo de reserva en la cantina de Daniela.';

                // Enviar el correo
                $mail->send();
                echo 'Correo enviado exitosamente';
            } catch (Exception $e) {
                echo "Error al enviar el correo: {$mail->ErrorInfo}";
            }

        break;

    }

?>