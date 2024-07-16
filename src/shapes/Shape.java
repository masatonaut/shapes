package shapes;

/**
 * The abstract Shape class represents a generic shape with a specified center.
 * It is designed to be extended by specific shape classes like Circle, Hexagon, etc.
 * @author Masato Ito YUUU2V
 */
public abstract class Shape {
    protected double centerX;
    protected double centerY;

    /**
     * Constructs a generic Shape with the specified center coordinates.
     * @param centerX X-coordinate of the shape's center.
     * @param centerY Y-coordinate of the shape's center.
     */
    public Shape(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Returns the X-coordinate of this shape's center.
     * @return X-coordinate of the center.
     */
    public double getCenterX() {
        return centerX;
    }

    /**
     * Returns the Y-coordinate of this shape's center.
     * @return Y-coordinate of the center.
     */
    public double getCenterY() {
        return centerY;
    }
    
    /**
     * Abstract method to calculate the distance from a given point to the shape.
     * Must be implemented by subclasses.
     * @param pointX X-coordinate of the point.
     * @param pointY Y-coordinate of the point.
     * @return Distance to the shape.
     */
    public abstract double distanceTo(double pointX, double pointY);
}

