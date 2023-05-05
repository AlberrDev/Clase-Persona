package clasepersona;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cantidadPersonas = 0;
        String persona = "";
        String apellidos = "";
        String fechaNacimiento = "";
        String fechaReferencia = "";
        String fechaComparar = "";
        int edadReferencia = 0;
        int edad = 0;
        int casos = 0;
        Persona Gente = null;
        ArrayList<Persona> Personas = new ArrayList<>(1000);

        cantidadPersonas = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < cantidadPersonas; i++) {
            persona = sc.nextLine();
            apellidos = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try {
                Gente = new Persona(persona, apellidos, fechaNacimiento);
                Personas.add(Gente);
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR procesando alumno. Datos incorrectos. Procesando siguiente alumno");
            }
        }
        casos = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < casos; i++) {
            fechaReferencia = sc.nextLine();
            edadReferencia = sc.nextInt();
            Iterator<Persona> it1 = Personas.iterator();
            while (it1.hasNext()) {
                Gente = it1.next();
                edad = Gente.getEdadEnFecha(fechaReferencia);

                if (edad < edadReferencia) {
                    System.out.println(Gente.toString());

                }
            }
        }

    }
}
