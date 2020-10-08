package com.epam.library.view.factory;

import com.epam.library.view.BooksPrinter;
import org.junit.Assert;
import org.junit.Test;

public class FileBooksPrintFactoryTest {

    @Test
    public void testCreateShouldCreateFileBooksPrinter() {
        BooksPrinterFactory printerFactory = new FileBooksPrinterFactory();
        BooksPrinter booksPrinter = printerFactory.create();
        Assert.assertNotNull(booksPrinter);
    }
}
