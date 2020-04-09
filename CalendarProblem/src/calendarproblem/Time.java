/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarproblem;

/**
 *
 * @author Claudiu
 */
public class Time {
    private String hour;
    private String minutes;
    Time() {
        
    }
    
    //facem a. i. citirea sa fie cat mai usoara
    Time(String s){
        String[] str = s.split(":");
        hour = str[0];
        minutes = str[1];
    }
    
    Time(Time t){
        hour = t.getHour();
        minutes = t.getMinutes();
    }

    @Override
    public String toString() {
        return hour + ":" + minutes;
    }

    public String getHour() {
        return hour;
    }

    public String getMinutes() {
        return minutes;
    }
    
    public static boolean isBiggerThanMeetingTime(Time t1, Time t2, Time meeting){
        int difference=0;
        int differenceHours = 0;
        int meetingM=0, meetingH=0;
        boolean passOne = false;
        //diff for minutes
        if(Integer.parseInt(t2.getMinutes())>Integer.parseInt(t1.getMinutes())){
            difference = Integer.parseInt(t2.getMinutes()) - Integer.parseInt(t1.getMinutes());
            passOne = true;
        } else if(Integer.parseInt(t2.getMinutes())<Integer.parseInt(t1.getMinutes())) 
            difference = Integer.parseInt(t1.getMinutes()) - Integer.parseInt(t2.getMinutes());
        
        //diff for hours
        differenceHours = Integer.parseInt(t2.getHour()) - Integer.parseInt(t1.getHour());
        differenceHours *= 60;
        if(passOne == true){
            differenceHours += 60;
        }
        
        meetingM = Integer.parseInt(meeting.getMinutes());
        meetingH = Integer.parseInt(meeting.getHour());
        meetingH *= 60;
        /*
        System.out.println("meeting "+ (meetingH +meetingM));
        System.out.println("dif "+ (differenceHours + difference));
        */
        if(meetingM + meetingH <= differenceHours + difference) {
            return true;
        }
        return false;
    }
    
    
    /*
    public int isEqualTo(Time t1) {
        int hour1 = Integer.parseInt(t1.getHour());
        int minutes1 = Integer.parseInt(t1.getMinutes());
       
        if(Integer.parseInt(hour)==hour1 && Integer.parseInt(minutes)==minutes1)
            return 0;
        
        if(Integer.parseInt(hour) > hour1) 
            if(Integer.parseInt(minutes) > minutes1 ||Integer.parseInt(minutes) == minutes1)
            return 1;
        return -1;
    }*/
    
    public int isTimeHigher(Time t2) {
        if(Integer.parseInt(hour) == Integer.parseInt(t2.getHour()))
                if(Integer.parseInt(minutes) == Integer.parseInt(t2.getMinutes()))
                    return 0;
                else if(Integer.parseInt(minutes) > Integer.parseInt(t2.getMinutes()))
                    return 1;
        if(Integer.parseInt(hour) > Integer.parseInt(t2.getHour()))
            //if(Integer.parseInt(minutes) == Integer.parseInt(t2.getMinutes()))
                return 1;
        return -1;
    }
    
    
}
