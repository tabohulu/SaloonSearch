package com.creativediligence.saloonsearch;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Arrays;

public class Helper_TestData {

    static ArrayList<String> hairStyles = new ArrayList<>(Arrays.asList("--Select Style--", "Cornrows", "Alata", "Box Braids", "Weave-on", "Twists",
            "Twists(Natural)"));

    static ArrayList<String> locations = new ArrayList<>(Arrays.asList("--Select Location--", "Ayeduase", "Kotei", "Tech", "Nungua", "Teshie",
            "Ejisu"));

    static ArrayList<String> dummyDataNames = new ArrayList<>(Arrays.asList("Saloon1", "Saloon2", "Saloon3", "Saloon4", "Saloon5", "Saloon6", "Saloon7", "Saloon8"));
    static ArrayList<String> dummyDataLocations = new ArrayList<>(Arrays.asList("Ayeduase", "Kotei", "Kotei", "Tech", "Tech", "Nungua", "Teshie", "Ejisu"));
    static ArrayList<String> dummyDataRatings = new ArrayList<>(Arrays.asList("5", "5", "4", "3", "2", "1", "4", "3"));

    static ArrayList<String> tabtitlesHomepage = new ArrayList<>(Arrays.asList("Discover", "Appointments", "My Saloons"));
    static ArrayList<String> tabtitlesSaloonDetails = new ArrayList<>(Arrays.asList("Services", "Calendar", "Reviews"));
    static ArrayList<Integer> tabImagesHomepage = new ArrayList<>(Arrays.asList(R.drawable.ic_search_small, R.drawable.ic_appointments, R.drawable.ic_mysaloons));
    static ArrayList<String> saloonServices = new ArrayList<>(Arrays.asList("Washing", "Conditioning", "Natural Hair Services", "ETC"));
    static ArrayList<String> reviewerName = new ArrayList<>(Arrays.asList("User1", "User2", "User3", "User4", "User5", "User6", "User7", "User8", "User9", "User10"));
    static ArrayList<String> reviewerReviews = new ArrayList<>(Arrays.asList("Review1", "Review2", "Review3", "Review4", "Review5", "Review6",
            "Review7", "Review8", "Review9", "Review10"));
    static ArrayList<String> times = new ArrayList<>(Arrays.asList("9:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00"
            , "13:00-14:00", "14:00-15:00", "15:00-16:00", "16:00-17:00", "17:00-18:00"));

    static ArrayList<Boolean> availability=new ArrayList<Boolean>(Arrays.asList(Boolean.FALSE,Boolean.TRUE,Boolean.TRUE,Boolean.FALSE
            ,Boolean.FALSE,Boolean.TRUE,Boolean.FALSE,Boolean.TRUE,Boolean.FALSE));

    static ArrayList<String> daysWeek=new ArrayList<>(Arrays.asList("Mon","Tue","Wed","Thu","Fri","Sat","Sun"));

    static ArrayList<String> daysMonth=new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7"));




}
