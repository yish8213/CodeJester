package lambda.works;

public class ImplFunctions {
	//두 스트링의 연결
	TestFunctionalInterface<String> stringAdder = (String s1, String s2) -> s1 + s2;
	
	//두 수의 곱
	TestFunctionalInterface<Integer> multipleNumbers = (Integer i1, Integer i2) -> i1 * i2;
	
	//두 박스의 합
	TestFunctionalInterface<CargoWorks> quantityAdder = (CargoWorks c1, CargoWorks c2) -> {
		c1.setBoxQty(c1.getBoxQty() + c2.getBoxQty());
		return c1;
	};
	
	//수가 많은 박스
	TestFunctionalInterface<CargoWorks> compareBoxes = (CargoWorks c1, CargoWorks c2) -> {
		if(c1.getBoxQty() > c2.getBoxQty()) {
			return c1;
		} else {
			return c2;
		}
		
	};
	
	//또 다른 박스관련 작업
	TestFunctionalInterface<CargoWorks> otherJobs = (CargoWorks c1, CargoWorks c2) -> thatThingYouDo(c1, c2);
	
	private CargoWorks thatThingYouDo(CargoWorks c1, CargoWorks c2) {
		return new CargoWorks(c1.getBoxQty() - c2.getBoxQty());
	}
	
	@SuppressWarnings("unused")
	private void concatnateStrings(String s1, String s2) {
		System.out.println("Concatenated result : " + stringAdder.doSomething(s1, s2));
	}
	
	@SuppressWarnings("unused")
	private void applyBehavior(TestFunctionalInterface<CargoWorks> applySomething, CargoWorks c1, CargoWorks c2) {
		applySomething.doSomething(c1, c2);
	}
}
