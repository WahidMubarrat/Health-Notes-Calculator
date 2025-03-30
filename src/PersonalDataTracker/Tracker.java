package PersonalDataTracker;

import java.io.*;
import java.time.LocalDate;

 public class Tracker implements Trackable {
    protected String loggedInUser;
    protected String filename;

    public Tracker(String loggedInUser, String filename) {
        this.loggedInUser = loggedInUser;
        this.filename = filename;
    }

     @Override
     public void addRecord() {

     }

     @Override
     public void viewHistory() {

     }
 }