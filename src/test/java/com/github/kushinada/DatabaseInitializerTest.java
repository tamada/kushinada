package com.github.kushinada;

import static org.hamcrest.CoreMatchers.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.dbutils.QueryRunner;

public class DatabaseInitializerTest{
    private KushinadaContext context = new KushinadaContext();
    private QueryRunner runner;

    @Before
    public void setUp() throws Exception{
        context.setDatabasePath("jdbc:h2:./kushinada/db");
        runner = new QueryRunner(context.getDataSource());
        DatabaseInitializer initializer = new DatabaseInitializer();
        initializer.initTable(context.getDataSource());
    }

    @Test
    public void testDataSourceAvailability() throws Exception{
        Assert.assertThat(context.getDataSource(), is(notNullValue()));
    }

    @Test
    public void testJarsTable() throws Exception{
        int count = runner.update("INSERT INTO jars (jarid, groupid, artifactid, version, jarname, register_date) VALUES (?, ?, ?, ?, ?, NOW())", 1, "com.github", "stigmata", "5.0", "stigmata-5.0.jar");
        Assert.assertThat(count, is(1));
    }

    @Test
    public void testBirthmarkTable() throws Exception{
        runner.update("INSERT INTO jars (jarid, groupid, artifactid, version, jarname, register_date) VALUES (?, ?, ?, ?, ?, NOW())", 2, "com.github", "stigmata", "5.0", "stigmata-5.0.jar");
        int count = runner.update("INSERT INTO birthmark (birthmarkid, jarid, birthmark_name, class_name, count, birthmark_value) VALUES (?, 2, ?, ?, ?, ?)", 1, "tmp", "com.github.stigmata.BirthmarkEngine", 5, "1, 2, 3, 4, 5");
        Assert.assertThat(count, is(1));
    }

    @After
    public void tearDown() throws Exception{
        runner.update("DELETE birthmark WHERE birthmarkid = 1");
        runner.update("DELETE jars WHERE jarid = 1 OR jarid = 2");
    }
}
