package lb1vj1;

public class Color {
    private int red;
    private int green;
    private int blue;

    // Konstruktor koji prima hex string
    public static Color decode(String hex) {
        int intColor = Integer.decode(hex);
        int red = (intColor >> 16) & 0xFF;
        int green = (intColor >> 8) & 0xFF;
        int blue = intColor & 0xFF;
        return new Color(red, green, blue);
    }

    // Konstruktor za RGB vrijednosti
    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    // Getter za crvenu komponentu
    public int getRed() {
        return red;
    }

    // Getter za zelenu komponentu
    public int getGreen() {
        return green;
    }

    // Getter za plavu komponentu
    public int getBlue() {
        return blue;
    }

    // Pretvaranje RGB u HSB (Hue, Saturation, Brightness)
    public static float[] RGBtoHSB(int red, int green, int blue, float[] hsb) {
        java.awt.Color.RGBtoHSB(red, green, blue, hsb);
        return hsb;
    }

    // Pretvaranje RGB u HSL
    public float[] RGBtoHSL() {
        float r = red / 255f;
        float g = green / 255f;
        float b = blue / 255f;
        float max = Math.max(r, Math.max(g, b));
        float min = Math.min(r, Math.min(g, b));
        float h, s, l;
        l = (max + min) / 2;

        if (max == min) {
            h = s = 0;
        } else {
            float d = max - min;
            s = (l > 0.5) ? d / (2 - max - min) : d / (max + min);
            if (max == r) {
                h = (g - b) / d + (g < b ? 6 : 0);
            } else if (max == g) {
                h = (b - r) / d + 2;
            } else {
                h = (r - g) / d + 4;
            }
            h /= 6;
        }

        return new float[]{h * 360, s * 100, l * 100};
    }

    // Pretvaranje RGB u CMYK
    public float[] RGBtoCMYK() {
        float r = red / 255f;
        float g = green / 255f;
        float b = blue / 255f;

        float k = 1 - Math.max(r, Math.max(g, b));
        if (k == 1) {
            return new float[]{0, 0, 0, 100};
        }

        float c = (1 - r - k) / (1 - k);
        float m = (1 - g - k) / (1 - k);
        float y = (1 - b - k) / (1 - k);

        return new float[]{c * 100, m * 100, y * 100, k * 100};
    }


    // Pretvaranje RGB u String
    public String toString() {
        return "RGB: (" + red + ", " + green + ", " + blue + ")";
    }

    public int getRGB() {
        return (red << 16) | (green << 8) | blue;
    }

    // Pretvaranje RGB u HEX
    public String toHexString() {
        return String.format("0x%06X", getRGB());
    }
}
