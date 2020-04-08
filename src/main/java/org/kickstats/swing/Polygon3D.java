
package org.kickstats.swing;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

/**
 * An experiment creating 3D shapes
 * 
 * @author Chase Sonnemaker with guidance from Leon Tabak's code.
 * @version 7 April 2020
 */
public class Polygon3D {
    
    private final List<Vector> points = new ArrayList<>();
    
    public Polygon3D(int sides, double radius, double z) {
        for(int i = 0; i < sides; i++) {
            double percent = ((double) i) / sides;
            double angle = percent * 2 * Math.PI;
            
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            
            Vector v = new Vector(x, y, z);
            this.points.add(v);
        }// for
    }// Polygon3D(int, double, double)
    
    
    public Polygon3D(Vector p00, Vector p10, Vector p11, Vector p01) {
        points.add(p00);
        points.add(p10);
        points.add(p11);
        points.add(p01);
    }// Polygon3D(Vector, Vector, Vector, Vector)
    
    
    public void change(Matrix m) {
        for(Vector point : this.points) {
            Vector newPoint = m.multiply(point);
            point.set(newPoint);
        }// for
    }// change(Matrix)
    
    
    public Polygon3D changeShape(Matrix m) {
        this.change(m);
        return this;
    }// changeShape(Matrix)
    
    
    public List<Vector> getPoints() {
        return this.points;
    }// getPoints()
    
    
    public double smallestZ() {
        double smallestZ = this.points.get(0).get(2);
        for(Vector point : this.points) {
            double z = point.get(2);
            
            if(z < smallestZ) {
                smallestZ = z;
            }// if
        }// for
        return smallestZ;
    }// smallestZ()
    
    
    public Shape getShape() {
        Path2D.Double newPath = new Path2D.Double();
        int length = this.points.size();
        
        Vector start = this.points.get(length - 1);
        newPath.moveTo(start.get(0), start.get(1));
        
        for(Vector point : this.points) {
            double x = point.get(0);
            double y = point.get(1);
                    
            newPath.lineTo(x, y);  
        }// for
        newPath.closePath();
        return newPath;
    }// getShape()
    
    
}// Polygon3D
