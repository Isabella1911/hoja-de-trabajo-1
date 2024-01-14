import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Radio radio = new Radio();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n----- Radio -----");
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
                    System.out.println("\nRadio " + (radio.isOn() ? "encendido" : "apagado"));
                    break;
                case 2:
                    if (radio.isOn()) {
                        radio.switchAMFM();
                        System.out.println("\nAhora sintonizado en " + (radio.isAM() ? "AM" : "FM"));
                    } else {
                        System.out.println("\nEl radio está apagado. Enciéndelo primero.");
                    }
                    break;
                case 3:
                    if (radio.isOn()) {
                        double nuevaEstacion = radio.nextStation();
                        System.out.println("\nSintonizado en la estación: " + nuevaEstacion);
                    } else {
                        System.out.println("\nEl radio está apagado. Enciéndelo primero.");
                    }
                    break;
                case 4:
                    if (radio.isOn()) {
                        System.out.print("\nIngrese el número del botón (1-12): ");
                        int boton = scanner.nextInt();
                        System.out.print("\nIngrese la frecuencia de la emisora: ");
                        double frecuencia = scanner.nextDouble();
                        radio.saveStation(boton, frecuencia);
                        System.out.println("\nEmisora guardada en el botón " + boton);
                    } else {
                        System.out.println("\nEl radio está apagado. Enciéndelo primero.");
                    }
                    break;
                case 5:
                    if (radio.isOn()) {
                        System.out.print("\nIngrese el número del botón (1-12): ");
                        int botonSeleccionado = scanner.nextInt();
                        double emisoraSeleccionada = radio.selectStation(botonSeleccionado);
                        System.out.println("\nSintonizado en la emisora guardada en el botón " + botonSeleccionado + ": " + emisoraSeleccionada);
                    } else {
                        System.out.println("\nEl radio está apagado. Enciéndelo primero.");
                    }
                    break;
                case 6:
                    if (radio.isOn()) {
                        radio.switchOnOff();
                        System.out.println("\nRadio apagado");
                    } else {
                        System.out.println("\nEl radio ya está apagado.");
                    }
                    break;
                case 0:
                    System.out.println("\nSaliendo del programa");
                    break;
                default:
                    System.out.println("\nOpción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}

