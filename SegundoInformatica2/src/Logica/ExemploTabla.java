package Logica;

import javax.swing.*;
import java.awt.*;

public class ExemploTabla {
    public static void main(String[] args) {
        // Crear el marco (JFrame)
        JFrame frame = new JFrame("Ejemplo de JTable con Scroll");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        // Crear los datos para la tabla
        String[][] datos = {
            {"1", "Oreo", "U$ 80", "Rico!"},
            {"2", "Chiquilin", "U$ 80", "Rico!"},
            {"3", "Papas Lays", "U$ 55", "Rico!"},
            {"4", "Pepito Mini", "U$ 45", "Rico!"},
            {"5", "Chiqules", "U$ 25", "Rico!"},
            {"6", "Chocolate", "U$ 75", "Rico!"},
            {"7", "Pop Dulce", "U$ 50", "Rico!"}
        };

        // Crear los nombres de las columnas
        String[] columnas = {"ID", "Nombre","Precio", "Descripcion"};

        // Crear la JTable con los datos y las columnas
        JTable tabla = new JTable(datos, columnas);

        // Añadir la tabla dentro de un JScrollPane para agregar scroll
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Ajustar el tamaño preferido de la tabla
        tabla.setPreferredScrollableViewportSize(new Dimension(450, 100));
        tabla.setFillsViewportHeight(true);

        // Añadir el JScrollPane al marco
        frame.add(scrollPane);

        // Hacer visible el marco
        frame.setVisible(true);
    }
}

