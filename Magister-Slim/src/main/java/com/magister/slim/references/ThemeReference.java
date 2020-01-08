package com.magister.slim.references;

public class ThemeReference {

	private String themeId;
	private String themeName;
	private boolean isActive;

	public ThemeReference(String themeId, String themeName, boolean isActive) {
		super();
		this.themeId = themeId;
		this.themeName = themeName;
		this.isActive = isActive;
	}

	public ThemeReference() {
		// TODO Auto-generated constructor stub
	}

	public String getThemeId() {
		return themeId;
	}

	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
