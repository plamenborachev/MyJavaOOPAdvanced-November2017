package p01Database.tests;

import org.junit.Assert;
import org.junit.Test;
import p01Database.Database;
import p01Database.DatabaseImpl;

import javax.naming.OperationNotSupportedException;

public class Tests {

    private static final Integer[] INTEGERS_MORE_THAN_MAX_CAPACITY = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    private static final Integer[] CORRECT_NUMBER_OF_INTEGERS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final Integer[] MAX_CAPACITY_INTEGERS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    private static final int ONE_NUMBER = 1;

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNoIntegers() throws OperationNotSupportedException {
        Database db = new DatabaseImpl();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreThanMaxIntegers() throws OperationNotSupportedException {
        Database db = new DatabaseImpl(INTEGERS_MORE_THAN_MAX_CAPACITY);
    }

    @Test
    public void testConstructorWithCorrectNumberOfIntegeres() throws OperationNotSupportedException {
        Database db = new DatabaseImpl(CORRECT_NUMBER_OF_INTEGERS);
        Assert.assertEquals("", CORRECT_NUMBER_OF_INTEGERS.length, db.getNumbers().length);
    }

    @Test
    public void testGetNumbers() throws OperationNotSupportedException {
        Database db = new DatabaseImpl(CORRECT_NUMBER_OF_INTEGERS);
        Assert.assertEquals("Incorrect numbers", CORRECT_NUMBER_OF_INTEGERS.length, db.getNumbers().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNumbersWithNullElement() throws OperationNotSupportedException {
        Database db = new DatabaseImpl(CORRECT_NUMBER_OF_INTEGERS);
        db.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNumbersToFullCollection() throws OperationNotSupportedException {
        Database db = new DatabaseImpl(MAX_CAPACITY_INTEGERS);
        db.add(1);
    }

    @Test
    public void testAddNumbersToNotFullCollectionWithCorrectInteger() throws OperationNotSupportedException {
        Database db = new DatabaseImpl(ONE_NUMBER);
        db.add(ONE_NUMBER);
        Assert.assertEquals("Wrong numbers length", ONE_NUMBER + 1, db.getNumbers().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyCollection() throws OperationNotSupportedException {
        Database db = new DatabaseImpl();
        db.remove();
    }

    @Test
    public void testRemoveElementFromCollection() throws OperationNotSupportedException {
        Database db = new DatabaseImpl(CORRECT_NUMBER_OF_INTEGERS);
        db.remove();
        Assert.assertEquals("", CORRECT_NUMBER_OF_INTEGERS.length - 1, db.getNumbers().length);
    }
}
