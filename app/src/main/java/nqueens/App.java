/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package nqueens;

public class App {
    public static void main(String[] args) {
        if (args.length != 1 && args.length != 2 && args.length != 3) {
            System.out.println("Grade usage: ./gradlew run \"[<N>, <algorithm> <findAll>]\"");
            System.out.println("N is any positive integer");
            System.out.println("algorithm is 'b' for backtracking and 'm' for minconflict");
            System.out.println("If algorithm is b, findAll is 'true' for all solutions and 'false' for first one");
            System.out.println("Default is minconflict, N is required");
            System.out.println("Example (for 8 queens, backtracking, find all): ./gradlew run \"[8, 'b', true]\"");
            System.out.println("Example (for 10 queens, backtracking, find one): ./gradlew run \"[10, 'b', false]\"");
            System.out.println("Example (for 10 queens, minconflict): ./gradlew run \"[10, 'm', false]\"");
            System.exit(0);
        }

        int n = 1;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println(args[0] + " is not an integer");
            System.exit(0);
        }

        if (n <= 0) {
            System.out.println(args[0] + " is not an integer > 0");
            System.exit(0);
        }

        // default algo is min conflict
        String algo = "m";
        if (args.length >= 2) {
            if ("b".equals(args[1])) {
                algo = "b";
            } else if ("m".equals(args[1])) {
                algo = "m";
            } else {
                System.out.println("algorithm must be 'm' or 'b'. Got: " + args[1]);
                System.exit(0);
            }
        }

        if (algo == "b") {
            // default is find one
            boolean findAll = false;
            if (args.length == 3) {
                if ("true".equals(args[2])) {
                    findAll = true;
                } else if ("false".equals(args[2])) {
                    findAll = false;
                } else {
                    System.out.println("findAll must be true or false. Got: " + args[2]);
                    System.exit(0);
                }
            }

            NQueensBacktrack nq = new NQueensBacktrack(n);
            System.out.println("Number of solutions = " + nq.computePositions(findAll));
        } else {
            NQueensMinConflict nq = new NQueensMinConflict(n);
            boolean retVal = nq.computePositions();
            if (retVal) {
                System.out.println("Found a solution!");
            } else {
                System.out.println("No solution found");
            }
        }

    }
}
