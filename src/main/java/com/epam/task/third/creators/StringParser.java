package com.epam.task.third.creators;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    private final static String SPACE_TO_SPLIT = " ";

    public List<Integer> parse(String data){
        List<Integer> listOfNumbers = new ArrayList<>();
        String[] parts = data.split(SPACE_TO_SPLIT);
        for (String part : parts) {
            int number = Integer.parseInt(part);
            listOfNumbers.add(number);
        }
        return listOfNumbers;
    }
}
