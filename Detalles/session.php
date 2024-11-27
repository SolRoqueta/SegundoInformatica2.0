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
        
                $_SESSION['name'] = null;
                $_SESSION['mail'] = null;

                echo null;
        
            }

            break;

        case 2:

            session_destroy();

            break;

    }

?>