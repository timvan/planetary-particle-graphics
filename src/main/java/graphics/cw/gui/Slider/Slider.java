package graphics.cw.gui.Slider;

import graphics.cw.display.Display;
import graphics.cw.display.RGB;
import graphics.cw.particles.Vector2D;

/***
 * A slider button that can be clicked to position or dragged
 * The slider returns a double value between 0(buttons far left) and 1(button far right)
 * Keeps track of whether slider has moved/changed since last checked
 * x,y are top left hand corner position of slider
 */
public class Slider {
    // Top left hand corner pos of slider
    private int x;
    private int y;

    private int width;
    private int height;
    private int buttonWidth;

    private enum featureType {NONE, SLIDER, BUTTON};

    private SlideButton slideButton;

    private RGB slideButtonColor = new RGB (150, 150, 150);
    private RGB sliderAreaColor = new RGB(100, 100, 100);

    boolean changed = false;

    public Slider(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 100;
        this.height = 20;
        this.buttonWidth = this.height;

        slideButton = new SlideButton(x + width / 2 - this.buttonWidth / 2, y, this.buttonWidth, height);

    }

    public double getValue() {
        double diff = (double) slideButton.getX() -  this.x;
        return diff /  (this.width - this.buttonWidth);
    }

    public void draw(Display display) {
        display.drawRect(new Vector2D(this.x, this.y), width, height, sliderAreaColor);
        display.drawRect(new Vector2D(slideButton.getX(), this.y), this.buttonWidth, height, slideButtonColor);
    }

    // handle click
    // handle drag
    // handle release

    public featureType isIn(int x, int y){
        if(x >= this.x && x <= this.x + width) {
            if(y >= this.y && y <= this.y + height) {
                if(slideButton.isIn(x, y)){
                    return featureType.BUTTON;
                }
                return featureType.SLIDER;
            }
        }
        return  featureType.NONE;
    }

    public boolean hasChanged(){
        if(changed){
            changed = false;
            return true;
        }
        return false;

    }

    public void handleMousePressed(int x, int y) {
        if(isIn(x, y) != featureType.NONE){
            this.setSliderX(x);
            changed = true;
        }
    }

    public void handleMouseDragged(int x, int y) {
        if(isIn(x, y) == featureType.BUTTON){
            setSliderX(x);
            changed = true;
        }
    }

    public void setSliderX(int x){
        if(x <= this.x + buttonWidth / 2){
            slideButton.setX(this.x);
            return;
        }
        if(x >= this.x + width - buttonWidth / 2){
            slideButton.setX(this.x + width - buttonWidth);
            return;
        }
        slideButton.setX(x - buttonWidth / 2);
    }

    private class SlideButton {

        private int x;
        private int y;
        private int width;
        private int height;

        public SlideButton(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public boolean isIn(int x, int y){
            if(x >= this.x && x <= this.x + width) {
                if(y >= this.y && y <= this.y + height) {
                    return true;
                }
            }
            return false;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }
}
