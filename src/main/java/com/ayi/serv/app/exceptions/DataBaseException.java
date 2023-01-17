package com.ayi.serv.app.exceptions;

import java.sql.SQLException;

public class DataBaseException extends SQLException {
    public DataBaseException(String reason) {
        super(reason);
    }
}
