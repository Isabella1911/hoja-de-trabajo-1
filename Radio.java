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
}
