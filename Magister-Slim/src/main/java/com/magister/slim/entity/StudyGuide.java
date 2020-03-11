package com.magister.slim.entity;

import java.util.Date; 
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magister.slim.references.CourseReference;
import com.magister.slim.references.OfferingLevelReference;
import com.magister.slim.references.OfferingReference;
import com.magister.slim.references.StudentReference;
import com.magister.slim.references.TeacherReference;
import com.magister.slim.references.ThemeReference;
import com.magister.slim.references.UnitReference;

@Document
public class StudyGuide {

	@Id
	private String studyGuideId;
	private String studyGuideName;
	private TeacherReference teacherReference;
	private List<ThemeReference> themes;
	private List<UnitReference> units;
	private List<StudentReference> students;
	private CourseReference courseReference;
	private OfferingReference offeringReference;
	private OfferingLevelReference offeringLevelReference;
	private Date validOnwards;
	private Date validUpto;
	private boolean isDeleted;
	private boolean active;
	
	public StudyGuide() {
	}
	public StudyGuide( String studyGuideName, CourseReference courseReference, OfferingReference offeringReference,
			OfferingLevelReference offeringLevelReference, Date validOnwards, Date validUpto, boolean isDeleted,
			boolean active) {
		super();
		this.studyGuideName = studyGuideName;
		this.courseReference = courseReference;
		this.offeringReference = offeringReference;
		this.offeringLevelReference = offeringLevelReference;
		this.validOnwards = validOnwards;
		this.validUpto = validUpto;
		this.isDeleted = isDeleted;
		this.active = active;
	}
	public StudyGuide( String studyGuideName,boolean isDeleted,boolean active) {
		super();
		this.studyGuideName = studyGuideName;
		this.isDeleted = isDeleted;
		this.active = active;
	}

	public StudyGuide( String studyGuideName, TeacherReference teacherReference,
			List<ThemeReference> themes, List<UnitReference> units, List<StudentReference> students,
			CourseReference courseReference, OfferingReference offeringReference,
			OfferingLevelReference offeringLevelReference, Date validOnwards, Date validUpto, boolean isDeleted,
			boolean active) {
		super();
		this.studyGuideName = studyGuideName;
		this.teacherReference = teacherReference;
		this.themes = themes;
		this.units = units;
		this.students = students;
		this.courseReference = courseReference;
		this.offeringReference = offeringReference;
		this.offeringLevelReference = offeringLevelReference;
		this.validOnwards = validOnwards;
		this.validUpto = validUpto;
		this.isDeleted = isDeleted;
		this.active = active;
	}

	public void setStudyGuideId(String studyGuideId) {
		this.studyGuideId = studyGuideId;
	}

	public String getStudyGuideName() {
		return studyGuideName;
	}

	public void setStudyGuideName(String studyGuideName) {
		this.studyGuideName = studyGuideName;
	}

	public TeacherReference getTeacherReference() {
		return teacherReference;
	}

	public void setTeacherReference(TeacherReference teacherReference) {
		this.teacherReference = teacherReference;
	}

	public List<ThemeReference> getThemes() {
		return themes;
	}

	public void setThemes(List<ThemeReference> themes) {
		this.themes = themes;
	}

	public List<UnitReference> getUnits() {
		return units;
	}

	public void setUnits(List<UnitReference> units) {
		this.units = units;
	}

	public List<StudentReference> getStudents() {
		return students;
	}

	public void setStudents(List<StudentReference> students) {
		this.students = students;
	}

	public CourseReference getCourseReference() {
		return courseReference;
	}

	public void setCourseReference(CourseReference courseReference) {
		this.courseReference = courseReference;
	}

	public OfferingReference getOfferingReference() {
		return offeringReference;
	}

	public void setOfferingReference(OfferingReference offeringReference) {
		this.offeringReference = offeringReference;
	}

	public OfferingLevelReference getOfferingLevelReference() {
		return offeringLevelReference;
	}

	public void setOfferingLevelReference(OfferingLevelReference offeringLevelReference) {
		this.offeringLevelReference = offeringLevelReference;
	}

	public Date getValidOnwards() {
		return validOnwards;
	}

	public void setValidOnwards(Date validOnwards) {
		this.validOnwards = validOnwards;
	}

	public Date getValidUpto() {
		return validUpto;
	}

	public void setValidUpto(Date validUpto) {
		this.validUpto = validUpto;
	}
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getStudyGuideId() {
		return studyGuideId;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (active ? 1231 : 1237);
		result = prime * result + ((courseReference == null) ? 0 : courseReference.hashCode());
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((offeringLevelReference == null) ? 0 : offeringLevelReference.hashCode());
		result = prime * result + ((offeringReference == null) ? 0 : offeringReference.hashCode());
		result = prime * result + ((students == null) ? 0 : students.hashCode());
		result = prime * result + ((studyGuideId == null) ? 0 : studyGuideId.hashCode());
		result = prime * result + ((studyGuideName == null) ? 0 : studyGuideName.hashCode());
		result = prime * result + ((teacherReference == null) ? 0 : teacherReference.hashCode());
		result = prime * result + ((themes == null) ? 0 : themes.hashCode());
		result = prime * result + ((units == null) ? 0 : units.hashCode());
		result = prime * result + ((validOnwards == null) ? 0 : validOnwards.hashCode());
		result = prime * result + ((validUpto == null) ? 0 : validUpto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudyGuide other = (StudyGuide) obj;
		if (active != other.active)
			return false;
		if (courseReference == null) {
			if (other.courseReference != null)
				return false;
		} else if (!courseReference.equals(other.courseReference))
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (offeringLevelReference == null) {
			if (other.offeringLevelReference != null)
				return false;
		} else if (!offeringLevelReference.equals(other.offeringLevelReference))
			return false;
		if (offeringReference == null) {
			if (other.offeringReference != null)
				return false;
		} else if (!offeringReference.equals(other.offeringReference))
			return false;
		if (students == null) {
			if (other.students != null)
				return false;
		} else if (!students.equals(other.students))
			return false;
		if (studyGuideId == null) {
			if (other.studyGuideId != null)
				return false;
		} else if (!studyGuideId.equals(other.studyGuideId))
			return false;
		if (studyGuideName == null) {
			if (other.studyGuideName != null)
				return false;
		} else if (!studyGuideName.equals(other.studyGuideName))
			return false;
		if (teacherReference == null) {
			if (other.teacherReference != null)
				return false;
		} else if (!teacherReference.equals(other.teacherReference))
			return false;
		if (themes == null) {
			if (other.themes != null)
				return false;
		} else if (!themes.equals(other.themes))
			return false;
		if (units == null) {
			if (other.units != null)
				return false;
		} else if (!units.equals(other.units))
			return false;
		if (validOnwards == null) {
			if (other.validOnwards != null)
				return false;
		} else if (!validOnwards.equals(other.validOnwards))
			return false;
		if (validUpto == null) {
			if (other.validUpto != null)
				return false;
		} else if (!validUpto.equals(other.validUpto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudyGuide [studyGuideId=" + studyGuideId + ", studyGuideName=" + studyGuideName + ", teacherReference="
				+ teacherReference + ", themes=" + themes + ", units=" + units + ", students=" + students
				+ ", courseReference=" + courseReference + ", offeringReference=" + offeringReference
				+ ", offeringLevelReference=" + offeringLevelReference + ", validOnwards=" + validOnwards
				+ ", validUpto=" + validUpto + ", isDeleted=" + isDeleted + ", active=" + active + "]";
	}

	

}
