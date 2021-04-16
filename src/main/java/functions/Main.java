package functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        final Integer number = 10;

        MyFunctionInterface object = (n, str) -> n + number + str;

        String num = object.myMethod(5, "hello");

        System.out.println(num);




    }

    public static List<Integer> map(List<Integer> input, Function<Integer, Integer> mapFn) {
        ArrayList<Integer> result = new ArrayList<>(input.size());
        for (Integer elem : input) {
            Integer newElem = mapFn.apply(elem);
            result.add(newElem);
        }
        return result;

    }

    public static List<Integer> filter(List<Integer> input, Function<Integer, Boolean> filterFn) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (Integer num : input) {
            Boolean isValid = filterFn.apply(num);
            if (isValid) {
                numbers.add(num);
            }
        }
        return numbers;
    }

    public static Function<Integer, Integer> compose(Function<Integer, Integer> a, Function<Integer, Integer> b) {
        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return a.apply(b.apply(integer));
            }
        };
    }

    public static void exampleFilter(){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        List<Integer> filtredList = filter(numbers, integer -> integer % 2 == 0);


        for(Integer element : filtredList){
            System.out.println(element);
        }

    }

    public static void exampleCompose(){
        Sum5Function sum5 = new Sum5Function();
        Div3Function div3 = new Div3Function();


        Function<Integer, Integer> result = compose(sum5, div3);

        Integer total = result.apply(10);

        System.out.println(total);

    }

}

//todo method compose in interface Function, create function div3Function (number - 3). sum5Function and div3Function create new function use compose