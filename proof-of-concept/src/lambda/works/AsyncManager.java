package lambda.works;

public class AsyncManager {
	public void runAsync(Runnable r) {
		new Thread(r).start();
	}
}
