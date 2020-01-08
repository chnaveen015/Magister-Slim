package com.magister.slim.references;

public class UnitReference {

	private String unitId;
	private String unitName;
	private boolean isActive;
	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UnitReference(String unitId, String unitName, boolean isActive) {
		super();
		this.unitId = unitId;
		this.unitName = unitName;
		this.isActive = isActive;
	}
	public UnitReference() {
		
	}
}
