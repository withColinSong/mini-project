package coffee.main;

import coffee.service.Service;
import coffee.vo.Menu;

import java.util.NoSuchElementException;
import java.util.Scanner;


public class Coffee {
    public void app() {

        while(true) {

            Menu menu = new Menu();
            Service m = new Service();
            Scanner scan = new Scanner(System.in);

            m.menuPrint();
            m.menuChoice();


        }
    }
}
