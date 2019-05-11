package graphics.cw.display;

/***
 * Storage class to hold RGB color data
 */
public class RGB {
    private int red;
    private int green;
    private int blue;

    public RGB (int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

}
