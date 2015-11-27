package com.github.kushinada;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class InitializeServlet extends GenericServlet{
    public InitializeServlet(){
    }

    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);

        KushinadaContext context = new KushinadaContext();

        initTable(context);
    }

    @Override
    public void service(ServletRequest request, ServletResponse response){
    }

    private void initTable(KushinadaContext context){
        DatabaseInitializer dbInitializer = new DatabaseInitializer();
        dbInitializer.init(context);
    }
}
