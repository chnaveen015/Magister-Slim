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

	public Offering() {

	}

	public Offering( String offeringName, List<OfferingLevelReference> offeringLevelReferences,
			boolean isActive) {
		super();
		this.offeringName = offeringName;
		this.offeringLevelReferences = offeringLevelReferences;
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

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((offeringId == null) ? 0 : offeringId.hashCode());
		result = prime * result + ((offeringLevelReferences == null) ? 0 : offeringLevelReferences.hashCode());
		result = prime * result + ((offeringName == null) ? 0 : offeringName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offering other = (Offering) obj;
		if (isActive != other.isActive)
			return false;
		if (offeringId == null) {
			if (other.offeringId != null)
				return false;
		} else if (!offeringId.equals(other.offeringId))
			return false;
		if (offeringLevelReferences == null) {
			if (other.offeringLevelReferences != null)
				return false;
		} else if (!offeringLevelReferences.equals(other.offeringLevelReferences))
			return false;
		if (offeringName == null) {
			if (other.offeringName != null)
				return false;
		} else if (!offeringName.equals(other.offeringName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Offering [offeringId=" + offeringId + ", offeringName=" + offeringName + ", offeringLevelReferences="
				+ offeringLevelReferences + ", isActive=" + isActive + "]";
	}

}
