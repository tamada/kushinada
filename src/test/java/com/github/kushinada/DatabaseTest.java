package com.github.kushinada;

import java.sql.Driver;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.apache.commons.dbutils.DbUtils;

import static org.hamcrest.CoreMatchers.*;

public class DatabaseTest{
    @Before
    public void setUp() throws Exception{
        // do nothing.
    }

    @Test
    public void testLoadH2Driver() throws Exception{
        Assert.assertThat(DbUtils.loadDriver("org.h2.Driver"), is(true));
    }

    @Test
    public void testLoadUnknownClass() throws Exception{
        Assert.assertThat(DbUtils.loadDriver("com.microsoft.sqlserver.jdbc.SQLServerDriver"), is(false));
    }
}
