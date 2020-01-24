package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Theme;
import com.magister.slim.entity.Unit;
import com.magister.slim.entity.User;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.TeacherReference;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.references.UnitReference;
import com.magister.slim.repository.CourseInterface;
import com.magister.slim.repository.StudyGuideInterface;
import com.magister.slim.repository.ThemeInterface;
import com.magister.slim.repository.UnitInterface;

@Service
public class StudyGuideAppService {

	@Autowired
	StudyGuideInterface studyGuideInterface;
	@Autowired
	ThemeInterface themeInterface;
	@Autowired
	UnitInterface unitInterface;
	@Autowired
	CourseInterface courseInterface;
	@Autowired
	CourseAppService courseAppService;
	@Autowired
	ResourceAppService resourceAppService;

	public StudyGuide getStudyGuideById(String studyGuideid) {
		if (studyGuideInterface.findById(studyGuideid).isPresent()) {
			return studyGuideInterface.findById(studyGuideid).get();
		} else
			return null;
	}

	public List<StudyGuide> getStudyGuide(String studyGuideName) {
		return studyGuideInterface.getStudyGuides(studyGuideName);
	}

	public List<StudyGuide> getStudyGuide(User user) {
		List<StudyGuide> studyGuides = studyGuideInterface.findAll();
		if (studyGuides != null) {
			List<StudyGuide> updatedStudyguides = studyGuides.stream().filter(
					studyGuide -> studyGuide.getTeacherReference().getTeacherid().equals(user.getUserid()) == true
							&& studyGuide.isActive() == true)
					.collect(Collectors.toList());
			return updatedStudyguides;
		}
		return null;
	}
	
	public String deleteStudyGuide(String studyGuideId) {
		StudyGuide studyGuide = studyGuideInterface.findById(studyGuideId).get();
		studyGuide.setActive(false);
		studyGuide.setDeleted(true);
		if (studyGuide.getThemes() != null) {
			List<ThemeReference> themeReferences = studyGuide.getThemes().stream().map(themeReference -> {
				Theme theme = themeInterface.findById(themeReference.getThemeId()).get();
				theme.setActive(false);
				theme.getStudyGuideReference().setActive(false);
				themeInterface.save(theme);
				themeReference.setActive(false);
				return themeReference;
			}).collect(Collectors.toList());
			studyGuide.setThemes(themeReferences);
		}
		if (studyGuide.getUnits() != null) {
			List<UnitReference> unitReferences = studyGuide.getUnits().stream().map(unitReference -> {
				Unit unit = unitInterface.findById(unitReference.getUnitId()).get();
				unit.setActive(false);
				unit.getStudyGuideReference().setActive(false);
				unit.getThemeReference().setActive(false);
				unitInterface.save(unit);
				unitReference.setActive(false);
				return unitReference;
			}).collect(Collectors.toList());
			studyGuide.setUnits(unitReferences);
		}
		studyGuideInterface.save(studyGuide);
		return studyGuideId;
	}

	public StudyGuide updateStudyGuide(StudyGuide studyGuide, String studyGuideId) {
		StudyGuide sg = studyGuideInterface.findById(studyGuideId).get();
		if (studyGuide.getStudyGuideName() != null) {
			sg.setStudyGuideName(studyGuide.getStudyGuideName());
			if (sg.getThemes() != null) {
				List<ThemeReference> themeReferences = sg.getThemes().stream().map(themeReference -> {
					Theme theme = themeInterface.findById(themeReference.getThemeId()).get();
					StudyGuideReference studyGuideReference = theme.getStudyGuideReference();
					studyGuideReference.setStudyGuideName(studyGuide.getStudyGuideName());
					theme.setStudyGuideReference(studyGuideReference);
					System.out.println(theme);
					themeInterface.save(theme);
					return themeReference;
				}).collect(Collectors.toList());
				sg.setThemes(themeReferences);
			}
			if (sg.getUnits() != null) {
				List<UnitReference> unitReferences = sg.getUnits().stream().map(unitReference -> {
					Unit unit = unitInterface.findById(unitReference.getUnitId()).get();
					StudyGuideReference studyGuideReference = unit.getStudyGuideReference();
					studyGuideReference.setStudyGuideName(studyGuide.getStudyGuideName());
					unit.setStudyGuideReference(studyGuideReference);
					System.out.println(unit);
					unitInterface.save(unit);
					return unitReference;
				}).collect(Collectors.toList());
				sg.setUnits(unitReferences);
			}
		}
		if (studyGuide.getValidOnwards() != null) {
			sg.setValidOnwards(studyGuide.getValidOnwards());
		}
		if (studyGuide.getValidUpto() != null) {
			sg.setValidUpto(studyGuide.getValidUpto());
		}
		studyGuideInterface.save(sg);
		return sg;
	}

	public StudyGuide addStudyGuide(StudyGuide studyGuide, User user) {
		studyGuide.setTeacherReference(teacherDetails(user.getUserid(), user.getUsername()));
		courseAppService.updateStudyguideReferences(studyGuide);
		studyGuideInterface.save(studyGuide);
		return studyGuide;
	}

	public List<StudyGuideReference> studyGuideDetails(String id, String studyGuideName) {
		StudyGuideReference studyGuideReference = new StudyGuideReference();
		List<StudyGuideReference> sR = new ArrayList<StudyGuideReference>();
		studyGuideReference.setStudyGuideId(id);
		studyGuideReference.setStudyGuideName(studyGuideName);
		studyGuideReference.setActive(true);
		sR.add(studyGuideReference);
		return sR;
	}

	public TeacherReference teacherDetails(String id, String teacherName) {
		TeacherReference teacherReference = new TeacherReference();
		teacherReference.setTeacherid(id);
		teacherReference.setName(teacherName);
		teacherReference.setActive(true);
		return teacherReference;
	}

	public boolean deleteThemeReference(String themeId, String studyGuideId) {
		StudyGuide studyGuide = studyGuideInterface.findById(studyGuideId).get();
		List<ThemeReference> ThemeReferences = studyGuide.getThemes().stream().map(studyGuideReference -> {
			if (studyGuideReference.getThemeId().equals(themeId)) {
				studyGuideReference.setActive(false);
			}
			return studyGuideReference;
		}).collect(Collectors.toList());
		studyGuide.setThemes(ThemeReferences);
		studyGuideInterface.save(studyGuide);
		return true;
	}

	public boolean deleteUnitReference(String unitId, String studyGuideId) {
		StudyGuide studyGuide = studyGuideInterface.findById(studyGuideId).get();
		List<UnitReference> unitReferences = studyGuide.getUnits().stream().map(studyGuideReference -> {
			if (studyGuideReference.getUnitId().equals(unitId)) {
				studyGuideReference.setActive(false);
			}
			return studyGuideReference;
		}).collect(Collectors.toList());
		studyGuide.setUnits(unitReferences);
		studyGuideInterface.save(studyGuide);
		return true;
	}
}
