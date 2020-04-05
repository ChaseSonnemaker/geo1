
package org.kickstats.swing;

/**
 * Models a 4 element vector.
 * 
 * Designed to model a vector in 3D space. As a result nearly all of these
 * methods ignore the fourth element in the vector and assume the resulting 
 * value to be 1. Not recommended to use this class if math needs to be done 
 * with all 4 elements in the vector.
 * 
 * @author Chase Sonnemaker
 * @version 5 April 2020
 */
public class Vector {
    
    private double x;
    private double y;
    private double z;
    private double h;
    
    /**
     * Creates a 4 element vector where each element is equal to 0.
     */
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.h = 0;
    }// Vector()
    
    
    /**
     * Creates a 4 element vector with specified x, y, and z elements 
     * representing a vector in 3D space.
     * 
     * Designed to model a position in 3D space so the final fourth element 
     * representing the homogeneous coordinate is set to 1. 
     * 
     * @param x An x-axis coordinate in 3D space.
     * @param y A y-axis coordinate in 3D space.
     * @param z A z-axis coordinate in 3D space.
     */
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = 1;
    }// Vector(double, double, double)
    
    /**
     * Creates a 4 element vector where each element is specified.
     * 
     * This can be used to model a position in 3D space.
     * 
     * @param x The first element in the vector. Models the x-axis coordinate
     * when modeling 3D space.
     * @param y The second element in the vector. Models the y-axis coordinate 
     * when modeling 3D space.
     * @param z The third element in the vector. Models the z-axis coordinate
     * when modeling 3D space.
     * @param h The final element in the vector. Models the homogeneous 
     * coordinate when modeling 3D space.
     */
    public Vector(double x, double y, double z, double h) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.h = h;
    }// Vector(double, double, double, double)

    
    /**
     * Returns the value at a specified position in this vector.
     * 
     * Will return an exception if given an index that does not 
     * exist in this vector.
     * 
     * @param position An integer from 0 to 3 representing the position of the 
     * value in this vector.
     * @return The value of the element at the specified 
     * position in this vector.
     */
    public double get(int position) {
        if(position < 0 || position > 3) {
            throw new ArrayIndexOutOfBoundsException("Position " + position 
                                                    + " does not exist");                                            
        }// if
        switch(position) {
            case 0:
                return this.x;
            case 1:
                return this.y;
            case 2:
                return this.z;
        }// switch
        return this.h;
    } // get(int)

    
     /**
     * Changes the value at a specified position in this vector.
     * 
     * Will return an exception if given an index that does not 
     * exist in this vector.
     * 
     * @param position An integer from 0 to 3 representing the position of the 
     * change in this vector.
     * @param value The new number that the position will be changed to.
     */
    public void set(int position, double value) {
        if(position < 0 || position > 3) {
            throw new ArrayIndexOutOfBoundsException("Position " + position 
                                                    + " does not exist");                                            
        }// if
        switch(position) {
            case 0:
                this.x = value;
            case 1:
                this.y = value;
            case 2:
                this.z = value;
            case 3:
                this.h = value;
        }// switch
    }// set(int, double)
    
    
    /**
     * Returns a string representation of this vector.
     * 
     * @return A string representation of this vector.
     */
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " 
                + this.z + ", " + this.h + ")";
    }// toString()
    
    
    /**
     * Adds the x, y, and z positions of this vector and 
     * another vector of 4 elements together.
     * 
     * @param v A vector of 4 elements to be added to this vector.
     * @return A vector of 4 elements that is the sum of the other two vectors 
     * at the x, y and z positions. The homogeneous coordinate position is 
     * set equal to 1.
     */
    public Vector add(Vector v) {
        double sumX = this.x + v.x;
        double sumY = this.y + v.y;
        double sumZ = this.z + v.z;
        return new Vector(sumX, sumY, sumZ);
    }// add(Vector)
    
    
    /**
     * Subtracts the x, y, and z positions of this vector and
     * another vector 4 elements. 
     * 
     * @param v A vector of 4 elements to be subtracted from this vector.
     * @return A vector of 4 elements that is the difference of the other
     * two vectors at the x, y, and z positions. The homogeneous coordinate
     * position is set to 1.
     */
    public Vector subtract(Vector v) {
        double diffX = this.x - v.x;
        double diffY = this.y = v.y;
        double diffZ = this.z - v.z;
        return new Vector(diffX, diffY, diffZ);
    }// subtract(Vector)
    
    
    /**
     * Dot multiplies the x, y, and z positions in this vector 
     * with the x, y, and z positions of another vector of 4 elements.
     * 
     * @param v A vector of 4 elements to be multiplied with this vector.
     * @return A number that is the product of the dot multiplication of the 
     * x, y, and z positions other two vectors.
     */
    public double dot(Vector v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }// dot(Vector v)
    
    
    /**
     * Returns the magnitude of this vector using the x, y, and z positions.
     * 
     * @return The magnitude of this vector using the x, y, and z positions.
     */
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }// magnitude()
    
    
    /**
     * Normalizes this vector such that it has the same direction but has
     * a magnitude (length) equal to 1 according to the x, y, and z positions.
     * 
     * @return A new vector with the same direction as this vector but a
     * magnitude equal to 1 according to the x, y, and z positions. The 
     * homogeneous coordinate position is set to 1.
     */
    public Vector normalize() {
        double magnitude = this.magnitude();
        Vector newV = new Vector();
        for(int i = 0; i < 3; i++) {
            double newValue = this.get(i) / magnitude;
            newV.set(i, newValue);
        }// for
        newV.set(3, 1);
        return newV;
    }// normalize()
    
    
    /**
     * Creates a 4 element vector that is the result of a cross multiplication
     * between this vector and another 4 element vector.
     * 
     * This cross multiplication and the resulting vector finds vectors in 3D
     * space that is perpendicular to both this vector and another 4 element 
     * vector under the right-hand rule. As such, the final element in the 
     * vector representing the homogeneous coordinate will be ignored and 
     * assumed to be equal to 1.
     * 
     * @param v Another 4 element vector which is to be cross multiplied with 
     * this 4 element vector.
     * @return A 4 element vector that represents a vector in 3D space that 
     * is perpendicular to the other two vectors. Due to the right-hand rule, 
     * the returned vector with the positional x, y, and z elements 
     * multiplied by -1 would also be perpendicular.
     */
    public Vector cross(Vector v) {
        double newX = this.y * v.z - this.z * v.y;
        double newY = this.z * v.x - this.x * v.z;
        double newZ = this.x * v.y - this.y * v.x;
        return new Vector(newX, newY, newZ);
    }// cross()
    
}// Vector
