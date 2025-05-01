import java.util.Scanner;

public class Main { 
    public static void main(String [] args) {
        Scanner scnr = new Scanner(System.in);

// need try catch statement for inputs that are not perfect squares 
        System.out.println("Insert number of Individuals (Insert perfect squares ONLY ex. 4, 64, 81):");
        int numOfPpl = scnr.nextInt();

        /* not implemented yet
        System.out.println("Insert number of times simulation will be ran:");
        int TimeStep = scnr.nextInt();
        */

        System.out.println("Insert probability of infection (a percent written as a decimal, ex. 0.45 from 0 to 1)");
        double probOfInfection = scnr.nextDouble();

        /* not implemented yet
        System.out.println("Insert probability of recovery (a percent written as a decimal, ex. 0.45)");
        double probOfRecovery = scnr.nextDouble();
        */

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
                System.out.println(array[i][j]);
            }
        }
        System.out.println("1st test done");
    ScanArray(array, probOfInfection);

//print again after first round will make loop instead later just made this for testing
     for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.println(array[i][j]);
            }
        }

    }





// methods 
public static int getRowsColumns(int input) {
    int Value = (int) Math.sqrt(input);
    return Value;

}

// used for getting random place in array
public static int getRanNum(int maxNum) {
    return (int) (Math.random() * maxNum);
}

// infects s
public static String getInfection(double probOfInfection) {
    if (Math.random() <= probOfInfection) {
    return "Infected";
    }
    else return "Safe";
}

// scans array for where s is, then sees if it becomes infected or not
public static void ScanArray(String[][] array, double probofInfection) {
    for (int i = 0; i < array.length; ++i) {
       for (int j = 0; j < array.length; ++j) {
        if ((array[i][j]).equals("S " + "(" + (i) + "," + (j) + ")")) {
            if ((getInfection(probofInfection)).equals("Infected")) {
                array[i][j] = "I " + "(" + (i) + "," + (j) + ")";
            }
        }

    }
}
}





}