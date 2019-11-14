package com.imageshop.domain;

import java.io.Serializable;

public class Pds implements Serializable {

	private static final long serialVersionUID=2782595509618997354L;
	
	private Integer itemId;
	
	private String itemName;
	
	private String description;
	
	private String[] files;
	
	private Integer viewCnt;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public Integer getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(Integer viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
	
}
