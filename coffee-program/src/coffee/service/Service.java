package coffee.service;

import coffee.vo.Order;

import java.util.*;

public class Service implements MenuChoice {

    Map<String, Integer> map = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    Order order = new Order();
    List<Order> list = new ArrayList<>();

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

    public void menuChoice() {
        System.out.println("음료를 선택해주세요.>>");

        String menu = "";
        int num = scan.nextInt();

        switch (num) {
            case 1 :
                menu = "아메리카노";
                typeChoice(menu);
                shotChoice(menu);
                sizeChoice(menu);
                takeOut(menu);

                list.add(order);
                for(Order a: list) {
                    System.out.println(a);
                }
                break;
        }
    }




    @Override
    public void typeChoice(String menu) {

        System.out.println(menu);
        System.out.println("1. ice 2. hot 선택 (주문취소 c)");
        System.out.print(">>");
        String type = scan.next();

        String type_ = (type.equals("1")) ? "ice":"hot";
        order.setType(type_);
        System.out.println(menu + "/" + order.getType());

    }

    @Override
    public void shotChoice(String menu) {
        System.out.println("1. 1샷(+0원) 2. 2샷(+500원) 선택 (주문취소 c)");
        System.out.print(">>");
        String shot = scan.next();

        String shot_ = (shot.equals("1")) ? "1":"2";
        order.setShot(shot);

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
            case "2" :
                size = "M";
                order.setSize(size);
                break;
            case "3" :
                size = "L";
                order.setSize(size);
                break;
            case "c":
                System.out.println("주문취소");
                break;
            default:
                System.out.println("잘못된 선택입니다.");
        }

        System.out.println(menu + "/" + order.getType() + "/" + order.getShot()+"샷" + "/" + order.getSize());
    }

    @Override
    public void takeOut(String menu) {
        System.out.println("1. 매장이용(+500원) 2. 테이크아웃 선택 선택 (주문취소 c)");
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
        }
        System.out.println(menu + "/" + order.getType() + "/" + order.getShot()+"샷" + "/" + order.getSize() + "/" + order.getTakeOut());

    }
}
