# event-bus
Just a simple event bus that implements the observer pattern with subscribe / publish.
It's lightweight, and no any other dependency.

# Usage
You can use maven to retrieve this lib as the following:

    <dependency>
        <groupId>com.github.bryan0919lin</groupId>
        <artifactId>event-bus</artifactId>
        <version>0.0.2</version>
    </dependency>
    
Then use the EventBusFactory to get the EventBus:

    EventBus eventBus = EventBusFactory.getEventBus();
    
Subscribe an action for a specific event:
    
    eventBus.subscribe("EventA", new SubscribeAction() {
            
        @Override
        public void execute(Object eventData) {
            // do something...
        }
    });
    
If using JDK 8+, you can use lambda expression to declare an action:

    eventBus.subscribe("EventA", d -> {
        // do something...
    });
    
Try to publish an event with data, then the event will execute all the subscriptions with the specific data.

    eventBus.publish("EventA", "I'm data");
    
# Using asynchronous event bus
This lib use synchronous event bus by default. That means when you publish an event, you need to wait for all subscrptions done, then you can go to next step. To use the event bus more efficiently, you can change the default event bus as below:

    EventBusConfig.setEventBus(new AsyncEventBus(Executors.newCachedThreadPool()));
    
Be careful that you should only use this configuration at the beginning of the application startup. If you use this configuration, that means the original event bus will be erased and the orginal subscriptions are erased as well.
