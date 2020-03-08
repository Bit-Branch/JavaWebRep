package by.javatr.task1.entity;

import by.javatr.task1.exception.NonexistentIndexException;
import by.javatr.task1.exception.NullArgumentException;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Ball> balls;

    public Basket() {
        this.balls = new ArrayList<>();
    }

    public Basket(ArrayList<Ball> balls) throws NullArgumentException{
        setBalls(balls);
    }

    public List<Ball> getBalls() {
        return new ArrayList<>(balls);
    }

    public void setBalls(List<Ball> balls) throws NullArgumentException{
        if (balls == null) {
            throw new NullArgumentException("Argument(balls) is null");
        }
        this.balls = balls;
    }

    public void add(Ball ball) throws NullArgumentException{
        checkForNull(ball);
        balls.add(ball);
    }

    public void remove(int index) throws NonexistentIndexException{
        if (index < 0 || (index > balls.size()-1)){
            throw new NonexistentIndexException("Argument(index) goes beyond");
        }
        balls.remove(index);
    }

    public void remove(Ball ball) throws NullArgumentException{
        checkForNull(ball);
        balls.remove(ball);
    }

    private void checkForNull(Ball ball) throws NullArgumentException {
        if (ball == null){
            throw new NullArgumentException("Argument(ball) is null");
        }
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
        if (balls == null) {
            return basket.getBalls() == null;
        } else {
            return balls.equals(basket.getBalls());
        }
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
