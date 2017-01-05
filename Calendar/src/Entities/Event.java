package Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Created by Marina on 12.12.2016.
 */
public class Event {
    private String title;
    private Date beginDate;
    private Date endDate;
    private Place place;
    private ArrayList<User> participants = new ArrayList<User>();
    private User creator;
    private int priority;

    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private static ArrayList<Event> events = new ArrayList<Event>();
    private static ArrayList<Event> pastEvents = new ArrayList<Event>();
    static {
        try {
            ArrayList<User> part1 = new ArrayList<User>();
            part1.add(User.getUserByName("Agapov Sergey"));
            part1.add(User.getUserByName("Kolesnikov Victor"));
            part1.add(User.getUserByName("Olhovik Alexander"));
            events.add(new Event("Casual meeting", formatter.parse("2016-12-29 8:30"),
                    formatter.parse("2016-12-29 9:10"), Place.DEVHALL, part1, User.getUserByName("Kolesnikov Victor"),1));
            events.add(new Event("Developers meeting", formatter.parse("2016-12-29 11:30"),
                    formatter.parse("2016-12-29 12:30"), Place.DEVHALL, part1, User.getUserByName("Kolesnikov Victor"),1));
            part1 = new ArrayList<User>();
            part1.add(User.getUserByName("Agapov Maksim"));
            part1.add(User.getUserByName("Korolkov Maksim"));
            events.add(new Event("Testers meeting", formatter.parse("2016-12-29 12:40"),
                    formatter.parse("2016-12-29 13:30"), Place.TESTINGHALL, part1, User.getUserByName("Agapov Maksim"),2));
            part1= new ArrayList<User>();
            part1.add(User.getUserByName("Korolkov Maksim"));
            part1.add(User.getUserByName("Kolesnikov Victor"));
            part1.add(User.getUserByName("Kolesnikova Marina"));
            part1.add(User.getUserByName("Kovolev Vladislav"));
            part1.add(User.getUserByName("Makarov Roman"));
            events.add(new Event("Leaders meeting", formatter.parse("2016-12-29 13:50"),
                    formatter.parse("2016-12-29 14:30"), Place.CONFERENCEHALL, part1, User.getUserByName("Kolesnikov Victor"),3));


        }
        catch (java.text.ParseException e)
        {

        }
        updateEventsList(new Date());

    }

    public  static void updateEventsList(Date currentDate){
        int i = 0;
        while(i<events.size()){
            if (events.get(i).getEndDate().compareTo(currentDate)<=0)
            {
                pastEvents.add(events.get(i));
                events.remove(i);
            }
            else{
                i++;
            }
        }
    }

    public static ArrayList<Event> getPastedEvents(){
        return  pastEvents;
    }

    public Event(String title, Date beginDate, Date endDate, Place place, ArrayList<User> participants, User creator, int priority) {
        this.title = title;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.place = place;
        this.participants = participants;
        this.creator = creator;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public ArrayList<String> getParticipantsNames(){
        ArrayList<String> pararticipantsNames = new ArrayList<String>();
        for(User user : participants) {
            pararticipantsNames.add(user.getName());
        }
        return pararticipantsNames;
    }

    public void addParticipant(String name){
        User user = User.getUserByName(name);
        if(user!=null)
            participants.add(user);
    }


    private boolean isDateInTime(String date){
        if(date.isEmpty()) return true;
        try {
            Date mdate = formatter.parse(date);
            return beginDate.compareTo(mdate)<=0 && endDate.compareTo(mdate)>=0;
        }catch (java.text.ParseException e){
            return  false;
        }
    }


    private boolean isDateInInterval(String iBeginDate, String iEndDate){
        try {
            Date bdate = formatter.parse(iBeginDate);
            Date edate = formatter.parse(iEndDate);
            return (beginDate.compareTo(edate)<=0)&&(endDate.compareTo(bdate)>=0);
        }catch (java.text.ParseException e){
            return  false;
        }
    }


    private  boolean isContainUser(String userName){
        if(userName.isEmpty()) return true;
        User user = User.getUserByName(userName);
        if(user!=null) {
            return participants.contains(user);
        }
        return false;
    }


    private  boolean isInPlace(String place) {
        if (place.isEmpty()||place.equals(Place.noPlace)) return true;
        return this.place.equals(Place.valueOf(place));
    }



    static public ArrayList<Event> search(String title,String date,String userName,String place) {
        ArrayList<Event> result = new ArrayList<Event>();
        Comparator<Event> c = (e1, e2) -> e1.getBeginDate().compareTo(e2.getBeginDate());
        events.sort(c);
        for (Event event : events) {
            if (event.getTitle().contains(title)
                    && event.isDateInTime(date)
                    &&event.isContainUser(userName)
                    && event.isInPlace(place))
            {
                result.add(event);
            }
        }
        return result;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        priority = priority;
    }

    public static String checkEvent(String title, String beginDate, String endDate, String place,
                                    ArrayList<String> participants, User creator, int priority){
        String result = "";
        ArrayList<Event> interEvents = new ArrayList<Event>();

        for(Event event : events) {
           if(!event.getTitle().equals(title)&&event.isDateInInterval(beginDate,endDate)){
               interEvents.add(event);
           }
        }
        for(String par: participants) {
            User user = User.getUserByName(par);
            if (user==null)
            {
                result+="User with name " + par + " doesn't exist \n" ;
            }else
            {
                for(Event event : interEvents ) {
                    if(event.isContainUser(par))
                    {
                        result+="User with name " + par + " already has an event at this time \n" ;
                    }
                }

            }
        }

        for(Event event : interEvents) {
            if(event.isInPlace(place)){
                result+="In the hall " + place + " already taken place an event at this time with title \n" + event.getTitle() ;
            }
        }
        return result;
    }



    public static void addEvent(String title, String beginDate, String endDate, String place,
                                ArrayList<String> participants, User creator, int priority) {
        ArrayList<User> users = new ArrayList<User>();

        for (String par : participants) {
            User user = User.getUserByName(par);
            users.add(user);
        }
        try {
            Event event = new Event(title, formatter.parse(beginDate), formatter.parse(endDate), Place.valueOf(place), users, creator, priority);
            events.add(event);
        }
        catch (java.text.ParseException e){

        }
    }

    public void setParticipants(ArrayList<User> participants) {
        this.participants = participants;
    }

    public static ArrayList<String> getAllEventsTitles() {
        ArrayList<String> titles = new ArrayList<String>();
        for(Event event : events ) {
            titles.add(event.getTitle());
        }
        return  titles;
    }

    public static Event getEventByTitle(String title){
        for(Event event : events) {
            if(event.getTitle().equals(title)) {
                return event;
            }
        }
        return null;
    }

    public static void deleteEventByTitle(String title){
        for(Event event : events) {
            if(event.getTitle().equals(title)) {
                events.remove(events.indexOf(event));
                return;
            }
        }
    }


}

