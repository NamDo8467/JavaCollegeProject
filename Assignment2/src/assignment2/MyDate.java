/**
 *
 * Do Huynh - 101293009
 * Minh Nhat Vo - 101224717
 */

package assignment2;

/**
 *
 * @author huynh
 */
public class MyDate {
        private int day;
        private int month;
        private int year;
        
        public MyDate(int day, int month, int year){
            this.day = day;
            this.month = month;
            this.year = year;
        }
        
        public int getDay(){
            return day;
        }
        
        public void setDay(int day){
            this.day = day;
        }
        public String getMonthShortForm(){
           switch (month) {
                case 1:
                  return "January";
                case 2:
                  return "February";
                  
                case 3:
                  return "March" ;
                  
                case 4:
                  return "April";
                  
                case 5:
                  return "May";
                  
                case 6:
                  return "June" ;
                  
                case 7:
                  return "July" ;
                  
                case 8:
                  return "August";
                  
                case 9:
                  return "September";
                  
                case 10:
                  return "October" ;
                  
                case 11:
                  return "November";
                  
                case 12:
                  return "December";
                  
                
              }
            return null;
        }
        
        public String getMonthLongForm(){
            switch (month) {
                case 1:
                  return "Jan";
                case 2:
                  return "Feb";
                  
                case 3:
                  return "Mar" ;
                  
                case 4:
                  return "April";
                  
                case 5:
                  return "May";
                  
                case 6:
                  return "Jun" ;
                  
                case 7:
                  return "Jul" ;
                  
                case 8:
                  return "Aug";
                  
                case 9:
                  return "Sep";
                  
                case 10:
                  return "Oct" ;
                  
                case 11:
                  return "Nov";
                  
                case 12:
                  return "Dec";
                  
                
              }
            return null;
        }
        public void setMonth(int month){
            this.month = month;
        }
        public int getYear(){
            return year;
        }
        public void setYear(int year){
            this.year = year;
        }
        
        @Override
        public String toString(){
            String s = "Day: " + day + ", Month: " + month + ", Year: " + year;
            return s;
        }
            
        
}
