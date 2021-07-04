package coffee.main;

import coffee.service.Service;
import coffee.vo.Menu;
import coffee.vo.Order;

import java.util.*;


public class Coffee {
    public void app() {
        while(true) {


            Menu menu = new Menu();
            Service service = new Service();
            Scanner scan = new Scanner(System.in);
            List<Order> odList = new ArrayList<>();

            service.menuPrint();
            odList.add(service.menuChoice());

            for(Order o :  odList) {
                System.out.println(o);
            }

        }
    }
}
