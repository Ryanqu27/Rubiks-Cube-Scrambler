public class Main {
    public static void main(String[] args) {
        String scramble = ScrambleGenerator.generateScramble(20);
        javax.swing.SwingUtilities.invokeLater(() -> {
            CubeUI cubeUI = new CubeUI(scramble);
            cubeUI.setVisible(true);
        });
    }
}
