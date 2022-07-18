import java.util.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }
        char[] line = new char[width];
        List<Coordinates> coordinates = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            line = in.nextLine().toCharArray();
            for (int j = 0; j < width; j++) {
                if(line[j] == '0') {
                    Coordinates c = new Coordinates(j, i);
                    coordinates.add(c);
                }
            }
        }

        for(Coordinates c : coordinates) {
            Optional<Coordinates> optHorizontal = coordinates.stream().filter(c2 -> c2.y == c.y && c2.x > c.x).findFirst();
            Optional<Coordinates> optVertical = coordinates.stream().filter(c2 -> c2.x == c.x && c2.y > c.y).findFirst();
            
            System.out.print(c);
            
            if(optHorizontal.isPresent() && optVertical.isPresent()) {
                System.out.print(optHorizontal.get());
                System.out.println(optVertical.get());
            }
            else if(!optHorizontal.isPresent() && !optVertical.isPresent()) {
                System.out.println("-1 -1 -1 -1");
            } 
            else {
                if(optHorizontal.isPresent()) {
                    System.out.print(optHorizontal.get());
                } else System.out.print("-1 -1 ");
                if(optVertical.isPresent()) {
                    System.out.println(optVertical.get());
                } else System.out.println("-1 -1 ");
            }
        }

    }
}

class Coordinates {
    public int x;
    public int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y + " ";
    }
}
