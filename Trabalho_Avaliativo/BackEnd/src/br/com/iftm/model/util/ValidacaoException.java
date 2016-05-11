package br.com.iftm.model.util;

public class ValidacaoException extends Exception {

	private static final long serialVersionUID = 7173221020055669263L;

	public ValidacaoException() {
		super();
	}

	public ValidacaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValidacaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidacaoException(String message) {
		super(message);
	}

	public ValidacaoException(Throwable cause) {
		super(cause);
	}

}
