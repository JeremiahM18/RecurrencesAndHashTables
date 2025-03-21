public class Main {
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        String[] arr = 	{"google", "gojo",	"amazingly", "jogo",	"luna", "pup", "solas",	"solo",	"pupperino",	"amaterasu",
                "amazon",	"puppy",	"hydra",	"amazonia",	"vueltiao"};

        int n = arr.length;
        radixSort.radixSort(arr,n);
        for(String str : arr) {
            System.out.println(str);
        }

        WordPattern wordPattern = new WordPattern();
        // Examples
        System.out.println(wordPattern.wordP("abba", '?', "dog?cat?cat?dog"));
        System.out.println(wordPattern.wordP("abba", '|', "apple|banana|grape|apple"));
        System.out.println(wordPattern.wordP("aaaa", ',', "dog,cat,cat,dog"));
        System.out.println(wordPattern.wordP("aaaa", ' ', "ice cream taco day"));
        System.out.println(wordPattern.wordP("adxp", ' ', "ice cream taco day"));
    }

}
