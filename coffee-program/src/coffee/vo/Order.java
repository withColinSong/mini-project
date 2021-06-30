package coffee.vo;

public class Order {
    private String type; // ice, hot
    private String shot; // 샷
    private String size; // 사이즈
    private String takeOut; // 포장종류
    private int resultSum; // 합계

    public int getResultSum() {
        return resultSum;
    }

    public void setResultSum(int resultSum) {
        this.resultSum = resultSum;
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
