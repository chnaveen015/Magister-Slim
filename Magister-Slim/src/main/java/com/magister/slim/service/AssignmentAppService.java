package com.magister.slim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.magister.slim.entity.Assignment;
import com.magister.slim.entity.Unit;
import com.magister.slim.references.AssignmentReference;
import com.magister.slim.repository.AssignmentInterface;
import com.magister.slim.repository.UnitInterface;

@Service
public class AssignmentAppService {

	@Autowired
	AssignmentInterface assignmentInterface;
	@Autowired
	UnitAppService unitAppService;
	@Autowired
	UnitInterface unitInterface;

	public List<Assignment> getAssignments(String assignmentName, String studyGuideId, String unitId) {
		List<Assignment> assignments = assignmentInterface.getAssignments(assignmentName);
		List<Assignment> assignmentReferences = assignments.stream().map(assignmentReference -> {
			if (assignmentReference.getStudyGuideReference().getStudyGuideId().equals(studyGuideId)
					&& assignmentReference.getUnitReference().getUnitId() .equals(unitId)) {
				return assignmentReference;
			} else
				return null;
		}).collect(Collectors.toList());
		return assignmentReferences;
	}

	public String deleteAssignment(String assignmentId, String unitId) {
		Assignment assignment = assignmentInterface.findById(assignmentId).get();
		assignment.setActive(false);
		unitAppService.deleteAssignmentReference(unitId, assignmentId);
		assignmentInterface.save(assignment);
		return assignmentId;
	}

	public Assignment addAssignment(Assignment assignment, Unit unit) {
		assignmentInterface.save(assignment);
		unit.setAssignments(assignmentDetails(assignment.getAssignmentId(), assignment.getAssignmentName(), unit));
		unitInterface.save(unit);
		return assignment;
	}

	private List<AssignmentReference> assignmentDetails(String assignmentId, String assignmentName, Unit unit) {
		AssignmentReference assignmentReference = new AssignmentReference();
		List<AssignmentReference> assignments = new ArrayList<AssignmentReference>();
		assignments = unit.getAssignments();
		if (assignments == null)
			assignments = new ArrayList<AssignmentReference>();
		assignmentReference.setAssignmentId(assignmentId);
		assignmentReference.setAssignmentName(assignmentName);
		assignmentReference.setActive(true);
		assignments.add(assignmentReference);
		return assignments;
	}

	public Assignment updateAssignment(Assignment assignment) {
		Assignment assignment0 = assignmentInterface.findById(assignment.getAssignmentId()).get();
		if (assignment.getAssignmentName() != null) {
			assignment0.setAssignmentName(assignment.getAssignmentName());
			if(unitInterface.findById(assignment0.getUnitReference().getUnitId()).isPresent()) {
			Unit unit = unitInterface.findById(assignment0.getUnitReference().getUnitId()).get();
			List<AssignmentReference> assignmentReferences = unit.getAssignments().stream().map(unitReference -> {
				if (unitReference.getAssignmentId().equals( assignment.getAssignmentId())) {
					unitReference.setAssignmentName(assignment.getAssignmentName());
				}
				return unitReference;
			}).collect(Collectors.toList());
			unit.setAssignments(assignmentReferences);
			unitInterface.save(unit);
			}
		}
		if(assignment.getValidOnwards()!=null)
		{
			assignment0.setValidOnwards(assignment.getValidOnwards());
			assignmentInterface.save(assignment0);
		}
		if(assignment.getValidUpto()!=null)
		{
			assignment0.setValidUpto(assignment.getValidUpto());
			assignmentInterface.save(assignment0);
		}
		assignmentInterface.save(assignment0);
		return assignment0;
	}

	public Assignment getAssignment(String assignmentid, String studyGuideId, String unitId) {
		System.out.println(assignmentid);
		System.out.println(assignmentInterface.findById(assignmentid));
		if (assignmentInterface.findById(assignmentid).isPresent()) {
			Assignment assignment = assignmentInterface.findById(assignmentid).get();
			if (assignment.getStudyGuideReference().getStudyGuideId().equals(studyGuideId)
					&& assignment.getUnitReference().getUnitId().equals(unitId))
				return assignment;
			return assignment;
		} else
			return null;
	}

}
