package cmw.services;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateProcess {
  public LocalDate addDaysSkippingWeekends(LocalDate date, int days) {
    LocalDate result = date;
    int addedDays = 0;
    while (addedDays < days) {
      result = result.plusDays(1);
      if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY
          || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
        ++addedDays;
      }
    }
    return result;
  }
}
