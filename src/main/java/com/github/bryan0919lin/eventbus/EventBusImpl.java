package com.github.bryan0919lin.eventbus;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EventBusImpl implements EventBus {

    private Map<String, Collection<SubscribeAction>> subscriptionMap = new HashMap<>();

    @Override
    public synchronized void subscribe(String event, SubscribeAction action) {
        if (subscriptionMap.keySet().contains(event)) {
            subscriptionMap.get(event).add(action);
        } else {
            subscriptionMap.put(event, Arrays.asList(action));
        }
    }

    @Override
    public void publish(String event, Object data) {
        Collection<SubscribeAction> subscriptions = subscriptionMap.get(event);
        if (event == null) {
            return;
        }

        for (SubscribeAction a: subscriptions) {
            a.execute(data);
        }
    }

}
