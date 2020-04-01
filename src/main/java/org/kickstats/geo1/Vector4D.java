
package org.kickstats.geo1;

/**
 * Models a 4 element vector.
 * 
 * @author Chase Sonnemaker
 */
public class Vector4D {
    
    private final double p0;
    private final double p1;
    private final double p2;
    private final double p3;
    
    public Vector4D(double p0, double p1, double p2, double p3) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }// Vector4D(double, double, double, double)

    
    /**
     * Returns the value at position 0 in this vector.
     * 
     * @return The value of the first element in this vector.
     */
    public double getP0() {
        return p0;
    }// getP0()

    
    /**
     * Returns the value at position 1 in this vector.
     * 
     * @return The value of the first element in this vector.
     */
    public double getP1() {
        return p1;
    }// getP1()

    
    /**
     * Returns the value at position 2 in this vector.
     * 
     * @return The value of the first element in this vector.
     */
    public double getP2() {
        return p2;
    }// getP2()

    
    /**
     * Returns the value at position 3 in this vector.
     * 
     * @return The value of the first element in this vector.
     */
    public double getP3() {
        return p3;
    }// getP3()
}// Vector4D
