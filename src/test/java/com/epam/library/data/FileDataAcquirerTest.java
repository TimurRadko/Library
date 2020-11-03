package com.epam.library.data;

import com.epam.library.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FileDataAcquirerTest {
    private static final String VALID_DATA_FILE = "src/test/resources/test_data.txt";
    private static final String FAILED_FILE_PATH = "src/test/resources/failed.txt";
    private static final int FIRST_STRING_INDEX = 0;
    private static final String EXPECTED_STRING = "Carrie,King S.,1976,Thriller";

    @Test
    public void testReadShouldCorrectReadIfFileExists() throws DataException {
        FileDataAcquirer dataAcquirer = new FileDataAcquirer();
        List<String> lines = dataAcquirer.read(VALID_DATA_FILE);
        String actualString = lines.get(FIRST_STRING_INDEX);
        Assert.assertEquals(EXPECTED_STRING, actualString);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowDataExceptionIfFileNotExists() throws DataException {
        FileDataAcquirer dataAcquirer = new FileDataAcquirer();
        dataAcquirer.read(FAILED_FILE_PATH);
    }
}
