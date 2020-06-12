package com.company;

public class Matrix
{
    double[] data;
    int rows;
    int cols;

    Matrix(int rows, int cols)
    {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows*cols];
    }

    Matrix(double[][] d)
    {
        this.rows = d.length;
        this.cols = 0;

        // Sets number of columns based on length of the longest row
        for(int i=0; i<rows; i++)
        {
            if(d[i].length > cols)
            {
                cols = d[i].length;
            }
        }

        if(cols != 0)
        {
            this.data = new double[cols*rows];
        }
        else
        {
            System.out.println("You gave me an empty array.");
            return;
        }

        int counter = 0;
        for(int i=0; i<rows; i++)
        {
            // Add numbers to data property
            for(int j=0; j<d[i].length; j++)
            {
                data[counter] = d[i][j];
                counter++;
            }
            // Fill in the remaining cells with zeros
            for(int j=0; j<cols-d[i].length; j++)
            {
                data[counter] = 0;
                counter++;
            }
        }

    }

    public double[][] asArray()
    {
        double[][] resultArray = new double[rows][cols];

        int counter=0;
        // Fill in new array with numbers (zeros included, because it is not know whether they existed during
        // initialization of the object Matrix)
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                resultArray[i][j] = this.data[counter];
                System.out.print(resultArray[i][j] + "|");//TO REMOVE
                counter++;
            }
            System.out.print("\n");// TO REMOVE
        }
        return resultArray;
    }

    // Get number from under a specific index
    public double get(int r, int c) throws IndexOutOfBoundsException
    {
        if ((r >= 0 && r < rows) && (c >= 0 && c < cols))
        {
            return data[cols * r + c];
        }
        else
            {
            throw new IndexOutOfBoundsException("You are trying to extract number from non-existing index. Try again.");
        }
    }

    // Set number to cell from under a specific index
    public void set (int r,int c, double value) throws IndexOutOfBoundsException
    {
        if ((r >= 0 && r < rows) && (c >= 0 && c < cols))
        {
            data[cols * r + c] = value;
        }
        else
        {
            throw new IndexOutOfBoundsException("You are trying to put number into non-existing cell. Try again.");
        }
    }

    public String toString()
    {
        StringBuilder buf = new StringBuilder();
        buf.append("[");

        int counter = 0;
        for (int i = 0; i < rows; i++) {
            buf.append("[");
            for (int j = 0; j < cols; j++) {
                if(j != cols-1) { buf.append(data[counter] + ", "); }
                else            { buf.append(data[counter]); }
                counter++;
            }
            if(i != rows-1) { buf.append("], "); }
            else            { buf.append("]"); }
        }
        buf.append("]");

        return buf.toString();
    }

    public void reshape(int newRows,int newCols) throws RuntimeException
    {
        if(rows*cols != newRows*newCols)
            {throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d", rows, cols, newRows, newCols));}

        rows = newRows;
        cols = newCols;
    }

    public int[] shape()
    {
        return new int[] {rows, cols};
    }

    public Matrix add(Matrix m)
    {
        if((this.rows != m.rows) || (this.cols != m.cols))
        {
            throw new RuntimeException("The numbers of rows or columns are not the same in both matrices.");
        }

        Matrix resultMatrix = new Matrix(this.rows, this.cols);

        for(int i=0; i<data.length; i++)
        {
            resultMatrix.data[i] = this.data[i] + m.data[i];
        }

        return resultMatrix;
    }

    public Matrix add(double w)
    {
        Matrix resultMatrix = new Matrix(this.rows, this.cols);

        for(int i=0; i<data.length; i++)
        {
            resultMatrix.data[i] = this.data[i] + w;
        }
        return resultMatrix;
    }

    public Matrix sub(Matrix m)
    {
        if((this.rows != m.rows) || (this.cols != m.cols))
        {
            throw new RuntimeException("The numbers of rows or columns are not the same in both matrices.");
        }

        Matrix resultMatrix = new Matrix(this.rows, this.cols);

        for(int i=0; i<data.length; i++)
        {
            resultMatrix.data[i] = this.data[i] - m.data[i];
        }

        return resultMatrix;
    }

    public Matrix sub(double w)
    {
        Matrix resultMatrix = new Matrix(this.rows, this.cols);

        for(int i=0; i<data.length; i++)
        {
            resultMatrix.data[i] = this.data[i] - w;
        }
        return resultMatrix;
    }

    // Multiple numbers which are corresponding to each other
    public Matrix mul(Matrix m)
    {
        if((this.rows != m.rows) || (this.cols != m.cols))
        {
            throw new RuntimeException("The numbers of rows or columns are not the same in both matrices.");
        }

        Matrix resultMatrix = new Matrix(this.rows, this.cols);

        for(int i=0; i<data.length; i++)
        {
            resultMatrix.data[i] = this.data[i] * m.data[i];
        }

        return resultMatrix;
    }

    // Multiple each number by scalar
    public Matrix mul(double w)
    {
        Matrix resultMatrix = new Matrix(this.rows, this.cols);

        for(int i=0; i<data.length; i++)
        {
            resultMatrix.data[i] = this.data[i] * w;
        }
        return resultMatrix;
    }

    // Divide numbers which are corresponding to each other
    public Matrix div(Matrix m)
    {
        if((this.rows != m.rows) || (this.cols != m.cols))
        {
            throw new RuntimeException("The numbers of rows or columns are not the same in both matrices.");
        }

        Matrix resultMatrix = new Matrix(this.rows, this.cols);

        for(int i=0; i<data.length; i++)
        {
            // This is some simplification
            if(m.data[i] != 0)
            {
                resultMatrix.data[i] = this.data[i] / m.data[i];
            }
            else
            {
                resultMatrix.data[i] = 0;
            }
        }

        return resultMatrix;
    }

    // Divide numbers scalar
    public Matrix div(double w)
    {
        if(w == 0.0)
        {
            throw new RuntimeException("You cannot divide by 0!");
        }

        Matrix resultMatrix = new Matrix(this.rows, this.cols);

        for(int i=0; i<data.length; i++)
        {
            resultMatrix.data[i] = this.data[i] / w;
        }
        return resultMatrix;
    }

    // Multiple two matrices
    public Matrix dot(Matrix m)
    {
        if(this.cols != m.rows)
        {
            throw new RuntimeException("The numbers of rows or columns are not the same in both matrices.");
        }

        Matrix resultMatrix = new Matrix(this.rows, m.cols);

        int counter=0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<m.cols; j++)
            {
                for(int k=0; k<cols; k++)
                {
                    resultMatrix.data[counter] += this.data[i*cols+k] * m.data[k*m.cols+i];
                }
                counter++;
            }
        }
        return resultMatrix;
    }

    // Returns sum of squares of individual elements from matrix
    public double frobenius()
    {
        double frobNorm=0;
        for(double k : data)
        {
            frobNorm += k*k;
        }
        return frobNorm;
    }
}

