package idv.bryan0919lin.eventbus;

public interface EventBus {

    void subscribe(String event, SubscribeAction action);

    void publish(String event, Object data);
}
