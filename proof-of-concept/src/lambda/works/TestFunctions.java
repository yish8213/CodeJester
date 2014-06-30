package lambda.works;

public class TestFunctions {
	private AsyncManager manager = new AsyncManager();

	//두 스트링의 연결
	TestFunctionalInterface<String> stringAdder = (String s1, String s2) -> s1 + s2;
		
	//두 수의 곱
	TestFunctionalInterface<Integer> multipleNumbers = (Integer i1, Integer i2) -> i1 * i2;
	
	//두 박스의 합
	TestFunctionalInterface<CargoWorks> quantityAdder = (CargoWorks c1, CargoWorks c2) -> {
		c1.setBoxQty(c1.getBoxQty() + c2.getBoxQty());
		return c1;
	};
	
	private void takeResults() {
		CargoWorks cargoNoOne = new CargoWorks(1000);
		CargoWorks cargoNoTwo = new CargoWorks(2000);
		
		manager.runAsync(() -> System.out.println("Running in Async mode"));
		manager.runAsync(() -> {
			for(int i = 0; i < 100; i++) {
				System.out.println("just counting : " + i);
			}
		});
		manager.runAsync(() -> System.out.println("String : " + stringAdder.doSomething("A", "b")));
		manager.runAsync(() -> System.out.println("Number : " + multipleNumbers.doSomething(1, 2)));
		manager.runAsync(() -> System.out.println("Qty : " + quantityAdder.doSomething(cargoNoOne, cargoNoTwo).getBoxQty()));

	}
	
	public static void main(String[] args) throws Exception {
		new TestFunctions().takeResults();
	}
}
