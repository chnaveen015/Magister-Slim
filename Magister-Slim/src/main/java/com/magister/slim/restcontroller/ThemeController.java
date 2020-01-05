package com.magister.slim.restcontroller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Theme;
import com.magister.slim.entity.Unit;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.UnitReference;
import com.magister.slim.repository.StudyGuideInterface;
import com.magister.slim.repository.ThemeInterface;
import com.magister.slim.repository.UnitInterface;
import com.magister.slim.service.ThemeAppService;

@RestController
@RequestMapping("studyGuide/{studyGuideId}/theme")
@CrossOrigin(origins = "http://localhost:4200")
public class ThemeController {

	@Autowired
	StudyGuideInterface studyGuideInterface;
	@Autowired
	ThemeAppService themeAppService;
	@Autowired
	ThemeInterface themeInterface;
	@Autowired
	UnitInterface unitInterface;

	StudyGuideReference studyGuideReference = new StudyGuideReference();
	StudyGuide studyGuide = new StudyGuide();

	@RequestMapping(method = RequestMethod.POST)
	public Theme createTheme(@RequestBody Theme theme, @PathVariable("studyGuideId") String studyGuideId) {
		studyGuideReference.setStudyGuideId(studyGuideId);
		System.out.println(studyGuideInterface.findAll());
		List<StudyGuide> studyGuideList=studyGuideInterface.findAll();
		StudyGuide studyGuide=studyGuideList.stream().filter(oneTheme-> oneTheme.getStudyGuideId().equals(studyGuideId)).findFirst().get();
		if (studyGuide.isActive()) {
			studyGuideReference.setStudyGuideName(studyGuide.getStudyGuideName());
			studyGuideReference.setActive(studyGuide.isActive());
			theme.setStudyGuideReference(studyGuideReference);
			theme.setActive(true);
			Theme status = themeAppService.addTheme(theme, studyGuide);
			System.out.println(status);
			return status;
		} else
			return null;
	}

	@RequestMapping(value = "/{themeId}", method = RequestMethod.PUT)
	public Theme updateThemeDetails(@PathVariable("themeId") String themeId, @RequestBody Theme theme,
			@PathVariable("studyGuideId") String studyGuideId) {
		String themeName = theme.getThemeName();
		theme = themeInterface.findById(themeId).get();
		if (theme.getUnits() != null) {
			List<UnitReference> unitReferences = theme.getUnits().stream().map(unitReference -> {
				Unit unit = unitInterface.findById(unitReference.getUnitId()).get();
				unit.getThemeReference().setThemeName(themeName);
				unitInterface.save(unit);
				return unitReference;
			}).collect(Collectors.toList());
			theme.setUnits(unitReferences);
		}
		studyGuide = studyGuideInterface.findById(studyGuideId).get();
		studyGuide.getThemes().stream().filter((studyGuideReference) -> studyGuideReference.getThemeId().equals(themeId))
				.findAny().get().setThemeName(themeName);
		theme.setThemeName(themeName);
		return themeAppService.updateTheme(theme, studyGuide);
	}

	@RequestMapping(value = "/{themeId}", method = RequestMethod.DELETE)
	public String deleteThemeDetails(@PathVariable("themeId") String themeId,
			@PathVariable("studyGuideId") String studyGuideId) {
		System.out.println("Hii");
		String status = themeAppService.deleteTheme(themeId, studyGuideId);
		return status;
	}

	@RequestMapping(value = "/{themeId}", method = RequestMethod.GET)
	public Theme getThemeDetail(@PathVariable("themeId") String themeId, @PathVariable("studyGuideId") String studyGuideId) {
		System.out.println(themeId);
		Theme theme = themeAppService.getTheme(themeId, studyGuideId);
		return theme;

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Theme> getThemeDetails(@RequestParam String themeName, @PathVariable("studyGuideId") String studyGuideId) {
		List<Theme> themes = themeAppService.getThemes(themeName, studyGuideId);
		return themes;
	}

}
