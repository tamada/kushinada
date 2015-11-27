package com.github.kushinada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.SQLException;
import javax.sql.DataSource;
import javax.naming.Context;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

public class DatabaseInitializer{
    private static final String INITIALIZE_SQL = "/resources/init.sql";

    public void init(KushinadaContext context){
        if(DbUtils.loadDriver("org.h2.Driver")){
            DataSource ds = context.getDataSource();
            initTable(ds);
        }
    }

    void initTable(DataSource ds){
        QueryRunner runner = new QueryRunner(ds);

        try(BufferedReader in = new BufferedReader(
                new InputStreamReader(getClass().getResource(INITIALIZE_SQL).openStream())
        )){
            String line;
            while((line = in.readLine()) != null){
                line = line.trim();
                if(!line.equals("")){
                    runner.update(line);
                }
            }
        } catch(IOException e){
            e.printStackTrace();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
