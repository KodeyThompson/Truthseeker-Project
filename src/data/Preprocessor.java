package data;

import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

public class Preprocessor {
    public static void preprocessData(String inputPath, String outputPath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(inputPath));
            List<String> processedLines = lines.stream()
                .map(line -> line.replaceAll("missing_value", "0")) // Example: Replace missing values
                .collect(Collectors.toList());
            
            Files.write(Paths.get(outputPath), processedLines);
            System.out.println("Processed data saved to " + outputPath);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        preprocessData("data/Features_For_Traditional_ML_Techniques.csv", "data/processed_data.csv");
    }
}