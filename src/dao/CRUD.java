package dao;

import vo.userInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {
    public Scanner scan;
    public vo.userInfo userInfo;

    public ArrayList<userInfo> userList = new ArrayList<>();

    // 출력
    public void printMenu(String num) {
        switch (num) {
            case "0" :
                System.out.println("메뉴(0)");
                System.out.println("1. 스터디 가입");
                System.out.println("2. 정보 입력");
                System.out.println("3. 정보 수정");
                System.out.println("4. 스터디 탈퇴");
                System.out.println("5. 벌금 현황");
                System.out.println("6. 스터디 관리 내용");
                System.out.println("7. 종료");
                break;
            case "1" :  // 스터디 가입
                System.out.println("회원번호를 입력해주세요.");
                this.userJoin(scan.next());
                break;
            case "2" :  // 정보 입력
                System.out.println("회원번호를 입력해주세요.");
                this.userInfomation(scan.next());
                break;
            case "3" : // 회원 정보 수정
                System.out.println("회원 번호를 입력해주세요.");
                this.updateUser(scan.next());
                break;
            case "4": // 스터디 탈퇴
                break;
            case "5": // 벌금 내역
                this.printFine();
                break;
            case "6" : // 스터디 관리
                this.studyInfo();
        }
    }


    // 1. 스터디 가입하기

    public void userJoin (String id) {

        int i = 0;
        while(i < userList.size()) {
            String userId = userInfo.getId(); // 아이디

            if(userId.equalsIgnoreCase(id)) {
                System.out.println("회원번호가 존재합니다.");
                break;
            }
            i++;

        }

        userInfo.setId(id);
        System.out.println("회원번호 : " + id);
        System.out.print("이름: ");
        userInfo.setName(scan.next());
        System.out.print("보증금 : ");
        userInfo.setDeposit(scan.next());
        System.out.print("가입날짜:");
        userInfo.setJoinDate(scan.next());

        userList.add(userInfo);
    }

    // 2. 정보 입력
    public void userInfomation(String id) {

        if(userList.size() == 0) {
            System.out.println("해당하는 회원이 존재하지 않습니다.");
            return;
        }

        int i = 0;
        while( i < userList.size()) {
            String userId = userInfo.getId(); // 아이디
            if(!userId.equalsIgnoreCase(id)) {
                System.out.println("해당하는 회원이 존재하지 않습니다.");
                return;
            }
            i++;
        } // while 끝

        int sum = 0;
        System.out.println("이름 : " + userInfo.getName());

        System.out.print("스터디 날짜 : ");
        userInfo.setStudyDate(scan.next());

        System.out.print("챕터정리 : ");
        String chapter = scan.next();
        userInfo.setChapter(chapter);
        if(!chapter.equalsIgnoreCase("O")) {
            sum += 500;
        }

        System.out.print("과제 : ");
        String homework = scan.next();
        userInfo.setHomework(homework);
        if(!homework.equalsIgnoreCase("O")) {
            sum += 500;
        }

        System.out.print("중간점검참석 : ");
        String middleMeetings = scan.next();
        userInfo.setMiddleMeetings(middleMeetings);
        if(!middleMeetings.equalsIgnoreCase("O")) {
            sum += 500;

        }

        System.out.print("1주일점검참석 : ");
        String weekMeeting = scan.next();
        userInfo.setWeekMeeting(weekMeeting);
        if(!weekMeeting.equalsIgnoreCase("O")) {
            sum += 500;
        }

        userInfo.setFine(sum);
        System.out.println(userInfo.getFine());

    }

    // 3. 정보 수정

    public void updateUser(String id) {
        if(userList.size() == 0) {
            System.out.println("해당하는 회원이 존재하지 않습니다.");
            return;
        }

        int i = 0;
        while( i < userList.size()) {
            String userId = userInfo.getId(); // 아이디
            if(!userId.equalsIgnoreCase(id)) {
                System.out.println("해당하는 회원이 존재하지 않습니다.");
                return;
            }
            i++;
        } // while 끝

        System.out.println(userList.get(i-1).getId());

        // 데이터 출력
        for(userInfo a: userList) {
            System.out.println(a);
        }

        this.userInfomation(userList.get(i-1).getId());
        userList.set(i-1, userInfo);
    }

    // 4. 스터디 탈퇴

    // 5. 벌금 내역
    public void printFine() {
        int sum = 0;

        for(int i=0; i<userList.size(); i++) {
            System.out.println("==========================================================================");
            System.out.println("\t\t\t\t\t\t\t벌금 내역");
            System.out.println("==========================================================================");
            System.out.println("\t\t벌금");
            if(0 < userList.get(i).getFine()) {
                System.out.print(userList.get(i).getName()+"\t" + userList.get(i).getFine()+"\n");
            }
            sum += userList.get(i).getFine();
            System.out.println("─────────────────────────────────────");
        }

        System.out.println("총 벌금 : " + sum);
    }

    // 6. 스터디 관리 내용
    public void studyInfo() {

        String deposit_;
        int deposit;

        int sumDeposit = 0;
        int sumFine = 0;
        int total = 0;

        for(int i=0; i<userList.size(); i++) {
            System.out.println("==========================================================================");
            System.out.println("\t\t\t\t\t\t\t스터디 관리");
            System.out.println("==========================================================================");
            System.out.println("\t\t 보증금| 챕터 정리 | 과제 | 중간점검참석 | 1주일 점검참석 | 벌금 | 잔액 ");
            System.out.print(userList.get(i).getName());
            System.out.print("   \t"+userList.get(i).getDeposit());
            System.out.print("\t\t"+userList.get(i).getChapter());
            System.out.print(" \t\t"+userList.get(i).getHomework());
            System.out.print("\t\t\t"+userList.get(i).getMiddleMeetings());
            System.out.print("\t\t\t\t\t"+userList.get(i).getWeekMeeting());
            System.out.print("\t\t"+userList.get(i).getFine());

            deposit_ = (String)userList.get(i).getDeposit();
            deposit = Integer.parseInt(deposit_);
            System.out.print("\t"+(deposit - userList.get(i).getFine())+"\n");
            System.out.println("─────────────────────────────────────");

            sumDeposit += deposit; // 보증금
            sumFine += userList.get(i).getFine(); // 총 벌금
            total += sumDeposit - sumFine; // 총 잔액
        }

        System.out.println("총 보증금 : " + sumDeposit + ", 총 벌금 : " + sumFine + ", 총 잔액 : " + total);

    }
}
