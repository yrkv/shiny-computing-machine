public class Main {
    public static void main(String[] args) {
        Network network = new Network(new int[]{9, 3, 1});
        network.randomizeWeights();

        double[][] inputValues = {
                {-1, 0, -1, -1, 1, 1, 0, 1, 0}
        };

        Matrix input = new Matrix(inputValues);

        Matrix out = network.forward(input);

        System.out.println(out.getValues()[0][0]);
    }

    private void train() {
        Trainer trainer = new Trainer();
    }
}
