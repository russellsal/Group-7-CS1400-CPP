import java.util.Scanner;

public class Main { 
    public static void main(String [] args) {
        Scanner scnr = new Scanner(System.in);

// need try catch statement for inputs that are not perfect squares 
        System.out.println("Insert number of Individuals (Insert perfect squares ONLY ex. 4, 64, 81):");
        int numOfPpl = scnr.nextInt();
    

        int rows = getRowsColumns(numOfPpl);

        int columns = getRowsColumns(numOfPpl);

        String[][]array = new String[rows][columns];


        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                array[i][j] = "Not Infected " + "(" + (i) + "," + (j) + ")";
            }
        }

        //gets first S
        int rowOfS = getRanNum(getRowsColumns(numOfPpl));
        int columnOfS = getRanNum(getRowsColumns(numOfPpl));
        array[rowOfS][columnOfS] = "S " + "(" + (rowOfS) + "," + (columnOfS) + ")" ;

//prints array for testing
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.print(array[i][j]);
            }
        }
    }

public static int getRowsColumns(int input) {
    int Value = (int) Math.sqrt(input);
    return Value;

}

public static int getRanNum(int maxNum) {
    return (int) (Math.random() * maxNum);
}



}