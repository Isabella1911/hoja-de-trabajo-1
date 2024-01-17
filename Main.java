import java.util.Scanner;
/**
 * Clase principal que contiene el método main para ejecutar el programa de control de radio.
 */
public class Main {

    public static void main(String[] args) {
        Radio radio = new Radio();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            // Mostrar información sobre la radiofrecuencia y emisora actual si la radio está encendida
            // if (radio.isOn()) {
            //     double emisoraActual = radio.isAM() ? radio.nextStation() : radio.nextStation();
            //     System.out.print("\n[" + Math.round(emisoraActual * 100.0) / 100.0);
            //     System.out.print(" | " + (radio.isAM() ? "AM" : "FM") + "]\n");
            // }
            
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
                        System.out.println("\nSintonizado en la estación: " + Math.round(nuevaEstacion * 100.0) / 100.0);
                    } else {
                        System.out.println("\nEl radio está apagado. Enciéndelo primero.");
                    }
                    break;
                case 4:
                    if (radio.isOn()) {
                        System.out.print("\nIngrese el número del botón (1-12): ");
                        int boton = scanner.nextInt();
                        // Obtener la emisora actualmente sintonizada
                        double emisoraActual = radio.isAM() ? radio.nextStation() : radio.nextStation();
                        radio.saveStation(boton, Math.round(emisoraActual * 100.0) / 100.0);
                        System.out.println("\nEmisora guardada en el botón " + boton);
                        break;
                    } else {
                        System.out.println("\nEl radio está apagado. Enciéndelo primero.");
                    }
                    break;
                    case 5:
                    if (radio.isOn()) {
                        System.out.println("\n----- Emisoras Guardadas -----");
                        if (radio.isAM()) {
                            // Mostrar emisoras guardadas en AM
                            for (int i = 0; i < radio.savedStationsAM.length; i++) {
                                double emisoraGuardada = radio.savedStationsAM[i];
                                System.out.println("\tBotón " + (i + 1) + ": " + (emisoraGuardada > 0 ? emisoraGuardada : "No guardada"));
                            }
                        } else {
                            // Mostrar emisoras guardadas en FM
                            for (int i = 0; i < radio.savedStationsFM.length; i++) {
                                double emisoraGuardada = radio.savedStationsFM[i];
                                System.out.println("\tBotón " + (i + 1) + ": " + (emisoraGuardada > 0 ? emisoraGuardada : "No guardada"));
                            }
                        }
                        
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

