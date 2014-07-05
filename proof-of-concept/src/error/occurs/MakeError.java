package error.occurs;

public class MakeError {
	public void makeSomeErrors() throws RuntimeException {
		throw new RuntimeException("Exception in subroutine");

	}

	public void generateNumberFormatException() throws NumberFormatException {
		throw new NumberFormatException("NumberFormatException in subroutine");

	}

	public void generateUnexpectedError() throws RuntimeException {
		MakeUnexpectedError makeUnexpectedError = new MakeUnexpectedError();
		makeUnexpectedError.unexpectedError();

	}
}
