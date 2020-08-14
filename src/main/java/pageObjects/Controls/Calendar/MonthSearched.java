package pageObjects.Controls.Calendar;

import utils.DriverManager;
import utils.DriverType;

public class MonthSearched {

    public String monthSearched(String month){

        String monthSearched = "none";

        switch (month){
            case "January":
                monthSearched = "Jan";
                break;

            case "February":
                monthSearched = "Feb";
                break;

            case "March":
                monthSearched = "Mar";
                break;

            case "April":
                monthSearched = "Apr";
                break;

            case "May":
                monthSearched = "May";
                break;

            case "June":
                monthSearched = "Jun";
                break;

            case "July":
                monthSearched = "Jul";
                break;

            case "August":
                monthSearched = "Aug";
                break;

            case "September":
                monthSearched = "Sep";
                break;

            case "October":
                monthSearched = "Oct";
                break;

            case "November":
                monthSearched = "Nov";
                break;

            case "December":
                monthSearched = "Dec";
                break;
        }
        return monthSearched;
    }
}
