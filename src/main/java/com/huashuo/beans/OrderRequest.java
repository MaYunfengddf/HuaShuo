package com.huashuo.beans;

import java.util.List;

public class OrderRequest {
	private String id;
	private String accountc;
	private String key;
	private List<String> key2;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountc() {
		return accountc;
	}
	public void setAccounrc(String accountc) {
		this.accountc = accountc;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public List<String> getKey2() {
		return key2;
	}
	public void setKey2(List<String> key2) {
		this.key2 = key2;
	}
	
}
