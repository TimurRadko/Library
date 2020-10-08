package com.epam.library.data;

import com.epam.library.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

public class FileDataAcquirerTest {
    private static final String FILE_PATH = "src/test/resources/test_data.txt";
    private static final String EXPECTED_DATA = "Carrie King S. 1976 Thriller\n" +
            "The Shining King S. 1980 Thriller\n" +
            "A Game of Thrones Martin G. 1996 Fantasy\n" +
            "A Feast for Crows Martin G. 2005 Fantasy";
    private static final String FAILED_FILE_PATH = "src/test/resources/failed.txt";

    @Test
    public void testReadShouldCorrectReadIfFileExists() throws DataException {
        FileDataAcquirer dataAcquirer = new FileDataAcquirer(FILE_PATH);
        String readingData = dataAcquirer.read();
        Assert.assertNotNull(EXPECTED_DATA, readingData);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowDataExceptionIfFileNotExists() throws DataException {
        FileDataAcquirer dataAcquirer = new FileDataAcquirer(FAILED_FILE_PATH);
        String readingData = dataAcquirer.read();
    }
}
