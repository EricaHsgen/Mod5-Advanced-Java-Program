import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // see if the input is the desired input
        if (args.length == 5) {
            // get input
            try{
                
				int[] intArgs = {1,2,3,4,5}; //declare the integer argument array using temporary values

                //convert string arguments to int arguments
                for(int i = 0; i < args.length; i++){
                    int num = Integer.parseInt(args[i]);
                    intArgs[i] = num;
                }
                
                //print unsorted array
                System.out.print("Unsorted arguments: ");
                printArray(intArgs);

                MultiThreading t1 = new MultiThreading("Thread A", intArgs);
                t1.start();

                System.out.println();

                //sort array and print sorted array
                int[] sortedArr = intArgs;
                sortArray(sortedArr);
                System.out.print("Sorted arguments: ");
                printArray(sortedArr);

                System.out.println();

                // multithreading
                MultiThreading t2 = new MultiThreading("Thread B", sortedArr);
                
                t2.start();

                //print sum of all integers in array
                System.out.println("Total of all integers in array: " + addArray(intArgs));
                
            } catch (NumberFormatException e) {     //catch non-integers
                System.out.println("Invalid number. Provide integers.");
            }
        }
        else{   // if the user did not supply enough arguments/too many arguments
            System.out.println("Invalid arguments. Provide 5 integers.");
        }
    
}
    // print array method
    static void printArray(int[] numArr){
        for (int i : numArr) {
            System.out.print(i + " ");
        }
    }

    // selection sort method
    static int[] sortArray(int[] numArr){
        int n = numArr.length;
        for(int i = 0; i < n-1; i++){
            int minIndex = i;
            for(int j = i+1; j < n; j++){
                if(numArr[j] < numArr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = numArr[minIndex];
            numArr[minIndex] = numArr[i];
            numArr[i] = temp;
        }
        return numArr;
    }

    // add integers in array
    static int addArray(int[] numArr){
        int total = 0;
        for (int i : numArr) {
            total += i;
        }
        return total;
    }
}

// multithreading class
class MultiThreading extends Thread{
    private final String name;
    private final int[] numArr;

    MultiThreading(String name, int[] numArr){
        this.name = name;
        this.numArr = numArr;
    }
    
    public void run(){
        try{
            System.out.println(name + ": ");
            for (int i : numArr) {
                System.out.print(i);
                Thread.sleep(500); //time delay
            }
            System.out.println();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}