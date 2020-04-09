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

/*
 booked calendar1: [['9:00','10:30'], ['12:00','13:00'], ['16:00','18:00]]

*/

public class PeriodOfTime {
    private Time firstTime;
    private Time secondTime;
    
    PeriodOfTime(){
        
    }
    
    //simplificam in continuare citirea
    PeriodOfTime(String s){
        String[] str = s.split(",");
        firstTime = new Time(str[0]);
        secondTime = new Time(str[1]);
    }

    public PeriodOfTime(Time firstTime, Time secondTime) {
        this.firstTime = firstTime;
        this.secondTime = secondTime;
    }
    public PeriodOfTime(PeriodOfTime p1) {
        firstTime = p1.getFirstTime();
        secondTime = p1.getSecondTime();
    }

    public Time getFirstTime() {
        return firstTime;
    }

    public Time getSecondTime() {
        return secondTime;
    }
    
    @Override
    public String toString() {
        return "[" + firstTime + "," + secondTime + "]";
    }

    public void setFirstTime(Time firstTime) {
        this.firstTime = firstTime;
    }

    public void setSecondTime(Time secondTime) {
        this.secondTime = secondTime;
    }
    
    public Boolean isInsideSecondPeriod(PeriodOfTime p2) {
        Time p2FirstTime = p2.getFirstTime();
        Time p2SecondTime = p2.getSecondTime();
        if((firstTime.isTimeHigher(p2FirstTime)==1||firstTime.isTimeHigher(p2FirstTime)==0 ))
            if((secondTime.isTimeHigher(p2SecondTime)==-1)||secondTime.isTimeHigher(p2SecondTime)==0 ) {
            return true;
        }
        return false;
    }
    
}
