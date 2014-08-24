package lambda.works;

public class TestPreJava8 {
	TestFunctionalInterface<CargoWorks> quantityMerger = new TestFunctionalInterface<CargoWorks>() {
		@Override
		public CargoWorks doSomething(CargoWorks c1, CargoWorks c2) {
			c1.setBoxQty(c1.getBoxQty() + c2.getBoxQty());
			return c1;
		}
		
	};
	
	@SuppressWarnings("unused")
	public void preJava8Method() {
		CargoWorks c1 = new CargoWorks(1000);
		CargoWorks c2 = new CargoWorks(2000);
		
		CargoWorks mergedQunatiy = quantityMerger.doSomething(c1, c2);
	}
}
