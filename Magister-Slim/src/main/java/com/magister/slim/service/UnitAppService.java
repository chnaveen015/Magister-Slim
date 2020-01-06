package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Theme;
import com.magister.slim.entity.Unit;
import com.magister.slim.references.AssignmentReference;
import com.magister.slim.references.UnitReference;
import com.magister.slim.repository.StudyGuideInterface;
import com.magister.slim.repository.ThemeInterface;
import com.magister.slim.repository.UnitInterface;

@Service
public class UnitAppService {

	@Autowired
	UnitInterface unitInterface;
	@Autowired
	ThemeInterface themeInterface;
	@Autowired
	StudyGuideInterface studyGuideInterface;
	@Autowired
	UnitAppService unitAppService;
	@Autowired
	ThemeAppService themeAppService;
	@Autowired
	StudyGuideAppService studyGuideAppService;

	public Unit getUnit(String unitid, String themeId, String studyGuideId) {
		if (unitInterface.findById(unitid).isPresent()) {
			Unit unit = unitInterface.findById(unitid).get();
			if (unit.getStudyGuideReference().getStudyGuideId().equals(studyGuideId)
					&& unit.getThemeReference().getThemeId().equals(themeId) && unit.isActive() == true) {
				return unit;
			} else
				return null;
		} else
			return null;
	}

	public List<Unit> getUnits(String unitName, String themeId, String studyGuideId) {
		List<Unit> units = unitInterface.getUnits(unitName);
		List<Unit> unitReferences = units.stream().map(unitReference -> {
			if (unitReference.getStudyGuideReference().getStudyGuideId().equals(studyGuideId)
					&& unitReference.getThemeReference().getThemeId().equals(themeId)
					&& unitReference.isActive() == true) {
				return unitReference;
			} else
				return null;
		}).collect(Collectors.toList());
		return unitReferences;
	}

	public String deleteUnit(String unitId, String themeId, String studyGuideId) {
		Unit unit = unitInterface.findById(unitId).get();
		unit.setActive(false);
		studyGuideAppService.deleteUnitReference(unitId, studyGuideId);
		themeAppService.deleteUnitReference(unitId, themeId);
		unitInterface.save(unit);
		return unitId;
	}

	public Unit updateUnit(Unit unit, Theme theme, StudyGuide studyGuide) {
		themeInterface.save(theme);
		studyGuideInterface.save(studyGuide);
		unitInterface.save(unit);
		return unit;
	}

	public Unit addUnit(Unit unit) {
		unitInterface.save(unit);
		StudyGuide studyGuide = studyGuideInterface.findById(unit.getStudyGuideReference().getStudyGuideId()).get();
		Theme theme = themeInterface.findById(unit.getThemeReference().getThemeId()).get();
		studyGuide.setUnits(unitDetails(unit.getUnitId(), unit.getUnitName(), studyGuide));
		theme.setUnits(unitDetails(unit.getUnitId(), unit.getUnitName(), theme));
		themeInterface.save(theme);
		studyGuideInterface.save(studyGuide);
		return unit;
	}

	public List<UnitReference> unitDetails(String unitId, String unitName, Theme theme) {
		UnitReference unitReference = new UnitReference();
		List<UnitReference> units = new ArrayList<UnitReference>();
		units = theme.getUnits();
		if (units == null)
			units = new ArrayList<UnitReference>();
		unitReference.setUnitId(unitId);
		unitReference.setUnitName(unitName);
		unitReference.setActive(true);
		units.add(unitReference);
		return units;
	}

	public List<UnitReference> unitDetails(String unitId, String unitName, StudyGuide studyGuide) {
		UnitReference unitReference = new UnitReference();
		List<UnitReference> units = new ArrayList<UnitReference>();
		units = studyGuide.getUnits();
		if (units == null)
			units = new ArrayList<UnitReference>();
		unitReference.setUnitId(unitId);
		unitReference.setUnitName(unitName);
		unitReference.setActive(true);
		units.add(unitReference);
		return units;
	}

	public boolean deleteAssignmentReference(String unitId, String assignmentId) {
		Unit unit = unitInterface.findById(unitId).get();
		List<AssignmentReference> assignmentReferences = unit.getAssignments().stream().map(assignmentReference -> {
			if (assignmentReference.getAssignmentId().equals(assignmentId)) {
				assignmentReference.setActive(false);
			}
			return assignmentReference;
		}).collect(Collectors.toList());
		unit.setAssignments(assignmentReferences);
		;
		unitInterface.save(unit);
		return true;
	}
}