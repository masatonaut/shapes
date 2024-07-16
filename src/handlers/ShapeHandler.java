package handlers;

import java.util.*;

import shapes.Shape;

/**
 * The ShapeHandler class provides functionalities to handle a collection of shapes,
 * calculate the distance from each shape to a specified point, and identify the shape(s) 
 * that are the closest to that point.
 *
 * @author Masato Ito YUUU2V
 */
public class ShapeHandler {
    
    private final Collection<Shape> shapes;
    private final Map<Shape, Double> distanceMap;

    /**
     * Constructs a ShapeHandler with a given collection of shapes.
     * Initializes an empty map to store the distances from a reference point to each shape.
     *
     * @param shapes Collection of shapes to handle.
     */
    public ShapeHandler(Collection<Shape> shapes) {
        this.shapes = shapes;
        this.distanceMap = new HashMap<>();
    }

    /**
     * Calculates the distance from each shape in the collection to the specified point
     * and stores these distances in the distanceMap.
     *
     * @param pointX X-coordinate of the reference point.
     * @param pointY Y-coordinate of the reference point.
     */
    public void calculateDistances(double pointX, double pointY) {
        for (Shape shape : shapes) {
            double distance = shape.distanceTo(pointX, pointY);
            distanceMap.put(shape, distance);
        }
    }

    /**
     * Identifies the shape(s) in the collection with the shortest distance to the reference point.
     * If multiple shapes have the same shortest distance, they are all included in the result.
     *
     * @return List containing the closest shape(s) to the reference point.
     */
    public List<Shape> findClosestShapes() {
        List<Shape> closestShapes = new ArrayList<>();
        double minDistance = Collections.min(distanceMap.values());

        for (Map.Entry<Shape, Double> entry : distanceMap.entrySet()) {
            if (entry.getValue().equals(minDistance)) {
                closestShapes.add(entry.getKey());
            }
        }
        return closestShapes;
    }
}
