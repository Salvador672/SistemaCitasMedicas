/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author chava
 */

package com.salvador.evidencia;

import java.util.Scanner;

public class SistemaCitas {
    
    private static Doctor[] listaDoctores = new Doctor[100];
    private static Paciente[] listaPacientes = new Paciente[100];
    private static Cita[] listaCitas = new Cita[100];
    
    private static int totalDoctores = 0;
    private static int totalPacientes = 0;
    private static int totalCitas = 0;
    
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       
        System.out.println("--- CONTROL DE ACCESO ---");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        
        if (!usuario.equals("admin") || !contrasena.equals("1234")) {
            System.out.println("Acceso denegado. Credenciales incorrectas.");
            return; 
        }
        
        System.out.println("¡Bienvenido al Sistema!");
        
        
        int opcion = 0;
        do {
            System.out.println("\n--- MENÚ DE OPCIONES ---");
            System.out.println("1. Registrar Doctor");
            System.out.println("2. Registrar Paciente");
            System.out.println("3. Crear Cita Médica");
            System.out.println("4. Mostrar Citas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = 0; 
            }
            
            switch (opcion) {
                case 1:
                    registrarDoctor();
                    break;
                case 2:
                    registrarPaciente();
                    break;
                case 3:
                    crearCita();
                    break;
                case 4:
                    mostrarCitas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);
    }

    
    private static void registrarDoctor() {
        if (totalDoctores >= 100) {
            System.out.println("Error: Límite de doctores alcanzado.");
            return;
        }
        
        Doctor nuevoDoc = new Doctor();
        System.out.print("Ingrese ID del Doctor: ");
        nuevoDoc.id = scanner.nextLine();
        System.out.print("Ingrese Nombre del Doctor: ");
        nuevoDoc.nombre = scanner.nextLine();
        System.out.print("Ingrese Especialidad: ");
        nuevoDoc.especialidad = scanner.nextLine();
        
        
        listaDoctores[totalDoctores] = nuevoDoc;
        totalDoctores = totalDoctores + 1;
        
        System.out.println("Doctor registrado con éxito.");
    }

    
    private static void registrarPaciente() {
        if (totalPacientes >= 100) {
            System.out.println("Error: Límite de pacientes alcanzado.");
            return;
        }
        
        Paciente nuevoPac = new Paciente();
        System.out.print("Ingrese ID del Paciente: ");
        nuevoPac.id = scanner.nextLine();
        System.out.print("Ingrese Nombre del Paciente: ");
        nuevoPac.nombre = scanner.nextLine();
        
       
        listaPacientes[totalPacientes] = nuevoPac;
        totalPacientes = totalPacientes + 1;
        
        System.out.println("Paciente registrado con éxito.");
    }

    
    private static void crearCita() {
        if (totalDoctores == 0 || totalPacientes == 0) {
            System.out.println("Error: Debe registrar al menos un doctor y un paciente primero.");
            return;
        }
        if (totalCitas >= 100) {
            System.out.println("Error: Límite de citas alcanzado.");
            return;
        }
        
        Cita nuevaCita = new Cita();
        System.out.print("Ingrese ID de la Cita: ");
        nuevaCita.id = scanner.nextLine();
        System.out.print("Ingrese Fecha y Hora: ");
        nuevaCita.fechaHora = scanner.nextLine();
        System.out.print("Ingrese Motivo: ");
        nuevaCita.motivo = scanner.nextLine();
        System.out.print("Ingrese ID del Doctor que atenderá: ");
        nuevaCita.idDoctor = scanner.nextLine();
        System.out.print("Ingrese ID del Paciente: ");
        nuevaCita.idPaciente = scanner.nextLine();
        
        
        listaCitas[totalCitas] = nuevaCita;
        totalCitas = totalCitas + 1;
        
        System.out.println("Cita creada exitosamente.");
    }

   
    private static void mostrarCitas() {
        if (totalCitas == 0) {
            System.out.println("No hay citas registradas.");
            return;
        }
        System.out.println("--- LISTADO DE CITAS ---");
        for (int i = 0; i < totalCitas; i++) {
            System.out.println("Cita ID: " + listaCitas[i].id);
            System.out.println("Fecha/Hora: " + listaCitas[i].fechaHora);
            System.out.println("Motivo: " + listaCitas[i].motivo);
            System.out.println("ID Doctor: " + listaCitas[i].idDoctor);
            System.out.println("ID Paciente: " + listaCitas[i].idPaciente);
            System.out.println("-----------------------");
        }
    }
}
    

