package util;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class ParserWebItemsTest {

    ParserWebItems parser = new ParserWebItems();

    @Test
    public void testParseStringToLocalDate() {
        String date = "07/26/1982";
        LocalDate act = parser.parseStringToLocalDate(date);
        LocalDate exp = LocalDate.of(1982, Month.JULY, 26);
        Assert.assertEquals(exp, act);
    }
}