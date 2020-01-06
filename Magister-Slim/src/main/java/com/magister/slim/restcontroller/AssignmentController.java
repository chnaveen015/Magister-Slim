package com.magister.slim.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.magister.slim.entity.Assignment;
import com.magister.slim.entity.StudyGuide;
import com.magister.slim.entity.Theme;
import com.magister.slim.entity.Unit;
import com.magister.slim.references.StudyGuideReference;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.references.UnitReference;
import com.magister.slim.repository.StudyGuideInterface;
import com.magister.slim.repository.UnitInterface;
import com.magister.slim.service.AssignmentAppService;

@RestController
@RequestMapping("studyGuide/{studyGuideId}/theme/{themeId}/unit/{unitId}/assignment")
@CrossOrigin(origins = "http://localhost:4200")

public class AssignmentController {

	@Autowired
	AssignmentAppService assignmentAppService;
	@Autowired
	StudyGuideInterface studyGuideInterface;
	@Autowired
	UnitInterface unitInterface;

	Assignment assignment = new Assignment();
	StudyGuide studyGuide = new StudyGuide();
	Theme theme = new Theme();
	Unit unit = new Unit();
	StudyGuideReference studyGuideReference = new StudyGuideReference();
	ThemeReference themeReference = new ThemeReference();
	UnitReference unitReference = new UnitReference();

	@RequestMapping(method = RequestMethod.POST)
	public Assignment createAssignment(@RequestBody Assignment assignment, @PathVariable("unitId") String unitId,
			@PathVariable("studyGuideId") String studyGuideId, @PathVariable("themeId") String themeId) {
		assignment.setActive(true);
		studyGuide = studyGuideInterface.findById(studyGuideId).get();
		StudyGuideReference studyGuideReference = new StudyGuideReference();
		studyGuideReference.setActive(true);
		studyGuideReference.setStudyGuideId(studyGuideId);
		studyGuideReference.setStudyGuideName(studyGuide.getStudyGuideName());
		unit = unitInterface.findById(unitId).get();
		UnitReference unitReference = new UnitReference();
		unitReference.setActive(true);
		unitReference.setUnitId(unitId);
		unitReference.setUnitName(unit.getUnitName());
		assignment.setStudyGuideReference(studyGuideReference);
		assignment.setUnitReference(unitReference);
		Assignment status = assignmentAppService.addAssignment(assignment,unit);
		return status;
	}

	@RequestMapping(value = "/{assignmentId}", method = RequestMethod.DELETE)
	public String deleteAssignmentDetails(@PathVariable("assignmentId") String assignmentId,
			@PathVariable("unitId") String unitId, @PathVariable("studyGuideId") String studyGuideId) {
		String status = assignmentAppService.deleteAssignment(assignmentId, unitId);
		return status;
	}

	@RequestMapping(value = "/{assignmentId}", method = RequestMethod.PUT)
	public Assignment updateAssignmentDetails(@PathVariable("assignmentId") String assignmentId,
			@RequestBody Assignment assignment, @PathVariable("unitId") String unitId,
			@PathVariable("studyGuideId") String studyGuideId, @PathVariable("themeId") String themeId) {
		assignment.setAssignmentId(assignmentId);
		Assignment status = assignmentAppService.updateAssignment(assignment);
		return status;
	}

	@RequestMapping(value = "/{assignmentId}", method = RequestMethod.GET)
	public Assignment getAssignmentDetail(@PathVariable("studyGuideId") String studyGuideId,
			@PathVariable("themeId") String themeId, @PathVariable("unitId") String unitId,
			@PathVariable("assignmentId") String assignmentId) {
		Assignment assignment = assignmentAppService.getAssignment(assignmentId, studyGuideId, themeId);
		return assignment;

	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Assignment> getAssignmentDetails(@PathVariable("studyGuideId") String studyGuideId,
			@PathVariable("themeId") String themeId, @PathVariable("unitId") String unitId,
			@RequestParam String assignmentName) {
		List<Assignment> assignments = assignmentAppService.getAssignments(assignmentName, studyGuideId, unitId);
		return assignments;
	}
}
