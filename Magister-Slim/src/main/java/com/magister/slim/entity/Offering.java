package com.magister.slim.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.OfferingLevelReference;

@Document
public class Offering {
	@Id
	private String offeringId;
	private String offeringName;
	private List<OfferingLevelReference> offeringLevelReferences;
	private boolean isActive;
	
	public Offering()
	{
		
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

	public List<OfferingLevelReference> getOfferingLevelReferences() {
		return offeringLevelReferences;
	}

	public void setOfferingLevelReferences(List<OfferingLevelReference> offeringLevelReferences) {
		this.offeringLevelReferences = offeringLevelReferences;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Offering(String offeringId, String offeringName, List<OfferingLevelReference> offeringLevelReferences,
			boolean isActive) {
		super();
		this.offeringId = offeringId;
		this.offeringName = offeringName;
		this.offeringLevelReferences = offeringLevelReferences;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Offering [offeringId=" + offeringId + ", offeringName=" + offeringName + ", offeringLevelReferences="
				+ offeringLevelReferences + ", isActive=" + isActive + "]";
	}
	
}
