package proyectoPersona.crud;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import java.util.ArrayList;
import java.util.List;
import proyectoPersona.conexion.Conexion;
import proyectoPersona.modelo.Persona;

import java.util.concurrent.ExecutionException;

public class PersonaCRUD {

    private final Firestore db;

    // Aquí creo la conexión con Firestore y apunto a la colección "personas"
    public PersonaCRUD() {
        db = Conexion.getConexion();
    }

    // Aquí agregué el método para crear una persona en Firestore
    public void crearPersona(Persona persona) {
        try {
            // Aquí verifico si el id está vacío y genero uno nuevo si es necesario
            if (persona.getId() == null || persona.getId().isEmpty()) {
                persona.setId(db.collection("personas").document().getId());
            }
            // Aquí guardo el objeto persona en Firestore
            ApiFuture<WriteResult> result = db.collection("personas").document(persona.getId()).set(persona);
            System.out.println("Persona registrada con éxito: " + persona.getNombre() +
                    " en " + result.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al crear persona: " + e.getMessage());
        }
    }
    // Aquí aqregué el método para consultar todas las Personas que estan dentro de la base de datos
    public List<Persona> consultarPersonas() {
        List<Persona> lista = new ArrayList<>();
        try {
            ApiFuture<QuerySnapshot> future = db.collection("personas").get();
            List<QueryDocumentSnapshot> documentos = future.get().getDocuments();

            for (QueryDocumentSnapshot doc : documentos) {
                Persona p = doc.toObject(Persona.class);
                lista.add(p);
            }

        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener personas: " + e.getMessage());
        }

        return lista;
    }


    // Aquí agregué el método para actualizar los datos de una persona existente
    public void actualizarPersona(Persona persona) {
        try {
            ApiFuture<WriteResult> result = db.collection("personas").document(persona.getId()).set(persona);
            System.out.println("Persona actualizada: " + persona.getNombre() +
                    " en " + result.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al actualizar persona: " + e.getMessage());
        }
    }

    // Aquí agregué el método para eliminar una persona por su ID
    public void eliminarPersona(String id) {
        try {
            ApiFuture<WriteResult> result = db.collection("personas").document(id).delete();
            System.out.println("Persona eliminada con ID: " + id +
                    " en " + result.get().getUpdateTime());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al eliminar persona: " + e.getMessage());
        }
    }

    // Aquí agregué el método para obtener una persona por su ID
    public Persona obtenerPersona(String id) {
        try {
            DocumentReference docRef = db.collection("personas").document(id);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();

            if (document.exists()) {
                return document.toObject(Persona.class);
            } else {
                System.out.println("No encontré ninguna persona con el ID: " + id);
                return null;
            }
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error al obtener persona: " + e.getMessage());
            return null;
        }
    }
}
