package com.rdpgroupbd.apps.rich.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.rdpgroupbd.apps.rich.domain.T01I001;
import com.rdpgroupbd.apps.rich.serv.IT01I001Service;

@RequestScoped
@ManagedBean(name = "B01I001001")
public class B01I001001 implements Serializable {

	private static final long serialVersionUID = 3789030925623191597L;
	private static Logger log = LoggerFactory.getLogger(B01I001001.class);

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	@ManagedProperty(value="#{T01I001Service}")
	private IT01I001Service service;

	private T01I001 continent = new T01I001();

	public String addUser() {
		try {
			service.save(continent);
			return SUCCESS;
		} catch (DataAccessException e) {
			log.error(e.getMessage(), e);
		}

		return ERROR;
	}

	public void reset() {
		continent = new T01I001();
	}

	public List<T01I001> getContinentList() {
		return service.get();
	}
	
	public IT01I001Service getService() {
		return service;
	}

	public void setService(IT01I001Service service) {
		this.service = service;
	}

	public T01I001 getContinent() {
		return continent;
	}

	public void setContinent(T01I001 continent) {
		this.continent = continent;
	}

}
