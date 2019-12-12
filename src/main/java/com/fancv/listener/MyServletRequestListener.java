package com.fancv.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    /**
     * The request is about to go out of scope of the web application.
     * The default implementation is a NO-OP.
     *
     * @param sre Information about the request
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

        System.out.println("requestDestroyed");
    }

    /**
     * The request is about to come into scope of the web application.
     * The default implementation is a NO-OP.
     *
     * @param sre Information about the request
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {

        System.out.println("requestInitialized: "+sre.getServletContext().getServerInfo());
    }
}
