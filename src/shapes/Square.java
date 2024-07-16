package shapes;

/**
 * The Square class represents a square shape with a specified center and side length.
 * It extends the abstract Shape class.
 * @author Masato Ito YUUU2V
 */
public class Square extends Shape {
    private final double sideLength;

    /**
     * Constructs a Square with the specified center coordinates and side length.
     * @param centerX X-coordinate of the square's center.
     * @param centerY Y-coordinate of the square's center.
     * @param sideLength Side length of the square.
     */
    public Square(double centerX, double centerY, double sideLength) {
        super(centerX, centerY);
        this.sideLength = sideLength;
    }

    /**
     * Calculates the distance from a given point to the boundary of this square.
     * @param pointX X-coordinate of the point.
     * @param pointY Y-coordinate of the point.
     * @return Distance to the boundary of the square.
     */
    @Override
    public double distanceTo(double pointX, double pointY) {
        double halfLength = sideLength / 2.0;
        double deltaX = Math.abs(pointX - centerX) - halfLength;
        double deltaY = Math.abs(pointY - centerY) - halfLength;
        double maxDelta = Math.max(deltaX, deltaY);
        return Math.max(0, maxDelta);
    }

    /**
     * Returns a string representation of this square.
     * @return String representation of the square.
     */
    @Override
    public String toString() {
        return "Square with center at (" + getCenterX() + ", " + getCenterY() + ") and side length " + sideLength;
    }
}

