import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Radio radio = new Radio();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("----- Radio -----");
            System.out.println("1. Prende el radio");
            System.out.println("2. Cambia de AM a FM o viceversa");
            System.out.println("3. Avanzar en el dial de las emisoras");
            System.out.println("4. Guardar una emisora en uno de los 12 botones");
            System.out.println("5. Seleccionar una emisora guardada");
            System.out.println("6. Apagar el radio");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    radio.switchOnOff();
                    System.out.println("Radio " + (radio.isOn() ? "encendido" : "apagado"));
                    break;
                case 2:
                    radio.switchAMFM();
                    System.out.println("Ahora sintonizado en " + (radio.isAM() ? "AM" : "FM"));
                    break;
                case 3:
                    double nuevaEstacion = radio.nextStation();
                    System.out.println("Sintonizado en la estación: " + nuevaEstacion);
                    break;
                case 4:
                    System.out.print("Ingrese el número del botón (1-12): ");
                    int boton = scanner.nextInt();
                    System.out.print("Ingrese la frecuencia de la emisora: ");
                    double frecuencia = scanner.nextDouble();
                    radio.saveStation(boton, frecuencia);
                    System.out.println("Emisora guardada en el botón " + boton);
                    break;
                case 5:
                    System.out.print("Ingrese el número del botón (1-12): ");
                    int botonSeleccionado = scanner.nextInt();
                    double emisoraSeleccionada = radio.selectStation(botonSeleccionado);
                    System.out.println("Sintonizado en la emisora guardada en el botón " + botonSeleccionado + ": " + emisoraSeleccionada);
                    break;
                case 6:
                    radio.switchOnOff();
                    System.out.println("Radio apagado");
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}

