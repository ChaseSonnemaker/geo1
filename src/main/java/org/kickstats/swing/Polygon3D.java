
package org.kickstats.swing;

import java.awt.Shape;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Uses 4 element vectors as vertices to model a 2D polygon in 3D space.
 * 
 * This class is used to model 3D shapes, such as a prism, an anti-prism, or  
 * a pyramid in 2D space so they can be visualized.
 * 
 * @author Chase Sonnemaker with guidance from Leon Tabak's code.
 * @version 10 April 2020
 */
public class Polygon3D {
    
    private List<Vector> points = new ArrayList<>();
    
    
    /**
     * Creates an instance of the Polygon3D class with specified attributes.
     * 
     * The instance will be a regular polygon, centered at the origin in 2D 
     * space, and have the same z-coordinate for all vertices.
     * 
     * @param sides The number of sides the regular polygon will have.
     * @param radius The radius of the largest circle that completely 
     * surrounds the polygon. 
     * @param z The z coordinate of all of the vertices in the polygon.
     */
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
    
    
    /**
     * Creates an instance of the Polygon3D class which models a triangle with
     * specified vertices.
     * 
     * Note that order of point placement can matter when using this 
     * constructor. Other methods of this class expect the vertices of polygons
     * to be listed in a clockwise direction. To ensure this occurs, the vectors
     * representing 3D coordinates should be passed in a clockwise direction.
     * 
     * @param v0 A vector representing the first vertex of the triangle.
     * @param v1 A vector representing the second vertex of the triangle.
     * @param v2 A vector representing the final vertex of the triangle.
     */
    public Polygon3D(Vector v0, Vector v1, Vector v2) {
        this.points.add(v0);
        this.points.add(v1);
        this.points.add(v2);
    }// Polygon3D(List<Vector>)
    
    
    /**
     * Transforms this Polygon3D object to reflect some transformation modeled 
     * by a 4x4 matrix.
     * 
     * Applies the transformation to each vertex in this Polygon3D object and
     * sets each vector to represent a new transformed vertex. Note this will 
     * take into account the z-axis coordinate and can lead to distorted 2D 
     * representations of the polygon.
     * 
     * @param m A 4x4 matrix modeling some transformation.
     */
    public void change(Matrix m) {
        for(Vector point : this.points) {
            Vector newPoint = m.multiply(point);
            point.set(newPoint);
        }// for
    }// change(Matrix)
    
    
    /**
     * Returns a list of 4 element vectors which represent the vertices of this
     * Polygon3D object. 
     * 
     * This list is ordered in a clockwise direction.
     * 
     * @return A list of 4 element vectors representing the vertices of this
     * Polygon3D object. 
     */
    public List<Vector> getPoints() {
        return this.points;
    }// getPoints()
    
    
    /**
     * Creates a 2D shape equivalent of this Polygon3D object.
     * 
     * This allows the polygon to be visually drawn and animated.
     * 
     * @return A Shape object representing this Polygon3D object in 2D space.
     */
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
    
    
    /**
     * Returns a vector that is perpendicular to this Polygon3D object. 
     * 
     * Uses the clockwise direction of the first 3 vertices to calculate so the
     * Polygon3D class expects vertices to be added in a clockwise direction. 
     * 
     * @return A vector that is perpendicular to this polygon.
     */
    public Vector getNormal() {       
        Vector v0 = this.points.get(0);
        Vector v1 = this.points.get(1);
        Vector v2 = this.points.get(2);
        
        Vector normalV = (v2.subtract(v1)).cross(v0.subtract(v1));
        normalV = normalV.normalize();
        
        return normalV;
    }// getNormal()
    
    
}// Polygon3D
