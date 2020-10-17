package com.clinicals.api.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClinicalData {

	@Id
	private int id;
	private String componentName;
	private String componentValue;
	private Timestamp measuredDateTime;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="patient_id",nullable=false)
	private Patient patient;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getComponentValue() {
		return componentValue;
	}
	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}
	public Timestamp getMeasuredDateTime() {
		return measuredDateTime;
	}
	public void setMeasuredDateTime(Timestamp measuredDateTime) {
		this.measuredDateTime = measuredDateTime;
	}
	
	
	
}