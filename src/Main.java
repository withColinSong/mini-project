import vo.userInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<userInfo> userInfo = new ArrayList<>();

        while (true) {
            System.out.println("\n메뉴");
            System.out.println("1. 정보입력");
            System.out.println("2. 벌금내역");
            System.out.println("3. 스터디관리");
            System.out.println("4. 종료");

            int num = scan.nextInt();

            if (num == 1) {
                int num0 = 0;
                userInfo userInfo1 = new userInfo();
                userInfo1.scan = new Scanner(System.in);
                userInfo1.setInfo();
                userInfo1.eqaulCheck(userInfo1);

                if(!userInfo1.getChapter().equals("O")) {
                    num0 += 500;
                }

                if (!userInfo1.getHomework().equals("O")) {
                    num0 += 500;
                }

                if (!userInfo1.getMiddleMeetings().equals("O")) {
                    num0 += 500;
                }

                if (!userInfo1.getWeekMeetings().equals("O")) {
                    num0 += 500;
                }

                userInfo1.setStudyFine(num0);
                userInfo.add(userInfo1);

            }

            if (num == 2) {
                int sum = 0;
                System.out.println("==========================================");
                System.out.println("　　　　　　　　　　벌금 내역　　　　　　　　　　");
                System.out.println("==========================================");
                System.out.println("　　　 벌금                                ");
                System.out.println("──────────────────────────────────────────");

                for(user_info info : userInfo) {
                    System.out.print(info.getUserName() + "       ");
                    System.out.print(info.getStudyFine() + "\n");
                    sum += info.getStudyFine();
                }
                System.out.println("──────────────────────────────────────────");
                System.out.println("총 벌금 " + sum);
            }

            if(num == 3) {

                int sum = 0;
                int fine = 0;
                int balance = 0;

                System.out.println("====================================================================================");
                System.out.println("　　　　　　　　　　　　　　　　　　　　　스터디 관리　　　　　　　　　　　　　　　　　　　　　");
                System.out.println("====================================================================================");

                System.out.print("\t보증금" + " | 챕터 정리 | 과제 | 중간점검참석 | 1주일점검참석 | 벌금 | 잔액\n");
                for(user_info info : userInfo) {
                    System.out.print(info.getUserName()+"\t");
                    System.out.print(info.getDeposit()+"\t\t");
                    System.out.print(info.getChapter()+"\t\t");
                    System.out.print(info.getHomework()+"\t\t\t");
                    System.out.print(info.getMiddleMeetings()+"\t\t");
                    System.out.print(info.getWeekMeetings()+"\t\t\t");
                    System.out.print(info.getStudyFine()+"\t");

                    balance = info.getDeposit() - info.getStudyFine();
                    sum += info.getDeposit();
                    fine += info.getStudyFine();
                    System.out.print(balance + "\n");
                    System.out.println("───────────────────────────────────────────────────────────────");

                }

                System.out.println("총 보증금: " + sum);
                System.out.println("총 벌금 : " + fine);
                System.out.println("총 잔액 : " +(sum-fine));
            }

            if(num == 4) {
                System.out.println("종료!");
                break;
            }
        }
    }
}
