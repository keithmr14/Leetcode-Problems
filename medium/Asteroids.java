package medium;

import java.util.Arrays;

public class Asteroids {

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {

        long earthMass = mass;
        int n = asteroids.length;
        int astLeft;
        int lastN;
        do {
            astLeft = 0; // assume all asteroids will be absorbed
            
            for(int i = 0; i < n; i++) {
                int astMass = asteroids[i];
                
                if(earthMass >= astMass) earthMass += astMass;
                else {
                    asteroids[astLeft] = astMass; // move all unabsorbed asteroids in the front
                    astLeft++;
                }
            }
            lastN = n;
            n = astLeft; // new search size for all unabsorbed asteroids
            
            if(lastN == n) return false; // when no asteroid was absorbed

        } while(astLeft > 0); // return true when there's no more asteroid

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
