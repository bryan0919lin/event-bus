package com.github.bryan0919lin.eventbus;

public class EventBusFactory {

    private static EventBus eventBus = new EventBusImpl();

    public static EventBus getEventBus() {
        return eventBus;
    }

    static void setEventBus(EventBus eventBus) {
        EventBusFactory.eventBus = eventBus;
    }
}
