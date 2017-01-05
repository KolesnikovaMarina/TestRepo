package Testing;

import Entities.Event;
import Entities.Place;
import Entities.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Marina on 15.12.2016.
 */
public class Test {
    public static void printEvent(Event event){
        System.out.println( "Title: " + event.getTitle());
        System.out.println( "Begin Date: " + Event.formatter.format(event.getBeginDate()));
        System.out.println( "End Date: " + Event.formatter.format(event.getEndDate()));
        System.out.println( "Creator: " + event.getCreator().getName());
        System.out.println( "Priority: " + event.getPriority());
        System.out.println( "Place: " + event.getPlace());
        System.out.println( "Participants: ");
        for(String user:event.getParticipantsNames()){
            System.out.print(user+"; ");
        }
        System.out.print( "\n ------------------------------------------- \n");
    }
    public static void main(String[] args){

        ArrayList<String> part1 = new ArrayList<String>();
        part1.add("Kovolev Vladislav");
        part1.add("Makarov Roman");
        part1.add("Agapov Maksim");
        Event.addEvent("General meeting","2016-12-29 15:00","2016-12-29 16:00",
                "ACCOUNTHALL", part1, User.getUserByName("Kovolev Vladislav"),1);

        part1 = new ArrayList<String>();
        part1.add("Shatov Roman");
        part1.add("Agapov Sergey");
        Event.addEvent("Discussion meeting","2016-12-29 15:00","2016-12-29 19:00",
                "DEVHALL", part1, User.getUserByName("Shatov Roman"),2);

        part1 = new ArrayList<String>();
        part1.add("Kolesnikov Victor");
        part1.add("Korolkov Maksim");
        part1.add("Kutin Victor");
        part1.add("Makarov Roman");
        Event.addEvent("Global meeting","2016-12-29 19:00","2016-12-29 22:20",
                "CONFERENCEHALL", part1, User.getUserByName("Kolesnikov Victor"),4);

        part1 = new ArrayList<String>();
        part1.add("Kolesnikov Victor");
        part1.add("Kutin Victor");
        part1.add("Olhovik Alexander");
        part1.add("Kovolev Vladislav");
        Event.addEvent("Morning meeting","2016-12-30 7:00","2016-12-30 9:50",
                "CONFERENCEHALL", part1, User.getUserByName("Kolesnikov Victor"),3);

        part1 = new ArrayList<String>();
        part1.add("Agapov Sergey");
        part1.add("Agapov Maksim");
        Event.addEvent("Project-1 meeting", "2016-12-30 09:30","2016-12-30 11:30",
                "DEVHALL", part1, User.getUserByName("Kolesnikova Marina"),2);

        part1 = new ArrayList<String>();
        part1.add("Kovolev Vladislav");
        Event.addEvent("Business trip", "2016-12-30 12:30","2016-12-31 18:30",
                "OTHER", part1, User.getUserByName("Kolesnikov Victor"),3);

        part1 = new ArrayList<String>();
        part1.add("Kutin Victor");
        part1.add("Makarov Roman");
        part1.add("Olhovik Alexander");
        Event.addEvent("Project-2 meeting", "2016-12-30 19:30","2016-12-30 21:30",
                "ITHALL", part1, User.getUserByName("Makarov Roman"),1);

        part1 = new ArrayList<String>();
        part1.add("Agapov Sergey");
        part1.add("Kolesnikov Victor");
        part1.add("Makarov Roman");
        part1.add("Olhovik Alexander");
        part1.add("Kutin Victor");
        part1.add("Kovolev Vladislav");
        part1.add("Kolesnikova Marina");
        part1.add("Korolkov Maksim");
        Event.addEvent("New Year celebration", "2016-12-31 19:00","2016-12-31 23:30",
                "CONFERENCEHALL", part1, User.getUserByName("Kolesnikov Victor"),5);
        try{
        Date bDate = Event.formatter.parse("2016-12-29 01:00");
        Date eDate = Event.formatter.parse("2016-12-29 23:00");
        Calendar c = Calendar.getInstance();
        while (bDate.compareTo(eDate)<=0){
            Event.updateEventsList(bDate);
            System.out.println(Event.formatter.format(bDate));
            for(Event event : Event.getPastedEvents()){
                printEvent(event);
            }
            System.out.print( "\n |||||||||||||||||||||||||||||||| \n");
            c.setTime(bDate);
            c.add(Calendar.HOUR,1);
            bDate = c.getTime();
        }
        }catch(java.text.ParseException e){
            System.out.print(e);
        }

    }
}

