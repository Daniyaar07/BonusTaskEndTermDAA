import java.util.*;
public class Main {
    static String generate(Random r , int n){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i<n; i++){
            s.append((char)('a' + r.nextInt(4)));
        }
        return s.toString();
    }
    public static void main(String[] args){
        int[] counts = {10 , 100 , 1000};
        int[] sizes = {1000 , 10000 , 100000};
        Random r = new Random(42);
        System.out.println("Patterns  Text  Aho(ms)  KMP(ms)");

        for(int p : counts){
            for(int n : sizes){
                List<String> patterns = new ArrayList<>();

                for(int i =0; i < p; i++){
                    patterns.add(generate(r ,5));
                }
                String text = generate(r , n);
                double a = 0 , k = 0;

                for(int run = 0; run < 5; run++) {
                    long start = System.nanoTime();

                    int x = new AhoCorasick(patterns).search(text);
                    a += System.nanoTime() - start;

                    start = System.nanoTime();

                    int y = 0;

                    for (String word : patterns) {
                        y += KMP.search(text, word);
                    }
                    k += System.nanoTime() - start;

                    if (x != y) {
                        throw new RuntimeException("Different results");
                    }
                }
                    System.out.printf("%d  %d  %.3f  %.3f%n",
                            p , n , a / 5000000 , k / 5000000);
            }
        }
    }
}
