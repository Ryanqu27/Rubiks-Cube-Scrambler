import java.util.Random;

public class ScrambleGenerator {
    private static final String[] MOVES = {
        "U", "U'", "U2",
        "D", "D'", "D2",
        "L", "L'", "L2",
        "R", "R'", "R2",
        "F", "F'", "F2",
        "B", "B'", "B2"
    };

    public static String generateScramble(int length) {
        Random rand = new Random();
        StringBuilder scramble = new StringBuilder();
        String lastFace = "";
        for (int i = 0; i < length; i++) {
            String move;
            String face;
            do {
                move = MOVES[rand.nextInt(MOVES.length)];
                face = move.substring(0, 1);
            } while (face.equals(lastFace));
            scramble.append(move).append(" ");
            lastFace = face;
        }
        return scramble.toString().trim();
    }
}
