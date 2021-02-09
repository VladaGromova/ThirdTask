package com.epam.task.third.logic;

import com.epam.task.third.creators.PointCreator;
import com.epam.task.third.creators.PyramidValidator;
import com.epam.task.third.creators.StringParser;
import com.epam.task.third.data.DataException;
import com.epam.task.third.data.DataReader;
import com.epam.task.third.entities.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class PointCreatorTest {
    private final static String FIRST_STRING = "0 0 0 0";
    private final static String SECOND_STRING = "1t 2 3";
    private final static String THIRD_STRING = "1 3 5";
    private final static String FOURTH_STRING = "5 4 7 9";

    private final static List<Integer> FIRST_LIST = Arrays.asList(0, 0, 0, 0);
    private final static List<Integer> SECOND_LIST = Arrays.asList(1, 3, 5);
    private final static List<Integer> THIRD_LIST = Arrays.asList(5, 4, 7, 9);

    private final static List<String> TEST_ARRAY = Arrays.asList(FIRST_STRING, SECOND_STRING, THIRD_STRING, FOURTH_STRING);
    private final static String TEST_DATA = "src/test/resources/points.txt";

    private static DataReader reader;
    private static StringParser parser;
    private static PyramidValidator validator;
    private static PointCreator creator;

    @Test
    public void testProcess() throws DataException {

        reader = Mockito.mock(DataReader.class);
        when(reader.readData(anyString())).thenReturn(TEST_ARRAY);

        validator = Mockito.mock(PyramidValidator.class);
        when(validator.isOnlyDigits(FIRST_STRING)).thenReturn(true);
        when(validator.isOnlyDigits(SECOND_STRING)).thenReturn(false);
        when(validator.isOnlyDigits(THIRD_STRING)).thenReturn(true);
        when(validator.isOnlyDigits(FOURTH_STRING)).thenReturn(true);

        parser = Mockito.mock(StringParser.class);
        when(parser.parse(FIRST_STRING)).thenReturn(FIRST_LIST);
        when(parser.parse(THIRD_STRING)).thenReturn(SECOND_LIST);
        when(parser.parse(FOURTH_STRING)).thenReturn(THIRD_LIST);

        when(validator.isValid(FIRST_LIST)).thenReturn(true);
        when(validator.isValid(SECOND_LIST)).thenReturn(false);
        when(validator.isValid(THIRD_LIST)).thenReturn(true);

        creator = new PointCreator(reader, parser, validator);

        List<Point> expected = Arrays.asList(new Point(FIRST_LIST) , new Point(THIRD_LIST));

        List<Point> actual = creator.process(TEST_DATA);

        Assert.assertEquals(expected, actual);
    }
}
