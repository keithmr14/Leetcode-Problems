package medium;

import java.util.Arrays;

public class DestroyAsteroids {

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {

        if(mass < 1) throw new IllegalArgumentException(
                "planet mass " + mass + " mustn't be less than 1");

        long earthMass = mass;
        int n = asteroids.length;
        int astLeft;
        int lastN;
        do {
            astLeft = 0; // non absorbed asteroids in this current loop

            for(int i = 0; i < n; i++) {

                int astMass = asteroids[i];

                if(astMass < 1) throw new IllegalArgumentException("asteroid mass "
                        + mass + " at index " + i + " mustn't be less than 1");

                if(earthMass >= astMass) earthMass += astMass;
                else {
                    asteroids[astLeft] = astMass;
                    astLeft++;
                }
            }
            lastN = n;
            n = astLeft;

            if(lastN == n) return false; // no asteroids were absorbed

        } while(astLeft > 0); // all asteroids were absorbed

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
