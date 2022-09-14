public class TicTacToe {
    public boolean validTicTacToe(String[] board) {
        var b = new int[][] { new int[3], new int[3], new int[3] };
        int c1=0;
        int c2=0;
        for (int y=0;y<board.length;y++) {
            for (int x=0;x<board.length;x++) {
                char c = board[y].charAt(x);
                if (c == 'X') {
                    b[y][x] = 1;
                    ++c1;
                }
                else if (c == 'O') {
                    b[y][x] = 2;
                    ++c2;
                }
            }
        }

        if (c1 - c2 == 1 || c1-c2 == 0) {
            int winner = findWinner(b);
            return winner == 0 || winner == 2 && c1==c2 || winner == 1 && c1>c2 ;
        }
        return false;
    }

    public int findWinner(int[][] b) {
        int w1 = 0;
        int w2 = 0;
        for (int row=0;row<3;row++) {
            if (b[row][0] != 0 && b[row][0] == b[row][1] && b[row][1] == b[row][2]) {
                if (b[row][0] == 1) {
                    ++w1;
                }
                else {
                    ++w2;
                }
            }
        }
        for (int col=0;col<3;col++) {
            if (b[0][col] != 0 && b[0][col] == b[1][col] && b[1][col] == b[2][col]) {
                if (b[0][col] == 1) {
                    ++w1;
                }
                else {
                    ++w2;
                }
            }
        }

        if (b[0][0] != 0 && b[0][0] == b[1][1] && b[1][1] == b[2][2]) {
            if (b[1][1] == 1) {
                ++w1;
            }
            else {
                ++w2;
            }
        }

        if (b[0][2] != 0 && b[0][2] == b[1][1] && b[1][1] == b[2][0]) {
            if (b[1][1] == 1) {
                ++w1;
            }
            else {
                ++w2;
            }
        }

        if (w1 > 0 && w2 == 0) {
            return 1;
        }
        else if (w1 == 0 && w2 > 0) {
            return 2;
        }
        else if (w1 == 0 && w2 == 0) {
            return 0;
        }
        else {
            return -1;
        }
    }

}
