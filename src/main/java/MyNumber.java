public class MyNumber {
    private double number;

    public MyNumber(double number){
        this.number = number;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public MyNumber sum(MyNumber number){
        return new MyNumber(getNumber() + number.getNumber());
    }
}
