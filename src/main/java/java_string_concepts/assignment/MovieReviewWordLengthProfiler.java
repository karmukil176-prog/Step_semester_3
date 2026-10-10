package java_string_concepts.assignment;


public class MovieReviewWordLengthProfiler {
    public static void classifyWordLengths(String review) {
        int shortN = 0, medium = 0, longN = 0;
        for (String word : review.trim().split("\\s+")) {
            if (word.isEmpty()) continue;
            int n = word.replaceAll("[^\\p{L}]", "").length();
            if (n <= 4) shortN++;
            else if (n <= 8) medium++;
            else longN++;
        }
        System.out.printf("Short: %d | Medium: %d | Long: %d%n", shortN, medium, longN);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}
