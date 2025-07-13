import java.io.*;

public class WriteToFile {

    public static void main(String[] args) {
        byte[] gameBoard = {1, 2, 0, 3, 2, 1, 0, 3, 2};

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("tic-tac-toe_board.dat"))) {
            for (byte value : gameBoard) {
                outputStream.writeByte(value);
            }
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
