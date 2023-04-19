package clasepersona;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;

public class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String apellidos, String fechaNacimiento) {

        if (ComprobarString(nombre) || ComprobarString(apellidos)) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;

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

    public void setFechaNacimiento(String fechaNacimiento) throws IllegalArgumentException {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }

    private LocalDate generarFecha(String fechaNacimiento) { //Funcion creada para devolver un dato correcto y en LocalDate
        LocalDate esFechaCorrecta = null;
        int dia = 0;
        int mes = 0;
        int anyo = 0;
        String[] fechaSeparada = fechaNacimiento.split("[-/]"); //Deberiam
        if (!fechaNacimiento.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}") && !fechaNacimiento.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")) {
            try {
                dia = Integer.parseInt(fechaSeparada[0]);
                mes = Integer.parseInt(fechaSeparada[1]);
                anyo = Integer.parseInt(fechaSeparada[2]);
                esFechaCorrecta = LocalDate.of(dia, mes, anyo);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            } catch (DateTimeException ex) {
                throw new IllegalArgumentException();
            }
        }

        return esFechaCorrecta;
    }

    private boolean ComprobarString(String cadena) { //Funcion Creada para comprobar String no es null
        boolean esStringCorrecta = false;
        if (cadena.length() <= 0) { //Se puede comparar con ("".equals(nombre))
            esStringCorrecta = false;
        } else {
            esStringCorrecta = true;
        }
        return esStringCorrecta;
    }

}
