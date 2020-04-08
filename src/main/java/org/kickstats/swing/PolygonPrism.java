
package org.kickstats.swing;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates the elements needed to create a 3D polygon prism.
 * 
 * @author Chase Sonnemaker 
 * @version 7 April 2020
 */
public class PolygonPrism {
    
    List<Vector> shape1 = new ArrayList<>();
    List<Vector> shape2 = new ArrayList<>();
    
    
    public PolygonPrism(int sides, double radius, double length) {
        for(int i = 0; i < sides; i++) {
            double percent = ((double) i) / sides;
            double angle = percent * 2 * Math.PI;
            
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            
            Vector v1 = new Vector(x, y, 0.0);
            Vector v2 = new Vector(x, y, -length);
        }// for
    }// PolygonPrism(int, double)
    
}// PolygonPrism
