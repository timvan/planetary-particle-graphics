package graphics.cw.display;

import graphics.cw.particles.Vector2D;

import java.awt.*;
import java.util.Map;
import java.util.HashMap;

public class InfoBox {
    private boolean show = false;
    private Display display;
    private int x;
    private int y;
    private int width;
    private int height;

    Map<String, String> keyInputs;

    public InfoBox(Display display, int x, int y) {
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

        this.x = x;
        this.y = y;

        this.width = 110;
        this.height = keyInputs.size() * 15;
    }

    public void draw() {
        display.drawRect(new Vector2D(x, y), width, height, Color.WHITE);
        int i = 0;
        for(Map.Entry<String, String> entry : keyInputs.entrySet()){
            display.drawText(new Vector2D(x + 5, y + i * 15), 10, Color.BLACK, entry.getKey(), TextAlign.CORNER);
            display.drawText(new Vector2D(x + 15, y + i * 15), 10, Color.BLACK, entry.getValue(), TextAlign.CORNER);
            i++;
        }
    }


    public boolean isInside(int x, int y) {
        if(x >= this.x && x <= this.x + this.width) {
            if(y >= this.y && y <= this.y + this.height) {
                return true;
            }
        }
        return false;
    }
}
