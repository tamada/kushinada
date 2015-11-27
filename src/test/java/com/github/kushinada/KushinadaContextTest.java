package com.github.kushinada;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KushinadaContextTest{
    private KushinadaContext context;

    @Before
    public void setUp() throws Exception{
        context = new KushinadaContext();
    }

    @Test
    public void testDatabasePath(){
        Assert.assertThat(context.getDatabasePath(), is("jdbc:h2:tcp://localhost/./kushinada/db"));
    }

    @Test
    public void testDatabasePathSetterAndGetter(){
        context.setDatabasePath("jdbc:h2:./hoge");
        Assert.assertThat(context.getDatabasePath(), is("jdbc:h2:./hoge"));
    }
}
