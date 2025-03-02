package EmployeeException;

public class EmployeeException extends BaseException {

    public EmployeeException(String messageKey, String messageParams) {
        super(messageKey, messageParams);
    }

    public EmployeeException(String messageKey, String[] messageParams) {
        super(messageKey, messageParams);
    }