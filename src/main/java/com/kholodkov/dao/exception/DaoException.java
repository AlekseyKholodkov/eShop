package com.kholodkov.dao.exception;

/**
 * Created by Aleksey on 24.02.2015.
 */
public class DaoException extends Exception {
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
