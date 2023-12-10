package pairmatching.constants;

public enum FileConstants {
    BACKEND_CREW_NAME(Courses.BACKEND, "src/main/resources/backend-crew.md"),
    FRONTEND_CREW_NAME(Courses.BACKEND, "src/main/resources/frontend-crew.md");

    private final Courses course;
    private final String path;

    FileConstants(Courses course, String path) {
        this.course = course;
        this.path = path;
    }

    public Courses getCourse() {
        return course;
    }

    public String getPath() {
        return path;
    }
}
