package com.indi.stay.domain;

import java.io.Serializable;

public class DomainObject implements Serializable{
	
	private static final long serialVersionUID = -7976046608200730405L;
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
