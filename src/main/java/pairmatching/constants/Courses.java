package pairmatching.constants;

public enum Courses {
    FRONTEND("프론트엔드"),
    BACKEND("백엔드");

    private final String courseName;

    Courses(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}
