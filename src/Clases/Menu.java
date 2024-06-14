package Clases;

import Excepciones.ExisteException;
import Excepciones.NoExisteException;
import Generic.Conteiner;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static Conteiner<Integer, Juego> conteinerJuegos = new Conteiner<>("Contenedora Juegos");
    static Conteiner<Integer, Expansion> conteinerExpansiones = new Conteiner<>("Contenedora Expansiones");

    public void mostrarMenu() {
        System.out.println("1. Cargar ...");
        System.out.println("2. Ver ... ");
        System.out.println("3. Buscar un ... ");
        System.out.println("4. Ver por Genero");
        System.out.println("5. Modificar atributo de ...");
        System.out.println("6. Eliminar algo");
        System.out.println("0. Salir");
    }

    public void cargar() {
        int op;
        do {
            System.out.println("1. Cargar Juego");
            System.out.println("2. Cargar Expansion");
            System.out.println("0. Volver al menu anterior");

            op = scanner.nextInt();

            switch (op) {
                case 1:
                    crearJuego();
                    break;
                case 2:
                    crearExpansion();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (op != 0);
    }

    void crearJuego() {
        char mander = 's';
        scanner.nextLine();  // Consumir la nueva línea pendiente

        while (mander == 's') {
            try {
                System.out.println("Ingrese el ID del juego");
                Integer id = scanner.nextInt();
                scanner.nextLine();  // Consumir la nueva línea pendiente
                System.out.println("Ingrese el titulo");
                String titulo = scanner.nextLine();
                System.out.println("Ingrese el genero");
                String genero = scanner.nextLine();
                System.out.println("Ingrese el creador");
                String creador = scanner.nextLine();
                System.out.println("Ingrese la version");
                String version = scanner.nextLine();
                Juego nuevo = new Juego(id, titulo, genero, creador, version);
                conteinerJuegos.agregar(id, nuevo);
            } catch (ExisteException e) {
                System.out.println("Juego no agregado, ya existe en el mapa");
            }

            System.out.println("Desea cargar otro juego: (s/n) ?");
            mander = scanner.next().charAt(0);
            scanner.nextLine();  // Consumir la nueva línea pendiente
        }
    }

    void crearExpansion() {
        char mander = 's';
        scanner.nextLine();  // Consumir la nueva línea pendiente

        while (mander == 's') {
            try {
                System.out.println("Ingrese el ID de la expansion");
                Integer id = scanner.nextInt();
                scanner.nextLine();  // Consumir la nueva línea pendiente
                System.out.println("Ingrese el titulo");
                String titulo = scanner.nextLine();
                System.out.println("Ingrese el genero");
                String genero = scanner.nextLine();
                System.out.println("Ingrese el creador");
                String creador = scanner.nextLine();
                System.out.println("Ingrese la Fecha de lanzamiento");
                String fechaLanzamiento = scanner.nextLine();
                Expansion nueva = new Expansion(id, titulo, genero, creador, fechaLanzamiento);
                conteinerExpansiones.agregar(id, nueva);
            } catch (ExisteException e) {
                System.out.println("Expansion no agregada, ya existe en el mapa");
            }

            System.out.println("Desea cargar otra Expansion: (s/n) ?");
            mander = scanner.next().charAt(0);
            scanner.nextLine();  // Consumir la nueva línea pendiente
        }
    }

    public void ver() {
        int op;
        do {
            System.out.println("1. Ver Juegos");
            System.out.println("2. Ver Expansiones");
            System.out.println("0. Volver al menu anterior");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println(conteinerJuegos.obtenerMapa());
                    break;
                case 2:
                    System.out.println(conteinerExpansiones.obtenerMapa());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (op != 0);
    }

    public void buscar() {
        int op;
        do {
            System.out.println("1. Buscar Juego");
            System.out.println("2. Buscar Expansion");
            System.out.println("0. Volver al menu anterior");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Ingrese el id a buscar: ");
                    Integer idJuego = scanner.nextInt();
                    try {
                        Juego aBuscar = conteinerJuegos.obterPorId(idJuego); // Probar con un idValidoPara el "correcto" funcionamientp
                        System.out.println("Juego Buscado: " + aBuscar);
                    } catch (NoExisteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el id a buscar: ");
                    Integer idExpasion = scanner.nextInt();
                    try {
                        Expansion aBuscar = conteinerExpansiones.obterPorId(idExpasion); // Probar con un idValidoPara el "correcto" funcionamientp
                        System.out.println("Expansion Buscada: " + aBuscar);
                    } catch (NoExisteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        } while (op != 0);
    }

    public void verPorGenero() {
        int op;
        do {
            System.out.println("1. Ver Juegos por genero");
            System.out.println("2. Ver Expansiones por genero");
            System.out.println("0. Volver al menu anterior");
            op = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea pendiente

            switch (op) {
                case 1:
                    System.out.println("Ingrese el genero a buscar");
                    String genero = scanner.nextLine();
                    ArrayList<Juego> juegosPorGenero = conteinerJuegos.mostrarPorGenero(genero);
                    if (juegosPorGenero.isEmpty()) {
                        System.out.println("No hay juegos de ese genero");
                    } else {
                        System.out.println(juegosPorGenero);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el genero a buscar");
                    String generoEx = scanner.nextLine();
                    ArrayList<Expansion> exPorGenero = conteinerExpansiones.mostrarPorGenero(generoEx);
                    if (exPorGenero.isEmpty()) {
                        System.out.println("No hay juegos de ese genero");
                    } else {
                        System.out.println(exPorGenero);
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (op != 0);
    }

    public void modificar() {
        int op;
        do {
            System.out.println("1. Modificar un Juego");
            System.out.println("2. Modificar una Expansion");
            System.out.println("0. Volver al menu anterior");
            op = scanner.nextInt();

            switch (op) {
                case 1:
                    modificarJuego();
                    break;
                case 2:
                    modificarExpansion();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (op != 0);
    }

    void modificarJuego() {
        int opcion;
        do {
            menuModificacionesJuego();
            opcion = scanner.nextInt();

        } while (opcion < 1 || opcion > 4);

        try {
            conteinerJuegos.Modificar(123, opcion, "GTA SA");
        } catch (NoExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    void modificarExpansion() {
        int opcion;
        do {
            menuModificacionesExpansiones();
            opcion = scanner.nextInt();

        } while (opcion < 1 || opcion > 4);

        try {
            conteinerExpansiones.Modificar(123, opcion, "...");
        } catch (NoExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    void menuModificacionesJuego() {
        System.out.println("1. Titulo");
        System.out.println("2. Creador");
        System.out.println("3. Genero");
        System.out.println("4. Version");
    }

    void menuModificacionesExpansiones() {
        System.out.println("1. Titulo");
        System.out.println("2. Creador");
        System.out.println("3. Genero");
        System.out.println("4. FechaLanzamiento");
    }

    public void eliminar (){
        System.out.println("Ingrese el id a eliminar: ");
        Integer id = scanner.nextInt();
        conteinerJuegos.eliminar(id);
    }



}
