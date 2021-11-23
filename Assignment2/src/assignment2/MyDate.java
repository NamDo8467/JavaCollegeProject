/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
            return "H";
        }
        
        public String getMonthLongForm(){
            return "h";
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
        
        public String toString(){
            String s = "Day: " + day + ", Month: " + month + ", Year: " + year;
            return s;
        }
            
        
}
