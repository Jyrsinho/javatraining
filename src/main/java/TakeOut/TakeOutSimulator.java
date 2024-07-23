package TakeOut;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TakeOutSimulator {

    Customer customer;
    FoodMenu menu;
    Scanner input;

    /**
     * Constructor for TakeOutSimulator
     *
     * @param customer customer
     * @param menu     menu
     * @param input    user input
     */
    public TakeOutSimulator(Customer customer, FoodMenu menu, Scanner input) {
        this.customer = customer;
        this.menu = menu;
        this.input = input;
    }

    public void startTakeOutSimulator() {
        while (shouldSimulate()) {
            System.out.println(STR."Hello\{customer.toString()}and welcome to my restaurant.");
            takeOutPrompt();
        }
    }

    private void takeOutPrompt() {
        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        //Display a message telling the customer how much money they have left.
        System.out.println(STR."You have \{customer.getMoney()}$ left.");
        //Prompt the user for a menu selection and store the selected Food object.
        while (isStillOrderingFood()) {
            Food selectedFood = getMenuSelection();
            if ((int) selectedFood.getPrice() > customer.getMoney()) {
                System.out.println("You don't have enough money to buy this product. Choose another" +
                        "product or checkout.");
                continue;
            }
            shoppingBag.addItem(selectedFood);
        }
        checkOutCustomer(shoppingBag);


    }

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever) {

        while (true) {
            try {
                System.out.println(userInputPrompt);
                int order = input.nextInt();
                return intUserInputRetriever.produceOutputOnIntUserInput(order);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid index. Please enter a valid index");
            }
        }
    }


    private Food getMenuSelection() {
        String userPrompt = STR."Select your food from menu\{menu}";

        IntUserInputRetriever<Food> foodSelector = (selection) -> {

            Food selectedFood = menu.getFood(selection);
            if (selectedFood == null) {
                throw new IllegalArgumentException("Invalid selection. No food item found");
            }
            return selectedFood;
        };
        return getOutputOnIntInput(userPrompt, foodSelector);

    }

    private boolean isStillOrderingFood() {
        String userPrompt = "Press 1 to continue shopping, 0 to checkout";

        IntUserInputRetriever<Boolean> retriever = selection -> {
            if (selection != 0 && selection != 1) {
                throw new IllegalArgumentException("Invalid selection. Please enter 1 or 0");
            }
            return selection != 0;
        };
        return getOutputOnIntInput(userPrompt, retriever);
    }


    private boolean shouldSimulate() {
        String userPrompt = "Enter \"1\" to CONTINUE simulation or \"0\" to EXIT program";


        IntUserInputRetriever<Boolean> retriever = (selection) -> {
            if (selection != 0 && selection != 1) {
                throw new IllegalArgumentException("Invalid selection. Please enter 1 or 0");
            }
            int lowestCost = (int) menu.getLowestCostFood().getPrice();
            int customerMoney = customer.getMoney();
            return (selection == 1 && customerMoney >= lowestCost);
        };
        return getOutputOnIntInput(userPrompt, retriever);

    }

    private void checkOutCustomer(ShoppingBag<Food> shoppingBag) {
        System.out.println("Payment processing...");

        // Calculate the customers remaining money after paying for the total cost of Food in shoppingBag.
        int customerRemainingMoney = customer.getMoney() - shoppingBag.getTotalPrice();

        // Update customer’s money with their remaining money.
        customer.setMoney(customerRemainingMoney);

        // Inform the customer of the updated money they have left.
        System.out.println(STR."Your remaining money: $\{customer.getMoney()}");

        // Display a friendly message telling our customer to enjoy their meal.
        System.out.println("Thank you and enjoy your food!");
    }

    /**
     * Test method for the TakeOutSimulator class
     *
     * @param args not used
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name:");
        String customerName = input.nextLine();
        System.out.println("Enter your money:");
        int money = input.nextInt();
        input.nextLine(); // Consume newline left-over

        FoodMenu menu = new FoodMenu();
        Customer customer = new Customer(customerName, money);
        TakeOutSimulator simulator = new TakeOutSimulator(customer, menu, input);
        simulator.startTakeOutSimulator();
    }
}

