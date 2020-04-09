/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarproblem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Claudiu
 */
public class CalendarProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        test1();
        System.out.println("\n----------------");
        test2();
        
    }
    
    public static void test1() {
        
        
        PeriodOfTime pOfTime1 = new PeriodOfTime("9:00,10:30");
        PeriodOfTime pOfTime2 = new PeriodOfTime("12:00,13:00");
        PeriodOfTime pOfTime3 = new PeriodOfTime("16:00,18:00");
        //range limits: ['9:00','20:00'] 
        PeriodOfTime restrictions1 = new PeriodOfTime("9:00,20:00");
        //list is created correctly
        List<PeriodOfTime> bookedCal1 = new ArrayList<>();
        bookedCal1.add(pOfTime1);
        bookedCal1.add(pOfTime2);
        bookedCal1.add(pOfTime3);
        /*
        for(PeriodOfTime var : bookedCal1){
            System.out.print(var + " ");
        }*/
        Calendar cal1 = new Calendar(bookedCal1,restrictions1);
        PeriodOfTime pOfTime21 = new PeriodOfTime("10:00,11:30");
        PeriodOfTime pOfTime22 = new PeriodOfTime("12:30,14:30");
        PeriodOfTime pOfTime23 = new PeriodOfTime("14:30,15:00");
        PeriodOfTime pOfTime24 = new PeriodOfTime("16:00,17:00");
        PeriodOfTime restrictions2 = new PeriodOfTime("10:00,18:30");
        List<PeriodOfTime> bookedCal2 = new ArrayList<>();
        bookedCal2.add(pOfTime21);
        bookedCal2.add(pOfTime22);
        bookedCal2.add(pOfTime23);
        bookedCal2.add(pOfTime24);
        Calendar cal2 = new Calendar(bookedCal2,restrictions2);
        
        Time meetingTime = new Time("00:30");
        /*
        Time t1 = new Time("09:00");
        Time t2 = new Time("09:29");
        if(Time.isBiggerThanMeetingTime(t1, t2, meetingTime)==true)
            System.out.println("it works");*/
        PeriodOfTime[] available1 = cal1.availableTime();
        PeriodOfTime[] available2 = cal2.availableTime();
        
        
        /*for(PeriodOfTime x : available1){
            System.out.print(x + " ");
        }
        System.out.println("av2");
        for(PeriodOfTime x : available2){
            System.out.print(x + " ");
        }*/
        System.out.print("Time when they could have  a meeting: ");
        PeriodOfTime[] bothMeetingTime = Calendar.meetingAvailabilityTime(available1, available2, meetingTime);
        for(PeriodOfTime x : bothMeetingTime){
            System.out.print(x + " ");
        }
        
    }
    
    public static void test2() {
        PeriodOfTime pOfTime1 = new PeriodOfTime("09:00,10:30");
        PeriodOfTime pOfTime2 = new PeriodOfTime("12:00,13:00");
        PeriodOfTime pOfTime3 = new PeriodOfTime("16:00,18:00");
        //range limits: ['9:00','20:00'] 
        PeriodOfTime restrictions1 = new PeriodOfTime("9:00,20:00");
        //list is created correctly
        List<PeriodOfTime> bookedCal1 = new ArrayList<>();
        bookedCal1.add(pOfTime1);
        bookedCal1.add(pOfTime2);
        bookedCal1.add(pOfTime3);
        
        Calendar cal1 = new Calendar(bookedCal1,restrictions1);
        PeriodOfTime pOfTime21 = new PeriodOfTime("12:00,18:00");
        PeriodOfTime restrictions2 = new PeriodOfTime("09:00,18:30");
        List<PeriodOfTime> bookedCal2 = new ArrayList<>();
        bookedCal2.add(pOfTime21);
        Calendar cal2 = new Calendar(bookedCal2,restrictions2);
        
        Time meetingTime = new Time("00:30");
        
        PeriodOfTime[] available1 = cal1.availableTime();
        PeriodOfTime[] available2 = cal2.availableTime();
        
        System.out.print("Time when they could have  a meeting: ");
        PeriodOfTime[] bothMeetingTime = Calendar.meetingAvailabilityTime(available1, available2, meetingTime);
       
        
        for(PeriodOfTime x : bothMeetingTime){
            System.out.print(x + " ");
        }
    }
}
