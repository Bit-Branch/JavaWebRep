package by.javatr.task1.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {
    private List<Ball> balls;

    public Basket() {
        this.balls = new ArrayList<>();
    }

    public Basket(ArrayList<Ball> balls) throws IllegalArgumentException{
        if (balls == null) {
            throw new IllegalArgumentException("Argument(balls) is null");
        }
        this.balls = new ArrayList<>(balls);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void setBalls(List<Ball> balls) throws IllegalArgumentException{
        if (balls == null) {
            throw new IllegalArgumentException("Argument(balls) is null");
        }
        this.balls = balls;
    }

    public void add(Ball ball) throws IllegalArgumentException{
        if (ball == null) {
            throw new IllegalArgumentException("Argument(ball) is null");
        }
        balls.add(ball);
    }

    public void remove(int index) throws IllegalArgumentException{
        if (index < 0 || (index > balls.size()-1)){
            throw new IllegalArgumentException("Argument(index) goes beyond");
        }
        balls.remove(index);
    }

    public void remove(Ball ball) throws IllegalArgumentException{
        if (ball == null){
            throw new IllegalArgumentException("Argument(ball) is null");
        }
        balls.remove(ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Basket basket = (Basket) o;
        return Objects.equals(balls, basket.balls);
    }

    @Override
    public int hashCode() {
        return ((balls == null) ? 0 : balls.hashCode());
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + "balls: " +  balls;
    }
}
