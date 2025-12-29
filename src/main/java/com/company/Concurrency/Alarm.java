package com.company.Concurrency;

import java.time.LocalDateTime;

public class Alarm {

    private LocalDateTime dateTime;

    private String reminder;

    public Alarm(LocalDateTime dateTime, String reminder) {
        this.dateTime = dateTime;
        this.reminder = reminder;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
