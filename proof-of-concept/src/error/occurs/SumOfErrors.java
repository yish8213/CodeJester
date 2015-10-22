package error.occurs;

import java.util.Scanner;

public class SumOfErrors {
	public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("1. Normal  2. Unexpected Error  3. Error occurs in the catch area  4. Error occurs in the finally area");
        System.out.print("Enter a number : ");
        int selection = keyboard.nextInt();

        int loopCount = 1;

		while (true) {
			System.out.println("Number of loop count : " + loopCount);

            MakeError error = new MakeError();

			try {
				if (loopCount % 2 == 1) {
					System.out.println("Before error");
					error.generateNumberFormatException();
					System.out.println("After error"); // never running this line
				} else if (loopCount == 2 && selection == 2) {
					System.out.println("Unexpected Error");
					error.generateUnexpectedError(); // Move to finally area and running codes then exit the process when meet this line
				}

			} catch (RuntimeException e) { // Can not catch the InterruptedException. It because InterruptedException is not subclass of the RuntimeException
				if (selection == 3) { //error occurs in catch area..
                    error.makeErrorsInCatchArea(); // Move to finally area and running codes then exit the process when meet this line
                }

                System.out.println("Message in the catch area : " + e.getMessage());

			} finally {
				if (selection == 4) { //error occurs in finally area..
                    error.makeErrorsInFinallyArea(); // Exit the process when meet this line
                }

                System.out.println("Message in the finally area");

			}

			loopCount++;
			System.out.println("Wait for 2000ms...");
            System.out.println("==================");

            if (loopCount == 5) {
                break;
            }

			Thread.sleep(2000);
		}

	}

}