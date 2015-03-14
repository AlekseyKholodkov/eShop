package com.kholodkov.dao.exception;

/**
 * Created by Aleksey on 24.02.2015.
 */
public class NoSuchEntityException extends DaoBusinessException {
    public NoSuchEntityException(String message) {
        super(message);
    }

    public NoSuchEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
