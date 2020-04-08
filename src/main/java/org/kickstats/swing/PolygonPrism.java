
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
    
    private Polygon3D primary1;
    private Polygon3D primary2;
    private List<Polygon3D> rectangles = new ArrayList<>(); 
    
    
    public PolygonPrism(int sides, double radius, double length) {
        
        this.primary1 = new Polygon3D(sides, radius, 0);
        this.primary2 = new Polygon3D(sides, radius, -length);
        
        List<Vector> points1 = this.primary1.getPoints();
        List<Vector> points2 = this.primary2.getPoints();
        
        int size = points1.size();
        
        for(int i = 0; i < size - 1; i++) {
            Vector p00 = points1.get(i);
            Vector p10 = points2.get(i);
            Vector p11 = points2.get(i + 1);
            Vector p01 = points1.get(i + 1);
            
            Polygon3D newRec = new Polygon3D(p00, p10, p11, p01);
            this.rectangles.add(newRec);
        }// for
        
        Vector p00 = points1.get(size-1);
        Vector p10 = points2.get(size-1);
        Vector p11 = points2.get(0);
        Vector p01 = points1.get(0);
            
        Polygon3D newRec = new Polygon3D(p00, p10, p11, p01);
        this.rectangles.add(newRec); 
    }// PolygonPrism(int, double)
    
    public void change(Matrix m) {
        this.primary1 = this.primary1.changeShape(m);
        this.primary2 = this.primary2.changeShape(m);
        List<Polygon3D> newList = new ArrayList<>();
        for(Polygon3D p : this.rectangles) {
            newList.add(p.changeShape(m));
        }// for
        this.rectangles = newList;
    }// change(Matrix)

    /**
     * @return the primary1
     */
    public Polygon3D getPrimary1() {
        return primary1;
    }

    /**
     * @return the primary2
     */
    public Polygon3D getPrimary2() {
        return primary2;
    }

    /**
     * @return the rectangles
     */
    public List<Polygon3D> getRectangles() {
        return rectangles;
    }
    
    
}// PolygonPrism
