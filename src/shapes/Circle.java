package shapes;

/**
 * The Circle class represents a circle shape with a specified center and radius.
 * It extends the abstract Shape class.
 * @author Masato Ito YUUU2V
 */
public class Circle extends Shape {
    private final double radius;

    /**
     * Constructs a Circle with the specified center coordinates and radius.
     * @param centerX X-coordinate of the circle's center.
     * @param centerY Y-coordinate of the circle's center.
     * @param radius Radius of the circle.
     */
    public Circle(double centerX, double centerY, double radius) {
        super(centerX, centerY);
        this.radius = radius;
    }

    /**
     * Calculates the distance from a given point to the boundary of this circle.
     * If the point is inside the circle, the distance is considered zero.
     * @param pointX X-coordinate of the point.
     * @param pointY Y-coordinate of the point.
     * @return Distance to the boundary of the circle.
     */
    @Override
    public double distanceTo(double pointX, double pointY) {
        double distanceToCenter = Math.sqrt(
                Math.pow(pointX - centerX, 2) +
                Math.pow(pointY - centerY, 2)
        );
        double distanceToBoundary = distanceToCenter - radius;
        return Math.max(0, distanceToBoundary);
    }

    /**
     * Returns a string representation of this circle.
     * @return String representation of the circle.
     */
    @Override
    public String toString() {
        return "Circle with center at (" + getCenterX() + ", " + getCenterY() + ") and radius " + radius;
    }
}

