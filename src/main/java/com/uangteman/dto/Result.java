package com.uangteman.dto;

import java.util.ArrayList;
import java.util.List;

public class Result <T>{
	
	List<String> messages = new ArrayList<>();
	T payload;
	

	public Result(){}
	
	public Result(List<String> messages, T payload){
		this.messages = messages;
		this.payload = payload;
	}
	
	public List<String> getMessages() {
		return messages;
	}

	public Result<T> setMessages(List<String> messages) {
		this.messages = messages;
		return this;
	}

	public T getPayload() {
		return payload;
	}

	public Result<T> setPayload(T payload) {
		this.payload = payload;
		return this;
	}
	
}
