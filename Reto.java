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
public class Reto {


    public static void main(String[] args) {
       
       Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa una cadena de caracteres: ");
        String input = scanner.nextLine();
        
        if (esNumerico(input)) {
            System.out.println("La cadena contiene solo números.");
        } else if (esAlfabetico(input)) {
            System.out.println("La cadena contiene solo letras.");
        } else {
            System.out.println("La cadena contiene una combinación de caracteres.");
        }
    }
    

    public static boolean esNumerico(String str) {
        return str.matches("[0-9]+");
    }
    
 
    public static boolean esAlfabetico(String str) {
        return str.matches("[a-zA-Z]+");
    }
        
        
        
    
    
}
