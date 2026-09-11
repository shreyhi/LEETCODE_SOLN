class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        // Count occurrences
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;

        // First digit: 1 to 9
        for (int first = 1; first <= 9; first++) {

            if (freq[first] == 0) {
                continue;
            }

            freq[first]--;

            // Second digit: 0 to 9
            for (int second = 0; second <= 9; second++) {

                if (freq[second] == 0) {
                    continue;
                }

                freq[second]--;

                // Third digit: even digits
                for (int third = 0; third <= 8; third += 2) {

                    if (freq[third] > 0) {
                        count++;
                    }
                }

                // Restore second digit
                freq[second]++;
            }

            // Restore first digit
            freq[first]++;
        }

        return count;
    }
}