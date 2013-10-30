public interface LectureVisitor {
	public void visitLecture();
}

public class Person implements LectureVisitor {
	
	private LectureVisitor m_visitorBehaviour;
	
	public void visitLecture() {
		m_visitorBehaviour.visitLecture();
	}

	public void switchToStudent() {
		m_visitorBehaviour = new StudentBehaviour();
	}

	public void switchToTeacher() {
		m_visitorBehaviour = new TeacherBehaviour();
	}
}

public class StudentBehaviour implements LectureVisitor {
	public void visitLecture() {
		// <послушать и поспать>
	}
}

public class TeacherBehaviour implements LectureVisitor {
	public void visitLecture() {
		// <рассказать и разбудить>
	}
}

public class StafferBehaviour implements LectureVisitor {
	public void visitLecture() {
		// <принести ноутбук>
	}
}