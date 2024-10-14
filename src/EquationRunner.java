import java.util.Scanner;

    public class EquationRunner {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Welcome the user
            System.out.println("Welcome to the Linear Equation Solver!");

            // Prompt user to input the first coordinate point
            System.out.print("Enter the first coordinate point (format: (x1,y1)): ");
            String point1 = scanner.nextLine();
            int x1 = Integer.parseInt(point1.substring(1, point1.indexOf(',')));
            int y1 = Integer.parseInt(point1.substring(point1.indexOf(',') + 1, point1.length() - 1));

            // Prompt user to input the second coordinate point
            System.out.print("Enter the second coordinate point (format: (x2,y2)): ");
            String point2 = scanner.nextLine();
            int x2 = Integer.parseInt(point2.substring(1, point2.indexOf(',')));
            int y2 = Integer.parseInt(point2.substring(point2.indexOf(',') + 1, point2.length() - 1));

            // Create LinearEquation object
            LinearEquation equation = new LinearEquation(x1, y1, x2, y2);

            // Print the information
            System.out.println(equation);

            // Ask the user if they want to find a y-value for a specific x-value
            System.out.print("Enter an x-value to get a corresponding (x, y) coordinate: ");
            double xValue = scanner.nextDouble();
            System.out.println("Solved coordinate point is: " + equation.coordinateForX(xValue));
        }
    }

