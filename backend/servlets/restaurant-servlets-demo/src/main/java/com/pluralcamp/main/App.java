package com.pluralcamp.main;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        String webappDirLocation = "src/main/webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8082);

        // https://tomcat.apache.org/tomcat-10.0-doc/connectors.html
        /*
         * The HTTP Connector element represents a Connector component
         * that supports the HTTP/1.1 protocol. It enables Catalina to
         * function as a stand-alone web server, in addition to
         * its ability to execute servlets and JSP pages.
         * 
         * Mandatory since Tomcat 9
         * https://stackoverflow.com/questions/56668892/embedded-tomcat-java-application
         * -is-running-but-server-cannot-be-reached
         */
        tomcat.getConnector();

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/",
                new File(webappDirLocation).getAbsolutePath());

        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        ctx.setResources(resources);

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        tomcat.getServer().await();
    }
}
