public class Radio {
    private boolean isOn;
    private boolean isAM;
    private double currentStation;
    double[] savedStations;

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

    public void switchAMFM() {
        isAM = !isAM;
        if (isAM) {
            currentStation = 530;  // Primera estación de AM
        } else {
            currentStation = 87.9;  //Primera estación de FM
        }
    }

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

