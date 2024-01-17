import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestRadio {
    private Radio radio;

    @BeforeEach
    public void setUp() {
        radio = new Radio();
    }

    @Test
    public void testSwitchOnOff() {
        assertFalse(radio.isOn());
        radio.switchOnOff();
        assertTrue(radio.isOn());
        radio.switchOnOff();
        assertFalse(radio.isOn());
    }

    @Test
    public void testSwitchAMFM() {
        assertTrue(radio.isAM());
        radio.switchAMFM();
        assertFalse(radio.isAM());
        assertEquals(87.9, radio.nextStation(), 0.01);
        radio.switchAMFM();
        assertTrue(radio.isAM());
        assertEquals(530, radio.nextStation(), 0.01);
    }

    @Test
    public void testNextStation() {
        assertEquals(530, radio.nextStation(), 0.01);
        radio.switchAMFM();
        assertEquals(87.9, radio.nextStation(), 0.01);
    }

    // Puedes agregar más pruebas según sea necesario para cubrir otras funciones

    @Test
    public void testSaveAndSelectStation() {
        assertFalse(radio.isOn());
        radio.switchOnOff();
        assertTrue(radio.isOn());

        radio.saveStation(1, 550.0);
        assertEquals(550.0, radio.selectStation(1), 0.01);

        radio.switchAMFM();
        radio.saveStation(2, 95.5);
        assertEquals(95.5, radio.selectStation(2), 0.01);
    }
}
