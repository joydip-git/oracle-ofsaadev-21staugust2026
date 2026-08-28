//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Calculation class DOESN'T implement the interface
        //1. non-static member
        CalculationInvoker addInvoker = new Calculation()::add;
        //2. static member
        CalculationInvoker subtractInvoker = Calculation::subtract;

        //AnotherCalculation DOES implement the interface
        CalculationInvoker multiplyInvoker = new AnotherCalculation();

        //No class created explicitly. Implicitly an anonymous class will
        //be created implementing the interface method
        CalculationInvoker divideInvoker = new CalculationInvoker() {
            @Override
            public int invoke(int a, int b) {
                return a / b;
            }
        };

        //Lambda Function/Expression: No class created explicitly.
        // Implicitly an anonymous class will be created implementing
        // the interface method
        CalculationInvoker remainderInvoker = (a, b) -> a % b;

        call(addInvoker);
        call(subtractInvoker);
        call(multiplyInvoker);
        call(divideInvoker);
        call(remainderInvoker);
    }

    static void call(CalculationInvoker invoker) {
        System.out.println(invoker.invoke(12, 3));
    }
}