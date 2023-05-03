package clasepersona;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidadPersonas = 0;
        String nombrePersona = "";
        String apellidoPersona = "";
        String fechaNacimiento = "";
        String fechas = "";
        int edad = 0;
        int cantidadFechas = 0;
        Persona Gente = null;
        cantidadPersonas = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cantidadPersonas; i++) {
            nombrePersona = sc.nextLine();
            apellidoPersona = sc.nextLine();
            fechaNacimiento = sc.nextLine();

            try {
                Gente = new Persona(nombrePersona, apellidoPersona, fechaNacimiento);
                cantidadFechas = sc.nextInt();
                sc.nextLine();
                for (int j = 0; j < cantidadFechas; j++) {
                    fechas = sc.nextLine();
                    try {
                        edad = Gente.getEdadEnFecha(fechas);
                        if (edad == -1) {
                            System.out.println(nombrePersona + " " + apellidoPersona + " aun no ha nacido a fecha " + fechas);
                        } else {
                            System.out.println(nombrePersona + " " + apellidoPersona + " tendra " + edad + " anyos en fecha " + fechas);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("ERROR. Procesando siguiente fecha");

                    }

                }
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");

            }

        }
    }
}

