public class Cube {
    // 6 faces: U, D, F, B, L, R
    // Each face is a 3x3 grid of colors
    private String[][] faces;

    public Cube() {
        faces = new String[6][9];
        // U: 0, D: 1, F: 2, B: 3, L: 4, R: 5
        for (int i = 0; i < 9; i++) faces[0][i] = "Yellow"; // U
        for (int i = 0; i < 9; i++) faces[1][i] = "White";  // D
        for (int i = 0; i < 9; i++) faces[2][i] = "Red";    // F
        for (int i = 0; i < 9; i++) faces[3][i] = "Orange"; // B
        for (int i = 0; i < 9; i++) faces[4][i] = "Blue";   // L
        for (int i = 0; i < 9; i++) faces[5][i] = "Green";  // R
    }

    public void moveU() {
        rotateFaceCW(0);
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) temp[i] = faces[2][i]; // F top
        for (int i = 0; i < 3; i++) faces[2][i] = faces[5][i]; // F <- R
        for (int i = 0; i < 3; i++) faces[5][i] = faces[3][i]; // R <- B
        for (int i = 0; i < 3; i++) faces[3][i] = faces[4][i]; // B <- L
        for (int i = 0; i < 3; i++) faces[4][i] = temp[i];     // L <- F
    }
    public void moveUPrime() { moveU(); moveU(); moveU(); }
    public void moveU2() { moveU(); moveU(); }

    public void moveD() {
        rotateFaceCW(1);
        String[] temp = new String[3];
        for (int i = 0; i < 3; i++) temp[i] = faces[2][6 + i]; // F bottom
        for (int i = 0; i < 3; i++) faces[2][6 + i] = faces[4][6 + i]; // F <- L
        for (int i = 0; i < 3; i++) faces[4][6 + i] = faces[3][6 + i]; // L <- B
        for (int i = 0; i < 3; i++) faces[3][6 + i] = faces[5][6 + i]; // B <- R
        for (int i = 0; i < 3; i++) faces[5][6 + i] = temp[i];         // R <- F
    }
    public void moveDPrime() { moveD(); moveD(); moveD(); }
    public void moveD2() { moveD(); moveD(); }

    public void moveL() {
        rotateFaceCW(4);
        String[] temp = new String[3];
        temp[0] = faces[0][0]; temp[1] = faces[0][3]; temp[2] = faces[0][6]; // U left col
        faces[0][0] = faces[3][8]; faces[0][3] = faces[3][5]; faces[0][6] = faces[3][2]; // U <- B
        faces[3][8] = faces[1][0]; faces[3][5] = faces[1][3]; faces[3][2] = faces[1][6]; // B <- D
        faces[1][0] = faces[2][0]; faces[1][3] = faces[2][3]; faces[1][6] = faces[2][6]; // D <- F
        faces[2][0] = temp[0]; faces[2][3] = temp[1]; faces[2][6] = temp[2]; // F <- U
    }
    public void moveLPrime() { moveL(); moveL(); moveL(); }
    public void moveL2() { moveL(); moveL(); }

    public void moveR() {
        rotateFaceCW(5);
        String[] temp = new String[3];
        temp[0] = faces[0][2]; temp[1] = faces[0][5]; temp[2] = faces[0][8]; // U right col
        faces[0][2] = faces[2][2]; faces[0][5] = faces[2][5]; faces[0][8] = faces[2][8]; // U <- F
        faces[2][2] = faces[1][2]; faces[2][5] = faces[1][5]; faces[2][8] = faces[1][8]; // F <- D
        faces[1][2] = faces[3][6]; faces[1][5] = faces[3][3]; faces[1][8] = faces[3][0]; // D <- B
        faces[3][6] = temp[0]; faces[3][3] = temp[1]; faces[3][0] = temp[2]; // B <- U
    }
    public void moveRPrime() { moveR(); moveR(); moveR(); }
    public void moveR2() { moveR(); moveR(); }

    public void moveF() {
        rotateFaceCW(2);
        String[] temp = new String[3];
        temp[0] = faces[0][6]; temp[1] = faces[0][7]; temp[2] = faces[0][8]; // U bottom row
        faces[0][6] = faces[4][8]; faces[0][7] = faces[4][5]; faces[0][8] = faces[4][2]; // U <- L
        faces[4][8] = faces[1][2]; faces[4][5] = faces[1][1]; faces[4][2] = faces[1][0]; // L <- D
        faces[1][2] = faces[5][0]; faces[1][1] = faces[5][3]; faces[1][0] = faces[5][6]; // D <- R
        faces[5][0] = temp[0]; faces[5][3] = temp[1]; faces[5][6] = temp[2]; // R <- U
    }
    public void moveFPrime() { moveF(); moveF(); moveF(); }
    public void moveF2() { moveF(); moveF(); }

    public void moveB() {
        rotateFaceCW(3);
        String[] temp = new String[3];
        temp[0] = faces[0][0]; temp[1] = faces[0][1]; temp[2] = faces[0][2]; // U top row
        faces[0][0] = faces[5][2]; faces[0][1] = faces[5][5]; faces[0][2] = faces[5][8]; // U <- R
        faces[5][2] = faces[1][8]; faces[5][5] = faces[1][7]; faces[5][8] = faces[1][6]; // R <- D
        faces[1][8] = faces[4][6]; faces[1][7] = faces[4][3]; faces[1][6] = faces[4][0]; // D <- L
        faces[4][6] = temp[0]; faces[4][3] = temp[1]; faces[4][0] = temp[2]; // L <- U
    }
    public void moveBPrime() { moveB(); moveB(); moveB(); }
    public void moveB2() { moveB(); moveB(); }

    private void rotateFaceCW(int face) {
        String[] old = faces[face].clone();
        faces[face][0] = old[6]; faces[face][1] = old[3]; faces[face][2] = old[0];
        faces[face][3] = old[7]; faces[face][4] = old[4]; faces[face][5] = old[1];
        faces[face][6] = old[8]; faces[face][7] = old[5]; faces[face][8] = old[2];
    }

    public String getStickerColor(String face, int row, int col) {
        int faceIdx = faceToIdx(face);
        return faces[faceIdx][row * 3 + col];
    }

    private int faceToIdx(String face) {
        switch (face) {
            case "U": return 0;
            case "D": return 1;
            case "F": return 2;
            case "B": return 3;
            case "L": return 4;
            case "R": return 5;
            default: return 0;
        }
    }
}