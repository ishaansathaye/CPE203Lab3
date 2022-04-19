import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import java.awt.Color;
import java.awt.Point;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class TestCases
{
   public static final double DELTA = 0.00001;

   /* some sample tests but you must write more! see lab write up */

   // Testing Circle
   @Test
   public void testCircleGetArea()
   {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);

      assertEquals(101.2839543, c.getArea(), DELTA);
   }

   @Test
   public void testCircleGetPerimeter()
   {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);

      assertEquals(35.6759261, c.getPerimeter(), DELTA);
   }

   @Test
   public void testCircleTranslate() {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);
      c.translate(new Point(1, 1));
      assertEquals(new Point(3, 4), c.getCenter());
   }

   @Test
   public void testCircleEquals() {
      Circle c1 = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Circle c2 = new Circle(5.678, new Point(2, 4), Color.BLACK);
      assertFalse(c1.equals(c2));
      Circle c3 = null;
      assertFalse(c1.equals(c3));
      Rectangle r = new Rectangle(5.678, 101.28, new Point(2, 3), Color.BLACK);
      assertFalse(c2.equals(r));
      Circle c4 = new Circle(5.678, new Point(2, 3), Color.BLUE);
      assertFalse(c1.equals(c4));
   }

   @Test
   public void testCircleSetters() {
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);
      c.setRadius(1.0);
      assertEquals(1.0, c.getRadius(), DELTA);

      c.setColor(Color.BLUE);
      assertEquals(Color.BLUE, c.getColor());
   }

   // Testing Rectangle
   @Test
   public void testRectangleGetArea()
   {
      Rectangle r = new Rectangle(5.678, 101.28, new Point(2, 3), Color.BLACK);

      assertEquals(5.678 * 101.28, r.getArea(), DELTA);
   }

   @Test
   public void testRectangleGetPerimeter()
   {
      Rectangle r = new Rectangle(5.678, 101.28, new Point(2, 3), Color.BLACK);

      assertEquals(2 * (5.678 + 101.28), r.getPerimeter(), DELTA);
   }

   @Test
   public void testRectangleTranslate() {
      Rectangle r = new Rectangle(5.678, 101.28, new Point(2, 3), Color.BLACK);
      r.translate(new Point(1, 1));
      assertEquals(new Point(3, 4), r.getTopLeft());
   }

   @Test
   public void testRectangleEquals() {
      Rectangle r1 = new Rectangle(5.678, 101.28, new Point(2, 3), Color.BLACK);
      Rectangle r2 = new Rectangle(5.678, 101.28, new Point(2, 4), Color.BLACK);
      assertFalse(r1.equals(r2));
      Rectangle r3 = null;
      assertFalse(r1.equals(r3));
      Circle c = new Circle(5.678, new Point(2, 3), Color.BLACK);
      assertFalse(r1.equals(c));
      Rectangle r4 = new Rectangle(5.678, 101.28, new Point(2, 3), Color.BLUE);
      assertFalse(r1.equals(r4));
   }

   @Test
   public void testRectangleSetters() {
      Rectangle r = new Rectangle(5.678, 101.28, new Point(2, 3), Color.BLACK);
      r.setWidth(1.0);
      assertEquals(1.0, r.getWidth(), DELTA);
      r.setHeight(1.0);
      assertEquals(1.0, r.getHeight(), DELTA);
      r.setColor(Color.RED);
      assertEquals(Color.RED, r.getColor());
   }

   // Testing Triangle
   @Test
   public void testTriangleGetArea() {
      Triangle t1 = new Triangle(new Point(1, 2), new Point(4, 5), new Point(9, 6), Color.BLACK);
      assertEquals(6.0, t1.getArea(), DELTA);
   }

   @Test
   public void testTriangleGetPerimeter() {
      Triangle t1 = new Triangle(new Point(1, 2), new Point(4, 5), new Point(9, 6), Color.BLACK);
      assertEquals(18.28593, t1.getPerimeter(), DELTA);
   }

   @Test
   public void testTriangleTranslate() {
      Triangle t = new Triangle(new Point(1, 2), new Point(4, 5), new Point(9, 6), Color.BLACK);
      t.translate(new Point(1, 1));
      assertEquals(new Point(2, 3), t.getVertexA());
      assertEquals(new Point(5, 6), t.getVertexB());
      assertEquals(new Point(10, 7), t.getVertexC());
   }

   @Test
   public void testTriangleEquals() {
      Triangle t1 = new Triangle(new Point(1, 2), new Point(4, 5), new Point(9, 6), Color.BLACK);
      Triangle t2 = new Triangle(new Point(1, 2), new Point(4, 5), new Point(9, 6), Color.BLACK);
      assertTrue(t1.equals(t2));
      Triangle t3 = null;
      assertFalse(t1.equals(t3));
      Rectangle r = new Rectangle(5.678, 101.28, new Point(2, 3), Color.BLACK);
      assertFalse(t1.equals(r));
      Triangle t4 = new Triangle(new Point(1, 2), new Point(4, 5), new Point(9, 6), Color.BLUE);
      assertFalse(t1.equals(t4));
   }

   @Test
   public void testTriangleSetters() {
      Triangle t = new Triangle(new Point(1, 2), new Point(4, 5), new Point(9, 6), Color.BLACK);
      t.setColor(Color.CYAN);
      assertEquals(Color.CYAN, t.getColor());
   }

   // Testing Workspace
   @Test
   public void testWorkspaceGetShapes() {
      WorkSpace w = new WorkSpace();

      Rectangle r1 = new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK);
      Circle c1 = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Triangle t1 = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0), 
      Color.BLACK);

      w.add(r1);
      w.add(c1);
      w.add(t1);

      assertEquals(c1, w.get(1));
      assertNotEquals(t1, w.get(0));
   }

   @Test
   public void testWorkSpaceAreaOfAllShapes()
   {
      WorkSpace ws = new WorkSpace();

      ws.add(new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK));
      ws.add(new Circle(5.678, new Point(2, 3), Color.BLACK));
      ws.add(new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0), 
                 Color.BLACK));

      assertEquals(114.2906063, ws.getAreaOfAllShapes(), DELTA);
   }

   @Test
   public void testWorkSpacePerimeterOfAllShapes() {
      WorkSpace ws = new WorkSpace();

      Rectangle r1 = new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK);
      Circle c1 = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Triangle t1 = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0), 
      Color.BLACK);

      ws.add(r1);
      ws.add(c1);
      ws.add(t1);
      
      double expectedPerimeter = r1.getPerimeter() + c1.getPerimeter() + t1.getPerimeter();
      
      assertEquals(expectedPerimeter, ws.getPerimeterOfAllShapes(), DELTA);
   }

   @Test
   public void testGetShapesByColor() {
      List<Shape> expected = new ArrayList<>();

      WorkSpace ws = new WorkSpace();

      Rectangle r1 = new Rectangle(1.234, 5.678, new Point(2, 3), Color.CYAN);
      Circle c1 = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Triangle t1 = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
      Color.CYAN);

      ws.add(r1);
      ws.add(c1);
      ws.add(t1);

      expected.add(r1);
      expected.add(t1);

      assertEquals(expected, ws.getShapesByColor(Color.CYAN));
   }

   @Test
   public void testWorkSpaceGetCircles()
   {
      WorkSpace ws = new WorkSpace();
      List<Circle> expected = new LinkedList<>();

      // Have to make sure the same objects go into the WorkSpace as
      // into the expected List since we haven't overriden equals in Circle.
      Circle c1 = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Circle c2 = new Circle(1.11, new Point(-5, -3), Color.RED);

      ws.add(new Rectangle(1.234, 5.678, new Point(2, 3), Color.BLACK));
      ws.add(c1);
      ws.add(new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
                 Color.BLACK));
      ws.add(c2);

      expected.add(c1);
      expected.add(c2);

      // Doesn't matter if the "type" of lists are different (e.g Linked vs
      // Array).  List equals only looks at the objects in the List.
      assertEquals(expected, ws.getCircles());
   }

   @Test
   public void testWorkSpaceGetRectangles() {
      WorkSpace ws = new WorkSpace();
      List<Rectangle> expected = new ArrayList<>();

      Rectangle r1 = new Rectangle(1.234, 5.678, new Point(2, 3), Color.CYAN);
      Circle c1 = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Triangle t1 = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
      Color.CYAN);
      Rectangle r2 = new Rectangle(20.39342, 10.678, new Point(6, 9), Color.RED);

      ws.add(r1);
      ws.add(c1);
      ws.add(t1);
      ws.add(r2);

      expected.add(r1);
      expected.add(r2);

      assertEquals(expected, ws.getRectangles());

   }

   // Write getTriangles()
   @Test
   public void testWorkSpaceGetTriangles() {
      WorkSpace ws = new WorkSpace();
      List<Triangle> expected = new ArrayList<>();

      Rectangle r1 = new Rectangle(1.234, 5.678, new Point(2, 3), Color.CYAN);
      Circle c1 = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Triangle t1 = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
      Color.CYAN);
      Rectangle r2 = new Rectangle(20.39342, 10.678, new Point(6, 9), Color.RED);
      Triangle t2 = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0), Color.RED);

      ws.add(r1);
      ws.add(c1);
      ws.add(t1);
      ws.add(r2);
      ws.add(t2);

      expected.add(t1);
      expected.add(t2);

      assertEquals(expected, ws.getTriangles());

   }

   // Write size()
   @Test
   public void testWorkSpaceSize() {
      WorkSpace ws = new WorkSpace();

      Rectangle r1 = new Rectangle(1.234, 5.678, new Point(2, 3), Color.CYAN);
      Circle c1 = new Circle(5.678, new Point(2, 3), Color.BLACK);
      Triangle t1 = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0),
      Color.CYAN);
      Rectangle r2 = new Rectangle(20.39342, 10.678, new Point(6, 9), Color.RED);
      Triangle t2 = new Triangle(new Point(0,0), new Point(2,-4), new Point(3, 0), Color.RED);

      ws.add(r1);
      ws.add(c1);
      ws.add(t1);
      ws.add(r2);
      ws.add(t2);

      assertEquals(5, ws.size());
   
   }
      

   /* HINT - comment out implementation tests for the classes that you have not 
    * yet implemented */
   @Test
   public void testCircleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getRadius", "setRadius", "getCenter", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         double.class, void.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[] {double.class}, new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Circle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testRectangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getWidth", "setWidth", "getHeight", "setHeight", "getTopLeft", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         double.class, void.class, double.class, void.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[] {double.class}, new Class[0], new Class[] {double.class}, 
         new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Rectangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   @Test
   public void testTriangleImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getColor", "setColor", "getArea", "getPerimeter", "translate",
         "getVertexA", "getVertexB", "getVertexC", "equals");

      final List<Class> expectedMethodReturns = Arrays.asList(
         Color.class, void.class, double.class, double.class, void.class,
         Point.class, Point.class, Point.class, boolean.class);

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0], new Class[] {Color.class}, new Class[0], new Class[0], new Class[] {Point.class},
         new Class[0], new Class[0], new Class[0], new Class[] {Object.class});

      verifyImplSpecifics(Triangle.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals("Unexpected number of public fields",
         0, clazz.getFields().length);

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertEquals("Unexpected number of public methods",
         expectedMethodNames.size(), publicMethods.size());

      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodReturns.size());
      assertTrue("Invalid test configuration",
         expectedMethodNames.size() == expectedMethodParameters.size());

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }
}
