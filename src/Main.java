import Clases.Expansion;
import Clases.Juego;
import Clases.Menu;
import Excepciones.ExisteException;
import Excepciones.NoExisteException;
import Generic.Conteiner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu menu = new Menu();
        int op;

        do {
            menu.mostrarMenu();
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    menu.cargar();
                    break;
                case 2:
                    menu.ver();
                    break;
                case 3:
                    menu.buscar();
                    break;
                case 4:
                    menu.verPorGenero();
                    break;
                case 5:
                    menu.modificar();
                    break;
                case 6:
                    menu.eliminar();
                    break;
                case 0:
                    System.out.println("Adios !");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (op != 0);
    }
}