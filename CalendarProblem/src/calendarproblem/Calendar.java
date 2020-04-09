/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarproblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Claudiu
 */
public class Calendar {
    //booked periods of time
    private PeriodOfTime[] booked;
    
    //the beginning and ending of the availability period
    private Time beginAv;
    private Time endAv;
    
    Calendar() {
        
    }
    
    Calendar(List<PeriodOfTime> list, PeriodOfTime restrictions) {
        beginAv = restrictions.getFirstTime();
        endAv = restrictions.getSecondTime();
        //initialize the vector
        booked = new PeriodOfTime[list.size()];
        //convert from list to array
        booked = list.toArray(booked);
        for(PeriodOfTime var : booked) {
            Time startTime = var.getFirstTime();
            Time endTime = var.getSecondTime();
            //remove var from booked
            if(!var.isInsideSecondPeriod(restrictions)) {
                //remove like this cuz it's easier
                list.remove(var);
                System.out.print("1(one) time in calendar does not meet constraints! ");
                System.out.println(var.toString());
            }
        }
        //convert back from list to array
        booked = new PeriodOfTime[list.size()];
        //convert from list to array
        booked = list.toArray(booked);
    }

    public Time getBeginAv() {
        return beginAv;
    }

    public Time getEndAv() {
        return endAv;
    }

    public String bookedTime() {
        StringBuilder str = new StringBuilder("");
        for(PeriodOfTime var : booked){
            str.append(var.toString());
            str.append(" ");
        }
        return str.toString();
    }
    
    public String constaints() {
        return beginAv + "," + endAv;
    }
    
    
    public PeriodOfTime[] availableTime(){
        PeriodOfTime restrictions1 = new PeriodOfTime(beginAv,endAv);
        //System.out.println(restrictions1);
        //System.out.println(bookedTime());
        PeriodOfTime[] holdingVector = new PeriodOfTime[10];
        //[9:00,11:00]
        //[9:00,21:00]
        //1 edge case
        int k=1, i;
        if(booked.length==1) {
            if(booked[0].getFirstTime().isTimeHigher(beginAv)==1) {
                    holdingVector[0] = new PeriodOfTime(beginAv,booked[0].getFirstTime());
                } 
        }
        for(i=0;i<booked.length-1;i++) {
            /*
            if(i==0) {
                if(booked[0].getFirstTime().isTimeHigher(beginAv)==1) {
                    holdingVector[0] = new PeriodOfTime(beginAv,booked[0].getFirstTime());
                }  
            } else if(i!=0)
                */
            if(booked[i].getSecondTime().isTimeHigher(booked[i+1].getFirstTime())!=0) {
                holdingVector[k] = new PeriodOfTime(booked[i].getSecondTime(),booked[i+1].getFirstTime());
                    k++;
            }
        }
        if(booked[i].getSecondTime().isTimeHigher(endAv)!=0)
            holdingVector[k] = new PeriodOfTime(booked[i].getSecondTime(),endAv);
        
        List<PeriodOfTime> listTime = new ArrayList();
        for(PeriodOfTime var : holdingVector){
            if(var!=null){
                listTime.add(var);
            }
        }
        PeriodOfTime[] availableTime = new PeriodOfTime[listTime.size()];
        availableTime = listTime.toArray(availableTime);
        
        return availableTime;
    }
    
    
    public static PeriodOfTime[] meetingAvailabilityTime(PeriodOfTime[] av1, PeriodOfTime[] av2, Time meetingTime){
        int i=1,j=1,n = av1.length, m=av2.length;
        //alegem max dintre primele si min din al doilea
        //dar trebuie sa avem grija si de reziduu([min, max2])
        //comparam reziduu cu urm elem.
        PeriodOfTime reziduu;
        Time maxim, minim;
        
        //av1[0], av2[0]
        if(av1[0].getFirstTime().isTimeHigher(av2[0].getFirstTime())==1)
            maxim = new Time(av1[0].getFirstTime());
        else
            maxim = new Time(av2[0].getFirstTime());
        
        if(av1[0].getSecondTime().isTimeHigher(av2[0].getSecondTime())==-1) {
            minim = new Time(av1[0].getSecondTime());
            reziduu = new PeriodOfTime(minim, av2[0].getSecondTime());
        }
        else{
            minim = new Time(av2[0].getSecondTime());
            reziduu = new PeriodOfTime(minim, av2[0].getSecondTime()); 
        }
        PeriodOfTime[] meetings = new PeriodOfTime[10];
        
        if(Time.isBiggerThanMeetingTime(maxim, minim,meetingTime)==true)
            meetings[0] = new PeriodOfTime(maxim, minim);
        
        //System.out.println("\nmax si min sunt " + maxim + " " + minim);
        //System.out.println("reziduu is "+ reziduu);
        while(i!=n && j!=m){
            if(av1[i].getFirstTime().isTimeHigher(av2[j].getFirstTime())==1)
                maxim = new Time(av1[i].getFirstTime());
            else
                maxim = new Time(av2[j].getFirstTime());
        
            if(av1[i].getSecondTime().isTimeHigher(av2[j].getSecondTime())==-1) {
                minim = new Time(av1[i].getSecondTime());
                reziduu = new PeriodOfTime(minim, av2[j].getSecondTime());
            }
            else{
                minim = new Time(av2[j ].getSecondTime());
                reziduu = new PeriodOfTime(minim, av2[j].getSecondTime()); 
            }
            
            if(minim.isTimeHigher(maxim)==1) {
                if(Time.isBiggerThanMeetingTime(maxim, minim,meetingTime)==true) {
                    meetings[i] = new PeriodOfTime(maxim, minim);
                    
                }
                i++;j++;
            }
            else
                if(minim.isTimeHigher(av1[i].getSecondTime())==0){
                        i++;
                } else
                        j++;
            
        }
        
        List<PeriodOfTime> listTime = new ArrayList();
            for(PeriodOfTime var : meetings){
                if(var!=null){
                    listTime.add(var);
                }
            }
        meetings = new PeriodOfTime[listTime.size()];
        meetings = listTime.toArray(meetings);
        
        return meetings;
    }
    
}
