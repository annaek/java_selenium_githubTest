package functions;

import java.util.function.Function;

public class MultiplyFunction implements Function<Tuple, Integer> {


    @Override
    public Integer apply(Tuple tuple) {
        return tuple.getFirst() * tuple.getSecond();
    }
}
