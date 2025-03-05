package com.marcio.consumer.listener;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.marcio.consumer.custom.StrConsumerCustom;




@Component
public class StrConsumerListener {

	static final Logger logger = LogManager.getLogger(StrConsumerListener.class.getName());
	
	@StrConsumerCustom(groupId = "group-1")
	public void create(String message) {
		 logger.info("Mensagem 1: {} " , message );	
	}
	
	
	@StrConsumerCustom(groupId = "group-2")
	public void create2(String message) {
		 logger.info("Mensagem 2: {} " , message );	
	}
	
/*	@KafkaListener(groupId = "group-1" , topics = "str-topic" , containerFactory = "strconsumerFactory")
	public void listener(String message) {
       logger.info("Mensagem: {} " , message );        
	} */
}
