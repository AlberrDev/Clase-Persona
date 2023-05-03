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

class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private DateTimeFormatter GUION = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private DateTimeFormatter BARRAS = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Persona(String nombre, String apellidos, String fechaNacimiento) throws IllegalArgumentException {

        if (nombre.length() <= 0 || apellidos.length() <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = generarFecha(fechaNacimiento);

        }

    }

    public Persona(String nombre, String apellidos) {

        if (nombre.length() <= 0 || apellidos.length() <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.fechaNacimiento = null;

        }

    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento(char separador) {
        String fechaString = "";
        LocalDate fechaLocalDate;
        if (separador != '-' || separador != '/') {
            throw new IllegalArgumentException();
        } else if (separador == '-') {
            fechaString = fechaNacimiento.format(GUION);
        } else if (separador == '/') {
            fechaString = fechaNacimiento.format(BARRAS);
        }

        return fechaString;
    }

    public String getFechaNacimiento() {
        String fechaString = "";

        if (this.fechaNacimiento == null) {
            fechaString = null;
        } else {
            fechaString = getFechaNacimiento('-');
        }

        return fechaString;
    }

    public int getEdadEnFecha(String cadenaFecha) throws IllegalArgumentException {
        int edad = 0;
        String fechaStringDada = "";
        String fechaStringOriginal = "";
        LocalDate FechaLocal;
        LocalDate FechaLocal2;
        FechaLocal = generarFecha(cadenaFecha);
        FechaLocal2 = this.fechaNacimiento;

        if (this.fechaNacimiento == null || FechaLocal.isBefore(FechaLocal2)) {
            edad = -1;
        } else {
            Period periot = Period.between(FechaLocal2, FechaLocal);

            edad = periot.getYears();
        }

        return edad;
    }

    public void setFechaNacimiento(String fechaNacimiento) throws IllegalArgumentException {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }

    private LocalDate generarFecha(String fechaNacimiento) {
        LocalDate esFechaCorrecta = null;
        int dia = 0;
        int mes = 0;
        int anyo = 0;
        String[] fechaSeparada = fechaNacimiento.split("[-/]");
        if (!fechaNacimiento.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")
                && !fechaNacimiento.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")) {
            throw new IllegalArgumentException();
        }
        try {
            dia = Integer.parseInt(fechaSeparada[0]);
            mes = Integer.parseInt(fechaSeparada[1]);
            anyo = Integer.parseInt(fechaSeparada[2]);
            return LocalDate.of(anyo, mes, dia);

        } catch (DateTimeException ex) {
            throw new IllegalArgumentException();
        }

    }

    private boolean ComprobarString(String cadena) {
        boolean esStringCorrecta = false;
        if (cadena.length() <= 0) {
            esStringCorrecta = false;
        } else {
            esStringCorrecta = true;
        }
        return esStringCorrecta;
    }

}
