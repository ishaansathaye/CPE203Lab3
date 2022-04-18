import java.awt.Color;
import java.awt.Point;

interface Shape {
    
    Color getColor();
    void setColor(Color color);
    double getArea();
    double getPerimeter();
    void translate(Point p);

}
