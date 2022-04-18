import java.awt.Color;
import java.awt.Point;

public class Triangle implements Shape {
    
    private Point a;
    private Point b;
    private Point c;
    private Color color;

    public Triangle(Point a, Point b, Point c, Color color) {

        this.a = a;
        this.b = b;
        this.c = c;
        this.color = color;

    }

    public Point getVertexA() {
        return this.a;
    }

    public Point getVertexB() {
        return this.b;
    }

    public Point getVertexC() {
        return this.c;
    }

    public boolean equals(Object o) {
        
        if (o == null) {
            return false;
        }
        else if (o.getClass() != this.getClass()) {
            return false;
        }
        else {
            Triangle other = (Triangle) o;
            return this.a.equals(other.a) &&
            this.b.equals(other.b) &&
            this.c.equals(other.c) &&
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
        double a = Math.sqrt(Math.pow(this.a.getX() - this.b.getX(), 2) + Math.pow(this.a.getY() - this.b.getY(), 2));
        double b = Math.sqrt(Math.pow(this.b.getX() - this.c.getX(), 2) + Math.pow(this.b.getY() - this.c.getY(), 2));
        double c = Math.sqrt(Math.pow(this.c.getX() - this.a.getX(), 2) + Math.pow(this.c.getY() - this.a.getY(), 2));
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double getPerimeter() {
        double a = Math.sqrt(Math.pow(this.a.getX() - this.b.getX(), 2) + Math.pow(this.a.getY() - this.b.getY(), 2));
        double b = Math.sqrt(Math.pow(this.b.getX() - this.c.getX(), 2) + Math.pow(this.b.getY() - this.c.getY(), 2));
        double c = Math.sqrt(Math.pow(this.c.getX() - this.a.getX(), 2) + Math.pow(this.c.getY() - this.a.getY(), 2));
        return a + b + c;
    }

    public void translate(Point p) {
        int new_a_x = (int) (this.a.getX() + p.getX());
        int new_a_y = (int) (this.a.getY() + p.getY());
        this.a = new Point(new_a_x, new_a_y);

        int new_b_x = (int) (this.b.getX() + p.getX());
        int new_b_y = (int) (this.b.getY() + p.getY());
        this.b = new Point(new_b_x, new_b_y);

        int new_c_x = (int) (this.c.getX() + p.getX());
        int new_c_y = (int) (this.c.getY() + p.getY());
        this.c = new Point(new_c_x, new_c_y);
    }

}
