
package org.kickstats.swing;

import java.util.ArrayList;
import java.util.List;

/**
 * Models a pyramid in 3D space.
 * 
 * Uses a series of vectors which represent vertices, vectors representing 
 * the center and capstone vertices, and a series of triangular Polygon3D 
 * objects for modeling the pyramid. Contains methods designed to facilitate 
 * transformation and visual representation of the pyramid.
 * 
 * @author Chase Sonnemaker 
 * @version 10 April 2020
 */
public class PolygonPyramid {
    
    private List<Vector> shapePoints = new ArrayList<>();
    private Vector shapeCenter;
    private Vector pyramidPoint;
    private List<Polygon3D> triangles = new ArrayList<>();
    
    /**
     * Creates an instance of the PolygonPyramid class with 
     * specified attributes.
     * 
     * The pyramid represented will have a main face that is a regular polygon
     * and will be centered at the origin in 3D space. If given a high enough 
     * number of sides, this can also be used to model a cone in 3D space.
     * While very similar to a prism-like object, pyramids require different
     * instance variables and method bodies to model. Meaning this class must 
     * be separate from the PolygonTwoFace abstract class.
     * 
     * @param sides The number of sides the main face should have.
     * @param radius The radius of the smallest circle that completely 
     * surrounds the main face.
     * @param height The distance the main face is from the capstone of the 
     * pyramid (the perpendicular height of the triangular side faces).
     */
    public PolygonPyramid(int sides, double radius, double height) {
        
        //Finding shape centers
        double centerX = 0.0;
        double centerY = 0.0;
        
        double shapeZ = height / 2;
        double pyramidPointZ = -height / 2;
        
        this.shapeCenter = new Vector(centerX, centerY, shapeZ);
        this.pyramidPoint = new Vector(centerX, centerY, pyramidPointZ);
        
        
        //Finding point lists
        for(int i = 0; i < sides; i++) {
            double percent = ((double) i) / sides;
            double angle = percent * 2 * Math.PI;
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            
            Vector shape1V = new Vector(x, y, shapeZ);
            
            this.shapePoints.add(shape1V);
        }// for
        
        
        //Finding triangle list
        this.makeTriangles();
    }// PolygonPrism(int, double)
    
    /**
     * Creates the triangles that make up this PolygonPyramid object.
     * 
     * Uses the vertices stored in this PolygonPrism object to construct a list 
     * of triangular Polygon3D objects out of the main and side faces. This 
     * list is then stored in this PolygonPyramid object. Used to 
     * construct the initial triangle list and to update the stored triangle 
     * list based on transformations made to the vertices of this pyramid.
     */
    public void makeTriangles() {
        List<Polygon3D> triangleList = new ArrayList<>();
        
        //Creating shape triangles
        int length = this.shapePoints.size();
        
        Vector v0 = this.shapeCenter;
        Vector v1 = this.shapePoints.get(length - 1);
        Vector v2 = this.shapePoints.get(0);

        Polygon3D triangle = new Polygon3D(v0, v1, v2);
        triangleList.add(triangle);
        
        for(int i = 0; i < length - 1; i++) {
            v1 = this.shapePoints.get(i);
            v2 = this.shapePoints.get(i + 1);
            
            triangle = new Polygon3D(v0, v1, v2);
            triangleList.add(triangle);
        } // for
        
        
        //Creating side triangles
        v0 = this.shapePoints.get(length - 1);
        v1 = this.pyramidPoint;
        v2 = this.shapePoints.get(0);
        
        triangle = new Polygon3D(v0, v1, v2);
        triangleList.add(triangle);

        for(int i = 0; i < length - 1; i++) {
            v0 = this.shapePoints.get(i);
            v1 = this.pyramidPoint;
            v2 = this.shapePoints.get(i + 1);

            triangle = new Polygon3D(v0, v1, v2);
            triangleList.add(triangle);
        }// for
        
        this.triangles = triangleList;
    }// makeTriangles()
    
    /**
     * Transforms this PolygonPyramid object to reflect some 3D transformation 
     * modeled by a 4x4 matrix.
     * 
     * Allows the pyramid to be moved, scaled, and rotated, updating all of the 
     * stored vector vertices and Polygon3D objects accordingly.
     * 
     * @param m A 4x4 matrix modeling a 3D transformation.
     */
    public void change(Matrix m) {
        
        for(int i = 0; i < this.shapePoints.size(); i++) {
            Vector newV = this.shapePoints.get(i);
            
            newV = m.multiply(newV);
            
            this.shapePoints.set(i, newV);
        }// for
        
        this.shapeCenter = m.multiply(this.shapeCenter);
        this.pyramidPoint = m.multiply(this.pyramidPoint);
        this.makeTriangles();
    }// change(Matrix)

    
    /**
     * Orders and returns the list of triangular Polygon3D objects stored in 
     * this object based on each triangle's unit-normal vector's z-coordinate.
     * 
     * Designed to return a list of Polygon3D objects stored in this object 
     * that can then be converted to shapes and visually represented. 
     * Uses a selection sort algorithm to order the list from smallest 
     * unit-normal vector z-coordinate to largest. This creates an ordering 
     * by which the faces should be drawn to ensure the correct layering for 
     * 3D representation of this prism-like shape.
     * 
     * @return A list of triangular Polygon3D objects that make up this pyramid
     * and are ordered from the smallest unit-normal vector z-coordinate to 
     * largest.
     */
    public List<Polygon3D> getOrderedShapes() {
        List<Polygon3D> shapeList = this.triangles;
        int length = shapeList.size();
        
        for(int i = 0; i < length; i++) {
            int smallestIndex = i;
            
            for(int j = i + 1; j < length; j++) {
                Vector smallestNorm = shapeList.get(smallestIndex).getNormal();
                Vector currentNorm = shapeList.get(j).getNormal();
                
                double smallestZ = smallestNorm.get(2);
                double currentZ = currentNorm.get(2);
                
                
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
