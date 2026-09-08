import java.util.Scanner;

public class IT_2106_LAURIO_JOHNPAUL_C {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Menu
        String[] items = {
            "Burger",
            "Pizza",
            "Pasta",
            "Sandwich",
            "Fries"
        };

        double[] prices = {
            80.00,
            120.00,
            100.00,
            70.00,
            50.00
        };

        // Variables for the whole transaction
        int totalItems = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;

        char orderAgain = 'Y';

        // Display menu
        System.out.println("===== MENU =====");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-12s - $%.2f%n",
                    i + 1, items[i], prices[i]);
        }

        // Ordering process
        while (orderAgain == 'Y') {

            System.out.print("\nEnter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            // Validate item number and quantity
            if (itemNumber < 1 || itemNumber > 5 ||
                quantity < 1 || quantity > 10) {

                System.out.println(
                    "Invalid order! Please enter a valid item and quantity."
                );

            } else {

                // Ask if customer is a student
                System.out.print("Are you a student? (Y/N): ");
                char student = input.next().toUpperCase().charAt(0);

                // Calculate subtotal
                double subtotal = prices[itemNumber - 1] * quantity;

                // Calculate discount
                double discountRate;

                if (student == 'Y' && subtotal >= 500) {
                    discountRate = 0.15;
                } else if (student == 'Y') {
                    discountRate = 0.10;
                } else if (subtotal >= 500) {
                    discountRate = 0.05;
                } else {
                    discountRate = 0.00;
                }

                double discount = subtotal * discountRate;
                double orderTotal = subtotal - discount;

                // Display order details
                System.out.printf("%nSubtotal: $%.2f%n", subtotal);
                System.out.printf("Discount: $%.2f%n", discount);
                System.out.printf("Order total: $%.2f%n", orderTotal);

                // Add to overall transaction
                totalItems += quantity;
                totalBeforeDiscount += subtotal;
                totalDiscount += discount;
            }

            // Ask for another order
            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next().toUpperCase().charAt(0);
        }

        // Final summary
        double finalAmount = totalBeforeDiscount - totalDiscount;

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n",
                totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n",
                totalDiscount);
        System.out.printf("Final amount: $%.2f%n",
                finalAmount);

        System.out.println("Thank you for ordering!");

        input.close();
    }
}