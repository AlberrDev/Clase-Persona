package clasepersona;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Persona {

    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private DateTimeFormatter GUION = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private DateTimeFormatter BARRAS = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Persona(String nombre, String apellidos, String fechaNacimiento) {

        if (nombre.length() <= 0 || apellidos.length() <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.nombre = nombre;
            this.apellidos = apellidos;
            try {
                this.fechaNacimiento = generarFecha(fechaNacimiento);
            } catch (DateTimeException e) {
                throw new IllegalArgumentException();
            }
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

    public String getFechaNacimiento(char separador) { //Cambiar fehca nacimiento por string con el formato
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
            fechaString = this.fechaNacimiento.format(GUION);
        }

        return fechaString;
    }

    public void setFechaNacimiento(String fechaNacimiento) throws IllegalArgumentException {
        this.fechaNacimiento = generarFecha(fechaNacimiento);
    }

    private LocalDate generarFecha(String fechaNacimiento) { //Funcion creada para devolver un dato correcto y en LocalDate
        LocalDate esFechaCorrecta = null;
        int dia = 0;
        int mes = 0;
        int anyo = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String[] fechaSeparada = fechaNacimiento.split("[-/]"); //Deberiam
        if (!fechaNacimiento.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}") && !fechaNacimiento.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")) {
            throw new IllegalArgumentException();
        }
        try {
            dia = Integer.parseInt(fechaSeparada[0]);
            mes = Integer.parseInt(fechaSeparada[1]);
            anyo = Integer.parseInt(fechaSeparada[2]);
            esFechaCorrecta = LocalDate.of(anyo, mes, dia);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        } catch (DateTimeException ex) {
            throw new IllegalArgumentException();
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
