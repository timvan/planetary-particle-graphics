package graphics.cw.particles;

import graphics.cw.Constants;

import java.util.ArrayList;
import java.util.Iterator;

public class ParticleMouseHandler {
  ParticleSystem ps;
  Thing thingClicked;
  boolean dragOccured = false;

  public ParticleMouseHandler(ParticleSystem ps) {
    this.ps = ps;
  }

  public void mousePressed(int mouseX, int mouseY) {
    thingClicked = ps.getThing(mouseX, mouseY);
  }

  public void mouseReleased(int mouseX, int mouseY) {
    if(thingClicked != null && !dragOccured) {
      thingClicked.setOn(!thingClicked.isOn());
      thingClicked.setDensity(thingClicked.getDensity() * -1);
    }
    thingClicked = null;
    dragOccured = false;

  }

  public void mouseDragged(int mouseX, int mouseY) {
    if(thingClicked != null) {
      thingClicked.setLocation(new Vector2D(mouseX, mouseY));
      dragOccured = true;
    }
  }

  public void keyPressed(int key, int mouseX, int mouseY) {

    Thing thing = ps.getThing(mouseX, mouseY);

    if(key == '+' || key == '=') {
      if(thing != null) {
        thing.setRadius(thing.getRadius() * (1 + Constants.growthRate));
      }
    }
    if(key == '-' || key == '_') {
      if(thing != null) {
        thing.setRadius(thing.getRadius() * (1 - Constants.growthRate));
      }
    }
    if(key == ']' || key == '}') {
      if(thing != null) {
        thing.setDensity(thing.getDensity() * (1 + Constants.growthRate));
      }
    }
    if(key == '[' || key == '{') {
      if(thing != null) {
        thing.setDensity(thing.getDensity() * (1 - Constants.growthRate));
      }
    }
    if(key == '1') {
      ps.newSpawner(mouseX, mouseY);
    }
    if(key == '2') {
      ps.newFeature(mouseX, mouseY, true);
    }
    if(key == '3') {
      ps.newFeature(mouseX, mouseY, false);
    }
    if(key == 'x' || key == 'X') {
      ps.deleteThing(mouseX, mouseY);
    }
    if(key == 'r' || key == 'R') {
      ps.clearParticles();
    }
    if(key == 'c' || key == 'C') {
      ps.clearAll();
    }
  }
}
