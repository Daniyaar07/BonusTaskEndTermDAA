public class KMP {
    static int search(String text , String pattern){
        int[] lps = new int[pattern.length()];
        int j = 0;
        int count = 0;

        for(int i = 1; i < pattern.length(); i++){
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = lps[j - 1];
            }
            if(pattern.charAt(i) == pattern.charAt(j)){
                j++;
            }
            lps[i] = j;
        }
        j = 0;
        for(char c : text.toCharArray()){
            while (j > 0 && c!= pattern.charAt(j)){
                j = lps[j - 1];
            }
            if(c== pattern.charAt(j)){
                j++;
            }
            if(j == pattern.length()){
                count++;
                j = lps[j - 1];
            }
        }
        return count;
    }
}
