package com.williamdye.ctci.module1;

import com.williamdye.ctci.AbstractQuestion;

public abstract class AbstractMatrixQuestion extends AbstractQuestion
{

    protected int[][] matrix;
    protected int m, n;

    public AbstractMatrixQuestion(int[][] matrix)
    {
        this.matrix = matrix;
        if (matrixIsEmpty())
            throw new IllegalArgumentException("Matrix must be at least 1x1");
        this.n = matrix.length;
        this.m = matrix[0].length;
    }

    protected boolean matrixIsEmpty()
    {
        return (matrix.length == 0) || (matrix[0].length == 0);
    }

    protected void printMatrix()
    {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println();
    }

}
