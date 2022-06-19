package eapli.base.app.other.console.connectionmanagement.application.model;

public class Sensor {

    private int[] directions = new int[2];

    public Sensor(int direction) {
        setDirections(direction);
    }

    private void setDirections(int direction) {
        switch (direction) {
            case 0:
                directions[0] = 0;
                directions[1] = 1;
                break;
            case 1:
                directions[0] = 1;
                directions[1] = 1;
                break;
            case 2:
                directions[0] = 1;
                directions[1] = 0;
                break;
            case 3:
                directions[0] = 1;
                directions[1] = -1;
                break;
            case 4:
                directions[0] = 0;
                directions[1] = -1;
                break;
            case 5:
                directions[0] = -1;
                directions[1] = -1;
                break;
            case 6:
                directions[0] = -1;
                directions[1] = 0;
                break;
            case 7:
                directions[0] = -1;
                directions[1] = 1;
                break;
            default:
                directions[0] = 0;
                directions[1] = 0;
                break;
        }
    }

    public int checkClose(int x, int y, int[][] map) {
        try {
            if (map[x + directions[0]][y + directions[1]] == 0) {
                System.out.println("Object detected by the sensors in " + (x + directions[0]) + ":" + (y + directions[1]));
                return 0;
            } else {
                return 1;
            }
        } catch (Exception e) {
            return 1;
        }
    }

    public int checkFurther(int x, int y, int[][] map) {
        try {
            if (map[x + (directions[0] * 2)][y + (directions[1] * 2)] == 0) {
                System.out.println("Object detected by the sensors in " + (x + (2 * directions[0])) + ":" + (y + (2 * directions[1])));
                return 0;
            } else {
                return 1;
            }
        } catch (Exception e) {
            return 1;
        }
    }
}
