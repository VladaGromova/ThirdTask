package com.epam.task.third.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private  final static String TEST_DATA = "src/test/resources/points.txt";
    private  final static String FALSE_DATA = "src/test/resources/out.txt";
    private final static List EXPECTED = Arrays.asList("0 0 0 0", "1t 2 3", "1 3 5", "5 4 7 9");
    private final DataReader reader = new DataReader();

    @Test
    public void testReadDataShouldReadLinesFromFileWhenFileExists() throws DataException {
        List<String> actual = reader.readData(TEST_DATA);
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test (expected = DataException.class)
    public void testReadDataShouldThrowExceptionWhenFileDoesNotExist() throws DataException {
        List<String> actual = reader.readData(FALSE_DATA);
    }
}
