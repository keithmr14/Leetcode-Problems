import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackOperations {

    public static List<String> buildArray(int[] target, int n) {

        List<String> ans = new ArrayList<>();
        int stream = 1;

        for(int i = 0; i < target.length && stream <= n; i++) {

            if(target[i] == stream) {
                ans.add("Push");
                stream++; // increase push value and compare the next index
            }
            else {
                ans.add("Push");
                ans.add("Pop");
                stream++; // increase push value but stay at current index
                i--;
            }
        }
        return ans;
    }

    static void main(String[] args) {

        System.out.println("1441. Build an Array With Stack Operations\n");

        // example 1
        int[] a1 = {1, 3};
        System.out.println(Arrays.toString(a1));
        System.out.println(buildArray(a1, 3) + "\n");

        // example 2
        int[] a2 = {1, 2, 3};
        System.out.println(Arrays.toString(a2));
        System.out.println(buildArray(a2, 3) + "\n");
    }
}
