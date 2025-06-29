package com.hiruna.notification_service.kafka;

import com.hiruna.notification_service.data.CustomerNotif;
import com.hiruna.notification_service.data.WorkerNotif;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConsumerConfiguration {
    @Value("${spring.kafka.bootstrap-servers}")
    private String server_addr;

    //consumer configuration for customer notifications
    @Bean
    public ConsumerFactory<String, CustomerNotif> customerNotifConsumerFactory(){
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server_addr);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "customer-notif-group1");

        JsonDeserializer<CustomerNotif> deserializer = new JsonDeserializer<>(CustomerNotif.class, false);
        deserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CustomerNotif> customerNotifListenerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, CustomerNotif> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(customerNotifConsumerFactory());
        return factory;
    }

    //worker configuration for
    @Bean
    public ConsumerFactory<String, WorkerNotif> workerNotifConsumerFactory(){
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server_addr);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "worker-notif-group2");

        JsonDeserializer<WorkerNotif> deserializer = new JsonDeserializer<>(WorkerNotif.class, false);
        deserializer.addTrustedPackages("*");

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, WorkerNotif> workerNotifListenerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, WorkerNotif> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(workerNotifConsumerFactory());
        return factory;
    }
}
