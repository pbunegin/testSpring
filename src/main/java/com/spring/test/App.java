package com.spring.test;

import com.spring.test.beans.Client;
import com.spring.test.loggers.Event;
import com.spring.test.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;

    public static void main(String[] args) {
        ConfigurableApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = appContext.getBean(App.class);
        Event event = appContext.getBean(Event.class);
        app.logEvent(event);
        app.logEvent(event);

        appContext.close();
    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(Event event){
        eventLogger.logEvent(event);
    }
}
