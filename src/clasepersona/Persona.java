package clasepersona;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Persona {

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
            this.fechaNacimiento = generarFecha(fechaNacimiento); //Devolvera excepcion en caso de que la fecha no sea correcta y se propagará

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

    /**
     * Genera fecha de Nacimiento mediante un separador
     *
     * @param separador Indica el valor el cual se usará para separar los dias, meses y años
     * @return Devuelve la fecha ya sea con el separador dado '-' o '/'
     */
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

        if (this.fechaNacimiento == null || FechaLocal.isBefore(FechaLocal2)) { //En caso de que la persona no tenga establecida fecha o sea anterior
            edad = -1;
        } else {
            Period periot = Period.between(FechaLocal2, FechaLocal);

            edad = periot.getYears();
        }

        return edad;
    }
    public int getEdad() throws IllegalArgumentException {
        int edad = 0;
        String fechaStringDada = "";
        String fechaStringOriginal = "";
        LocalDate FechaLocal;
        LocalDate FechaLocal2;
        FechaLocal = LocalDate.now();
        FechaLocal2 = this.fechaNacimiento;

        if (this.fechaNacimiento == null || FechaLocal.isBefore(FechaLocal2)) { //En caso de que la persona no tenga establecida fecha o sea anterior
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

    private LocalDate generarFecha(String fechaNacimiento) { //Funcion creada para devolver un dato correcto y en LocalDate
        LocalDate esFechaCorrecta = null;
        int dia = 0;
        int mes = 0;
        int anyo = 0;
        String[] fechaSeparada = fechaNacimiento.split("[-/]");
        if (!fechaNacimiento.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}")
                && !fechaNacimiento.matches("[0-9]{2}[-][0-9]{2}[-][0-9]{4}")) { //Compruebo que el formato de la fecha sea correcta
            throw new IllegalArgumentException();
        }
        try {
            dia = Integer.parseInt(fechaSeparada[0]);
            mes = Integer.parseInt(fechaSeparada[1]);
            anyo = Integer.parseInt(fechaSeparada[2]);
            return LocalDate.of(anyo, mes, dia); //Comprueba que la fecha es correcta ya que al crearlo si no es correcta salta excepcion

        } catch (DateTimeException ex) {
            throw new IllegalArgumentException();
        }

    }

    private boolean ComprobarString(String cadena) { //Funcion Creada para comprobar String no es null
        boolean esStringCorrecta = false;
        if (cadena.length() <= 0) {
            esStringCorrecta = false;
        } else {
            esStringCorrecta = true;
        }
        return esStringCorrecta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.apellidos);
        hash = 79 * hash + Objects.hashCode(this.fechaNacimiento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { //Si yo soy igual al objeto dado true
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) { //Si las clases son distintas no somos iguales
            return false;
        }
        final Persona other = (Persona) obj; //Al ser una persona se tendra que hacer un casting al Obj para poder compararlo.
        if (!Objects.equals(this.nombre, other.nombre)) { //Compara que los atributos tengan el mismo valor
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return Objects.equals(this.fechaNacimiento, other.fechaNacimiento);
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    

}