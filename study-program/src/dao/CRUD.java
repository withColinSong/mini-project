package dao;

import vo.userInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {
    public Scanner scan;
    public vo.userInfo userInfo;
    public ArrayList<userInfo> user =  new ArrayList<>(); // 유저
    public ArrayList<userInfo> userList = new ArrayList<>(); // 스터디 정보


    // 출력
    public void printMenu(String num) {
        String name = "";
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
                name = scan.next();
                this.userJoin(name);
                break;
            case "2" :  // 정보 입력
                System.out.println("회원번호를 입력해주세요.");
                name = scan.next();
                this.userInfomation(name);
                break;
            case "3" : // 회원 정보 수정
                System.out.println("회원번호를 입력해주세요.");
                name = scan.next();
                this.updateUser(name);
                break;
            case "4": // 스터디 탈퇴
                System.out.println("회원번호를 입력해주세요.");
                name = scan.next();
                this.userOut(name);
                break;
            case "5": // 벌금 내역
                this.printFine();
                break;
            case "6" : // 스터디 관리
                this.studyInfo();
                break;
        }
    }


    // 1. 스터디 가입하기

    public boolean userJoin (String id) {

        boolean type = true;
        userInfo userInfo = new userInfo();

        int i = 0;
        while(i < user.size()) {
            String userId = user.get(i).getId(); // 아이디
            if(userId.equalsIgnoreCase(id)) {
                System.out.println("회원번호가 존재합니다.");
                type = false;
                return type;
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
        user.add(userInfo);
        return type;
    }

    // 2. 정보 입력
    public void userInfomation(String id) {

        if (user.size() == 0) {
            System.out.println("해당하는 회원이 존재하지 않습니다.");
            return;
        }

        int i = 0;
        while (i < user.size()) {
            String userId = user.get(i).getId();
            if (userId.equalsIgnoreCase(id)) {

                int sum = 0;
                userInfo userInfo = new userInfo();

                System.out.println("이름 : " + user.get(i).getName());
                userInfo.setName(user.get(i).getName());

                System.out.print("스터디 날짜 : ");
                userInfo.setStudyDate(scan.next());

                System.out.print("챕터정리 : ");
                String chapter = scan.next();
                userInfo.setChapter(chapter);

                if (!chapter.equalsIgnoreCase("O")) {
                    sum += 500;
                }

                System.out.print("과제 : ");
                String homework = scan.next();
                userInfo.setHomework(homework);
                if (!homework.equalsIgnoreCase("O")) {
                    sum += 500;
                }

                System.out.print("중간점검참석 : ");
                String middleMeetings = scan.next();
                userInfo.setMiddleMeetings(middleMeetings);
                if (!middleMeetings.equalsIgnoreCase("O")) {
                    sum += 500;
                }

                System.out.print("1주일점검참석 : ");
                String weekMeeting = scan.next();
                userInfo.setWeekMeeting(weekMeeting);
                if (!weekMeeting.equalsIgnoreCase("O")) {
                    sum += 500;
                }

                userInfo.setFine(sum);
                userInfo.setDeposit(user.get(i).getDeposit());
                userInfo.setJoinDate(user.get(i).getJoinDate());
                userInfo.setId(id);

                userList.add(userInfo);
                return;
            }

            i++;
        } // while 끝
        System.out.println("회원 정보가 없습니다.");
    }

    // 3. 정보 수정

    public void updateUser(String id) {

        int i = 0;
        while (i < user.size()) {
            String userId = user.get(i).getId();

            if (userId.equalsIgnoreCase(id)) {
                int sum = 0;
                System.out.println("이름 : " + userList.get(i).getName());

                System.out.print("스터디 날짜 : ");
                userList.get(i).setStudyDate(scan.next());

                System.out.print("챕터정리 : ");
                String chapter = scan.next();
                userList.get(i).setChapter(chapter);

                if (!chapter.equalsIgnoreCase("O")) {
                    sum += 500;
                }

                System.out.print("과제 : ");
                String homework = scan.next();
                userList.get(i).setHomework(homework);
                if (!homework.equalsIgnoreCase("O")) {
                    sum += 500;
                }

                System.out.print("중간점검참석 : ");
                String middleMeetings = scan.next();
                userList.get(i).setMiddleMeetings(middleMeetings);
                if (!middleMeetings.equalsIgnoreCase("O")) {
                    sum += 500;

                }

                System.out.print("1주일점검참석 : ");
                String weekMeeting = scan.next();
                userList.get(i).setWeekMeeting(weekMeeting);
                if (!weekMeeting.equalsIgnoreCase("O")) {
                    sum += 500;
                }

                userList.get(i).setFine(sum);

                return;
            }
            i++;
        } // while 끝
        System.out.println("회원 정보가 없습니다.");
    }

    // 4. 스터디 탈퇴
    public void userOut(String id) {

        int i = 0;
        while (i < userList.size()) {
            String userId = userList.get(i).getId();

            if(userId.equalsIgnoreCase(id)) {
                userList.get(i).setId("탈퇴회원");
                userList.get(i).setName("탈퇴회원");
                user.set(i, userList.get(i));
                break;
            }
            break;
        }

        for(userInfo a: userList) {
            System.out.println(a);
        }

        System.out.println("회원 정보가 없습니다.");
    }

    // 5. 벌금 내역
    public void printFine() {
        int sum = 0;
            System.out.println("==========================================================================");
            System.out.println("\t\t\t\t\t\t\t벌금 내역");
            System.out.println("==========================================================================");
            System.out.println("\t\t벌금");
        for(int i=0; i<userList.size(); i++) {
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

        System.out.println("======================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t스터디 관리");
        System.out.println("======================================================================================================");
        System.out.println("\t보증금| 챕터 정리 | 과제 | 중간점검참석 | 1주일 점검참석 | 벌금 | 잔액 | 스터디 날짜");

        for(int i=0; i<userList.size(); i++) {
            System.out.print(userList.get(i).getName());
            System.out.print("\t"+userList.get(i).getDeposit());
            System.out.print("\t"+userList.get(i).getChapter());
            System.out.print("\t"+userList.get(i).getHomework());
            System.out.print("\t\t\t\t"+userList.get(i).getMiddleMeetings());
            System.out.print("\t\t\t\t\t"+userList.get(i).getWeekMeeting());
            System.out.print("\t\t"+userList.get(i).getFine());

            deposit_ = (String)userList.get(i).getDeposit();
            deposit = Integer.parseInt(deposit_);
            System.out.print("\t"+(deposit - userList.get(i).getFine()));
            System.out.print("\t"+userList.get(i).getStudyDate()+"\n");
            System.out.println("────────────────────────────────────────────────────");

            sumDeposit += deposit; // 보증금
            sumFine += userList.get(i).getFine(); // 총 벌금
            total = sumDeposit - sumFine; // 총 잔액
        }

        System.out.println("총 보증금 : " + sumDeposit + ", 총 벌금 : " + sumFine + ", 총 잔액 : " + total);

    }
}
