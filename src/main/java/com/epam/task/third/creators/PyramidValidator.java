package com.epam.task.third.creators;

import java.util.List;

public class PyramidValidator extends Validator {

    public boolean isValid(List<Integer> data) {
        return data.size()==12;
    }
}
