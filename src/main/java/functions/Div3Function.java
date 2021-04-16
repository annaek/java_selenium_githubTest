package functions;

import java.util.function.Function;

public class Div3Function implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer-3;
    }
}
