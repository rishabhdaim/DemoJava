package demo.java;

public enum DayOfWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    public static DayOfWeek getRandomDay() {
        return values()[(int) (Math.random() * values().length)];
    }
}
