package com.williamdye.ctci.module1;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * TASK:
 * Implement an algorithm such that if an element in an MxN matrix is 0,
 * its entire row and column is set to 0.
 */
public class Question1_7 extends AbstractMatrixQuestion
{

    private Set<Integer> clearedRows;
    private Set<Integer> clearedColumns;

    public Question1_7(int[][] matrix)
    {
        super(matrix);
        this.clearedRows = new LinkedHashSet<>();
        this.clearedColumns = new LinkedHashSet<>();
    }

    public void solve()
    {
        if (matrixIsNotEmpty()) {
            findZerosAndClearEntries();
            printMatrix();
        }
    }

    private boolean matrixIsNotEmpty()
    {
        return (m > 0) && (n > 0);
    }

    private void findZerosAndClearEntries()
    {
        for (int i = 0; i < n; i++) {
            if (rowIsNotCleared(i)) {
                for (int j = 0; j < m; j++) {
                    if (rowIsNotCleared(i) && columnIsNotCleared(j) && entryIsZero(i, j))
                        clearRowAndColumn(i, j);
                }
            }
        }
    }

    private boolean rowIsNotCleared(int i)
    {
        return !clearedRows.contains(i);
    }

    private boolean columnIsNotCleared(int j)
    {
        return !clearedColumns.contains(j);
    }

    private boolean entryIsZero(int i, int j)
    {
        return (matrix[i][j] == 0);
    }

    private void clearRowAndColumn(int row, int column)
    {
        for (int i = 0; i < m; i++)
            matrix[row][i] = 0;
        for (int j = 0; j < n; j++)
            matrix[j][column] = 0;
        clearedRows.add(row);
        clearedColumns.add(column);
    }

    public static void main(String[] args)
    {
        int[][] matrix = new int[3][5];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[0][3] = 4;
        matrix[0][4] = 0;

        matrix[1][0] = 5;
        matrix[1][1] = 6;
        matrix[1][2] = 7;
        matrix[1][3] = 8;
        matrix[1][4] = 9;

        matrix[2][0] = 10;
        matrix[2][1] = 11;
        matrix[2][2] = 0;
        matrix[2][3] = 12;
        matrix[2][4] = 13;

        new Question1_7(matrix).solve();
    }

}
