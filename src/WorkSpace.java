import java.awt.Point;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

class WorkSpace {

    private List<Shape> shapes;

    public WorkSpace() {
        this.shapes = new ArrayList<Shape>();
    }

    public void add(Shape s) {
        this.shapes.add(s);
    }

    public Shape get(int index) {
        return this.shapes.get(index);
    }

    public int size() {
        return this.shapes.size();
    }

    public List<Circle> getCircles() {
        List<Circle> circleList = new ArrayList<Circle>();
        for (Shape s: this.shapes)  {
            if (s instanceof Circle) {
                circleList.add((Circle) s);
            }
        }
        return circleList;
    }

    public List<Rectangle> getRectangles() {
        List<Rectangle> rectangleList = new ArrayList<Rectangle>();
        for (Shape s: this.shapes)  {
            if (s instanceof Rectangle) {
                rectangleList.add((Rectangle) s);
            }
        }
        return rectangleList;
    }

    public List<Triangle> getTriangles() {
        List<Triangle> triangleList = new ArrayList<Triangle>();
        for (Shape s: this.shapes)  {
            if (s instanceof Triangle) {
                triangleList.add((Triangle) s);
            }
        }
        return triangleList;
    }

    public List<Shape> getShapesByColor(Color c) {
        List<Shape> shapeList = new ArrayList<Shape>();
        for (Shape s: this.shapes)  {
            if (s.getColor() == c) {
                shapeList.add(s);
            }
        }
        return shapeList;
    }

    public double getAreaOfAllShapes() {
        double areaSum = 0;
        for (Shape s: this.shapes)  {
            areaSum += s.getArea();
        }
        return areaSum;
    }

    public double getPerimeterOfAllShapes() {
        double perimeterSum = 0;
        for (Shape s: this.shapes)  {
            perimeterSum += s.getPerimeter();
        }
        return perimeterSum;
    }
    
}
