/**
 * Clase que representa un objeto Radio.
 * Da la funcionalidad para controlar un radio, sintonizar emisoras y guardarlas.
 */
public class Radio implements IRadio {
    private boolean isOn;
    private boolean isAM;
    /** Frecuencia actual de la emisora. */
    private double currentStation;
    /** Emisoras guardadas para la banda AM. */
    double[] savedStationsAM;
     /** Emisoras guardadas para la banda FM. */
    double[] savedStationsFM;

    /**
     * Constructor de la clase Radio.
     * Inicia el radio en estado apagado, en la banda AM y en la primera emisora de la AM.
     */
    public Radio() {
        isOn = false;
        isAM = true; //Iniciar en AM (preguntar)
        currentStation = 530.0;
        savedStationsAM = new double[12];
        savedStationsFM = new double[12];
    }
    /**
     * Guarda la emisora actual en uno de los botones de emisoras.
     * @param buttonID Número del botón (1-12) en el cual se guardará la emisora.
     * @param station Frecuencia de la emisora a guardar.
     */
    public void saveStation(int buttonID, double station) {
        if (isAM) {
            savedStationsAM[buttonID - 1] = station;
        } else {
            savedStationsFM[buttonID - 1] = station;
        }
    }
    /**
     * Verifica si el radio está en la banda AM.
     * @return true si el radio está en la banda AM, false si está en la banda FM.
     */
    public boolean isAM() {
        return isAM;
    }
    /**
     * Verifica si el radio está encendido.
     * @return true si el radio está encendido, false si está apagado.
     */
    public boolean isOn() {
        return isOn;
    }
    /**
     * Obtiene la emisora guardada en un botón específico.
     * @param buttonID Número del botón (1-12) del cual se obtendrá la emisora guardada.
     * @return La emisora guardada en el botón especificado.
     */
    public double selectStation(int buttonID) {
        return isAM ? savedStationsAM[buttonID - 1] : savedStationsFM[buttonID - 1];
    }
    /** 
     * Cambia el estado del radio de encendido a apagado o viceversa.
     */
    public void switchOnOff() {
        isOn = !isOn;
    }
    /** 
     * Cambia la banda del radio de AM a FM o viceversa.
     * Además, ajusta la frecuencia a la primera estación de la banda seleccionada.
     */
    public void switchAMFM() {
        isAM = !isAM;
        if (isAM) {
            currentStation = 530;  // Primera estación de AM
        } else {
            currentStation = 87.9;  //Primera estación de FM
        }
    }
    /**
     * Avanza a la siguiente estación en la banda actual del radio.
     * @return La frecuencia de la siguiente estación.
     */
    public double nextStation() {
        if (isAM) {
            currentStation += 10;
            if (currentStation > 1610) {
                currentStation = 530;  // Reiniciar al principio del dial de AM
            }
        } else {
            currentStation += 0.2;
            if (currentStation > 107.9) {
                currentStation = 87.9;  // Reiniciar al principio del dial de FM
            }
        }
        return currentStation;
    }

}

