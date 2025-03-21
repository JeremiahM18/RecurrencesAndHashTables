/*
*  Radix Sort: Wrote a program that takes in an array of Strings and uses radix sort to sort
*   the array lexicographically. Handles uppercase letters, strings of different lengths and
*   prevents out-of-bounds errors.
 */
import java.util.HashMap;

public class RadixSort {
    public void radixSort(String[] arr, int arrSize) {
        int maxDigits = getMaxLength(arr, arrSize);

        for (int pos = maxDigits - 1; pos >= 0; pos--) {
            HashMap<Character, String[]> buckets = new HashMap<>();
            HashMap<Character, Integer> bucketCount = new HashMap<>();

            for (char c = 'A'; c <= 'Z'; c++) {
                buckets.put(c, new String[arrSize]);
                bucketCount.put(c, 0);
            }

            for (char c = 'a'; c <= 'z'; c++) {
                buckets.put(c, new String[arrSize]);
                bucketCount.put(c, 0);
            }
            // Bucket for shorter words
            buckets.put(' ', new String[arrSize]);
            bucketCount.put(' ', 0);

            // Place words into corresponding buckets
            for (String word : arr) {
                char key = getCharAt(word, pos);
                if (!buckets.containsKey(key)) {
                    buckets.put(key, new String[arrSize]);
                    bucketCount.put(key, 0);
                }
                int count = bucketCount.get(key);
                if (count < arrSize) {
                    buckets.get(key)[count] = word;
                    bucketCount.put(key, count + 1);
                }
            }

            // Collect words in lexicographic order
            int index = 0;
            int count = bucketCount.get(' ');
            for (int i = 0; i < count; i++) {
                arr[index++] = buckets.get(' ')[i];
            }
            for (char c = 'A'; c <= 'Z'; c++) {
                count = bucketCount.get(c);
                for (int i = 0; i < count; i++) {
                    arr[index++] = buckets.get(c)[i];
                }
            }
            for (char c = 'a'; c <= 'z'; c++) {
                count = bucketCount.get(c);
                for (int i = 0; i < count; i++) {
                    arr[index++] = buckets.get(c)[i];
                }
            }
        }
    }

    // Find the longest string length
    private int getMaxLength(String[] arr, int arrSize) {
        int max = 0;
        for (int i = 0; i < arrSize; i++) {
            if(arr[i].length() > max) {
                max = arr[i].length();
            }
        }
        return max;
    }

    private char getCharAt(String s, int pos) {
        if(pos < s.length()) {
            return s.charAt(pos);
        }
        return '{';
    }
}

