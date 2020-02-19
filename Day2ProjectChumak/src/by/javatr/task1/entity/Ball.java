package by.javatr.task1.entity;

public class Ball {
    private Color color;
    private double weight;

    public Ball() {
    }

    public Ball(Color color, double weight) throws IllegalArgumentException{
        if (weight <= 0){
            throw new IllegalArgumentException("Argument(weight) has " +
                    "a value less than or equal to zero");
        }
        if (color == null){
            throw new IllegalArgumentException("Argument(color) is null");
        }
        this.color = color;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) throws IllegalArgumentException{
        if (color == null){
            throw new IllegalArgumentException("Argument(color) is null");
        }
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws IllegalArgumentException{
        if (weight <= 0){
            throw new IllegalArgumentException("Argument(weight) has " +
                    "a value less than or equal to zero");
        }
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return Double.compare(ball.weight, weight) == 0 &&
                color == ball.color;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color==null) ? 0 : color.hashCode());
        long longBits = Double.doubleToLongBits(weight);
        result = prime * result + (int)(longBits - (longBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + "weight: " + weight + ",color: " + color;
    }
}
