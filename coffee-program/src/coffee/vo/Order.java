package coffee.vo;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String type; // ice, hot
    private String shot; // 샷
    private String size; // 사이즈
    private String takeOut; // 포장종류

    private int totalSum = 0;
    private int shotSum = 0;
    private int sizeSum = 0;
    private int takeOutSum = 0;

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public int getShotSum() {
        return shotSum;
    }

    public void setShotSum(int shotSum) {
        this.shotSum = shotSum;
    }

    public int getSizeSum() {
        return sizeSum;
    }

    public void setSizeSum(int sizeSum) {
        this.sizeSum = sizeSum;
    }

    public int getTakeOutSum() {
        return takeOutSum;
    }

    public void setTakeOutSum(int takeOutSum) {
        this.takeOutSum = takeOutSum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShot() {
        return shot;
    }

    public void setShot(String shot) {
        this.shot = shot;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTakeOut() {
        return takeOut;
    }

    public void setTakeOut(String takeOut) {
        this.takeOut = takeOut;
    }

    @Override
    public String toString() {
        return "Order{" +
                "type='" + type + '\'' +
                ", shot=" + shot +
                ", size=" + size +
                ", takeOut=" + takeOut +
                '}';
    }
}
