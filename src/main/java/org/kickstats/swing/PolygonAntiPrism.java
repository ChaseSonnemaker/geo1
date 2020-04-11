
package org.kickstats.swing;

/**
 * Models an antiprism in 3D space.
 * 
 * Uses a series of vectors which represent vertices and a series of triangular
 * Polygon3D objects for modeling the antiprism. Extends the PolygonTwoFace 
 * class allowing it to inherit methods designed to facilitate 
 * transformation and visual representation of prism-like 3D shapes. More
 * information about antiprisms can be found 
 * <a href="https://math.wikia.org/wiki/Antiprism">here</a>.
 * 
 * @author Chase Sonnemaker
 * @version 10 April 2020
 */
public class PolygonAntiPrism extends PolygonTwoFace {
    
    /**
     * Creates an instance of the PolygonAnitPrism class with specified
     * attributes.
     * 
     * The antiprism represented will have main faces that are regular 
     * polygons. The second face will be turned <code>180 / sides</code> 
     * degrees to make the side triangles of the antiprism equally sized. 
     * The antiprism will also be centered at the origin in 3D space. 
     * 
     * 
     * @param sides The number of sides in each of the mains faces 
     * of the antiprism.
     * @param radius The radius of the smallest circle that can completely 
     * surround each of the main faces.
     * @param height The distance the main faces are from each other (the 
     * perpendicular height of the side triangle faces).
     */
    public PolygonAntiPrism(int sides, double radius, double height) {
        
        //Finding shape centers
        double centerX = 0.0;
        double centerY = 0.0;
        
        double shape1Z = height / 2;
        double shape2Z = -height / 2;
        
        this.shape1Center = new Vector(centerX, centerY, shape1Z);
        this.shape2Center = new Vector(centerX, centerY, shape2Z);
        
        
        //Shape 2 rotation
        double shape2Rotation = Math.PI / sides;
        Matrix m = new Matrix();
        m.rotateZ(shape2Rotation);
        
        
        //Finding point lists
        for(int i = 0; i < sides; i++) {
            double percent = ((double) i) / sides;
            double angle = percent * 2 * Math.PI;
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            
            Vector shape1V = new Vector(x, y, shape1Z);
            
            Vector shape2V = new Vector(x, y, shape2Z);
            shape2V = m.multiply(shape2V);
            
            this.shape1Points.add(shape1V);
            this.shape2Points.add(shape2V); 
        }// for
        
        
        //Finding triangle list
        this.makeTriangles(); 
    }// PolygonAntiPrism(int, double, double)
    

}// PolygonAnitPrism
