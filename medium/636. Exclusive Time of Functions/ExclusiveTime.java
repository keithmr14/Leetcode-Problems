import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTime {

    public static int[] exclusiveTime(int n, List<String> logs) {

        int[] exclusive = new int[n]; // final exclusive time for each function

        // You need stack because the functions may lie on top of each other,
        // and you need to have a reference for all prior active functions in
        // order to successfully credit the time to the right function.

        Stack<Integer> stack = new Stack<>();

        int lastTime = 0; // the default is 0, but it will always be corrected the 1st run

        for(String log : logs) { // for each log in the list

            String[] parts = log.split(":"); // separate the 3 given data

            int id = Integer.parseInt(parts[0]);
            int time = Integer.parseInt(parts[2]);

            if(parts[1].equals("start")) {

                // if there's any prior function, give it credit for the time passed
                if(!stack.empty()) exclusive[stack.peek()] += time - lastTime;

                stack.push(id); // push function
                lastTime = time; // the start of this function
            }
            else { // if function is set to "end"

                // pop last function and give it credit for the time passed;
                // + 1 because index "ended" will only take "start" at the next index
                exclusive[stack.pop()] += time - lastTime + 1;
                lastTime = time + 1; // the index of the next time frame
            }
        }

        return exclusive; // return result array
    }

    public static void main(String[] args) {

        System.out.println("636. Exclusive Time of Functions");

        // example 1
        String[] a1 = {"0:start:0", "1:start:2", "1:end:5", "0:end:6"};
        List<String> logs1 = Arrays.asList(a1);
        System.out.println("\nLogs: " + Arrays.toString(a1));
        System.out.println("Exclusive Time: " + Arrays.toString(exclusiveTime(2, logs1)));

        // example 2
        String[] a2 = {"0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"};
        List<String> logs2 = Arrays.asList(a2);
        System.out.println("\nLogs: " + Arrays.toString(a2));
        System.out.println("Exclusive Time: " + Arrays.toString(exclusiveTime(1, logs2)));

    }
}
