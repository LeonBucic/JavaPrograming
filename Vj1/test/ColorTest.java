package test;
import lb1vj1.Color;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {

    @Test
    public void testRGBtoHSL() {
        Color color = new Color(31, 240, 255);
        float[] hsl = color.RGBtoHSL();
        assertEquals(184.0f, hsl[0], 0.1);
        assertEquals(100f, hsl[1], 0.1);
        assertEquals(56.0f, hsl[2], 0.1);
    }

    @Test
    public void testRGBtoCMYK() {
        Color color = new Color(31, 240, 255);
        float[] cmyk = color.RGBtoCMYK();
        assertEquals(87.8f, cmyk[0], 0.1);
        assertEquals(5.9f, cmyk[1], 0.1);
        assertEquals(0f, cmyk[2], 0.1);
        assertEquals(0f, cmyk[3], 0.1);
    }

    @Test
    public void testToHexString() {
        Color color = new Color(31, 240, 255);
        assertEquals("0x1FF0FF", color.toHexString());
    }

    @Test
    public void testRGBValues() {
        Color color = Color.decode("0x1FF0FF");
        assertEquals(31, color.getRed());
        assertEquals(240, color.getGreen());
        assertEquals(255, color.getBlue());
    }
}

