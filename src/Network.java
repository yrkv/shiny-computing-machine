/**
 * Created by yegor on 12/12/16.
 */
public class Network {
    private int inputLayerSize;
    private int outputLayerSize;
    private int hiddenLayerSize;

    private Matrix[] weights = new Matrix[2];

    public Network(int inputLayerSize, int hiddenLayerSize, int outputLayerSize) {
        this.inputLayerSize = inputLayerSize;
        this.outputLayerSize = outputLayerSize;
        this.hiddenLayerSize = hiddenLayerSize;

        weights[0] = new Matrix(new double[2][3]);
        weights[1] = new Matrix(new double[3][1]);
    }

    public void forward() {

    }

    public Matrix[] getWeights() {
        return weights;
    }

    public void randomizeWeights() {
        for (int i = 0; i < weights.length; i++) {
            double[][] values = new double[weights[i].getHeight()][weights[i].getWidth()];

            for (int j = 0; j < values.length; j++) {
                for (int k = 0; k < values[0].length; k++) {
                    values[j][k] = Math.random() * 2 - 1;
                }
            }
            weights[i] = new Matrix(values);
        }
    }
}
