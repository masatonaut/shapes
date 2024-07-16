package shapes;

/**
 * The Hexagon class represents a hexagonal shape with a specified center and side length.
 * It extends the abstract Shape class.
 * @author Masato Ito YUUU2V
 */
public class Hexagon extends Shape {
    private final double sideLength;

    /**
     * Constructs a Hexagon with the specified center coordinates and side length.
     * @param centerX X-coordinate of the hexagon's center.
     * @param centerY Y-coordinate of the hexagon's center.
     * @param sideLength Side length of the hexagon.
     */
    public Hexagon(double centerX, double centerY, double sideLength) {
        super(centerX, centerY);
        this.sideLength = sideLength;
    }

    /**
     * Calculates the distance from a given point to the closest side of this hexagon.
     * @param pointX X-coordinate of the point.
     * @param pointY Y-coordinate of the point.
     * @return Distance to the hexagon.
     */
    @Override
    public double distanceTo(double pointX, double pointY) {
        // Calculating the distance from a point to the closest side of the hexagon.
        double dx = Math.abs(pointX - centerX);
        double dy = Math.abs(pointY - centerY);
        
        double distance = sideLength - Math.max(dx, dy + (dx / 2.0));
        
        if(dy > (Math.sqrt(3) / 2.0) * sideLength){
            distance = -distance;
        }
        return distance;
    }

    /**
     * Returns a string representation of this hexagon.
     * @return String representation of the hexagon.
     */
    @Override
    public String toString() {
        return "Hexagon with center at (" + getCenterX() + ", " + getCenterY() + ") and side length " + sideLength;
    }
}

