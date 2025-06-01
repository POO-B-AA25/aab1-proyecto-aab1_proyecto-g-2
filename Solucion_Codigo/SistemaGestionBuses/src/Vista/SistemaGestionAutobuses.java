import Controlador.ControladorAutobus;
import Controlador.ControladorRuta;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Modelo.Autobus;
import Modelo.Parada;
import Modelo.Ruta;
import Modelo.Horario;
import java.math.BigDecimal;
import java.time.LocalTime;

public class SistemaGestionAutobuses {

    static List<Ruta> rutas = new ArrayList<>();
    static List<Parada> paradas = new ArrayList();
    static List<Autobus> listautobus = new ArrayList();
    static List<Horario> horarios = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Ruta ruta = new Ruta();
    static Horario horario = new Horario();
    static Autobus autobus = new Autobus();
    static int opcion;
    static ControladorAutobus cont_Autobus = new ControladorAutobus();
    static ControladorRuta cont_Ruta = new ControladorRuta();

    public static void main(String[] args) {

        do {
            System.out.println("\n--- Sistema de GestiÃ³n de Buses UTPL ---");            
            System.out.println("1. Gestionar ruta");            
            System.out.println("2. Gestionar autobus");
            System.out.println("3. Salir/n");
            System.out.print("Seleccione una opciÃ³n: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 ->
                    gestionarRuta();
                case 2 ->
                    gestionarBus();
                case 3 ->
                    System.out.println("Saliendo del sistema...");

                default ->
                    System.out.println("OpciÃ³n invÃ¡lida");
            }
        } while (opcion != 4);
    }

    public static void gestionarRuta() {
        System.out.println("\n");
        do {
            System.out.println("Acciones de ruta");
            System.out.println("1. Crear nueva ruta ");
            System.out.println("2.Agregar parada a una ruta ");
            System.out.println("3. Ver rutas - sin horarios ni paradas");
            System.out.println("4. Mostrar ruta completa - Paradas y horarios ");
            System.out.println("5. Optimizar ruta (ordenar paradas) ");
            System.out.println("6. Eliminar parada ");
            System.out.println("7. Mostrar Paradas ");
            System.out.println("8. Regresar al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 ->
                    registrarRuta();
                case 2 ->
                    agregarParadaARuta(rutas);
                case 3 ->
                    cont_Ruta.mostrarRutas(rutas);
                case 4 ->
                    cont_Ruta.mostrarRutasHorarioyParada(rutas);
                case 5 ->
                    cont_Ruta.optimizarRuta(rutas, optimizarRuta());
                case 6 ->
                    eliminarParada();
                case 7 ->
                    cont_Ruta.mostrarParadas(paradas);
                default ->
                    System.out.println("Opcion Invalida...");

            }
        } while (opcion != 8);
    }

    public static void gestionarBus() {
        System.out.println("\n");
        do {
            System.out.println("Acciones Bus");
            System.out.println("1. Crear nuevo bus");
            System.out.println("2. Mostrar autobuses");
            System.out.println("3. Regresar al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1 ->
                    registrarAutobus();
                case 2 ->
                    cont_Autobus.mostrarAutobus(listautobus);
                default ->
                    System.out.println("Opcion Invalida...");
            }
        } while (opcion != 3);

    }

    public static void registrarRuta() {
        System.out.println("\n");
        System.out.println("Ingresar datos de ruta");
        System.out.print("Ingrese ID de la ruta: ");
        int idRuta = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese nombre de la ruta: ");
        String nombreRuta = scanner.nextLine();
        Ruta nuevaRuta = new Ruta(idRuta, nombreRuta);
        rutas.add(nuevaRuta);
        System.out.println("tamaaaaaaaaaaa " + rutas.size());
        System.out.println("Ruta creada exitosamente.");
        System.out.println("\n");
        nuevaRuta = new Ruta();
    }

