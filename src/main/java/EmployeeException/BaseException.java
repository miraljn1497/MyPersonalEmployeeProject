package EmployeeException;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private final String messageKey;
    private final String[] messageParams;

    @Builder
    public BaseException(String messageKey, String messageParams) {
        super(messageKey);
        this.messageKey = messageKey;
        this.messageParams = new String[]{messageParams};
    }

    @Builder
    public BaseException(String messageKey, String[] messageParams) {
        super(messageKey);
        this.messageKey = messageKey;
        this.messageParams = messageParams;
    }
}