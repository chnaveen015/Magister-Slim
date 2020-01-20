package com.magister.slim.references;

import org.springframework.data.annotation.Id;

public class OfferingReference {

	@Id
	private String offeringId;
	private String offeringName;
	private boolean isActive;
	
	public OfferingReference()
	{
		
	}

	public OfferingReference(String offeringId, String offeringName, boolean isActive) {
		super();
		this.offeringId = offeringId;
		this.offeringName = offeringName;
		this.isActive = isActive;
	}

	
	public String getOfferingId() {
		return offeringId;
	}

	public void setOfferingId(String offeringId) {
		this.offeringId = offeringId;
	}

	public String getOfferingName() {
		return offeringName;
	}

	public void setOfferingName(String offeringName) {
		this.offeringName = offeringName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
	@Override
	public String toString() {
		return "OfferingReference [offeringId=" + offeringId + ", offeringName=" + offeringName + ", isActive="
				+ isActive + "]";
	}

	
}
