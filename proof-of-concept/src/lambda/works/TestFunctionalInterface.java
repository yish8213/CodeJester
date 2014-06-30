package lambda.works;

@FunctionalInterface
public interface TestFunctionalInterface<T> {
	public T doSomething(T t1, T t2);
	
}
