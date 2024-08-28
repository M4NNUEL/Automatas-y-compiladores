/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto;

import java.util.Scanner;
/**
 *
 * @author josem
 */
public class Reto3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;
        
        do {
            // Leer la cadena de caracteres
            System.out.println("Ingresa una cadena de caracteres::");
            String cadena = scanner.nextLine();
            
            cadena = cadena.trim();
            
         
            String[] partes = cadena.split("\\s+");
            
            int contadorEnteros = 0;
            int contadorPalabras = 0;
            int contadorCompuestas = 0;
            
            
            for (String parte : partes) {
                if (parte.matches("-?\\d+")) {
                    contadorEnteros++;
                } else if (parte.matches("[a-zA-Z]+")) {
                    contadorPalabras++;
                } else {
                    contadorCompuestas++;
                }
            }
            
        
            String salida = "";
            if (contadorEnteros > 0) {
                salida += contadorEnteros + "  Entero";
                if (contadorEnteros > 1) salida += "s";
                salida += "   ";
            }
            if (contadorPalabras > 0) {
                salida += contadorPalabras + "  Palabra";
                if (contadorPalabras > 1) salida += "s";
                salida += "   ";
            }
            if (contadorCompuestas > 0) {
                salida += contadorCompuestas + " Combinación";
                if (contadorCompuestas > 1) salida += "s";
            }
            
         
            System.out.println(salida.trim());
            
  
            System.out.println("¿Ingresar nueva cadena? Selecciona - >(s/n):");
            opcion = scanner.nextLine().toLowerCase();
        } while (opcion.equals("s"));
        
        scanner.close();
    }
}
    
