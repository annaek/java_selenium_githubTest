public class NumberTest {
    public static void main(String[] args) {
        MyNumber number = null;

        number = new MyNumber(2.5);
        MyNumber anotherNumber = number;
        changeNumber(number);
        changeNumber(anotherNumber);
        System.out.println(number.getNumber());
        System.out.println(anotherNumber.getNumber());

        //MyNumber sumNumber = changeNumber(number.sum(new MyNumber(3.5)));
        //System.out.println(sumNumber.getNumber());


    }

    private static MyNumber changeNumber(MyNumber number){
         number.setNumber(number.getNumber() + 2.0);
         return number;

    }
}
