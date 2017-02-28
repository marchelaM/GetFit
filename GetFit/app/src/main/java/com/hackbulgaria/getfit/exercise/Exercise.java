package com.hackbulgaria.getfit.exercise;

import java.util.ArrayList;
import java.util.List;



public class Exercise {

    private static List<String> exercises = new ArrayList<>();

    static {
        exercises.add("Burzata stotachka");
        exercises.add("Licevi");
        exercises.add("Bqgane");
    }

    public static List<String> getExercises() {
        return exercises;
    }
}
