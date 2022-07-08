package com.flyaway.launcher;

import java.io.File;
import java.util.Optional;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class Main {

//	public static final Optional<String> port = Optional.ofNullable(System.getenv("PORT"));
	public static  String port = "8080";
	
	public static void main(String[] args) throws Exception {
       
		String contextPath = "/flyaway";
		String webappDirLocation = "src/main/webapp";
        String appBase = ".";
    
        String docBase = new File(webappDirLocation).getAbsolutePath(); 
       
        if(args != null && args.length > 0)
        {
         port = args[0];	;
        }
       
        Tomcat tomcat = new Tomcat();     
        tomcat.setPort(Integer.valueOf(port));
        tomcat.getConnector();
        tomcat.getHost().setAppBase(appBase);
        tomcat.getHost().setAutoDeploy(true);
        tomcat.getHost().setDeployOnStartup(true);
        
        Context context0 = (Context) tomcat.addWebapp(contextPath, docBase);
        
        File configFile = new File(webappDirLocation + "/WEB-INF/web.xml");
        context0.setConfigFile(configFile.toURI().toURL());
        
        
        tomcat.start();
        tomcat.getServer().await(); 
        
       
    }

}
