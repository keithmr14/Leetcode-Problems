import java.util.Arrays;

public class Asteroids {

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {

        long earthMass = mass;
        int n = asteroids.length;
        int g; // unabsorbed asteroid count
        int lastN;

        do {
            g = 0; // reset g for each recursion

            for(int i = 0; i < n; i++) {

                int astMass = asteroids[i];

                // if earth >= asteroid, absorb asteroid mass
                if(earthMass >= astMass) earthMass += astMass;
                else {
                    // move all unabsorbed asteroids in the front
                    asteroids[g] = astMass;
                    g++;
                }
            }

            lastN = n;
            n = g; // new search size for all unabsorbed asteroids

            // stop recursion when no asteroid was absorbed, return false
            if(lastN == n) return false;

        } while(g > 0); // stop recursion when there's no more asteroid, return true

        return true;
    }

    public static void main(String[] args) {

        System.out.println("2126. Destroying Asteroids");

        // example 1
        int[] a1 = {1};
        int m1 = 1;
        System.out.println("\nEarth's Mass: " + m1);
        System.out.println("Asteroids' Mass: " + Arrays.toString(a1));
        System.out.println("Earth Safe? " + asteroidsDestroyed(m1, a1));

        // example 2
        int[] a2 = {3, 9, 19, 5, 21};
        int m2 = 10;
        System.out.println("\nEarth's Mass: " + m2);
        System.out.println("Asteroids' Mass: " + Arrays.toString(a2));
        System.out.println("Earth Safe? " + asteroidsDestroyed(m2, a2));
    }
}
