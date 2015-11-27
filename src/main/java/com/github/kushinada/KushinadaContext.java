package com.github.kushinada;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;

public class KushinadaContext{
    private String databasePath = "jdbc:h2:tcp://localhost/./kushinada/db";
    private DataSource ds;
    private boolean autoCloseDatabase = false;

    public KushinadaContext(){
    }

    public DataSource getDataSource(){
        if(ds == null){
            JdbcDataSource jdbcDS = new JdbcDataSource();
            jdbcDS.setURL(getDatabasePath());
            jdbcDS.setUser("sa");
            jdbcDS.setPassword("sa");

            this.ds = jdbcDS;
        }
            
        return ds;
    }

    public void setDatabasePath(String databasePath){
        this.databasePath = databasePath;
    }

    public String getDatabasePath(){
        return databasePath;
    }
}
