package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Theme;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.references.UnitReference;
import com.magister.slim.repository.StudyGuideInterface;
import com.magister.slim.repository.ThemeInterface;

@Service
public class ThemeAppService {

	@Autowired
	StudyGuideInterface studyGuideInterface;
	@Autowired
	ThemeInterface themeInterface;
	@Autowired
	StudyGuideAppService studyGuideAppService;

	public List<Theme> getThemes(String themeName, String studyGuideId) {
		List<Theme> themes = themeInterface.getThemes(themeName);
		List<Theme> themeReferences = themes.stream().map(themeReference -> {
			if (themeReference.getStudyGuideReference().getStudyGuideId().equals(studyGuideId)) {
				return themeReference;
			} else
				return null;
		}).collect(Collectors.toList());
		return themeReferences;
	}

	public String deleteTheme(String themeId, String studyGuideId) {
		System.out.println(themeInterface.findAll());
		List<Theme> theme = themeInterface.findAll();
		for(int i=0;i<theme.size();i++)
		{
			if(themeId.equals(theme.get(i).getThemeId()))
			{
				theme.get(i).setActive(false);
			}
			else
				theme.remove(i);
		}
		studyGuideAppService.deleteThemeReference(themeId, studyGuideId);
		return themeId;
	}

	public Theme addTheme(Theme theme, StudyGuide studyGuide) {
		themeInterface.save(theme);
		studyGuide.setThemes(themeDetails(theme.getThemeId(), theme.getThemeName(), studyGuide));
		studyGuideInterface.save(studyGuide);
		return theme;
	}

	public Theme updateTheme(Theme theme, StudyGuide studyGuide) {
		themeInterface.save(theme);
		studyGuideInterface.save(studyGuide);
		return theme;
	}

	public List<ThemeReference> themeDetails(String id, String themeName, StudyGuide studyGuide) {
		ThemeReference themeReference = new ThemeReference();
		List<ThemeReference> themes = new ArrayList<ThemeReference>();
		themes = studyGuide.getThemes();
		if (themes == null)
			themes = new ArrayList<ThemeReference>();
		themeReference.setThemeId(id);
		themeReference.setThemeName(themeName);
		themeReference.setActive(true);
		themes.add(themeReference);
		return themes;
	}

	public Theme getTheme(String themeid, String studyGuideId) {
		List<Theme> themesList=themeInterface.findAll();
		Theme theme=themesList.stream().filter(oneTheme-> oneTheme.getThemeId().equals(themeid)).findFirst().get();
		System.out.println(theme);
		if (theme!=null) {
		//	Theme theme = themeInterface.findById(themeid).get();
			if (theme.getStudyGuideReference().getStudyGuideId().equals( studyGuideId))
				return theme;
			else
				return theme;
		} else
			return null;
	}

	public boolean deleteUnitReference(String unitId, String themeId) {
		Theme theme = themeInterface.findById(themeId).get();
		List<UnitReference> unitReferences = theme.getUnits().stream().map(themeReference -> {
			if (themeReference.getUnitId().equals(unitId)) {
				themeReference.setActive(false);
			}
			return themeReference;
		}).collect(Collectors.toList());
		theme.setUnits(unitReferences);
		themeInterface.save(theme);
		return true;
	}
}
