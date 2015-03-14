package com.kholodkov.dao.exception;

/**
 * Created by Aleksey on 24.02.2015.
 */
public class DaoSystemException extends DaoException {
    public DaoSystemException(String message) {
        super(message);
    }

    public DaoSystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
