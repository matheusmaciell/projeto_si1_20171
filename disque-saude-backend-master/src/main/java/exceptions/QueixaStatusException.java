package exceptions;

public class QueixaStatusException extends Exception {

	public QueixaStatusException(String msg) {
		super("Falha ao alterar status: "+msg);
	}
}
