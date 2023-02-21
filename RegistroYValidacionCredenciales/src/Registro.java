import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Registro {

    private static Scanner snString = new Scanner(System.in);

    public static void registrarUsuario(){
    try{
        System.out.println("Introduce el nombre del usuario");
        String nombre = snString.nextLine();
        System.out.println("Introduce la contraseña del usuario");
        String pass = snString.nextLine();
        byte[] passByte = pass.getBytes();
        byte[] passCifrada = Calculos.getDigest(passByte);
        byte[] pass64 = Calculos.pasarBase64Cifrado(passCifrada);
        FileWriter fw = new FileWriter(new File("src/"+nombre+"credenciales.cred"),true);
        fw.write(nombre);
        fw.append("\n" + new String(pass64));

        fw.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }


    }
}
