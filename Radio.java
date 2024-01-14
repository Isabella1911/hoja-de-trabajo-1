public class Radio {
    private boolean isOn;
    private boolean isAM;
    private double currentStation;
    private double[] savedStations;

    public Radio() {
        isOn = false;
        isAM = true; //Iniciar en AM (preguntar)
        currentStation = 530;  // Iniciar en la primera estación de AM
        savedStations = new double[12];
    }
<<<<<<< HEAD

    public void saveStation(int buttonId, double station) {
        savedStations[buttonId - 1] = station;
    }
    
    public boolean isAM() {
        return isAM;
    }

    public boolean isOn() {
        return isOn;
    }
}
=======
}
>>>>>>> 48bc772a0bb2b3eeb5ddf1d26d59f4da511bf28a
