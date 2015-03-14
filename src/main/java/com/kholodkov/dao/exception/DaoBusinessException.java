package com.kholodkov.dao.exception;

/**
 * Created by Aleksey on 24.02.2015.
 */
public class DaoBusinessException extends DaoException {
    public DaoBusinessException(String message) {
        super(message);
    }

    public DaoBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
