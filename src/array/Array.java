package array;

public class Array {
    public static void main(String[] args) {
        int[][] myArray = new int[4][2];

        System.out.println(myArray); // prints the default string representation of the toString() method

        int[][] newArray = new int[2][];
        newArray[0] = new int[5];
        newArray[1] = new int[2];


        // 3D array
        int[][][] threeDArray = {
                { // Primul oras
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 850, 0, 0},
                },
                { // Al 2-lea oras
                        {0, 0, 0, 0},
                        {0, 0, 280, 0},
                        {0, 320, 0, 0},
                        {0, 0, 0, 0},
                },

                { // Al 3lea oras
                        {0, 1, 0, 0},
                        {0, 0, 40, 0},
                        {0, 0, 0, 50},
                        {0, 850, 0, 0},
                },
                { // Al 4lea Oras
                        {1,0,0,0},
                        {0,4,0,0},
                        {0,0,66,0},
                        {0,850,0,0},
                }
        };

        //
        System.out.println(threeDArray[0][3][1]); // 850

        //
        System.out.println(threeDArray[1][1][2]); // 280
        System.out.println(threeDArray[1][2][1]); // 320

        //
        System.out.println(threeDArray[2][0][1]); // 1
        System.out.println(threeDArray[2][1][2]); // 40
        System.out.println(threeDArray[2][2][3]); // 50
        System.out.println(threeDArray[2][3][1]); // 850

        //
        System.out.println(threeDArray[3][0][0]); // 1
        System.out.println(threeDArray[3][1][1]); // 4
        System.out.println(threeDArray[3][2][2]); // 66
        System.out.println(threeDArray[3][3][1]); // 850

    }
}
