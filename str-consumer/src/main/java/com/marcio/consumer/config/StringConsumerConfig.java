package com.marcio.consumer.config;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.BatchInterceptor;
import org.springframework.kafka.listener.RecordInterceptor;

@EnableKafka
@Configuration
public class StringConsumerConfig {

	@Autowired
	private KafkaProperties properties;

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		var configs = new HashMap<String, Object>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<String, String>(configs);
	}

	/*
	 * @Bean public ConcurrentKafkaListenerContainerFactory<String,String>
	 * strconsumerFactory(){ var factory = new
	 * ConcurrentKafkaListenerContainerFactory<String,String>();
	 * factory.setConsumerFactory(consumerFactory()); return factory; }
	 */

	public ConcurrentKafkaListenerContainerFactory<String, String> strconsumerFactory() {
		var factory = new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		factory.setRecordInterceptor(validMessage());
		return factory;
	}

	private RecordInterceptor<String, String> validMessage() {
		
		return ( x , y ) -> {
			if ( x.value().contains("teste") ) {
			 
			}
			 return x;	
		}; 
		
	}

	
}
