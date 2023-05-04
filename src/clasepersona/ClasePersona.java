package clasepersona;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidadPersonas = 0;
        String persona = "";
        String apellidos = "";
        String fechaNacimiento = "";
        String fechas = "";
        String personaAntigua = "";
        String persona1 = "";
        int edad = 0;
        int cantidadFechas = 0;
        Persona Gente = null;
        cantidadPersonas = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cantidadPersonas; i++) {
            persona = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                Gente = new Persona(persona, apellidos, fechaNacimiento);
                if (personaAntigua != "") {
                    if (Gente.toString().equals(personaAntigua)) {
                        System.out.println(Gente.toString() + " y " + personaAntigua + " son la misma");
                    } else {
                        System.out.println(Gente.toString() + " y " + personaAntigua + " son distintas");
                    }
                }

                personaAntigua = Gente.toString();

            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");
            }

        }
    }
}
