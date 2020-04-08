
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
    
    public void change(Matrix m) {
        Polygon3D face1 = new Polygon3D(this.shape1Points);
        Polygon3D face2 = new Polygon3D(this.shape2Points);
        
        face1.change(m);
        face2.change(m);
        
        this.shape1Points = face1.getPoints();
        this.shape2Points = face2.getPoints();
    }// change(Matrix)

    /**
     * @return the primary1
     */
    public Polygon3D getFace1() {
        return new Polygon3D(this.shape1Points);
    }// getFace1

    /**
     * @return the primary2
     */
    public Polygon3D getFace2() {
        return new Polygon3D(this.shape2Points);
    }// getFace2

    /**
     * @return the rectangles
     */
    public List<Polygon3D> getRectangles() {
        int pointNum = this.shape1Points.size();
        
        List<Polygon3D> rectangles = new ArrayList<>();
        List<Vector> points = new ArrayList<>();
        
        points.add(this.shape1Points.get(pointNum - 1));
        points.add(this.shape2Points.get(pointNum - 1));
        points.add(this.shape1Points.get(0));
        points.add(this.shape2Points.get(0));
        
        rectangles.add(new Polygon3D(points));
        
        for(int i = 0; i < pointNum - 1; i++) {
            points = new ArrayList<>();
        
            points.add(this.shape1Points.get(i + 1));
            points.add(this.shape2Points.get(i + 1));
            points.add(this.shape1Points.get(i));
            points.add(this.shape2Points.get(i));
        
            rectangles.add(new Polygon3D(points));
        }// for
        
        return rectangles;
    }// getRectangles()
//    
//    
}// PolygonPrism
