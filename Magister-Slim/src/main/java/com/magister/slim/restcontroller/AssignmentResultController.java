package com.magister.slim.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.magister.slim.entity.Assignment;
import com.magister.slim.entity.AssignmentResult;
import com.magister.slim.entity.Student;
import com.magister.slim.references.AssignmentReference;
import com.magister.slim.references.StudentReference;
import com.magister.slim.repository.AssignmentInterface;
import com.magister.slim.repository.StudentInterface;
import com.magister.slim.service.AssignmentResultAppService;

@RestController
@RequestMapping("studyGuide/{studyGuideId}/theme/{themeId}/unit/{unitId}/assignment/{assignmentId}/assignmentResult")
public class AssignmentResultController {

	@Autowired
	AssignmentInterface assignmentInterface;
	@Autowired
	StudentInterface studentInterface;
	@Autowired
	AssignmentResultAppService assignmentResultAppService;

	StudentReference studentReference = new StudentReference();
	Student student = new Student();
	AssignmentReference assignmentReference = new AssignmentReference();
	Assignment assignment = new Assignment();

	@RequestMapping(method = RequestMethod.POST)
	public AssignmentResult createAssignmentResult(@RequestBody AssignmentResult assignmentResult,
			@PathVariable("assignmentId") String assignmentId, @PathVariable("unitId") String unitId,
			@PathVariable("themeId") String themeId, @PathVariable("studyGuideId") String studyGuideId) {
		assignment = assignmentInterface.findById(assignmentId).get();
		assignmentReference.setAssignmentId(assignment.getAssignmentId());
		assignmentReference.setAssignmentName(assignment.getAssignmentName());
		assignmentReference.setActive(true);
		if (assignmentResult.getStudentReference() != null) {
			student = studentInterface.findById(assignmentResult.getStudentReference().getId()).get();
			studentReference.setId(student.getId());
			studentReference.setName(student.getName());
			studentReference.setActive(true);
			assignmentResult.setStudentReference(studentReference);
		}
		assignmentResult.setAssignmentReference(assignmentReference);
		AssignmentResult status = assignmentResultAppService.addAssignmentResult(assignmentResult);
		return status;
	}

	@RequestMapping(value = "/{assignmentResultId}", method = RequestMethod.PUT)
	public AssignmentResult updateAssignmentResultdetails(@RequestBody AssignmentResult assignmentResult,
			@PathVariable("assignmentResultId") String assignmentResultId, @PathVariable("unitId") int unitId,
			@PathVariable("studyGuideId") int studyGuideId, @PathVariable("themeId") int themeId) {
		AssignmentResult status = assignmentResultAppService.updateAssignmentResult(assignmentResultId);
		return status;
	}

	@RequestMapping(value = "/{assignmentResultId}", method = RequestMethod.GET)
	public AssignmentResult getAssignmentResultDetail(@PathVariable("assignmentResultId") String assignmentResultId,
			@PathVariable("assignmentId") String assignmentId, @PathVariable("unitId") String unitId,
			@PathVariable("studyGuideId") String studyGuideId, @PathVariable("themeId") String themeId) {
		AssignmentResult assignmentResult = assignmentResultAppService.getAssignmentResult(assignmentResultId,
				assignmentId, studyGuideId, themeId);
		return assignmentResult;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<AssignmentResult> getAssignmentResultdetails(@RequestParam String assignmentResultId,
			@PathVariable("assignmentId") int assignmentId, @PathVariable("unitId") int unitId,
			@PathVariable("studyGuideId") int studyGuideId, @PathVariable("themeId") int themeId) {
		List<AssignmentResult> assignmentResults = assignmentResultAppService.getAssignmentResults(assignmentResultId);
		return assignmentResults;
	}

}
