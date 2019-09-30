package com.avinash.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TourPackage implements Serializable {

	private static final long serialVersionUID = 8162816051031406536L;

	@Id
	private String code;
	
	@Column
	private String name;
	
	protected TourPackage() {
		
	}
	
	public TourPackage(String code,String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "TourPackage{"+" code = "+code+" name = "+name+" }";
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		return false;
	}

}
