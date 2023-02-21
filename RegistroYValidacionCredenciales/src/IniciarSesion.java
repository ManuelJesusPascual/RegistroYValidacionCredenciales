import java.io.*;
import java.util.Scanner;

public class IniciarSesion {
    private static Scanner snString = new Scanner(System.in);

    public static void iniciarSesion(){
        try{
            System.out.println("Introduce el nombre del usuario");
            String nombre = snString.nextLine();
            System.out.println("Introduce la contraseña del usuario");
            String pass = snString.nextLine();
            byte[] passByte = pass.getBytes();
            byte[] passCifrada = Calculos.getDigest(passByte);
            FileReader fw = new FileReader(new File("src/"+nombre+"credenciales.cred"));
            BufferedReader br = new BufferedReader(fw);
            String linea = br.readLine();
            if (linea != null){
                if (!linea.equalsIgnoreCase(nombre)){
                    System.out.println("Usuario erroneo");
                }
            }
            linea = br.readLine();
            if(linea != null){
                byte[] passFicheroCifrada64 = linea.getBytes();
                byte[] passFicheroCifrada = Calculos.descifrarBase64(passFicheroCifrada64);
                if(Calculos.compararResumenes(passCifrada,passFicheroCifrada)){
                    System.out.println("Sesion iniciada con éxito");
                }else{
                    System.out.println("Contraseña incorrecta");
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero con las credenciales del usuario");
        }
    }

}
