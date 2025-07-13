import java.io.*;

public class ReadFromFile {

    public static void main(String[] args) {
        try {
            byte[] gameBoard = readGameBoard("tic-tac-toe_board.dat");
            printGameBoard(gameBoard);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readGameBoard(String filename) throws IOException {
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filename))) {
            byte[] gameBoard = new byte[9];
            for (int i = 0; i < 9; i++) {
                gameBoard[i] = inputStream.readByte();
            }
            return gameBoard;
        }
    }

    public static void printGameBoard(byte[] gameBoard) {
        System.out.println("Считанные значения из файла:");
        for (byte value : gameBoard) {
            System.out.println(value);
        }
    }
}
