package proyectoPersona.conexion;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.Firestore;

import java.io.FileInputStream;
import java.io.IOException;

public class Conexion {
    private static Firestore db;

    public static Firestore getConexion() {
        if (db == null) {
            try {
                FileInputStream serviceAccount = new FileInputStream("firebase/serviceAccountKey.json");

                FirebaseOptions options = FirebaseOptions.builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                FirebaseApp.initializeApp(options);
                db = FirestoreClient.getFirestore();
                System.out.println("✅Conectado correctamente a Firestore");

            } catch (IOException e) {
                System.out.println("Error al conectar con Firebase: " + e.getMessage());
            }
        }
        return db;
    }
}
