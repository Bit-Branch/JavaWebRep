package by.javatr.task1.runner;

import by.javatr.task1.scanner.DataScanner;
import by.javatr.task1.entity.Ball;
import by.javatr.task1.entity.Basket;
import by.javatr.task1.util.BasketService;
import by.javatr.task1.entity.Color;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        try {
            showMainMenu();
        } catch (IllegalArgumentException | InputMismatchException e){
            e.printStackTrace();
        }
    }

    private static void showMainMenu() {
        Basket basket = new Basket();
        while (true) {
            System.out.println("-------------------------");
            System.out.println("1 - Add ball to the basket");
            System.out.println("2 - Remove ball from the basket");
            System.out.println("3 - Count the number of blue balls");
            System.out.println("4 - Calculate weight of all balls in the basket");
            System.out.println("0 - Quit");
            System.out.println("-------------------------\n");

            switch (DataScanner.enterInt()) {
                case 1: {
                    Ball ball = getInputs();
                    basket.add(ball);
                    break;
                }
                case 2: {
                    System.out.println("Enter number of ball to remove");
                    int index = DataScanner.enterInt();
                    basket.remove(index - 1);
                    break;
                }
                case 3: {
                    System.out.println("Basket has "
                            + BasketService.countBlueBalls(basket) + " blue balls");
                    break;
                }
                case 4: {
                    System.out.println("Weight of all balls in basket is "
                            + BasketService.calculateBallsWeight(basket) + " kg");
                    break;
                }
                case 0: {
                    System.out.println("Leaving the program...");
                    System.exit(0);
                    break;
                }
            }
        }
    }

    private static Ball getInputs(){
        System.out.println("Pick color of the ball");
        Color color = pickBallColor();
        System.out.println("Enter the weight of the ball");
        double weight = DataScanner.enterDouble();
        return new Ball(color, weight);
    }

    private static Color pickBallColor() {
        System.out.println("1.BLACK");
        System.out.println("2.WHITE");
        System.out.println("3.RED");
        System.out.println("4.YELLOW");
        System.out.println("5.GREEN");
        System.out.println("6.BLUE");

        Color color = null;
        boolean flag;
        do {
            flag = false;
            switch (DataScanner.enterInt()) {
                case 1: {
                    color = Color.BLACK;
                    break;
                }
                case 2: {
                    color = Color.WHITE;
                    break;
                }
                case 3: {
                    color = Color.RED;
                    break;
                }
                case 4: {
                    color = Color.YELLOW;
                    break;
                }
                case 5: {
                    color = Color.GREEN;
                    break;
                }
                case 6: {
                    color = Color.BLUE;
                    break;
                }
                default: {
                    flag = true;
                    break;
                }
            }
        } while (flag);
        return color;
    }

}
