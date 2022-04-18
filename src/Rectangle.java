import java.awt.Color;
import java.awt.Point;

class Rectangle implements Shape {
    
    private double width;
    private double height;
    private Point topLeft;
    private Color color;

    public Rectangle(double width, double height, Point topLeft, Color color) {
        this.width = width;
        this.height = height;
        this.topLeft = topLeft;
        this.color = color;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Point getTopLeft() {
        return this.topLeft;
    }

    public boolean equals(Object o) {

        if (o == null) {
            return false;
        }
        else if (o.getClass() != this.getClass()) {
            return false;
        }
        else {
            Rectangle other = (Rectangle) o;
            return this.width == other.width &&
            this.height == other.height &&
            this.topLeft.equals(other.topLeft) &&
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
        return this.width * this.height;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    public void translate(Point p) {
        int new_x = (int) (this.topLeft.getX() + p.getX());
        int new_y = (int) (this.topLeft.getY() + p.getY());
        this.topLeft = new Point(new_x, new_y);
    }

}
