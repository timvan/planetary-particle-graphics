package graphics.cw.display;

public class Info {
    Display display;
    InfoBox infoBox;
    InfoCircle infoCircle;
    boolean expanded;

    int x;
    int y;

    int x_off = 20;
    int y_off = 20;

    public Info(Display display, int x, int y) {
        this.display = display;
        this.x = x;
        this.y = y;
        infoCircle = new InfoCircle(display, x, y);
        infoBox = new InfoBox(display, x - x_off, y - y_off);

        expanded = false;
    }

    public void update(int mouseX, int mouseY) {
        if(expanded){
            expanded = infoBox.isInside(mouseX, mouseY);
        } else {
            expanded = infoCircle.isInside(mouseX, mouseY);
        }
    }

    public void display() {
        if(expanded){
            infoBox.draw();
            return;
        }
        infoCircle.draw();
    }

}
