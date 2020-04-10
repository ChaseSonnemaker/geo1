
package org.kickstats.swing;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains instance variables and methods used to construct and visualize
 * prism-like shapes with two main faces.
 * 
 * An abstract class extended to classes that model shapes like antiprisms 
 * and prisms. Contains instance variables which are vectors and lists of 
 * vectors representing the vertices and centers of a prism-like shape. 
 * Also contains an instance variable which is a list of triangular Polygon3D 
 * objects and methods used to transform and draw prism-like shapes.
 * 
 * @author Chase Sonnemaker
 * @version 10 April 2020
 */
public abstract class PolygonTwoFace {
    
    protected List<Vector> shape1Points = new ArrayList<>();
    protected Vector shape1Center;
    protected List<Vector> shape2Points = new ArrayList<>();
    protected Vector shape2Center;
    protected List<Polygon3D> triangles = new ArrayList<>();
    
    
    /**
     * Creates the triangles that make up this prism-like object.
     * 
     * Uses the vertices stored in this prism-like object to construct a list 
     * of triangular Polygon3D objects out of the main and side faces. This 
     * list is then stored in this object. Used to construct the initial 
     * triangle list and to update the stored triangle list based on 
     * transformations made to the vertices of this prism-like object.
     */
    public final void makeTriangles() {
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
        v1 = this.shape2Points.get(length - 1);
        v2 = this.shape1Points.get(0);
        
        triangle = new Polygon3D(v0, v1, v2);
        triangleList.add(triangle);
        
        v0 = this.shape1Points.get(0);
        v1 = this.shape2Points.get(length - 1);
        v2 = this.shape2Points.get(0);
        
        triangle = new Polygon3D(v0, v1, v2);
        triangleList.add(triangle);
        
        for(int i = 0; i < length - 1; i++) {
            v0 = this.shape1Points.get(i);
            v1 = this.shape2Points.get(i);
            v2 = this.shape1Points.get(i + 1);

            triangle = new Polygon3D(v0, v1, v2);
            triangleList.add(triangle);
            
            v0 = this.shape1Points.get(i + 1);
            v1 = this.shape2Points.get(i);
            v2 = this.shape2Points.get(i + 1);
            triangle = new Polygon3D(v0, v1, v2);
            triangleList.add(triangle);
        }// for
        
        this.triangles = triangleList;
    }// makeTriangles()
    
    
    /**
     * Transforms this prism-like object to reflect some 3D transformation 
     * modeled by a 4x4 matrix.
     * 
     * Allows the shape to be moved, scaled, and rotated, updating all of the 
     * stored vector vertices and Polygon3D objects accordingly.
     * 
     * @param m A 4x4 matrix modeling a 3D transformation.
     */
    public void change(Matrix m) {
        
        for(int i = 0; i < this.shape1Points.size(); i++) {
            Vector newV1 = this.shape1Points.get(i);
            Vector newV2 = this.shape2Points.get(i);
            
            newV1 = m.multiply(newV1);
            newV2 = m.multiply(newV2);
            
            this.shape1Points.set(i, newV1);
            this.shape2Points.set(i, newV2);
        }// for
        
        this.shape1Center = m.multiply(this.shape1Center);
        this.shape2Center = m.multiply(this.shape2Center);
        
        this.makeTriangles();
    }// change(Matrix)

    
    /**
     * Orders and returns the list of triangular Polygon3D objects stored in 
     * this object based on the polygon's unit-normal vector's z-coordinate.
     * 
     * Designed to return a list of Polygon3D objects that can then be 
     * converted to shapes and visually represented. Uses a selection sort 
     * algorithm to order the list from smallest unit-normal vector z-coordinate 
     * to largest. This creates an ordering by which the faces should be drawn 
     * to ensure the correct layering for 3D representation of this prism-like
     * shape.
     * 
     * @return A list of triangular Polygon3D objects that make up this 
     * prism-like object and are ordered from the smallest unit-normal vector 
     * z-coordinate to largest.
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
    
    
}// PolygonTwoFace
