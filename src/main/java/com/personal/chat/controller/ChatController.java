package com.personal.chat.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.personal.chat.model.ChatMessage;

@Controller
public class ChatController {
	
	@MessageMapping("/{topic}/chat.sendMessage")
	@SendTo("/topic/{topic}")
	public ChatMessage sendMessage(@DestinationVariable String topic, @Payload ChatMessage chatMessage) {
		return chatMessage;
	}
	
	@MessageMapping("/{topic}/chat.addUser")
	@SendTo("/topic/{topic}")
	public ChatMessage addUser(@DestinationVariable String topic, @Payload ChatMessage chatMessage, SimpMessageHeaderAccessor header) {
		header.getSessionAttributes().put("username", chatMessage.getSender());
		header.getSessionAttributes().put("topic", topic);
		return chatMessage;
	}
}
