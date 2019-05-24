package com.github.bryan0919lin.eventbus;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class AsyncEventBus implements EventBus {

    private Map<String, Collection<SubscribeAction>> subscriptionMap = new HashMap<>();

    private final ExecutorService executorService;

    public AsyncEventBus(ExecutorService executorService) {
        this.executorService = executorService;
    }

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
        Collection<SubscribeAction> subscriptoins = subscriptionMap.get(event);
        if (event == null) {
            return;
        }

        for (SubscribeAction a: subscriptoins) {
            executorService.submit(new Runnable() {

                @Override
                public void run() {
                    a.execute(data);
                }
            });
        }
    }

}
