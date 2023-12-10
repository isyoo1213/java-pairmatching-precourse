package pairmatching.utils;

import pairmatching.constants.Courses;
import pairmatching.constants.ExceptionMessages;
import pairmatching.constants.FileConstants;
import pairmatching.model.Crew;
import pairmatching.model.Crews;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrewFileReader {

    public Crews readCrewFile(FileConstants fileInfo) {
        return convertFileToCrews(fileInfo.getCourse(), fileInfo.getPath());
    }

    private Crews convertFileToCrews(Courses course, String path) {
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<Crew> crews = new ArrayList<>();
            String crewName;
            while ((crewName = bufferedReader.readLine()) != null) {
                Crew crew = new Crew(crewName, course.getCourseName());
                crews.add(crew);
            }
            return new Crews(course, crews);
        } catch (Exception e) {
            ExceptionMessages.WRONG_FILE_FORMAT.throwException();
            return null;
        }
    }
}
