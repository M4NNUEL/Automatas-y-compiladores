/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto;

/**
 *
 * @author josem
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reto4 {

    public static String clasificarCadena(String cadena) {
        cadena = cadena.trim();

        if (cadena.matches("\\d+")) {
            return "entero";
        } else if (cadena.matches("[a-zA-Z]+")) {
            return "palabra";
        } else if (cadena.matches(".*\\d.*") && cadena.matches(".*[a-zA-Z].*")) {
            return "compuesta";
        } else {
            return "no clasificada";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar el nombre del archivo
        System.out.println("Ingresa el nombre del archivo de texto:");
        String nombreArchivo = scanner.nextLine();
        
        // Inicializar contadores
        int enteros = 0;
        int palabras = 0;
        int compuestas = 0;
        
        try {
            // Abrir el archivo
            File archivo = new File(nombreArchivo);
            Scanner lectorArchivo = new Scanner(archivo);
            
            // Leer el archivo línea por línea
            while (lectorArchivo.hasNextLine()) {
                String linea = lectorArchivo.nextLine();
                
                // Separar la línea en palabras
                String[] partes = linea.split("\\s+");
                
                // Clasificar cada parte
                for (String parte : partes) {
                    String tipo = clasificarCadena(parte);
                    switch (tipo) {
                        case "entero":
                            enteros++;
                            break;
                        case "palabra":
                            palabras++;
                            break;
                        case "compuesta":
                            compuestas++;
                            break;
                        default:
                            break;
                    }
                }
            }
            lectorArchivo.close();
            
            // Generar la salida
            StringBuilder resultado = new StringBuilder();
            if (enteros > 0) {
                resultado.append(enteros).append(" - entero");
                if (enteros > 1) resultado.append("s");
            }
            if (palabras > 0) {
                if (resultado.length() > 0) resultado.append(", ");
                resultado.append(palabras).append(" - palabra");
                if (palabras > 1) resultado.append("s");
            }
            if (compuestas > 0) {
                if (resultado.length() > 0) resultado.append(", ");
                resultado.append(compuestas).append(" - compuesta");
                if (compuestas > 1) resultado.append("s");
            }
            
            System.out.println(resultado.toString());

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + nombreArchivo);
        }
        
        scanner.close();
    }
}

