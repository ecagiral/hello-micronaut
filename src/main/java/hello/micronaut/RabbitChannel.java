package hello.micronaut;

import io.micronaut.configuration.rabbitmq.annotation.Binding;
import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;

@RabbitClient("micronaut")
public interface RabbitChannel {

    @Binding("msg")
    void sendMsg(RabbitMessage msg);

}
