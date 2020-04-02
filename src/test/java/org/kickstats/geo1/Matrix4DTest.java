
package org.kickstats.geo1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the methods of the Matrix4D class.
 * 
 * @author Chase Sonnemaker
 */
public class Matrix4DTest {
    
    public Matrix4DTest() {
    }

    /**
     * Test of get method, of class Matrix4D.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int row = 0;
        int column = 0;
        Matrix4D instance = new Matrix4D();
        double expResult = 1.0;
        double result = instance.get(row, column);
        assertEquals(expResult, result, 1E-8);
    }

//    /**
//     * Test of toString method, of class Matrix4D.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Matrix4D instance = new Matrix4D();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of identity method, of class Matrix4D.
     */
    @Test
    public void testIdentity() {
        System.out.println("identity");
        Matrix4D instance = new Matrix4D();
        instance.identity();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    assertEquals(instance.get(i, j), 1);
                }// if
                else {
                    assertEquals(instance.get(i, j), 0);
                }// else
            }// for
        }// for
    }

    /**
     * Test of multiply method, of class Matrix4D.
     */
    @Test
    public void testMultiply_Matrix4D() {
        System.out.println("multiply");
        Matrix4D m = new Matrix4D();
        m.set(1, 1, 1);
        m.set(2, 2, 2);
        m.set(3, 3, 3);
        m.set(4, 4, 4);
        Matrix4D instance = new Matrix4D();
        instance.set(1, 1, 1);
        instance.set(2, 2, 2);
        instance.set(3, 3, 3);
        instance.set(4, 4, 4);
        Matrix4D expResult = new Matrix4D();
        expResult.set(1, 1, 1);
        expResult.set(2, 2, 4);
        expResult.set(3, 3, 9);
        expResult.set(4, 4, 16);
        Matrix4D result = instance.multiply(m);
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(result.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }

    /**
     * Test of multiply method, of class Matrix4D.
     */
    @Test
    public void testMultiply_Vector4D() {
        System.out.println("multiply");
        Vector4D v = new Vector4D(4, 3, 2, 1);
        Matrix4D instance = new Matrix4D();
        instance.set(1, 1, 1);
        instance.set(2, 2, 2);
        instance.set(3, 3, 3);
        instance.set(4, 4, 4);
        Vector4D expResult = new Vector4D(4, 6, 6, 4);
        Vector4D result = instance.multiply(v);
        assertEquals(expResult.getP0(), result.getP0(), 1E-8);
        assertEquals(expResult.getP1(), result.getP1(), 1E-8);
        assertEquals(expResult.getP2(), result.getP2(), 1E-8);
        assertEquals(expResult.getP3(), result.getP3(), 1E-8);
    }

    /**
     * Test of translate method, of class Matrix4D.
     */
    @Test
    public void testTranslate() {
        System.out.println("translate");
        double x = 2.0;
        double y = 4.0;
        double z = 6.0;
        Matrix4D instance = new Matrix4D();
        instance.translate(x, y, z);
        Matrix4D expResult = new Matrix4D();
        expResult.set(0, 3, 2);
        expResult.set(1, 3, 4);
        expResult.set(2, 3, 6);
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }

    /**
     * Test of rotateX method, of class Matrix4D.
     */
    @Test
    public void testRotateX() {
        System.out.println("rotateX");
        double angle = Math.PI;
        Matrix4D instance = new Matrix4D();
        instance.rotateX(angle);
        Matrix4D expResult = new Matrix4D();
        expResult.set(1, 1, Math.cos(Math.PI));
        expResult.set(1, 2, -Math.sin(Math.PI));
        expResult.set(2, 1, Math.sin(Math.PI));
        expResult.set(2, 2, Math.cos(Math.PI));
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }

    /**
     * Test of rotateY method, of class Matrix4D.
     */
    @Test
    public void testRotateY() {
        System.out.println("rotateY");
        double angle = 0.0;
        Matrix4D instance = new Matrix4D();
        instance.rotateY(angle);
        Matrix4D expResult = new Matrix4D();
        expResult.set(0, 0, Math.cos(Math.PI));
        expResult.set(0, 2, Math.sin(Math.PI));
        expResult.set(2, 0, -Math.sin(Math.PI));
        expResult.set(2, 2, Math.cos(Math.PI));
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(instance.get(i, j), expResult.get(i, j), 1E-8);
            }// for
        }// for
    }

    /**
     * Test of rotateZ method, of class Matrix4D.
     */
    @Test
    public void testRotateZ() {
        System.out.println("rotateZ");
        double angle = 0.0;
        Matrix4D instance = new Matrix4D();
        instance.rotateZ(angle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scale method, of class Matrix4D.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        Matrix4D instance = new Matrix4D();
        instance.scale(x, y, z);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
