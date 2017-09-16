package com.epamlabs.lab1.services;

import com.epamlabs.lab1.entities.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UnitReaderService {

    private final String DATAPATH = "src/com/epamlabs/lab1/data.json";

    public App getData(){
        return parseAppDataFromJSON(readJSON());
    }

    private JSONObject readJSON(){
        StringBuilder json = new StringBuilder();
        try {
            Scanner jsonin = new Scanner(new File(this.DATAPATH));
            while(jsonin.hasNextLine()){
                json.append(jsonin.nextLine());
            }
        } catch (FileNotFoundException ex){
            System.err.println("Missing data.txt file at " + this.DATAPATH);
        }
        return (JSONObject) JSONValue.parse(json.toString());
    }

    private App parseAppDataFromJSON(JSONObject data){
        JSONArray universitiesJSON = (JSONArray) data.get("universities");
        ArrayList<University> universities = new ArrayList<>();
        for(Object object: universitiesJSON){
            universities.add(parseUniversityFromJSON((JSONObject)object));
        }
        return new App(universities);
    }

    private University parseUniversityFromJSON(JSONObject university){
        JSONArray facultiesJSON = (JSONArray) university.get("faculties");
        ArrayList<Faculty> faculties = new ArrayList<>();
        for(Object facultyObject : facultiesJSON){
            faculties.add(parseFacultyFromJSON((JSONObject)facultyObject));
        }
        return new University(
                (String)university.get("name"),
                faculties
        );
    }

    private Faculty parseFacultyFromJSON(JSONObject faculty){
        JSONArray groupJSON = (JSONArray) faculty.get("groups");
        ArrayList<Group> groups = new ArrayList<>();
        for(Object groupObject : groupJSON){
            groups.add(parseGroupFromJSON((JSONObject)groupObject));
        }
        return new Faculty(
                (String)faculty.get("name"),
                groups
        );
    }

    private Group parseGroupFromJSON(JSONObject group){
        JSONArray studentJSON = (JSONArray) group.get("students");
        ArrayList<Student> students = new ArrayList<>();
        for(Object studentObject: studentJSON){
            students.add(parseStudentFromJSON((JSONObject)studentObject));
        }
        return new Group(
                ((Long)group.get("course")).intValue(),
                (String)group.get("number"),
                students
        );
    }

    private Student parseStudentFromJSON(JSONObject student){
        JSONArray subjectJSON = (JSONArray) student.get("subjectMarks");
        ArrayList<SubjectMarks> subjects= new ArrayList<>();
        for(Object subjectObject: subjectJSON){
            subjects.add(parseSubjectFromJSON((JSONObject)subjectObject));
        }
        return new Student(
                (String)student.get("name"),
                subjects
        );
    }

    private SubjectMarks parseSubjectFromJSON(JSONObject subject){
        JSONArray semMarksJSON = (JSONArray) subject.get("semMarks");
        ArrayList<Integer> semMarks = new ArrayList<>();
        for(Object markObject:semMarksJSON ){
            semMarks.add(((Long)markObject).intValue());
        }
        return new SubjectMarks(
                (String)subject.get("name"),
                ((Long)subject.get("examMark")).intValue(),
                semMarks
        );
    }
}
