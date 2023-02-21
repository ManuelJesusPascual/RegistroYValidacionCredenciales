import java.util.Scanner;

public class Main {
    private static Scanner snInt = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion = 0;
        while(opcion != 3){
            System.out.println("Introduce la opcion que quieras realizar");
            System.out.println("1.- Registro");
            System.out.println("2.- Inicio de Sesión");
            System.out.println("3.- Salir");
            opcion = snInt.nextInt();
            switch (opcion){
                case 1:{
                    Registro.registrarUsuario();
                    break;
                }
                case 2:{
                    IniciarSesion.iniciarSesion();
                    break;
                }
                case 3:{
                    System.out.println("Saliendo del sistema");
                    break;
                }
            }
        }

    }
}