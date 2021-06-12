package vo;

import java.util.Scanner;

public class userInfo {

        private String userName;
        private int deposit;
        private String chapter;
        private String homework;
        private String middleMeetings;
        private String weekMeetings;
        private int studyFine;
        private int num;

        Scanner scan;

        public void setInfo() {
            System.out.print("이름 : ");
            this.setUserName(scan.next());
            System.out.print("보증금 : ");
            this.setDeposit(scan.nextInt());
            System.out.print("챕터정리 : ");
            this.setChapter(scan.next());
            System.out.print("과제 : ");
            this.setHomework(scan.next());
            System.out.print("중간점검참석 : ");
            this.setMiddleMeetings(scan.next());
            System.out.print("1주일점검참석 : ");
            this.setWeekMeetings(scan.next());
        }



        public void setUserName(String userName) {
            this.userName = userName;
        }
        public void setDeposit(int deposit) {
            this.deposit = deposit;
        }
        public void setChapter(String chapter) {
            this.chapter = chapter;
        }
        public void setHomework(String homework) {
            this.homework = homework;
        }
        public void setMiddleMeetings(String middleMeetings) {
            this.middleMeetings = middleMeetings;
        }
        public void setWeekMeetings(String weekMeetings) {
            this.weekMeetings = weekMeetings;
        }
        public String getUserName() {
            return userName;
        }
        public int getDeposit() {
            return deposit;
        }
        public String getChapter() {
            return chapter;
        }
        public String getHomework() {
            return homework;
        }
        public String getMiddleMeetings() {
            return middleMeetings;
        }
        public String getWeekMeetings() {
            return weekMeetings;
        }
        public void setStudyFine(int studyFine) {
            this.studyFine = studyFine;
        }
        public int getStudyFine() {
            return studyFine;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
    }

