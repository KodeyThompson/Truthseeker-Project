package data;

import utils.MetricsUtils;
import weka.classifiers.Evaluation;
import weka.core.Instances;

public class EvaluateModels {
    public static void evaluateModel(Evaluation eval, String outputPath) {
        MetricsUtils.saveMetrics(eval, outputPath);
    }

    public static void main(String[] args) {
        // Placeholder for evaluation
        System.out.println("Model evaluation not yet implemented.");
    }
}