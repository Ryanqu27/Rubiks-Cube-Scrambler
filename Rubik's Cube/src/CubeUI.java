import javax.swing.*;
import java.awt.*;

public class CubeUI extends JFrame {
    private Cube cube;
    private String scramble;
    private JPanel cubePanel;
    private JButton applyScrambleButton;

    public CubeUI(String scramble) {
        this.scramble = scramble;
        this.cube = new Cube();
        setTitle("Rubik's Cube Visualizer");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel scrambleLabel = new JLabel("Scramble: " + scramble);
        add(scrambleLabel, BorderLayout.NORTH);

        cubePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawCube(g);
            }
        };
        cubePanel.setPreferredSize(new Dimension(600, 400));
        add(cubePanel, BorderLayout.CENTER);

        applyScrambleButton = new JButton("Apply Scramble");
        applyScrambleButton.addActionListener(e -> {
            applyScrambleButton.setEnabled(false);
            applyScrambleButton.setText("Scramble Applied");
            applyScramble();
            cubePanel.repaint();
        });
        add(applyScrambleButton, BorderLayout.SOUTH);
    }

    private void applyScramble() {
        String[] moves = scramble.split(" ");
        for (String move : moves) {
            switch (move) {
                case "U": cube.moveU(); break;
                case "U'": cube.moveUPrime(); break;
                case "U2": cube.moveU2(); break;
                case "D": cube.moveD(); break;
                case "D'": cube.moveDPrime(); break;
                case "D2": cube.moveD2(); break;
                case "L": cube.moveL(); break;
                case "L'": cube.moveLPrime(); break;
                case "L2": cube.moveL2(); break;
                case "R": cube.moveR(); break;
                case "R'": cube.moveRPrime(); break;
                case "R2": cube.moveR2(); break;
                case "F": cube.moveF(); break;
                case "F'": cube.moveFPrime(); break;
                case "F2": cube.moveF2(); break;
                case "B": cube.moveB(); break;
                case "B'": cube.moveBPrime(); break;
                case "B2": cube.moveB2(); break;
            }
        }
    }

    private void drawCube(Graphics g) {
        // Draw a 2D cube net: U on top, L F R B in middle row, D on bottom
        int size = 30;
        int offsetX = 100;
        int offsetY = 50;
        // U face
        drawFace(g, "U", offsetX + size * 3, offsetY, size);
        // L face
        drawFace(g, "L", offsetX, offsetY + size * 3, size);
        // F face
        drawFace(g, "F", offsetX + size * 3, offsetY + size * 3, size);
        // R face
        drawFace(g, "R", offsetX + size * 6, offsetY + size * 3, size);
        // B face
        drawFace(g, "B", offsetX + size * 9, offsetY + size * 3, size);
        // D face
        drawFace(g, "D", offsetX + size * 3, offsetY + size * 6, size);
    }

    private void drawFace(Graphics g, String face, int x, int y, int size) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                String color = cube.getStickerColor(face, row, col);
                g.setColor(getColor(color));
                g.fillRect(x + col * size, y + row * size, size, size);
                g.setColor(Color.BLACK);
                g.drawRect(x + col * size, y + row * size, size, size);
            }
        }
    }

    private Color getColor(String color) {
        switch (color) {
            case "White": return Color.WHITE;
            case "Yellow": return Color.YELLOW;
            case "Red": return Color.RED;
            case "Orange": return Color.ORANGE;
            case "Blue": return Color.BLUE;
            case "Green": return Color.GREEN;
            default: return Color.GRAY;
        }
    }
}
