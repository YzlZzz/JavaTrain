package Ch22;

public class KMP {

    public static int KMPMatch(String text, String pattern){
        int[] fail = getFailure(pattern);

        int i = 0, k = 0;

        while(i < text.length()){
            if(text.charAt(i) == pattern.charAt(k)){
                if(k == pattern.length() - 1) return i - pattern.length() + 1;
                i++;
                k++;
            }
            else {
                if(k > 0) k = fail[k - 1];
                else i++;
            }
        }

        return -1;
    }

    private static int[] getFailure(String pattern){
        int[] failure = new int[pattern.length()];

        int i = 1, k = 0;

        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(k)){
                failure[i] = k + 1;
                i++;
                k++;
            } else if (k > 0) {
                k = failure[k - 1];
            }
            else i++;
        }
        return failure;
    }
}
