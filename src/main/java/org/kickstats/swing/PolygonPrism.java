
package org.kickstats.swing;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

/**
 * Creates the elements needed to create a 3D polygon prism.
 * 
 * @author Chase Sonnemaker 
 * @version 7 April 2020
 */
public class PolygonPrism {
    
    Polygon3D primary1;
    Polygon3D primary2;
    List<Polygon3D> rectangles = new ArrayList<>(); 
    
    
    public PolygonPrism(int sides, double radius, double length) {
        
        this.primary1 = new Polygon3D(sides, radius, 0);
        this.primary2 = new Polygon3D(sides, radius, -length);
        
        List<Vector> points1 = this.primary1.getPoints();
        List<Vector> points2 = this.primary1.getPoints();
        
        int size = points1.size();
        
        for(int i = 0; i < size - 1; i++) {
            Vector p00 = points1.get(i);
            Vector p10 = points2.get(i);
            Vector p11 = points2.get(i + 1);
            Vector p01 = points1.get(i + 1);
            
            Polygon3D newRec = new Polygon3D(p00, p10, p11, p01);
            this.rectangles.add(newRec);
        }// for
        
        Vector p00 = points1.get(size);
        Vector p10 = points2.get(size);
        Vector p11 = points2.get(0);
        Vector p01 = points1.get(0);
            
        Polygon3D newRec = new Polygon3D(p00, p10, p11, p01);
        this.rectangles.add(newRec); 
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
    
    
    public Shape getShape() {
        
    }// getShape()
    
    
}// PolygonPrism
