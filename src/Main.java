import com.sun.javaws.exceptions.InvalidArgumentException;

public class Main {
    // http://habrahabr.ru/post/198268/
    public static void main(String[] args) throws InvalidArgumentException {
        final int inSize = 11;
        final int innerSize = 20;
        final int outSize = 10;
        // внешняя сеть
        final Neiro neiroIn = new Neiro(inSize, innerSize) {
            @Override
            public double activationFunction(double x) {
                return 1.0 / (1 + Math.exp(-x));
            }
        };
        // выходная сеть
        final Neiro neiroOut = new Neiro(innerSize, outSize);

        final int[] numbers = {0, 9};

        // начинаем обучение
        final double[] arrIn = new double[inSize];
        final double[] arrOut = new double[outSize];

        for (int steps = 0; steps < 1000; steps++) {
            for (int i : numbers) {
                nullArray(arrOut);
                fillNumber(i, arrIn);
                arrOut[i] = 1;
                double[] res = neiroIn.activate(arrIn);
                double[] res2 = neiroOut.activate(res);
                double[] diff = Neiro.makeSubtract(arrOut, res2);
                // теперь нам надо провести обучение на основе diff
                //todo: отсюда
            }
        }


        /*
        for (int step : numbers) {
            fillNumber(step, arrIn);
            System.out.print("Step is " + step + ":");
            double[] res = neiro.activate(arrIn);
            for (int i = 0; i < res.length; i++) {
                if (res[i] != 0) {
                    System.out.print(" " + i);
                }
            }
            System.out.println();
        }
        */
    }

    private static void nullArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    private static void nullArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
    }

    private static void fillNumber(final int number, final double[] arrIn) {
        switch (number) {
            case 0:
                fillZero(arrIn);
                break;
            case 1:
                fillOne(arrIn);
                break;
            case 2:
                fillTwo(arrIn);
                break;
            case 3:
                fillTree(arrIn);
                break;
            case 4:
                fillFour(arrIn);
                break;
            case 5:
                fillFive(arrIn);
                break;
            case 6:
                fillSix(arrIn);
                break;
            case 7:
                fillTheven(arrIn);
                break;
            case 8:
                fillEight(arrIn);
                break;
            case 9:
                fillNine(arrIn);
                break;
        }
    }

    private static void fillOne(final double[] in) {
        nullArray(in);
        in[1] = 1;
        in[6] = 1;
        in[9] = 1;
    }

    private static void fillTwo(final double[] in) {
        nullArray(in);
        in[0] = 1;
        in[1] = 1;
        in[5] = 1;
        in[10] = 1;
    }

    private static void fillTree(final double[] in) {
        nullArray(in);
        in[0] = 1;
        in[3] = 1;
        in[9] = 1;
        in[10] = 1;
    }

    private static void fillFour(final double[] in) {
        nullArray(in);
        in[1] = 1;
        in[2] = 1;
        in[3] = 1;
        in[6] = 1;
    }

    private static void fillFive(final double[] in) {
        nullArray(in);
        in[0] = 1;
        in[2] = 1;
        in[3] = 1;
        in[5] = 1;
        in[6] = 1;
    }

    private static void fillSix(final double[] in) {
        nullArray(in);
        in[3] = 1;
        in[4] = 1;
        in[5] = 1;
        in[6] = 1;
        in[9] = 1;
    }

    private static void fillTheven(final double[] in) {
        nullArray(in);
        in[0] = 1;
        in[4] = 1;
        in[9] = 1;
    }

    private static void fillEight(final double[] in) {
        nullArray(in);
        in[0] = 1;
        in[1] = 1;
        in[2] = 1;
        in[3] = 1;
        in[4] = 1;
        in[5] = 1;
        in[6] = 1;
    }

    private static void fillNine(final double[] in) {
        nullArray(in);
        in[0] = 1;
        in[1] = 1;
        in[2] = 1;
        in[3] = 1;
        in[5] = 1;
        in[6] = 1;
    }

    private static void fillZero(final double[] in) {
        nullArray(in);
        in[0] = 1;
        in[1] = 1;
        in[2] = 1;
        in[4] = 1;
        in[5] = 1;
        in[6] = 1;
    }
}
