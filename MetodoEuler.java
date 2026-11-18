public class MetodoEuler {

    // EDO: y' = x - y
    public static double evaluarFuncion(double x, double y) {
        return x - y;
    }

    // Solución analítica exacta: y(x) = 2*e^(-x) + x - 1
    public static double solucionExacta(double x) {
        return 2.0 * Math.exp(-x) + x - 1.0;
    }

    public static void main(String[] args) {
        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1; // Variar este valor en el reporte (ej. 0.1, 0.05, 0.01)
        double xFinal = 0.3;

        // Criterio de paro (numero total de pasos N)
        int nPasos = (int) Math.round((xFinal - x0) / h);
        double x = x0;
        double y = y0;

        System.out.println("n\t x_n\t y_n (Euler)\t y_exacta\t Error Abs");
        System.out.println("------------------------------------------------------------");

        double yExacta = solucionExacta(x);
        double errorAbs = Math.abs(yExacta - y);
        System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.6f\n", 0, x, y, yExacta, errorAbs);

        for (int i = 0; i < nPasos; i++) {
            double pendiente = evaluarFuncion(x, y);
            y = y + h * pendiente;
            x = x + h;

            yExacta = solucionExacta(x);
            errorAbs = Math.abs(yExacta - y);

            System.out.printf("%d\t %.4f\t %.6f\t %.6f\t %.6f\n", (i + 1), x, y, yExacta, errorAbs);
        }
    }
}
