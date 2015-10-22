package error.occurs;

public class MakeError {
	public void makeErrorsInCatchArea() throws RuntimeException {
		throw new RuntimeException("Exception in Catch area");
	}

	public void makeErrorsInFinallyArea() throws RuntimeException {
		throw new RuntimeException("Exception in Finally area");
	}

	public void generateNumberFormatException() throws NumberFormatException {
		throw new NumberFormatException("NumberFormatException in subroutine");
	}

	public void generateUnexpectedError() throws InterruptedException {
		throw new InterruptedException("Unexpected exception in subroutine");
	}
}
