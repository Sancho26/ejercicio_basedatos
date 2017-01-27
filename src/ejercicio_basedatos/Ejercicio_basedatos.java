/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_basedatos;

import java.sql.SQLException;


/**
 * Clase principal de la aplicación, desde aquí se ejecuta la clase menú
 * @author Fran Sancho
 * @version 1.0
 */
public class Ejercicio_basedatos {

    /**
     * @param args the command line arguments
     * @throws SQLException ...
     */
    public static void main(String[] args) throws SQLException {
        Menu men = new Menu();
        men.setVisible(true);
    }
    
}
