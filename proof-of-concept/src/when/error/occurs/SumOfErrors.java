package when.error.occurs;

public class SumOfErrors {
	public static void main(String[] args) throws Exception{
		MakeError error = new MakeError();
		int loopCount = 1;
		System.out.println("Start Message !");

		while (true) {
			System.out.println("Number of loop count : " + loopCount);
			
			try {
				System.out.println("Unexpected Error");
				error.generateUnexpectedError();
				System.out.println("Before error");
				error.generateNumberFormatException();
				System.out.println("After error");
			} catch (RuntimeException e) {
				e.printStackTrace();
				//error occurs in catch area..
				//error.makeSomeErrors();
				System.out.println("Message in catch area");
			} finally {
				//error occurs in finally area..
				//error.makeSomeErrors();
				System.out.println("Message in finally area");
			}
			
			loopCount++;
			System.out.println("Wait for 3000ms...");
			Thread.sleep(3000);
		}

	}

}
