package functions;

import java.util.function.Function;

public class Sum5Function implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + 5;
    }
}
