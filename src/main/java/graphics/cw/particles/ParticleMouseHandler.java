package graphics.cw.particles;

import java.util.ArrayList;
import java.util.Iterator;

public class ParticleMouseHandler {
  ParticleSystem ps;
  Thing thingClicked;
  boolean dragOccured = false;

  public ParticleMouseHandler(ParticleSystem ps) {
    this.ps = ps;
  }

  private Thing getThing(int mouseX, int mouseY) {
    for(Feature feature : ps.getFeatures()) {
      if(feature.isInside(mouseX, mouseY)){ return feature; }
    }
    for(Spawner spawner : ps.getSpawners()) {
      if(spawner.isInside(mouseX, mouseY)){ return spawner; }
    }
    return null;
  }

  public void mousePressed(int mouseX, int mouseY) {
    thingClicked = this.getThing(mouseX, mouseY);
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

    Thing thing = this.getThing(mouseX, mouseY);

    if(key == '+' || key == '=') {
      if(thing != null) {
        thing.setRadius(thing.getRadius() * 1.2);
        System.out.println("enlarge");
      }
    }

    if(key == '-' || key == '_') {
      if(thing != null) {
        thing.setRadius(thing.getRadius() * 0.8);
        System.out.println("shrink");
      }
    }

    if(key == ']' || key == '}') {
      if(thing != null) {
        thing.setDensity(thing.getDensity() * 1.2);
        System.out.println("enlarge");
      }
    }

    if(key == '[' || key == '{') {
      if(thing != null) {
        thing.setDensity(thing.getDensity() * 0.8);
        System.out.println("shrink");
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

    if(key == 'x') {

    }
    if(key == 'r') {

    }
  }

}
