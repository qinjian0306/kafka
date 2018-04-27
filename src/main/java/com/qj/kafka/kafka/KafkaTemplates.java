package com.qj.kafka.kafka;

import com.qj.kafka.bean.KafkaOrder;
import com.qj.kafka.bean.KafkaTrade;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;


/**
 * kafka template
 */
@Component
public class KafkaTemplates {

    @Autowired
    private KafkaConfig config;

    /**
     * produce
     * @return
     */
    // string type
    @Bean
    public KafkaTemplate<String, String> stringKafkaTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<String, String>(config.kafkaProducerConfig()));
    }
    // object type
    @Bean
    public KafkaTemplate<String, Object> objectKafkaTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<String, Object>(config.kafkaProducerConfig()));
    }
    // order
    @Bean
    public KafkaTemplate<String, KafkaOrder> orderKafkaTemplate(){
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<String, KafkaOrder>(config.kafkaProducerConfig()));
    }
    @Bean
    public KafkaTemplate<String, KafkaTrade> tradeKafkaTemplate() {
        return new KafkaTemplate<>(new DefaultKafkaProducerFactory<String, KafkaTrade>(config.kafkaProducerConfig()));
    }


    /**
     * consumer
      * @return
     */
    // string type
    public ConsumerFactory<String, String> StringFactory() {
        return new DefaultKafkaConsumerFactory<>(config.kafkaConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(String.class));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaStringContainer() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(StringFactory());
        return factory;
    }
    // object type
    public ConsumerFactory<String, Object> objectFactory() {
        return new DefaultKafkaConsumerFactory<>(config.kafkaConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(Object.class));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Object> kafkaObjectListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(objectFactory());
        return factory;
    }
    // order
    public ConsumerFactory<String, KafkaOrder> orderFactory() {
        return new DefaultKafkaConsumerFactory<>(config.kafkaConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(KafkaOrder.class));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, KafkaOrder> kafkaOrderListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, KafkaOrder> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(orderFactory());
        return factory;
    }
    // trade
    public ConsumerFactory<String, KafkaTrade> tradeFactory() {
        return new DefaultKafkaConsumerFactory<>(config.kafkaConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(KafkaTrade.class));
    }
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, KafkaTrade> kafkaTradeListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, KafkaTrade> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(tradeFactory());
        return factory;
    }
}
