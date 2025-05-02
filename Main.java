import java.util.Scanner;

public class Main { 
    public static void main(String [] args) {
        Scanner scnr = new Scanner(System.in);

// need try catch statement for inputs that are not perfect squares 
        System.out.println("Insert number of Individuals (Insert perfect squares ONLY ex. 4, 64, 81):");
        int numOfPpl = scnr.nextInt();
        System.out.println();
        
        
        System.out.println("Insert number (integer) of times simulation will be ran:");
        int TimeStep = scnr.nextInt();
        System.out.println();

        System.out.println("Insert probability of infection (a percent written as a decimal, ex. 0.45 from 0 to 1)");
        double probOfInfection = scnr.nextDouble();
        System.out.println();

        /* not implemented yet needs a method aswell
        System.out.println("Insert probability of recovery (a percent written as a decimal, ex. 0.45)");
        double probOfRecovery = scnr.nextDouble();
        */

        System.out.println();

        int rows = getRowsColumns(numOfPpl);

        int columns = getRowsColumns(numOfPpl);

        String[][]array = new String[rows][columns];


        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                array[i][j] = "R";
            }
        }

        //gets first S
        int rowOfS = getRanNum(getRowsColumns(numOfPpl));
        int columnOfS = getRanNum(getRowsColumns(numOfPpl));
        array[rowOfS][columnOfS] = "S " + "(" + (rowOfS) + "," + (columnOfS) + ")" ;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.println(array[i][j]);
            }
        }

        System.out.println();
        System.out.println("Ran 1 time(s).");
        System.out.println();

        for (int k = 2; k <= TimeStep; ++k) {

        ScanArray(array, probOfInfection);
        Infect(array);

        /* prints array for testing we dont need to leave this code in, its only for testing we just need to print 
        how many people are infect after each trial run*/
        // delete v once finished
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                System.out.println(array[i][j]);
            }
        // delete ^
        }
        System.out.println();
        System.out.println("Ran " + k + " time(s).");
        System.out.println();
    

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

// infection of neighbors
public static void Infect(String[][] array) {
    for (int i = 0; i < array.length; ++i) {
       for (int j = 0; j < array.length; ++j) {
        if ((array[i][j]).equals("I " + "(" + (i) + "," + (j) + ")")) {
            if ((i -1 >= 0) && ((array[i-1][j]).equals("R"))) {
                array[i-1][j] = "S " + "(" + (i-1) + "," + (j) + ")";
            }
            if ((i + 1 < array.length) && ((array[i+1][j]).equals("R"))) {
                array[i+1][j] = "S " + "(" + (i+1) + "," + (j) + ")";
            }
            if ((j - 1 >= 0) && ((array[i][j-j]).equals("R"))) {
                array[i][j -1] = "S " + "(" + (i) + "," + (j-1) + ")";
            }
            if ((j + 1 < array[i].length) && ((array[i][j+1]).equals("R"))) {
                array[i][j+1] = "S " + "(" + (i) + "," + (j+1) + ")";
            }

        }
       }
    }
}





}