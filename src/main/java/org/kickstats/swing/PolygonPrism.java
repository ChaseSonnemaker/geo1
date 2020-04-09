
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
    
    private List<Vector> shape1Points = new ArrayList<>();
    private Vector shape1Center;
    private List<Vector> shape2Points = new ArrayList<>();
    private Vector shape2Center;
    private List<Polygon3D> triangles = new ArrayList<>();
    
    
    public PolygonPrism(int sides, double radius, double height) {
        
        //Finding shape centers
        double centerX = 0.0;
        double centerY = 0.0;
        
        double shape1Z = -height / 2;
        double shape2Z = height / 2;
        
        this.shape1Center = new Vector(centerX, centerY, shape1Z);
        this.shape2Center = new Vector(centerX, centerY, shape2Z);
        
        
        //Finding point lists
        for(int i = 0; i < sides; i++) {
            double angle = ((double) i) / sides;
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(radius);
            
            Vector shape1V = new Vector(x, y, shape1Z);
            Vector shape2V = new Vector(x, y, shape2Z);
            
            this.shape1Points.add(shape1V);
            this.shape2Points.add(shape2V); 
        }// for
        
        
        //Finding triangle list
        this.makeTriangles();
    }// PolygonPrism(int, double)
    
    
    public void makeTriangles() {
        List<Polygon3D> triangleList = new ArrayList<>();
        
        //Creating shape 1 triangles
        int length = this.shape1Points.size();
        
        Vector v0 = this.shape1Center;
        Vector v1 = this.shape1Points.get(length - 1);
        Vector v2 = this.shape1Points.get(0);

        Polygon3D triangle = new Polygon3D(v0, v1, v2);
        triangleList.add(triangle);
        
        for(int i = 0; i < length - 1; i++) {
            v1 = this.shape1Points.get(i);
            v2 = this.shape1Points.get(i + 1);
            
            triangle = new Polygon3D(v0, v1, v2);
            triangleList.add(triangle);
        } // for
        
        
        //Creating shape 2 triangles
        length = this.shape2Points.size();
        
        v0 = this.shape2Center;
        v1 = this.shape2Points.get(length - 1);
        v2 = this.shape2Points.get(0);

        triangle = new Polygon3D(v0, v2, v1);
        triangleList.add(triangle);
        
        for(int i = 0; i < length - 1; i++) {
            v1 = this.shape2Points.get(i);
            v2 = this.shape2Points.get(i + 1);
            
            triangle = new Polygon3D(v0, v2, v1);
            triangleList.add(triangle);
        } // for
        
        
        //Creating side triangles
        v0 = this.shape1Points.get(length - 1);
        v1 = this.shape1Points.get(0);
        v2 = this.shape2Points.get(0);
        Vector v3 = this.shape2Points.get(length - 1);
        
        triangle = new Polygon3D(v0, v1, v2);
        triangleList.add(triangle);
        triangle = new Polygon3D(v0, v2, v3);
        triangleList.add(triangle);
        
        for(int i = 0; i < length - 1; i++) {
            v0 = this.shape1Points.get(i);
            v1 = this.shape1Points.get(i + 1);
            v2 = this.shape2Points.get(i);
            v3 = this.shape2Points.get(i + 1);
        
            triangle = new Polygon3D(v0, v1, v2);
            triangleList.add(triangle);
            triangle = new Polygon3D(v0, v2, v3);
            triangleList.add(triangle);
        }// for
        
        this.triangles = triangleList;
    }// makeTriangles()
    
    
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
        points.add(this.shape1Points.get(0));
        points.add(this.shape2Points.get(0));
        points.add(this.shape2Points.get(pointNum - 1));
        
        rectangles.add(new Polygon3D(points));
        
        for(int i = 0; i < pointNum - 1; i++) {
            points = new ArrayList<>();
        
            points.add(this.shape1Points.get(i));
            points.add(this.shape1Points.get(i + 1));
            points.add(this.shape2Points.get(i + 1));
            points.add(this.shape2Points.get(i));
        
            rectangles.add(new Polygon3D(points));
        }// for
        
        return rectangles;
    }// getRectangles()    
    
    
    public List<Polygon3D> getOrderedShapes() {
        List<Polygon3D> shapeList = this.getRectangles();
        shapeList.add(this.getFace1());
        shapeList.add(this.getFace2());
        int length = shapeList.size();
        
        for(int i = 0; i < length; i++) {
            int smallestIndex = i;
            
            for(int j = i + 1; j < length; j++) {
                double smallestZ = shapeList.get(smallestIndex).smallestZ();
                double currentZ = shapeList.get(j).smallestZ();
                
                
                if(smallestZ > currentZ) {
                    smallestIndex = j; 
                }// if    
            }// for
            Polygon3D placeholder = shapeList.get(i);
            shapeList.set(i, shapeList.get(smallestIndex));
            shapeList.set(smallestIndex, placeholder);
        }// for
        
        return shapeList;
    }// getOrderedShapes()
    
    
}// PolygonPrism
