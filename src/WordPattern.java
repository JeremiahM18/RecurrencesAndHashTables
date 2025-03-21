/*
*  Word Pattern: Created an algorithm that takes an input of a given string pattern a delimiter character,
*   and a string, and finds if the string input matches the pattern. Each letter in the pattern maps to exactly
*   one word in the string.
 */
import java.util.HashMap;

public class WordPattern {

    public boolean wordP(String pattern, char delimiter, String s) {
        // Split the string using the delimiter
        String delim = String.valueOf(delimiter);
        if("[\\^$.|?+(){}".contains(delim)){
            delim = "\\" + delim;
        }
        String[] words = s.split(delim);


        // If number of words doesn't match length of pattern
        if(words.length != pattern.length()){
            return false;
        }

        // Two maps to store the pattern and word mappings
        HashMap<Character, String> patternToWord = new HashMap<>();
        HashMap<String, Character> wordToPattern = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = words[i];

            // Check patter to word
            if(patternToWord.containsKey(ch)){
                if(!patternToWord.get(ch).equals(word)){
                    return false;
                }
            } else {
                patternToWord.put(ch, word);
            }

            // Check word to pattern
            if(wordToPattern.containsKey(word)){
                if(wordToPattern.get(word) != ch){
                    return false;
                }
            } else{
                wordToPattern.put(word, ch);
            }
        }
        return true;
    }
}
