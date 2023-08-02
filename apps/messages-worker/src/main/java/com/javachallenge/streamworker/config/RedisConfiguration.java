package com.javachallenge.streamworker.config;

import com.javachallenge.streamworker.components.MessagePublisher;
import com.javachallenge.streamworker.components.RedisMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfiguration {

    @Value("${product.topic}")
    private String topic;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
     return redisMessageListenerContainer;
    }

    @Bean
    public ChannelTopic topic() {
        return new ChannelTopic(topic);
    }
    @Bean
    RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return redisTemplate;
    }

    @Bean
    MessagePublisher messagePublisher()
    {
        return new RedisMessagePublisher(redisTemplate(redisConnectionFactory),topic());
    }
}
