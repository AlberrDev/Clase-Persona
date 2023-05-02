package clasepersona;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClasePersona {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casosCompletos = 0;
        int casosNormales = 0;
        String nombre = "";
        String apellido = "";
        String fechaNacimiento = "";
        String fecha = "";
        boolean hayFechaCorrecta = false;
        Persona Gente = null;
        casosCompletos = sc.nextInt();
        String[] fechaArray;
        casosNormales = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < casosCompletos; i++) {
            nombre = sc.nextLine();
            apellido = sc.nextLine();
            fechaNacimiento = sc.nextLine();
            try { //Cambiar fecha nacimiento
                Gente = new Persona(nombre, apellido, fechaNacimiento);
                fechaArray = Gente.getFechaNacimiento().split("[/-]");
                        
                System.out.println("Procesado: " + Gente.getNombre() + Gente.getApellidos() + "," + "nacido el " + fechaArray[0] + " del "
                        + fechaArray[1] + " de " + fechaArray[2]);
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");
            }

        }
        for (int i = 0; i < casosNormales; i++) {
            nombre = sc.nextLine();
            apellido = sc.nextLine();
            try {
                Gente = new Persona(nombre, apellido);
                System.out.println("Procesado: " + Gente.getNombre() + Gente.getApellidos() + "," + "nacido el " + Gente.getFechaNacimiento());
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");
            }

        }
        while (!hayFechaCorrecta) {
            fecha = sc.nextLine();

            try {
                Gente.setFechaNacimiento(fecha);
                hayFechaCorrecta = true;
               System.out.println("Procesado: " + Gente.getNombre() + Gente.getApellidos() + "," + "nacido el " + Gente.getFechaNacimiento() + " del "
                        + Gente.getFechaNacimiento() + " de " + Gente.getFechaNacimiento());
            } catch (IllegalArgumentException e) {
                System.out.println("Fecha Incorrecta");
            }

        }

    }

}
