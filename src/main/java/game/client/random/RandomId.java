package game.client.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomId implements Random {
    private final java.util.Random random;

    @Autowired
    public RandomId(java.util.Random random) {
        this.random = random;
    }

    @Override
    public Integer getRandomId(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
