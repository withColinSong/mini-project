package coffee.main;

import coffee.service.Service;
import coffee.vo.Menu;
import coffee.vo.Order;

import java.util.*;


public class Coffee {
    public void app() {
        while(true) {

            Menu menu = new Menu();
            Service m = new Service();
            Scanner scan = new Scanner(System.in);

            m.menuPrint();
            m.list.add(m.menuChoice());

        }
    }
}
