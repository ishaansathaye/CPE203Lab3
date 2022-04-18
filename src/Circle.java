import java.awt.Color;
import java.awt.Point;

public class Circle implements Shape {

    private double radius;
    private Point center;
    private Color color;

    public Circle(double radius, Point center, Color color) {
        this.radius = radius;
        this.center = center;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return this.center;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        else if (o.getClass() != this.getClass()) {
            return false;
        }
        else {
            Circle other = (Circle) o;
            return this.radius == other.radius && 
            this.center.equals(other.center) && 
            this.color.equals(other.color);
        }
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * (Math.pow(this.radius, 2));
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    public void translate(Point p) {
        int new_x = (int) (this.center.getX() + p.getX());
        int new_y = (int) (this.center.getY() + p.getY());
        this.center = new Point(new_x, new_y);
    }
    
}
