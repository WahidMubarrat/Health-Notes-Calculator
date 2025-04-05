package Calculation;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract  class ActivityTracker implements Activity {
    protected LocalDateTime startTime;
    protected LocalDateTime endTime;
    protected String username;
    protected String fileName;

    public ActivityTracker(String username, String fileName) {
        this.username = username;
        this.fileName = fileName;
    }

    @Override
    public void startActivity() {
    }

    @Override
    public void stopActivity() {

    }
    private void saveDurationToFile() {
    }

    @Override
    public void viewRecords() {

    }
}
