class Main {
    public static void main(String[] args) {
        updateSet();
    }
    public static void updateSet() {
        double minXval = -2.0;
        double maxXval = 2.0; 
        double minYval = -2.0;
        double maxYval = 2.0;
        String cR = "\u001b[31m[ ]";
        String cG = "\u001b[32m[ ]";
        String cB = "\u001b[30m[ ]";
		
        int maxIterations = 1000;
        int width = 200;
        int height = 200;
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                double a = map(x, 0, width, minXval, maxXval);
                double b = map(y, 0, height, minYval, maxYval);
                double ca = a;
                double cb = b;
                int iteration = 0;
                while (iteration < maxIterations) {
                    double aResult = a * a - b* b;
                    double bResult = 2 * a * b;
                    a = aResult + ca;
                    b = bResult + cb;
                    if (a * a + b * b > 8) {
                        break;
                    }
                    iteration++;
                }
                if (iteration > 0.9 * maxIterations) {
                        System.out.print(cB);
                } else if (iteration < 0.01 * maxIterations) {
                        System.out.print(cR);
                } else {
                        System.out.print(cG);
                }
            }
            System.out.format("%n");
        }
    }
    public static double map(int x, double in_min, double in_max, double out_min, double out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }
}
