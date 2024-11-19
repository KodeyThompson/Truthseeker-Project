package data;

import utils.DatasetSplitter;

import java.util.*;
import weka.classifiers.*;
import weka.classifiers.trees.RandomForest;
import weka.core.*;

public class TrainMLModels {
    public static void trainModel(String inputPath) {
        try {
            // Load dataset
            Instances data = new Instances(new BufferedReader(new FileReader(inputPath)));
            data.setClassIndex(data.numAttributes() - 1); // Set the class attribute
            
            // Split dataset
            DatasetSplitter splitter = new DatasetSplitter();
            splitter.split(data, 0.8); // 80% training, 20% testing
            
            Instances train = splitter.getTrainData();
            Instances test = splitter.getTestData();

            // Train Random Forest
            RandomForest model = new RandomForest();
            model.buildClassifier(train);

            // Evaluate
            Evaluation eval = new Evaluation(train);
            eval.evaluateModel(model, test);

            System.out.println("Model Accuracy: " + eval.pctCorrect());
            System.out.println(eval.toSummaryString());
        } catch (Exception e) {
            System.err.println("Error training model: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        trainModel("data/processed_data.csv");
    }
}