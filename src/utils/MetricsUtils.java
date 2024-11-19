package utils;

import weka.classifiers.Evaluation;

import java.io.FileWriter;
import java.io.IOException;

public class MetricsUtils {
    public static void saveMetrics(Evaluation eval, String outputPath) {
        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write("Accuracy: " + eval.pctCorrect() + "%\n");
            writer.write(eval.toSummaryString());
            System.out.println("Metrics saved to " + outputPath);
        } catch (IOException e) {
            System.err.println("Error saving metrics: " + e.getMessage());
        }
    }
}