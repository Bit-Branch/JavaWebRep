package by.javatr.task1.util;

import by.javatr.task1.entity.Ball;
import by.javatr.task1.entity.Basket;
import by.javatr.task1.entity.Color;

public class BasketService {

    public static int countBlueBalls(Basket basket) throws IllegalArgumentException{
        if (basket == null){
            throw new IllegalArgumentException("Argument(basket) is null");
        }
        int numOfBalls = 0;
        for (Ball ball: basket.getBalls())
        {
            if (ball.getColor() == Color.BLUE)
                numOfBalls++;
        }
        return numOfBalls;
    }

    public static double calculateBallsWeight(Basket basket) throws IllegalArgumentException{
        if (basket == null){
            throw new IllegalArgumentException("Argument(basket) is null");
        }
        double weight = 0;
        for (Ball ball:basket.getBalls()
             ) {
            weight += ball.getWeight();
        }
        return weight;
    }
}
