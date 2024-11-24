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

    use PHPMailer\PHPMailer\PHPMailer;
    use PHPMailer\PHPMailer\Exception;

    // Cargar las clases de PHPMailer
    require 'C:/xampp/htdocs/LoginCheto/RecuperarContraseña/Exception.php';
    require 'C:/xampp/htdocs/LoginCheto/RecuperarContraseña/PHPMailer.php';
    require 'C:/xampp/htdocs/LoginCheto/RecuperarContraseña/SMTP.php';


    $mail = new PHPMailer(true);

    $reciverMail = $_REQUEST['email'];
    $userName = "";

    $query = "SELECT * FROM usuarios WHERE mail = '".$reciverMail."';";
    $output = conexion($query);
    $resultado = $output[0];
    $conn = $output[1];

    if (mysqli_num_rows($resultado) > 0) {

        $fila = mysqli_fetch_assoc($resultado);

        $userName = $fila['nombre'];

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
            $mail->addAddress($reciverMail, $userName); // Destinatario
    
            // Leer el contenido del archivo HTML
            $htmlContent = file_get_contents('file.html'); // Asegúrate de que el archivo esté en la misma carpeta o usa la ruta correcta
    
            $mail->isHTML(true);
            $mail->Subject = 'Recuperar contrasenia de la Cantina de Daniela - Usuario: '.$userName;
            $mail->Body = $htmlContent;
            $mail->AltBody = 'Recuperacion de contrasenia de La Cantina de Daniela.';
    
            // Enviar el correo
            $mail->send();

            $data = [];

            $data[] = [

                'pass' => '1',
                'result' => 'Correo enviado exitosamente'

            ];

        } catch (Exception $e) {
            echo "Error al enviar el correo: {$mail->ErrorInfo}";
        }

    } else {

        $data = [];

        $data[] = [

            'pass' => '0',
            'result' => 'Usuario no encontrado!'

        ];

    }

    echo json_encode($data);

?>