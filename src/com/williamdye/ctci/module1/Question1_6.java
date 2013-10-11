package com.williamdye.ctci.module1;

/**
 * TASK:
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class Question1_6 extends AbstractMatrixQuestion
{

    public Question1_6(int[][] picture)
    {
        super(picture);
        if (pictureSizeIsInvalid())
            throw new IllegalArgumentException("The picture (matrix) must be NxN, N > 0");
    }

    private boolean pictureSizeIsInvalid()
    {
        return (matrix.length == 0) || (matrix.length != matrix[0].length);
    }

    @Override
    public void solve()
    {
        printMatrix();
        swapRowsTopToBottom();
        swapNonDiagonalEntries();
        printMatrix();
    }

    private void swapRowsTopToBottom()
    {
        int fromRow = 0;
        int toRow = n - 1;
        while (toRow > fromRow) {
            swapEntriesInRows(fromRow, toRow);
            fromRow += 1;
            toRow -= 1;
        }
    }

    private void swapEntriesInRows(int fromRow, int toRow)
    {
        for (int col = 0; col < n; col++) {
            /* XOR swap */
            matrix[toRow][col] = matrix[fromRow][col] ^ matrix[toRow][col];
            matrix[fromRow][col] = matrix[fromRow][col] ^ matrix[toRow][col];
            matrix[toRow][col] = matrix[fromRow][col] ^ matrix[toRow][col];
        }
    }

    private void swapNonDiagonalEntries()
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j)
                    swapEntries(i, j);
            }
        }
    }

    private void swapEntries(int i, int j)
    {
        matrix[j][i] = matrix[i][j] ^ matrix[j][i];
        matrix[i][j] = matrix[i][j] ^ matrix[j][i];
        matrix[j][i] = matrix[i][j] ^ matrix[j][i];
    }

    public static void main(String[] args)
    {
        int[][] matrix = new int[4][4];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;

        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 8;

        matrix[2][0] = 9;
        matrix[2][1] = 10;
        matrix[2][2] = 11;
        matrix[2][3] = 12;

        matrix[3][0] = 13;
        matrix[3][1] = 14;
        matrix[3][2] = 15;
        matrix[3][3] = 16;

        new Question1_6(matrix).solve();
    }

}
