package lambda.works;

public class ImplFunctionExamples {
	// Concatenation between two strings
	TestFunctionalInterface<String> stringAdder = (String s1, String s2) -> s1 + s2;
	
	// Multiplying two numbers
	TestFunctionalInterface<Integer> multipleNumbers = (Integer i1, Integer i2) -> i1 * i2;
	
	// Sum of two cargo's box quantity
	TestFunctionalInterface<CargoWorks> quantityAdder = (CargoWorks c1, CargoWorks c2) -> {
		c1.setBoxQty(c1.getBoxQty() + c2.getBoxQty());
		return c1;
	};
	
	// Comparing box quantity between two cargos
	TestFunctionalInterface<CargoWorks> compareBoxes = (CargoWorks c1, CargoWorks c2) -> {
		if(c1.getBoxQty() > c2.getBoxQty()) {
			return c1;
		} else {
			return c2;
		}
		
	};
	
	// Do something with local method
	TestFunctionalInterface<CargoWorks> otherJobs = (CargoWorks c1, CargoWorks c2) -> thatThingYouDo(c1, c2);
	
	private CargoWorks thatThingYouDo(CargoWorks c1, CargoWorks c2) {
		return new CargoWorks(c1.getBoxQty() - c2.getBoxQty());
	}
	
	@SuppressWarnings("unused")
	private void concatenateStrings(String s1, String s2) {
		System.out.println("Concatenated result : " + stringAdder.doSomething(s1, s2));
	}
	
	@SuppressWarnings("unused")
	private void applyBehavior(TestFunctionalInterface<CargoWorks> applySomething, CargoWorks c1, CargoWorks c2) {
		applySomething.doSomething(c1, c2);
	}
}
