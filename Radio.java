public class Radio implements IRadio {
    private boolean isOn;
    private boolean isAM;
    private double currentStation;
    double[] savedStationsAM;
    double[] savedStationsFM;

    public Radio() {
        isOn = false;
        isAM = true; //Iniciar en AM (preguntar)
        currentStation = 530.0;
        savedStationsAM = new double[12];
        savedStationsFM = new double[12];
    }

    public void saveStation(int buttonID, double station) {
        if (isAM) {
            savedStationsAM[buttonID - 1] = station;
        } else {
            savedStationsFM[buttonID - 1] = station;
        }
    }
    
    public boolean isAM() {
        return isAM;
    }

    public boolean isOn() {
        return isOn;
    }
    
    public double selectStation(int buttonID) {
        return isAM ? savedStationsAM[buttonID - 1] : savedStationsFM[buttonID - 1];
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

