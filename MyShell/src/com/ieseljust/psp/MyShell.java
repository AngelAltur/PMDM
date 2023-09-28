/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author thest
 */
public class MyShell {

    public static void main(String[] args) {
        System.out.println("#MyShell>(Escribe 'quit' para salir)");

        while (true) {
            System.out.println("# MyShell");

            try {
                //leemos la entrada del usuario
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String input = reader.readLine();

                if (input.equalsIgnoreCase("quit")) {
                    break;
                }//If

                executeCommand(input);

            }//try
            catch (IOException e) {
                e.printStackTrace();
            }//catch

        }//While
    }//main
    public static void executeCommand(String cmd) {
        try {
            // Crear un proceso para ejecutar la orden
            Process process = Runtime.getRuntime().exec(cmd);

            // Capturar la salida estándar del proceso
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String outputLine;

            // Leer y mostrar la salida estándar en verde
            while ((outputLine = stdInput.readLine()) != null) {
                System.out.println("\u001B[32m" + outputLine + "\u001B[0m");
            }//while

            // Capturar la salida de error del proceso
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String errorLine;

            // Leer y mostrar la salida de error en rojo
            while ((errorLine = stdError.readLine()) != null) {
                System.out.println("\u001B[31m" + errorLine + "\u001B[0m");
            }//while
        }//try
        catch (IOException e) {
            e.printStackTrace();
        }//catch
    }//void
}//Class
 