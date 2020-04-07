
package org.kickstats.swing;

import java.util.ArrayList;
import java.util.List;

/**
 * An experiment creating 3D shapes
 * 
 * @author Chase Sonnemaker with guidance from Leon Tabak's code.
 * @version 7 April 2020
 */
public class Triangle3D {
    
    private final List<Vector> points = new ArrayList<>();
    
    public Triangle3D(double length) {
        for(int i = 0; i < 3; i++) {
            double percent = (double) i / 3d;
            double angle = percent * 2 * Math.PI;
            double radius = length / 2;
            
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            
            Vector v = new Vector(x, y, 0.0);
            this.points.add(v);
        }// for
    }// Triangle3D(double)
    
}// Triangle3D
