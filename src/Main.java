public class Main {
    public static void main(String[] args) {
        Network network = new Network(9, 3, 1);

        double[][] inputValues = {
                {-1},
                {0},
                {-1},
                {-1},
                {1},
                {1},
                {0},
                {1},
                {0},
        };

        Matrix input = new Matrix(inputValues);

        network.randomizeWeights();
        Matrix[] weights = network.getWeights();

        Matrix z2 = Matrix.multiply(input, weights[0]);
        Matrix a2 = sigmoid(z2);
        Matrix z3 = Matrix.multiply(a2, weights[1]);
        Matrix out = sigmoid(z3);

        System.out.println(out.getValues()[0][0]);
    }

    private static double sigmoid(double z) {
        return 1/(1+Math.exp(-z));
    }

    private static Matrix sigmoid(Matrix z) {
        double[][] values = z.getValues();

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[0].length; j++) {
                values[i][j] = 1/(1+Math.exp(-values[i][j]));
            }
        }

        return new Matrix(values);
    }
}
