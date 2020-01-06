package com.magister.slim.restcontroller;

import java.text.ParseException;
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
import com.magister.slim.references.ThemeReference;
import com.magister.slim.references.UnitReference;
import com.magister.slim.repository.StudyGuideInterface;
import com.magister.slim.repository.ThemeInterface;
import com.magister.slim.repository.UnitInterface;
import com.magister.slim.service.UnitAppService;
import com.magister.slim.service.UserAppService;

@RestController
@RequestMapping("studyGuide/{studyGuideId}/theme/{themeId}")
@CrossOrigin(origins = "http://localhost:4200")
public class UnitController {

	@Autowired
	StudyGuideInterface studyGuideInterface;
	@Autowired
	ThemeInterface themeInterface;
	@Autowired
	UnitInterface unitInterface;
	@Autowired
	UnitAppService unitAppService;

	StudyGuideReference studyGuideReference = new StudyGuideReference();
	StudyGuide studyGuide = new StudyGuide();
	Theme theme = new Theme();
	ThemeReference themeReference = new ThemeReference();

	@RequestMapping(value = "/unit", method = RequestMethod.POST)
	public Unit createUnit(@RequestBody Unit unit, @PathVariable("studyGuideId") String studyGuideId,
			@PathVariable("themeId") String themeId) throws ParseException {
		unit.setUnitId(UserAppService.generateNumber());
		if (studyGuideInterface.findById(studyGuideId).isPresent() && themeInterface.findById(themeId).isPresent()) {
			studyGuide = studyGuideInterface.findById(studyGuideId).get();
			studyGuideReference.setStudyGuideId(studyGuide.getStudyGuideId());
			studyGuideReference.setStudyGuideName(studyGuide.getStudyGuideName());
			studyGuideReference.setActive(studyGuide.isActive());
			theme = themeInterface.findById(themeId).get();
			themeReference.setThemeId(theme.getThemeId());
			themeReference.setThemeName(theme.getThemeName());
			themeReference.setActive(theme.isActive());
			unit.setStudyGuideReference(studyGuideReference);
			unit.setThemeReference(themeReference);
			unit.setActive(true);
			Unit status = unitAppService.addUnit(unit);
			System.out.println(status);
			return status;
		} else
			return null;
	}

	@RequestMapping(value = "/unit/{unitId}", method = RequestMethod.DELETE)
	public String deleteUnitDetails(@PathVariable("unitId") String unitId,
			@PathVariable("studyGuideId") String studyGuideId, @PathVariable("themeId") String themeId) {
		return unitAppService.deleteUnit(unitId, themeId, studyGuideId);
	}

	@RequestMapping(value = "/unit/{unitId}", method = RequestMethod.PUT)
	public Unit updateUnitDetails(@PathVariable("unitId") String unitId,
			@PathVariable("studyGuideId") String studyGuideId, @PathVariable("themeId") String themeId,
			@RequestBody Unit unit) {
		studyGuideReference.setStudyGuideId(studyGuideId);
		themeReference.setThemeId(themeId);
		String unitName = unit.getUnitName();
		StudyGuide studyGuide = studyGuideInterface.findById(studyGuideReference.getStudyGuideId()).get();
		Theme theme = themeInterface.findById(themeReference.getThemeId()).get();
		if (unit.getUnitName() != null) {
			List<UnitReference> unitReferences = theme.getUnits().stream().map(unitReference -> {
				if (unitReference.getUnitId().equals(unitId)) {
					unitReference.setUnitName(unitName);
				}
				return unitReference;
			}).collect(Collectors.toList());
			theme.setUnits(unitReferences);
			List<UnitReference> unitReferences1 = studyGuide.getUnits().stream().map(unitReference -> {
				if (unitReference.getUnitId().equals(unitId)) {
					unitReference.setUnitName(unitName);
				}
				return unitReference;
			}).collect(Collectors.toList());
			studyGuide.setUnits(unitReferences1);
		}
		unit = unitInterface.findById(unitId).get();
		unit.setUnitName(unitName);
		return unitAppService.updateUnit(unit, theme, studyGuide);
	}

	@RequestMapping(value = "/unit/{unitId}", method = RequestMethod.GET)
	public Unit getUnitDetail(@PathVariable("studyGuideId") String studyGuideId,
			@PathVariable("themeId") String themeId, @PathVariable("unitId") String unitId) {
		return unitAppService.getUnit(unitId, themeId, studyGuideId);
	}

	@RequestMapping(value = "/units", method = RequestMethod.GET)
	public List<Unit> getUnitDetails(@PathVariable("studyGuideId") String studyGuideId,
			@PathVariable("themeId") String themeId, @RequestParam String unitName) {
		return unitAppService.getUnits(unitName, themeId, studyGuideId);
	}
}
