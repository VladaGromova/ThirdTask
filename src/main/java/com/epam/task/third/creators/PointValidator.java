package com.epam.task.third.creators;

import java.util.List;

public class PointValidator extends Validator {

    public boolean isValid(List<Integer> data) {
        return data.size()==3;
    }
}
