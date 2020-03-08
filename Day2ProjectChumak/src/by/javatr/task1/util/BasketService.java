package by.javatr.task1.util;

import by.javatr.task1.entity.Ball;
import by.javatr.task1.entity.Basket;
import by.javatr.task1.entity.Color;
import by.javatr.task1.exception.NullArgumentException;

public class BasketService {

    public static int countBlueBalls(Basket basket) throws NullArgumentException{
        checkForNull(basket);
        int numOfBalls = 0;
        for (Ball ball: basket.getBalls())
        {
            if (ball.getColor() == Color.BLUE)
                numOfBalls++;
        }
        return numOfBalls;
    }

    public static double calculateBallsWeight(Basket basket) throws NullArgumentException{
        checkForNull(basket);
        double weight = 0;
        for (Ball ball:basket.getBalls()
             ) {
            weight += ball.getWeight();
        }
        return weight;
    }

    private static void checkForNull(Basket basket) throws NullArgumentException{
        if (basket == null){
            throw new NullArgumentException("Argument(basket) is null");
        }
    }
}
