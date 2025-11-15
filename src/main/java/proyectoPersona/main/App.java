package proyectoPersona.main;

import proyectoPersona.crud.PersonaCRUD;
import proyectoPersona.modelo.Persona;
import proyectoPersona.ui.Principal;

public class App {
    public static void main(String[] args) {
        
        Principal menu = new Principal();
        //Se visualiza el formulario principal
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setTitle("MENÚ PRINCIPAL");
        /*// Aquí creo un objeto de la clase PersonaCRUD para acceder a los métodos de Firebase
        PersonaCRUD crud = new PersonaCRUD();

        // Aquí creo una nueva persona y la registro en Firebase
        Persona p1 = new Persona("487", "Kimberly", "Sumala", 19);
        crud.crearPersona(p1);
        //prueba main*/
    }
}
