import dao.CRUD;
import vo.userInfo;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        /* 객체 생성 */
        Scanner scan = new Scanner(System.in);
        userInfo userInfo = new userInfo();
        CRUD crud = new CRUD();

        /* injection */
        crud.scan = scan;
        crud.userInfo = userInfo;

        /* 실행 */
        while(true) {
            crud.printMenu("0");
            String num = scan.next();
            crud.printMenu(num);

            if(num.equals("7")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
