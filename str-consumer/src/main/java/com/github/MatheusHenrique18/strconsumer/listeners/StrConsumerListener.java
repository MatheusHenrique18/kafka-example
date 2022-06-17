package com.github.MatheusHenrique18.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.github.MatheusHenrique18.strconsumer.custom.StrConsumerCustomListener;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {

	@StrConsumerCustomListener(groupId = "group-1")
	public void create(String message) {
		log.info("CREATE ::: Receive message {}", message);
	}
	
	@StrConsumerCustomListener(groupId = "group-1")
	public void log(String message) {
		log.info("LOG ::: Receive message {}", message);
	}
	
	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
	public void history(String message) {
		log.info("HISTORY ::: Receive message {}", message);
	}
	
//	@KafkaListener(groupId = "group-1", 
//			topicPartitions = {
//					@TopicPartition(topic = "str-topic", partitions = {"0"})
//			}, containerFactory = "strContainerFactory")
//	public void create(String message) {
//		log.info("LOG ::: Receive message {}", message);
//	}
	
//	@KafkaListener(groupId = "group-1", 
//			topicPartitions = {
//					@TopicPartition(topic = "str-topic", partitions = {"1"})
//			}, containerFactory = "strContainerFactory")
//	public void log(String message) {
//		log.info("LOG ::: Receive message {}", message);
//	}
}
