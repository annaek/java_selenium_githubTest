package functions;

import java.util.function.Function;

public class SumFunction implements Function<Tuple, Integer> {

    @Override
    public Integer apply(Tuple t) {
        return t.getFirst() + t.getSecond();
    }

}
