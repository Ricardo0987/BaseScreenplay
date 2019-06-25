package co.com.project.scp.exceptions;

import net.serenitybdd.core.exceptions.SerenityManagedException;

public class MyBusinessException extends SerenityManagedException {

	public MyBusinessException(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }

    public MyBusinessException(ExceptionMessages message) {
        super(new Error(message.getMensaje()));
    }

}
