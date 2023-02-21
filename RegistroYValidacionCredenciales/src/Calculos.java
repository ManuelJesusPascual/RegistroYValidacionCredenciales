import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Calculos {

    public static byte[] getDigest(byte[] mensajeBytes) {
        try {
            MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");

            byte[] resumen = null;
            // Reiniciamos el objeto por si contiene datos
            algoritmo.reset();
            // Añado el mensaje del cual quiero calcular su hash
            algoritmo.update(mensajeBytes);

            // Generamos el resumen
            resumen = algoritmo.digest();

            return resumen;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] pasarBase64Cifrado(byte[] passCifradaSHA) {
        byte[] base64 = Base64.getEncoder().encode(passCifradaSHA);
        return base64;
    }

    public static byte[] descifrarBase64(byte[] passBase64) {
        byte[] SHA = Base64.getDecoder().decode(passBase64);
        return SHA;
    }


    public static boolean compararResumenes(byte[] resumenUno, byte[] resumenDos) {
        boolean iguales = false;
        if (MessageDigest.isEqual(resumenUno, resumenDos)) {
            iguales = true;
        }
        return iguales;


    }
}
