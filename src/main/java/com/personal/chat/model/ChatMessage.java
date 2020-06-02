package com.personal.chat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
	private MessageType type;
	private String topic;
    private String content;
    private String sender;
    
    public enum MessageType {
    	CHAT, JOINED, LEFT
    }
}
