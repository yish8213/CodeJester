package lambda.works;

public class TestAsyncFunctions {
    private AsyncManager manager = new AsyncManager();

    // Concatenating between two strings
    TestFunctionalInterface<String> stringAdder = (String s1, String s2) -> s1 + s2;

    // multiplying two numbers
    TestFunctionalInterface<Integer> multiplyNumbers = (Integer i1, Integer i2) -> i1 * i2;

    // sum of two cargo's box quantity
    TestFunctionalInterface<CargoWorks> quantityAdder = (CargoWorks c1, CargoWorks c2) -> {
        c1.setBoxQty(c1.getBoxQty() + c2.getBoxQty());
        return c1;
    };

    private void takeResults() {
        CargoWorks cargoNoOne = new CargoWorks(1000);
        CargoWorks cargoNoTwo = new CargoWorks(2000);

        manager.runAsync(() -> System.out.println("Running in Async mode"));
        manager.runAsync(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("just counting : " + i);
            }
        });
        manager.runAsync(() -> System.out.println("String : " + stringAdder.doSomething("A", "b")));
        manager.runAsync(() -> System.out.println("Number : " + multiplyNumbers.doSomething(1, 2)));
        manager.runAsync(() -> System.out.println("Qty : " + quantityAdder.doSomething(cargoNoOne, cargoNoTwo).getBoxQty()));

    }

    public static void main(String[] args) throws Exception {
        new TestAsyncFunctions().takeResults();
    }
}
