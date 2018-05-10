import java.util.Scanner;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        boolean canBoost = true;

        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.err.println("Next (" + nextCheckpointX + "," + nextCheckpointY + ") at " + nextCheckpointDist + " with angle " + nextCheckpointAngle);

            /**
             si nextCheckpointAngle > 90 or nextCheckpointAngle < -90 alors
             thurst = 0
             sinon
             thurst = 100
             fin si
             */
            int thrust = 100;
            if (nextCheckpointAngle > 90 || nextCheckpointAngle < -90) {
                thrust = 0;
            }

            if (canBoost && nextCheckpointAngle < 20 && nextCheckpointAngle > -20 && nextCheckpointDist > 5000) {
                thrust = -1;
                canBoost = false;
            }

            if (nextCheckpointAngle < 10 && nextCheckpointAngle > -10 && nextCheckpointDist < 2500) {
                thrust = 75;
            }

            if (((nextCheckpointAngle > 40 && nextCheckpointAngle < 60) || (nextCheckpointAngle > -60 && nextCheckpointAngle < -40))  && nextCheckpointDist < 1500) {
                thrust = 0;
            }

            System.err.println("Thrust : " + thrust);

            // You have to output the target position
            // followed by the power (0 <= thrust <= 100)
            // i.e.: "x y thrust"
            System.out.println(nextCheckpointX + " " + nextCheckpointY + " " + (thrust != -1 ? thrust : "BOOST Boost !!"));
        }
    }
}
