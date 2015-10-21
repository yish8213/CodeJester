package lambda.works;

@FunctionalInterface
public interface TestFunctionalInterface<T> {
	T doSomething(T t1, T t2);
	
}
