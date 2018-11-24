package com.yc.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Listener01
 *
 */
@WebListener
public class Listener01 implements ServletRequestListener {

   
    public Listener01() {
       
    }

	
    public void requestDestroyed(ServletRequestEvent arg0)  { 
        
    }

	
    public void requestInitialized(ServletRequestEvent arg0)  { 
        
    }
	
}
