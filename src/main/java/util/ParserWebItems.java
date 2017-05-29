package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParserWebItems {

    public LocalDate parseStringToLocalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        formatter = formatter.withLocale(Locale.ENGLISH);
        LocalDate res = LocalDate.parse(date, formatter);
        return res;
    }
}
