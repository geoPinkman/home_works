import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int BOXES_IN_CONTAINER = 27;
        final int CONTAINERS_IN_TRUCK = 12;
        int containerCount = 0;
        int truckCount = 0;

        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("How many boxes are needed?");
        int boxCount = scanner.nextInt();


        for (int i = 1; i <= boxCount; i++){
            if(i % (BOXES_IN_CONTAINER * CONTAINERS_IN_TRUCK) == 1){
                truckCount++;
                System.out.println("*****************");
                System.out.println("Truck number: " + truckCount);
                System.out.println("*****************");
            }
            if(i % BOXES_IN_CONTAINER == 1){
                containerCount++;
                System.out.println("    =====================");
                System.out.println("    Container number: " + containerCount);
                System.out.println("    =====================");
            }
            System.out.println("        Box number: " + i);
        }
        System.out.println("Needs trucks: "+ truckCount);
        System.out.println("Needs containers: " + containerCount);

    }
}
