public class AnotherCalculation implements CalculationInvoker {
    @Override
    public int invoke(int a, int b) {
        return a * b;
    }
}
