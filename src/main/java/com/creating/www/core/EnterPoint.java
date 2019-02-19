package com.creating.www.core;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.creating.www.config.DispatcherConfig;
import com.creating.www.config.RootConfig;

public class EnterPoint implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigApplicationContext rootCtx=new AnnotationConfigApplicationContext();
		rootCtx.register(RootConfig.class);
		rootCtx.refresh();
		AnnotationConfigWebApplicationContext dispatcherCtx=new AnnotationConfigWebApplicationContext();
		dispatcherCtx.register(DispatcherConfig.class);
		ServletRegistration.Dynamic dispatcher=servletContext.addServlet("dispatcher",new DispatcherServlet(dispatcherCtx));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/app/*");
		dispatcherCtx.refresh();
		/**
		java.util.Properties props=System.getProperties();
		for(Map.Entry<Object,Object> entry:props.entrySet()) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}
		*/
		
	}

}
