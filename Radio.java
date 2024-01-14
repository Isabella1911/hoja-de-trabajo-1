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


    public void saveStation(int buttonId, double station) {
        savedStations[buttonId - 1] = station;
    }
    
    public boolean isAM() {
        return isAM;
    }

    public boolean isOn() {
        return isOn;
    }
    
    public double selectStation(int buttonId) {
        return savedStations[buttonId - 1];
    }

    public void switchOnOff() {
        isOn = !isOn;
    }
}