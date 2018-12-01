package app.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ListenerAplicacion implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerAplicacion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("Aplicación terminada");
    		
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        
    	System.out.println("Aplicación terminada");
    	
    	// Recuperar el contexto de la aplicacion	
    	ServletContext ctxApp = sce.getServletContext();
    	String msgOferta = ctxApp.getInitParameter("ofertaDia");
    	
    	ctxApp.setAttribute("msgOferta", msgOferta);
    }
}
