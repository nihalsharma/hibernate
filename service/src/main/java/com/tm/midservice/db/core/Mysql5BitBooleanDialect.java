package com.tm.midservice.db.core;

import org.hibernate.dialect.MySQL5Dialect;

import java.sql.Types;

/**
 * Created by Nihal on 9/11/14.
 */
public class Mysql5BitBooleanDialect extends MySQL5Dialect {
    public Mysql5BitBooleanDialect() {
        super();
        registerColumnType( Types.BOOLEAN, "bit" );
    }
}