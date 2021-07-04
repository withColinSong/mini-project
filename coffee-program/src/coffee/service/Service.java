package coffee.service;

import coffee.vo.Order;

import java.text.DateFormat;
import java.util.*;

public class Service implements MenuChoice {

    Map<String, Integer> map = new HashMap<>();
    Scanner scan = new Scanner(System.in);

    Order order = new Order();
    public List<Order> list = new ArrayList<>();

    public Map<String, Integer> addMenu() {

        map.put("아메리카노", 1000);
        map.put("바닐라라떼", 2500);
        map.put("레몬에이드", 3000);
        map.put("자몽에이드", 3000);
        map.put("수박주스", 4000);
        map.put("토마토주스", 4000);

        return  map;
    }

    // 메뉴 출력
    public void menuPrint() {
        System.out.println("메뉴");
        System.out.println("1. 아메리카노 1000원");
        System.out.println("2. 바닐라라떼 2500원");
        System.out.println("3. 레몬에이드 3000원");
        System.out.println("4. 자몽에이드 3000원");
        System.out.println("5. 수박주스 4000원");
        System.out.println("6. 토마토주스 4000원");
        System.out.println("─────────────────────────────");
    }

    public void OrderPrint(Order o, String menu) {

        int sum = 0;
        int size = 0;
        int shot = 0;
        int takeOut = 0;

        switch (order.getShot()) {
            case "1" :
                shot += 0;
                break;
            case "2" :
                shot += 500;
                break;
        }
        switch (order.getSize()) {
            case "S" :
                size = 0;
                break;
            case "M" :
                size += 500;
                break;
            case "L":
                size += 1000;
                break;
        }

        switch (order.getTakeOut()) {
            case "매장이용":
                takeOut += 500;
                break;
            case "테이크아웃":
                takeOut = 0;
                break;
        }

        sum = addMenu().get(menu) + shot + size + takeOut;

        System.out.println("주문완료");
        System.out.println("======================================");
        System.out.println("　　　　　　대기번호 : " + "날짜");
        System.out.println("===============결제내역===============");
        System.out.println("품목         수량          금액");
        System.out.println("---------------------------------------");
        System.out.print(menu+"\t"+ list.size() +"\t" + addMenu().get(menu)+"\n");
        System.out.print("추가 "+order.getType() +"\t"+ list.size() +"\t" + addMenu().get(menu)+"\n");
        System.out.print("추가 "+order.getShot() +"샷 \t"+ list.size()+ "\t" + shot + "\n");
        System.out.print("추가 "+order.getSize()+"사이즈 \t"+ list.size()+ "\t" + size + "\n");
        System.out.print("추가 "+order.getTakeOut()+ "\n");
        System.out.println("---------------------------------------");
        System.out.println("합계" +"\t\t"+ sum);
        System.out.println("======================================");
    }

    public boolean yn(String menu) {

        boolean type = true;
        System.out.println("추가 주문을 하시겠습니까?");

        String yn = scan.next();
        if(yn.equalsIgnoreCase("y")) {
           return type;
        } else {
            System.out.println(menu + "/" + order.getType() + "(" + order.getShot()+"샷" + "/" + order.getSize() + "/" + order.getTakeOut()+")을 주문하시겠습니까?(y/n)");
            yn = scan.next();
            switch (yn) {
                case "y":
                    OrderPrint(order, menu);
                    break;
                case "n":
                    System.out.println("주문이 취소되었습니다.");
                    break;
            }

            type = false;
            return type;
        }
    }

    public Order menuChoice() {
        System.out.print("음료를 선택해주세요.>>");
        String menu = "";
        int num = scan.nextInt();

        Order o = new Order();

        switch (num) {
            case 1 :
                menu = "아메리카노";
                menuRetrun(menu);
               break;
            case 2:
                menu = "바닐라라떼";
                menuRetrun(menu);
                break;
        }

        return order;
    }

    public void menuRetrun(String menu) {
        typeChoice(menu);
        shotChoice(menu);
        sizeChoice(menu);
        takeOut(menu);
        list.add(order);
        yn(menu);
    }

    @Override
    public void typeChoice(String menu) {

        System.out.println(menu);
        System.out.println("1. ice 2. hot 선택 (주문취소 c)");
        System.out.print(">>");
        String type = scan.next();

        switch (type) {
            case "1" :
                type = "ice";
                order.setType(type);
                break;
            case "2" :
                type = "hot";
                order.setType(type);
                break;
            case "c":
                System.out.println("주문이 취소되었습니다.");
                break;
        }
        System.out.println(menu + "/" + order.getType());
    }

    @Override
    public void shotChoice(String menu) {
        System.out.println("1. 1샷(+0원) 2. 2샷(+500원) 선택 (주문취소 c)");
        System.out.print(">>");
        String shot = scan.next();

        switch (shot) {
            case "1" :
                order.setShot(shot);
                break;
            case "2" :
                order.setShot(shot);
                break;
            case "c":
                System.out.println("주문이 취소되었습니다.");
                break;
        }
        System.out.println(menu + "/" + order.getType() + "/" + order.getShot()+"샷");
    }

    @Override
    public void sizeChoice(String menu) {
        System.out.println("1. S(+0원) 2. M(+500원) 3. L(+1000) 선택 (주문취소 c)");
        System.out.print(">>");
        String size = scan.next();

            switch (size) {
                case "1" :
                    size = "S";
                    order.setSize(size);
                    break;
                case "2" :
                    size = "M";
                    order.setSize(size);
                    break;
                case "3" :
                    size = "L";
                    order.setSize(size);
                    break;
                case "c":
                    System.out.println("주문이 취소되었습니다.");
                    break;
            }
        System.out.println(menu + "/" + order.getType() + "/" + order.getShot()+"샷" + "/" + order.getSize());
    }

    @Override
    public void takeOut(String menu) {
        System.out.println("1. 매장이용(+500원) 2. 테이크아웃 선택 (주문취소 c)");
        System.out.print(">>");
        String takeOut = scan.next();

        switch (takeOut) {
            case "1":
                takeOut = "매장이용";
                order.setTakeOut(takeOut);
                break;
            case "2":
                takeOut = "테이크아웃";
                order.setTakeOut(takeOut);
                break;
            case "c":
                System.out.println("주문취소");
                break;
        }
        System.out.println(menu + "/" + order.getType() + "/" + order.getShot()+"샷" + "/" + order.getSize() + "/" + order.getTakeOut());
    }
}
