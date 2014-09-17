package com.tm.midservice.web; /**
 * Created by Nihal on 9/10/14.
 */

import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TMMIDServiceStartUpListener implements ServletContextListener {

    private static Logger LOGGER = Logger.getLogger(TMMIDServiceStartUpListener.class);


    // Public constructor is required by servlet spec
    public TMMIDServiceStartUpListener() {
        System.out.println("Listener Class");
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {

    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("================  SHUTTING DOWN  ==================");
    }
}
