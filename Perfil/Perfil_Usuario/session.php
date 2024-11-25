<?php

    header('Content-Type: application/json');

    session_start();

    $data = [];

    $option = $_REQUEST['option'];

    switch ($option) {

        case 1:

            if (isset($_SESSION['name']) && isset($_SESSION['mail'])) {

                $name = $_SESSION['name'];
                $mail = $_SESSION['mail'];
        
                $data[] = [
        
                    'nombre' => $name,
                    'mail' => $mail
            
                ];
            
                echo json_encode($data);
        
            } else {
        
                echo null;
        
            }

            break;

        case 2:

            $name = $_REQUEST['name'];

            $_SESSION['name'] = $name;

            $name = $_SESSION['name'];
            $mail = $_SESSION['mail'];
        
            $data[] = [
        
                'nombre' => $name,
                'mail' => $mail
            
            ];

            echo json_encode($data);

            break;

        case 3:

            $mail = $_REQUEST['mail'];

            $_SESSION['mail'] = $mail;

            $name = $_SESSION['name'];
            $mail = $_SESSION['mail'];
        
            $data[] = [
        
                'nombre' => $name,
                'mail' => $mail
            
            ];

            echo json_encode($data);

            break;

    }

?>