    public static void eliminarParada() {
        System.out.println("\n Metodo Eliminar parada");
        System.out.println("Ingrese el id de la parada");
        int idParada = scanner.nextInt();
        paradas = cont_Ruta.removerParada(idParada, paradas);
        System.out.println("\n");
    }

    public static void agregarParadaARuta(List<Ruta> rutas) {
        cont_Ruta.mostrarRutas(rutas);
        System.out.println("Seleccione el id de la ruta:");
        int opcionRuta = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < rutas.size(); i++) {
            if (rutas.get(i).idRuta == opcionRuta) {
                ruta = rutas.get(i);
            }
        }
        Ruta rutaSeleccionada = ruta;
        rutas.remove(ruta);
        System.out.println("\n Ingresar datos de parada");
        System.out.print("Ingrese ID de la parada: ");
        String i = scanner.nextLine();
        int idParada = Integer.parseInt(i);
        System.out.print("Nombre de la parada: ");
        String nombre = scanner.nextLine();
        System.out.print("UbicaciÃ³n de la parada: ");
        String ubicacion = scanner.nextLine();
        System.out.println("\n Ingresar datos de horario");
        System.out.print("Ingrese ID del horario: ");
        int idHorario = Integer.parseInt(scanner.nextLine());
        boolean horaoka = false;
        do {
            System.out.print("Hora de llegada (HH:mm): ");
            LocalTime llegada = LocalTime.parse(scanner.nextLine());
            System.out.print("Hora de salida (HH:mm): ");
            LocalTime salida = LocalTime.parse(scanner.nextLine());
            if (cont_Ruta.esHoraValida(salida, llegada)) {
                Horario horario = new Horario(idHorario, llegada, salida);
                horarios.add(horario);
                horaoka = true;
            }
            System.out.println("La hora de salida debe ser mayor a la hora de llegada");
        } while (horaoka != true);
        Parada nuevaParada = new Parada(idParada, nombre, ubicacion);
        paradas.add(nuevaParada);
        rutaSeleccionada.horarios = horarios;
        rutaSeleccionada.paradas = paradas;
        rutas.add(rutaSeleccionada);
        System.out.println("Parada agregada exitosamente.");
        System.out.println("\n");
    }

    public static void registrarAutobus() {
        System.out.println("\n");
        System.out.println("Ingresar datos de autobus");
        System.out.println("Ingrese el id del autobus");
        int idautobus = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese la placa");
        String placa = scanner.nextLine();
        System.out.println("Ingrese la capacidad");
        int capacidad = Integer.parseInt(scanner.nextLine());

        do {
            cont_Ruta.mostrarRutas(rutas);
            System.out.println("Ingrese el id de la ruta");
            int idRuta = Integer.parseInt(scanner.nextLine());
            ruta = cont_Autobus.asignarRutaBus(idRuta, rutas);
        } while (ruta == null);

        autobus = new Autobus(idautobus, placa, capacidad, ruta);
        listautobus.add(autobus);
    }

    public static int optimizarRuta() {
        System.out.println("\n");
        if (rutas.isEmpty()) {
            System.out.println("No hay rutas para optimizar.");
        }
        System.out.println("Seleccione la ruta a optimizar:");
        cont_Ruta.mostrarRutasHorarioyParada(rutas);
        boolean numvalido = false;
        int seleccion;
        do {
            System.out.println("Ingrese la ruta a optimizar");
            seleccion = Integer.parseInt(scanner.nextLine());
            try {
                new BigDecimal(seleccion);
                numvalido = true;
            } catch (NumberFormatException e) {
                numvalido = false;
            }

            if (numvalido == false) {
                System.out.print("Ingrese una opción válida: ");
            } else {
                if (seleccion < 1 && seleccion > rutas.size()) {
                    System.out.println("Opción inválida, intente de nuevo.");
                }
            }

        } while (numvalido == false);

        return seleccion;
    }
}
