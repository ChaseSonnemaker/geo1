
package org.kickstats.swing;

/**
 * Models a prism in 3D space.
 * 
 * Uses a series of vectors which represent vertices and a series of triangular
 * Polygon3D objects for modeling the prism. Extends the PolygonTwoFace class  
 * allowing it to inherit methods designed to facilitate transformation and 
 * visual representation of prism-like 3D shapes. 
 * 
 * @author Chase Sonnemaker 
 * @version 10 April 2020
 */
public class PolygonPrism extends PolygonTwoFace {
    
    /**
     * Creates an instance of the PolygonPrism class with specified attributes.
     * 
     * The prism represented will have main faces that are regular polygons and
     * will be centered at the origin in 3D space.
     * 
     * @param sides The number of sides the each of the main faces should have.
     * @param radius The radius of the smallest circle that can completely 
     * surround each of the main faces.
     * @param height The distance the main faces are from each other (the 
     * height of the rectangular side faces).
     */
    public PolygonPrism(int sides, double radius, double height) {
        
        //Finding shape centers
        double centerX = 0.0;
        double centerY = 0.0;
        
        double shape1Z = height / 2;
        double shape2Z = -height / 2;
        
        this.shape1Center = new Vector(centerX, centerY, shape1Z);
        this.shape2Center = new Vector(centerX, centerY, shape2Z);
        
        
        //Finding point lists
        for(int i = 0; i < sides; i++) {
            double percent = ((double) i) / sides;
            double angle = percent * 2 * Math.PI;
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            
            Vector shape1V = new Vector(x, y, shape1Z);
            Vector shape2V = new Vector(x, y, shape2Z);
            
            this.shape1Points.add(shape1V);
            this.shape2Points.add(shape2V); 
        }// for
        
        
        //Finding triangle list
        this.makeTriangles();
    }// PolygonPrism(int, double, double)
    
    
}// PolygonPrism
