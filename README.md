# CalendarProblem
UMT Softare problem
At the bottom I have included some photos containing personal notes.
#### *_Problem: Given the calendar booked time of two people find all available time they can meet._*
![sample](https://user-images.githubusercontent.com/44347749/78875638-e1113980-7a56-11ea-86fd-5b850ff0cfa7.PNG)<br>

####the class CalendarProblem contains some tests.

### Issues  with the problem.
I have discovered 2 issues with the provided problem.
1. a typo. Instead of Booked calendar 2 it says Booked calendar 1 
2. in the sample output the first output should be [['11:30','12:00'] instead of [['11:30','12:30'] because `booked calendar1: [['9:00','10:30'], ['12:00','13:00'], ` has ['12:00','13:00'] booked.

<br><br>
## Explanation
Explanation for how I approached the problem.
First we need a method that gives us the available periods of time(which was done in Calendar `public PeriodOfTime[] availableTime()`). After we have this all that remains is that we find the common free available times.

Having these two arrays of available time we can go through both of them at the same time(similar to interclassing) so that we can get the common available periods(which was done in Calendar `public static PeriodOfTime[] meetingAvailabilityTime(PeriodOfTime[] av1, PeriodOfTime[] av2, Time meetingTime)`).
 
## Classes:
  ## 1. Time - base class
  ![Time](https://user-images.githubusercontent.com/44347749/78871761-df447780-7a50-11ea-9b73-a21fc4d68173.PNG) 
  ### Proprieties: 
  `String hour`<br>
  `String minutes `<br>
  
    Both are String so we can read the data easier.
    This way we can write "03:00" instead of 3:0
   
  ### Important methods:
   
  `public int isTimeHigher(Time t2)`<br>
      
      return 1 if t1 > t2
      return 0 if t1 = t2
      return -1 if t1 < t2
  `static boolean isBiggerThanMeetingTime(Time t1, Time t2, Time meetingTime)`<br>
      
      returns true if diference between t1 si t2 is higher than meetingTime
    ex: t1 = 9:00, t2 = 10:00, meetingTime = 00:30
      return true because 10 - 9(60 min) > 30 min
   
   
  ## 2. PeriodOfTime
  ![PeriodOfTime](https://user-images.githubusercontent.com/44347749/78873403-7d394180-7a53-11ea-98af-a455787790ca.PNG)
    
  ### Proprieties: 
  `private Time firstTime;`<br>
  `private Time secondTime;`<br>
  ### Important Methods:
  `public Boolean isInsideSecondPeriod(PeriodOfTime p2)`
    
    returns true if this. is inside p2(uses time.isTimeHigher(time2))
      Mainly used for restrictions purposes
    ex: Period1 = [9:00, 10:00], p2=[9:00, 20:00] => true
  
  ## 3. Calendar
  ![Calendar](https://user-images.githubusercontent.com/44347749/78873670-e4ef8c80-7a53-11ea-8518-3e441bed5500.PNG)
  
  This class incapsulates the previous classes
  ### Proprieties: 
   `private PeriodOfTime[] booked;`<br>
   ` private Time beginAv;`<br>
   ` private Time endAv;`<br>
   
    beginAv and endAv represent the beginning and ending of the availability
    ex: if restrictions are [9:00,20:00] beginAv = 9:00 and endAv= 20:00
  ### Important Methods:
  `public String bookedTime()`
    
    returns a String with the bookedTime for displaying purposes
    
  `public PeriodOfTime[] availableTime()`
  
    returns an array of all the available time
    
  `public static PeriodOfTime[] meetingAvailabilityTime(PeriodOfTime[] av1, PeriodOfTime[] av2, Time meetingTime)`
  
    arguably the most important method.
    This method return an array with all the available time they can meet.
  
  
  
  
  
<br><br><br>I have included my personal notebook notes
![notes1](https://user-images.githubusercontent.com/44347749/78874645-609e0900-7a55-11ea-873b-8d68c03ecab7.jpeg)
![notes2](https://user-images.githubusercontent.com/44347749/78874649-61369f80-7a55-11ea-96c3-2286b3f65b3f.jpeg)
![notes3](https://user-images.githubusercontent.com/44347749/78874650-61369f80-7a55-11ea-8c73-f4e11e7e7199.jpeg)
![notes4](https://user-images.githubusercontent.com/44347749/78874651-61cf3600-7a55-11ea-967d-a620ca270711.jpeg)
![notes5](https://user-images.githubusercontent.com/44347749/78874652-61cf3600-7a55-11ea-9af6-90804b39facd.jpeg)
