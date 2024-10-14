
    public class LinearEquation {
        private int x1, y1, x2, y2;

        public LinearEquation(int x1, int y1, int x2, int y2) {
            // Precondition: x1 != x2 (no vertical line)
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        // Calculate and return the distance between the two points, rounded to nearest hundredth
        public double distance() {
            double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            return Math.round(distance * 100.0) / 100.0;
        }

        // Calculate and return the slope of the line, rounded to nearest hundredth
        public String slope() {
            int deltaY = y2 - y1;
            int deltaX = x2 - x1;
            if (deltaX == 0) {
                throw new ArithmeticException("Undefined slope (vertical line).");
            }

            // If slope simplifies to a whole number
            if (deltaY % deltaX == 0) {
                return String.valueOf(deltaY / deltaX);
            }

            // Nice formatting of slope
            int gcd = gcd(Math.abs(deltaY), Math.abs(deltaX)); // Greatest common divisor
            deltaY /= gcd;
            deltaX /= gcd;

            if (deltaX < 0) {
                deltaY = -deltaY;
                deltaX = -deltaX;
            }
            return deltaY + "/" + deltaX;
        }

        // Helper method to calculate greatest common divisor
        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        // Calculate and return the y-intercept, rounded to nearest hundredth
        public double yIntercept() {
            double slope = (double) (y2 - y1) / (x2 - x1);
            double yIntercept = y1 - slope * x1;
            return Math.round(yIntercept * 100.0) / 100.0;
        }

        // Calculate and return the equation of the line in y = mx + b format
        public String equation() {
            String m = slope();
            double b = yIntercept();

            StringBuilder equation = new StringBuilder("y = ");
            if (m.equals("1")) {
                equation.append("x");
            } else if (m.equals("-1")) {
                equation.append("-x");
            } else {
                equation.append(m).append("x");
            }

            if (b > 0) {
                equation.append(" + ").append(b);
            } else if (b < 0) {
                equation.append(" - ").append(Math.abs(b));
            }

            return equation.toString();
        }

        // Return the corresponding y-coordinate for a given x value
        public String coordinateForX(double x) {
            double slope = (double) (y2 - y1) / (x2 - x1);
            double y = slope * x + yIntercept();
            return "(" + x + ", " + Math.round(y * 100.0) / 100.0 + ")";
        }

        // toString method to print information
        public String toString() {
            return "Two points: (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")\n" +
                    "Slope of line: " + equation() + "\n" +
                    "Slope: " + slope() + "\n" +
                    "Y-intercept: " + yIntercept() + "\n" +
                    "Distance: " + distance() + " units";
        }
    }
