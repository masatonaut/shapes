package handlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import shapes.*;

/**
 * The ShapeLoader class provides functionalities to load shapes from a file.
 * Each shape in the file is defined by its type, center coordinates, and either a side length or radius.
 *
 * @author Masato Ito YUUU2V
 */
public class ShapeLoader {
    
    private final Collection<Shape> shapes;

    /**
     * Default constructor that initializes an empty collection of shapes.
     */
    public ShapeLoader() {
        this.shapes = new ArrayList<>();
    }

    /**
     * Loads shapes from a specified file into the shapes collection.
     *
     * @param filename The path to the file containing the shape data.
     * @throws IOException if there's an issue reading the file, if the file is empty, if shape data is missing, 
     * or if invalid shape data is found.
     */
    public void loadShapesFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (line == null) {
                throw new IOException("File is empty");
            }
            int numberOfShapes = Integer.parseInt(line.trim());

            for (int i = 0; i < numberOfShapes; i++) {
                line = reader.readLine();
                if (line != null) {
                    createShapeFromLine(line);
                } else {
                    throw new IOException("Shape data is missing");
                }
            }
        } catch (IOException | NumberFormatException e) {
            throw new IOException("Error loading shapes: " + e.getMessage());
        }
    }

    /**
     * Parses a line from the input file to create and add a shape object to the shapes collection.
     *
     * @param line A string containing the data for a shape.
     * @throws IOException if the shape data is invalid, if insufficient parameters for shape data are found, 
     * or if an unknown shape type is encountered.
     */
    private void createShapeFromLine(String line) throws IOException {
        String[] parts = line.split("\\s+");
        if (parts.length < 4) {
            throw new IOException("Invalid shape data: Insufficient parameters.");
        }

        char type = parts[0].charAt(0);
        double centerX, centerY, size;

        try {
            centerX = Double.parseDouble(parts[1]);
            centerY = Double.parseDouble(parts[2]);
            size = Double.parseDouble(parts[3]);
        } catch (NumberFormatException e) {
            throw new IOException("Invalid numeric data encountered in shape creation.");
        }

        Shape shape;
        switch (type) {
            case 'C' -> shape = new Circle(centerX, centerY, size);
            case 'T' -> shape = new Triangle(centerX, centerY, size);
            case 'S' -> shape = new Square(centerX, centerY, size);
            case 'H' -> shape = new Hexagon(centerX, centerY, size);
            default -> throw new IOException("Unknown shape type: " + type);
        }

        shapes.add(shape);
    }

    /**
     * Returns the collection of loaded shapes.
     *
     * @return Collection of shapes.
     */
    public Collection<Shape> getShapes() {
        return shapes;
    }
}
