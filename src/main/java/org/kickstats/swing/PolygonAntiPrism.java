
package org.kickstats.swing;

/**
 *
 * @author irish
 */
public class PolygonAntiPrism extends PolygonTwoFace {
    
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
