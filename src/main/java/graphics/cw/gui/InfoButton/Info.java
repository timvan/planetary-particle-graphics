package graphics.cw.gui.InfoButton;

import graphics.cw.display.Display;

/***
 * Info is hoverable / expanding button.
 * When mouse hovers over circle, an info box is displayed
 */
public class Info {
    private InfoBox infoBox;
    private InfoCircle infoCircle;
    private boolean expanded;

    public Info(int x, int y) {
        int x_off = 20;
        int y_off = 20;
        infoCircle = new InfoCircle(x, y);
        infoBox = new InfoBox(x - x_off, y - y_off);
        expanded = false;
    }

    public void handleMouse(int mouseX, int mouseY) {
        if(expanded){
            expanded = infoBox.isInside(mouseX, mouseY);
        } else {
            expanded = infoCircle.isInside(mouseX, mouseY);
        }
    }

    public void draw(Display display) {
        if(expanded){
            infoBox.draw(display);
            return;
        }
        infoCircle.draw(display);
    }

}
