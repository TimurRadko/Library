package com.epam.library.view.factory;

import com.epam.library.view.BooksPrinter;
import org.junit.Assert;
import org.junit.Test;

public class ConsoleBooksPrintFactoryTest {

    @Test
    public void testCreateShouldCreateEntity() {
        BooksPrinterFactory factory = new ConsoleBooksPrinterFactory();
        BooksPrinter printer = factory.create();
        Assert.assertNotNull(printer);
    }
}
