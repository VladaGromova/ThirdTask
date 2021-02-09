package com.epam.task.third.logic;

import com.epam.task.third.creators.PyramidCreator;
import com.epam.task.third.creators.PyramidValidator;
import com.epam.task.third.creators.StringParser;
import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entities.Pyramid;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class PyramidCreatorTest{

    private final static String FIRST_STRING = "2 7 4 5 1 3 9 5 7 3 6 3";
    private final static String SECOND_STRING = "2k 7 4 5 1 3 9 5 7 3 6 3";
    private final static String THIRD_STRING = "5 1 3 9 5 7 3 6 3";
    private final static String FOURTH_STRING = " ";
    private final static String FIFTH_STRING = "1 6 4 6 1 6 9 4 6 2 6 0";

    private final static List<Integer> FIRST_LIST = Arrays.asList(2, 7, 4, 5, 1, 3, 9, 5, 7, 3, 6, 3);
    private final static List<Integer> SECOND_LIST = Arrays.asList(5, 1, 3, 9, 5, 7, 3, 6, 3);
    private final static List<Integer> THIRD_LIST = Arrays.asList(1, 6, 4, 6, 1, 6, 9, 4, 6, 2, 6, 0);

    private final static List<String> TEST_ARRAY = Arrays.asList(FIRST_STRING, SECOND_STRING, THIRD_STRING, FOURTH_STRING,FIFTH_STRING);
    private final static String TEST_DATA = "src/test/resources/pyramids.txt";

    private static DataReader reader;
    private static StringParser parser;
    private static PyramidValidator validator;
    private static PyramidCreator creator;

    @Test
    public void testProcess() throws DataException {

        reader = Mockito.mock(DataReader.class);
        when(reader.readData(anyString())).thenReturn(TEST_ARRAY);

        validator = Mockito.mock(PyramidValidator.class);
        when(validator.isOnlyDigits(FIRST_STRING)).thenReturn(true);
        when(validator.isOnlyDigits(SECOND_STRING)).thenReturn(false);
        when(validator.isOnlyDigits(THIRD_STRING)).thenReturn(true);
        when(validator.isOnlyDigits(FOURTH_STRING)).thenReturn(false);
        when(validator.isOnlyDigits(FIFTH_STRING)).thenReturn(true);

        parser = Mockito.mock(StringParser.class);
        when(parser.parse(FIRST_STRING)).thenReturn(FIRST_LIST);
        when(parser.parse(THIRD_STRING)).thenReturn(SECOND_LIST);
        when(parser.parse(FIFTH_STRING)).thenReturn(THIRD_LIST);

        when(validator.isValid(FIRST_LIST)).thenReturn(true);
        when(validator.isValid(SECOND_LIST)).thenReturn(false);
        when(validator.isValid(THIRD_LIST)).thenReturn(true);

        creator = new PyramidCreator(reader, parser, validator);

        List<Pyramid> expected = Arrays.asList(new Pyramid(FIRST_LIST) , new Pyramid(THIRD_LIST));

        List<Pyramid> actual = creator.process(TEST_DATA);

        Assert.assertEquals(expected, actual);
    }
}
