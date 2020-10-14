package com.epam.library.data.factory;

import com.epam.library.data.BooksField;
import com.epam.library.data.specification.Specification;
import org.junit.Assert;
import org.junit.Test;

public class SpecificationFactoryImplTest {

    @Test
    public void testCreateShouldReturnEntity() {
        SpecificationFactory factory = new SpecificationFactoryImpl();
        Specification<String> specification = factory.create(BooksField.AUTHOR_NAME);
        Assert.assertNotNull(specification);
    }
}
