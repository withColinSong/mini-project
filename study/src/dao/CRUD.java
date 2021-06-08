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
            case "1" :
                System.out.println("회원번호를 입력해주세요.");
                this.userJoin(scan.next());
                break;
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

}
