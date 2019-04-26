package graphics.cw.display;

import graphics.cw.particles.Vector2D;

import java.awt.*;
import java.util.Map;
import java.util.HashMap;

public class InfoBox {
    private boolean showInfo = false;
    private Display display;

    Map<String, String> keyInputs;

    public InfoBox(Display display) {
        this.display = display;

        keyInputs = new HashMap<>();

        keyInputs.put("1", "add spawner");
        keyInputs.put("2", "add attractor");
        keyInputs.put("3", "add repeller");
        keyInputs.put("-", "shrink radius");
        keyInputs.put("+", "enlarge radius");
        keyInputs.put("[", "decrease density");
        keyInputs.put("]", "increase density");
        keyInputs.put("x", "delete feature");
        keyInputs.put("c", "clear everything");
        keyInputs.put("r", "clear particles");
    }

    public void showInfoBox() {
    }

    public void showInfoIcon() {
        this.display.drawCircle(new Vector2D(100, 100), 10, Color.WHITE);
        this.display.drawCircle(new Vector2D(100, 100), 8, Color.BLACK);
        this.display.drawText(new Vector2D(100, 100 - 2), 12, Color.WHITE, "?");
    }

    public void draw() {
        if(showInfo){
            showInfoBox();
        } else {
            showInfoIcon();
        }
    }
}
