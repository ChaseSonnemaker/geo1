# swing
A project for CSC 144 at Cornell College based around 2D and 3D image creation. Much of this code was originally forked from Leon Tabak my professor. This program creates a window that shows an animated rotating shaded 3D shape. The color of the background, color of the shape, type of the 3D shape, number of sides of the main face(s), width of the shape, speed of the rotation, and axis of rotation can all be manipulated using menus in the window. To facilitate this process, several additional classes are defined including a class that models a 4 element Vectors used to represent a 3D vertex, a class that models a 4x4 matrix which is used to model transformations in 3D space, and an abstract class and several classes which model various 3D shapes such as a prism, an antiprism, and a pyramid. Despite me considering this project finished there are still some issues still occurring in this project that I could never quite figure out. For example, the menus are created using HashMaps which allow for more complicated and specified menus; however, as a result, menus that should be ordered by a number are out of order which is not very user friendly. I attempted making a sorting algorithm for these lists but they never worked as intended. Overall, during this project I gained a lot of experience working on larger programs, connecting classes, and working on 3D and 2D modeling.

