package graphics.cw.particles;

import java.util.ArrayList;
import java.util.Iterator;

public class ParticleMouseHandler {
  ParticleSystem ps;
  Thing thingClicked;

  public ParticleMouseHandler(ParticleSystem ps) {
    this.ps = ps;
  }

  public void mousePressed(int mouseX, int mouseY) {
    for(Thing sink : ps.getFeatures()) {
      if(sink.isInside(mouseX, mouseY)){ thingClicked = sink; }
    }
    for(Thing thing : ps.getSpawners()) {
      if(thing.isInside(mouseX, mouseY)){ thingClicked = thing; }
    }
  }

  public void mouseReleased(int mouseX, int mouseY) {
    thingClicked = null;

  }

  public void mouseDragged(int mouseX, int mouseY) {
    if(thingClicked != null) {
      thingClicked.setLocation(new Vector2D(mouseX, mouseY));
    }
  };

}
