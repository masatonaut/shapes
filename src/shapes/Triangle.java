package shapes;

/**
 * The Triangle class represents a regular triangle shape with a specified center and side length.
 * It extends the abstract Shape class.
 * @author Masato Ito YUUU2V
 */
public class Triangle extends Shape {
    private final double sideLength;

    /**
     * Constructs a Triangle with the specified center coordinates and side length.
     * @param centerX X-coordinate of the triangle's center.
     * @param centerY Y-coordinate of the triangle's center.
     * @param sideLength Side length of the triangle.
     */
    public Triangle(double centerX, double centerY, double sideLength) {
        super(centerX, centerY);
        this.sideLength = sideLength;
    }

    /**
     * Calculates the distance from a given point to the base of this triangle.
     * @param pointX X-coordinate of the point.
     * @param pointY Y-coordinate of the point.
     * @return Distance to the base of the triangle.
     */
    @Override
    public double distanceTo(double pointX, double pointY) {
        double baseY = centerY - (Math.sqrt(3) / 6 * sideLength);  // Base's Y-coordinate
        double distance = Math.abs(pointY - baseY);
        return distance;
    }

    /**
     * Returns a string representation of this triangle.
     * @return String representation of the triangle.
     */
   @Override
    public String toString() {
        return "Triangle with center at (" + getCenterX() + ", " + getCenterY() + ") and side length " + sideLength;
    }
}

