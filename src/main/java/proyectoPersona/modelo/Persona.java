package proyectoPersona.modelo;

public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;

    // Aquí agregué un constructor vacío para que Firebase pueda crear objetos automáticamente
    public Persona() {
    }

    // Aquí agregué un constructor para inicializar los atributos de la persona
    public Persona(String id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    // Aquí agregué los getters y setters para acceder y modificar los atributos
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
