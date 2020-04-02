
package org.kickstats.geo1;

/**
 * Models a 4 element vector.
 * 
 * @author Chase Sonnemaker
 */
public class Vector4D {
    
    private double p0;
    private double p1;
    private double p2;
    private double p3;
    
    
    public Vector4D() {
        this.p0 = 0;
        this.p1 = 0;
        this.p2 = 0;
        this.p3 = 0;
    }// Vector4D()
    
    
    public Vector4D(double x, double y, double z) {
        this.p0 = x;
        this.p1 = y;
        this.p2 = z;
        this.p3 = 1;
    }// Vector4D(double, double, double)
    
    
    public Vector4D(double p0, double p1, double p2, double p3) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }// Vector4D(double, double, double, double)

    
    /**
     * Returns the value at a specified position in this vector.
     * 
     * @param position An integer from 0 to 3 representing the position of the 
     * value in this vector.
     * @return The value of the first element in this vector.
     */
    public double get(int position) {
        if(position < 0 || position > 3) {
            throw new ArithmeticException("Position " + position 
                                            + " does not exist");                                            
        }// if
        switch(position) {
            case 0:
                return this.p0;
            case 1:
                return this.p1;
            case 2:
                return this.p2;
        }// switch
        return this.p3;
    } // get(int)

    
     /**
     * Changes the value at a specified position in this vector.
     * 
     * @param position An integer from 0 to 3 representing the position of the 
     * change in this vector.
     * @param value The new number that the position will be changed to.
     */
    public void set(int position, double value) {
        if(position < 0 || position > 3) {
            throw new ArithmeticException("Position " + position 
                                                + " does not exist");                                            
        }// if
        switch(position) {
            case 0:
                this.p0 = value;
            case 1:
                this.p1 = value;
            case 2:
                this.p2 = value;
            case 3:
                this.p3 = value;
        }// switch
    }// set(int, double)
    
    
    /**
     * Returns a string representation of this vector.
     * 
     * @return A string representation of this vector.
     */
    @Override
    public String toString() {
        return "(" + this.p0 + ", " + this.p1 + ", " 
                + this.p2 + ", " + this.p3 + ")";
    }// toString()
    
    
    /**
     * Adds this vector and another vector of 4 elements together.
     * 
     * @param v A vector of 4 elements to be added to this vector.
     * @return A vector of 4 elements that is the sum of the other two vectors.
     */
    public Vector4D add(Vector4D v) {
        double sum0 = this.p0 + v.p0;
        double sum1 = this.p1 + v.p1;
        double sum2 = this.p2 + v.p2;
        double sum3 = this.p3 + v.p3;
        
        return new Vector4D(sum0, sum1, sum2, sum3);
    }// add(Vector4D)
    
    
    /**
     * Dot multiplies this vector with another vector of 4 elements.
     * 
     * @param v A vector of 4 elements to be multiplied with this vector.
     * @return A number that is the product of the dot multiplication of the 
     * other two vectors.
     */
    public double dot(Vector4D v) {
        return this.p0 * v.p0 + this.p1 * v.p1 + 
                this.p2 * v.p2 + this.p3 * v.p3;
    }// dot(Vector4D v)
    
    
    /**
     * Returns the magnitude of this vector.
     * 
     * @return The magnitude of this vector.
     */
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }// magnitude()
    
    
}// Vector4D
