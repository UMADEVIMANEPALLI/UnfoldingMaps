package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
		this.setId(city.getId());
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.pushStyle();
		if(((Integer)this.getProperty("routecount"))<=100){
		    pg.fill(pg.color(255, 255, 0));
		    pg.ellipse(x, y, 12, 12);
		}
		else if(((Integer)this.getProperty("routecount"))<=200){
			pg.fill(pg.color(0, 0, 255));
			pg.ellipse(x, y, 12, 12);
		}
		else {
			pg.fill(pg.color(255, 0, 0));
			pg.ellipse(x, y, 12, 12);
		}

		pg.popStyle();
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		
		// show routes
        pg.pushStyle();
		pg.rectMode(PConstants.CORNER);
		
		pg.stroke(110);
		pg.fill(255,255,255);
		pg.rect(x, y + 15, pg.textWidth(String.valueOf("Name: " + this.getProperty("name") +" City: "+ this.getProperty("city") + " Total routes: "+this.getProperty("routecount"))) +6, 18, 5);
		
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.fill(0);
		pg.text(String.valueOf("Name: " + this.getProperty("name") +" City: "+ this.getProperty("city") + " Total routes: "+this.getProperty("routecount")), x + 3 , y +18);
		
		pg.popStyle();
	}
	
}
