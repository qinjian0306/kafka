package com.qj.kafka.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
@ConfigurationProperties("spring.kafka")
public class KafkaProperties {
    public static final String CONSUMER_MODE = "earliest";

    private String bootstrapServer;

    private String groupId;

    public String getBootstrapServer() {
        return bootstrapServer;
    }

    public void setBootstrapServer(String bootstrapServer) {
        this.bootstrapServer = bootstrapServer;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    private final Topics topics = new Topics();

    public static class Topics{

        private String tradeTopic;
        private String orderTopic;

        public String getTradeTopic() {
            return tradeTopic;
        }

        public void setTradeTopic(String tradeTopic) {
            this.tradeTopic = tradeTopic;
        }

        public String getOrderTopic() {
            return orderTopic;
        }

        public void setOrderTopic(String orderTopic) {
            this.orderTopic = orderTopic;
        }
    }

    public Topics getTopics() {
        return topics;
    }

}
