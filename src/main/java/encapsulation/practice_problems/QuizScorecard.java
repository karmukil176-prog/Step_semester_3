package encapsulation.practice_problems;

public class QuizScorecard {
    public static class Scorecard {
        private final boolean[] answers;
        private int entered;

        public Scorecard(int n) {
            answers = new boolean[n];
        }

        public boolean recordAnswer(boolean correct) {
            if (entered == answers.length) return false;
            answers[entered++] = correct;
            return true;
        }

        public int getScore() {
            int n = 0;
            for (int i = 0; i < entered; i++) if (answers[i]) n++;
            return n;
        }

        public int getQuestionCount() {
            return answers.length;
        }
    }

    public static void main(String[] x) {
        Scorecard s = new Scorecard(4);
        s.recordAnswer(true);
        s.recordAnswer(true);
        s.recordAnswer(false);
        s.recordAnswer(true);
        System.out.println(s.getScore());
    }
}
