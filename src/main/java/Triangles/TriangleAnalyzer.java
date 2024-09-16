package Triangles;

public class TriangleAnalyzer {

    private final int lengthA;
    private final int lengthB;
    private final int lengthC;


    public TriangleAnalyzer(int lengthA, int lengthB, int lengthC) {
        this.lengthA = lengthA;
        this.lengthB = lengthB;
        this.lengthC = lengthC;
    }


        public String analyze() {
        int[] sides = new int[lengthA + lengthB + lengthC];
        int amountOfEqualSides = countEqualSides(sides);

            return switch (amountOfEqualSides) {
                case 0 -> "scalene";
                case 1 -> "isosceles";
                case 2 -> "equilateral";
                default -> "not a triangle";
            };
    }

        public int countEqualSides(int[] sides) {

            return 0;
        }


        public static void main(String[] args) {
        TriangleAnalyzer analyzer = new TriangleAnalyzer(10, 10, 10);
        }
}
