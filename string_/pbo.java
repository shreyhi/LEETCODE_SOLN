public class pbo {
    public static int strStr(String haystack, String needle) {
        // If needle is empty, return 0 (as per LeetCode definition)
        if (needle.length() == 0) return 0;

        int h = haystack.length();
        int n = needle.length();

        // Loop through haystack
        for (int i = 0; i <= h - n; i++) {
            // Check substring match
            if (haystack.substring(i, i + n).equals(needle)) {
                return i; // Found match
            }
        }
        return -1; // No match found
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";

        int index = strStr(haystack, needle);
        System.out.println("First occurrence index = " + index);
        System.out.println("First occurrence index = " + index);
          System.out.println("First occurrence index = " + index);

         System.out.println("First occurrence index = " + index);
         System.out.println("First occurrence index = " + index);
          System.out.println("First occurrence index = " + index);


         //this is code
         //this is code
         //this is code
          //this is code
          //this is code
          //this is code
           //this is code
            //this is code
             //this is code
         
         
         
         
         
}
}