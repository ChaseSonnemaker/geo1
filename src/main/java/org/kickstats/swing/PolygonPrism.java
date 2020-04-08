
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
    
    private List<Vector> shape1Points = new ArrayList<>();
    private List<Vector> shape2Points = new ArrayList<>();
    
    
    public PolygonPrism(int sides, double radius, double length) {
        
        Polygon3D face1 = new Polygon3D(sides, radius, 0);
        Polygon3D face2 = new Polygon3D(sides, radius, -length);
        
        List<Vector> points1 = face1.getPoints();
        List<Vector> points2 = face2.getPoints();
        
        this.shape1Points = points1;
        this.shape2Points = points2;
    }// PolygonPrism(int, double)
    
//    public void change(Matrix m) {
//        this.primary1 = this.primary1.changeShape(m);
//        this.primary2 = this.primary2.changeShape(m);
//        List<Polygon3D> newList = new ArrayList<>();
//        for(Polygon3D p : this.rectangles) {
//            newList.add(p.changeShape(m));
//        }// for
//        this.rectangles = newList;
//    }// change(Matrix)
//
    /**
     * @return the primary1
     */
    public Polygon3D getFace1() {
        return new Polygon3D(this.shape1Points);
    }// getFace1
//
//    /**
//     * @return the primary2
//     */
//    public Polygon3D getPrimary2() {
//        return primary2;
//    }
//
//    /**
//     * @return the rectangles
//     */
//    public List<Polygon3D> getRectangles() {
//        return rectangles;
//    }
//    
//    
}// PolygonPrism
