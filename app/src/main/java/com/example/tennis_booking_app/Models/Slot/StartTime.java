package com.example.tennis_booking_app.Models.Slot;

public class StartTime {
    private int Ticks,Days,Hours,Milliseconds,Minutes,Seconds,TotalDays,
            TotalHours,TotalMilliseconds,TotalMinutes,TotalSeconds;

    public StartTime(int ticks, int days, int hours, int milliseconds, int minutes, int seconds, int totalDays, int totalHours, int totalMilliseconds, int totalMinutes, int totalSeconds) {
        Ticks = ticks;
        Days = days;
        Hours = hours;
        Milliseconds = milliseconds;
        Minutes = minutes;
        Seconds = seconds;
        TotalDays = totalDays;
        TotalHours = totalHours;
        TotalMilliseconds = totalMilliseconds;
        TotalMinutes = totalMinutes;
        TotalSeconds = totalSeconds;
    }

    public int getTicks() {
        return Ticks;
    }

    public void setTicks(int ticks) {
        Ticks = ticks;
    }

    public int getDays() {
        return Days;
    }

    public void setDays(int days) {
        Days = days;
    }

    public int getHours() {
        return Hours;
    }

    public void setHours(int hours) {
        Hours = hours;
    }

    public int getMilliseconds() {
        return Milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        Milliseconds = milliseconds;
    }

    public int getMinutes() {
        return Minutes;
    }

    public void setMinutes(int minutes) {
        Minutes = minutes;
    }

    public int getSeconds() {
        return Seconds;
    }

    public void setSeconds(int seconds) {
        Seconds = seconds;
    }

    public int getTotalDays() {
        return TotalDays;
    }

    public void setTotalDays(int totalDays) {
        TotalDays = totalDays;
    }

    public int getTotalHours() {
        return TotalHours;
    }

    public void setTotalHours(int totalHours) {
        TotalHours = totalHours;
    }

    public int getTotalMilliseconds() {
        return TotalMilliseconds;
    }

    public void setTotalMilliseconds(int totalMilliseconds) {
        TotalMilliseconds = totalMilliseconds;
    }

    public int getTotalMinutes() {
        return TotalMinutes;
    }

    public void setTotalMinutes(int totalMinutes) {
        TotalMinutes = totalMinutes;
    }

    public int getTotalSeconds() {
        return TotalSeconds;
    }

    public void setTotalSeconds(int totalSeconds) {
        TotalSeconds = totalSeconds;
    }
}
