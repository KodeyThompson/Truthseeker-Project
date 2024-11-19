package utils;

import weka.core.Instances;

public class DatasetSplitter {
    private Instances trainData;
    private Instances testData;

    public void split(Instances data, double trainRatio) throws Exception {
        int trainSize = (int) Math.round(data.numInstances() * trainRatio);
        int testSize = data.numInstances() - trainSize;
        trainData = new Instances(data, 0, trainSize);
        testData = new Instances(data, trainSize, testSize);
    }

    public Instances getTrainData() {
        return trainData;
    }

    public Instances getTestData() {
        return testData;
    }
}