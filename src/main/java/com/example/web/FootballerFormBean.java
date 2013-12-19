package com.example.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.domain.Footballer;
import com.example.service.FootballerManager;


@SessionScoped
@Named
public class FootballerFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Footballer footballer = new Footballer();
	private ListDataModel<Footballer> footballers = new ListDataModel<>();
	
	@Inject
	private FootballerManager footballerManager;

	public Footballer getFootballer() {
		return footballer;
	}

	public void setFootballer(Footballer footballer) {
		this.footballer = footballer;
	}

	public ListDataModel<Footballer> getAllFootballers() {
		footballers.setWrappedData(footballerManager.getAllFootballers());
		return footballers;
	}

	public void setFootballers(ListDataModel<Footballer> footballers) {
		this.footballers = footballers;
	}
	
	public String addFootballer() {
		footballerManager.addFootballer(footballer);
		return "show";
	}
	
	public String deleteFootballer() {
		Footballer toDelete = footballers.getRowData();
		footballerManager.deleteFootballer(toDelete);
		return null;
	}
	
}
