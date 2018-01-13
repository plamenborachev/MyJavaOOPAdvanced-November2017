package p01Weekdays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WeeklyCalendar {
    private List<WeeklyEntry> weeklySchedule;

    public WeeklyCalendar() {
        this.weeklySchedule = new ArrayList<>();
    }

    public void addEntry(String weekday, String notes){
        this.weeklySchedule.add(new WeeklyEntry(weekday, notes));
    }

    public Iterable<WeeklyEntry> getWeeklySchedule(){
        return this.weeklySchedule.stream()
                .sorted(Comparator.comparing(WeeklyEntry::getWeekday))
                .collect(Collectors.toList());
    }
}
