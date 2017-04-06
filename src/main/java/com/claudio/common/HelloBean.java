package com.claudio.common;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String name2;
	private String name3;
	
	//Aqui empieza la inyeccion de depencias
	@ManagedProperty(value = "#{message}")
	private MessageBean messageBean;
	
	// Hay que proveer el metodo setter
	public void setMessageBean(MessageBean messageBean){
		this.messageBean = messageBean;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getName3() {
		return name3;
	}

	public void setName3(String name3) {
		this.name3 = name3;
	}

	public String getSayWelcome() {
		// check if null?
		if ("".equals(name) || name == null) {
			return "";
		} else {
			return "Ajax message : Welcome " + name + ", " + name2 + ", " + name3;
		}
	}
	
	public String getMessageInjected(){
		
		return this.messageBean.getSayWelcome();
	}

}
