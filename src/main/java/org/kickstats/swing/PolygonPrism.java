
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
    
    public void change(Matrix m) {
        int length = this.shape1.size();
        
        List<Vector> newShape1 = new ArrayList<>();
        List<Vector> newShape2 = new ArrayList<>();
        
        for(int i = 0; i < length; i++) {
            Vector v1 = this.shape1.get(i);
            Vector v2 = this.shape2.get(i);
            
            Vector newV1 = m.multiply(v1);
            Vector newV2 = m.multiply(v2);
            
            newShape1.add(newV1);
            newShape2.add(newV2);
        }// for
        
        this.shape1 = newShape1;
        this.shape2 = newShape2;
    }// change(Matrix)
    
}// PolygonPrism
