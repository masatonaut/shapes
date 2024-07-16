package app;

import handlers.ShapeHandler;
import handlers.ShapeLoader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import shapes.Shape;

/**
 * The Main class serves as the entry point for the application. 
 * It provides functionalities to read multiple test files, 
 * load shapes from each file, ask the user for a specific point, 
 * and then determine and display which shape(s) are closest to the provided point.
 *
 * @author Masato Ito YUUU2V
 */
public class Main {

    /**
     * The main method to execute the application.
     * 
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] testFiles = {"normal.txt", "edge_cases.txt", "extreme_values.txt", "missing_data.txt", "invalid_type.txt"};
            
            for(String testFile : testFiles) {
                System.out.println("Loading shapes from: " + testFile); 
                
                // Initialize a new ShapeLoader for each file
                ShapeLoader shapeLoader = new ShapeLoader();
                try {
                    // Load the shapes from the file
                    shapeLoader.loadShapesFromFile("testfiles/" + testFile);
                    
                    // Get a point from the user
                    System.out.print("Enter the X coordinate of the point: ");
                    double pointX = scanner.nextDouble();
                    System.out.print("Enter the Y coordinate of the point: ");
                    double pointY = scanner.nextDouble();
                    
                    // Create a ShapeHandler and calculate distances from the point to all shapes
                    ShapeHandler handler = new ShapeHandler(shapeLoader.getShapes());
                    handler.calculateDistances(pointX, pointY);
                    
                    // Find and print the closest shapes
                    List<Shape> closestShapes = handler.findClosestShapes();
                    System.out.println("The closest shape(s) to the point (" + pointX + ", " + pointY + ") are:");
                    for (Shape shape : closestShapes) {
                        System.out.println(shape);
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
                System.out.println("----------------------------");
            }
        }
    }
}
