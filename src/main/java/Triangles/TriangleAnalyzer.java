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

        if (lengthA <= 0 || lengthB <= 0 || lengthC <= 0) {
            return "not a triangle";
        }

        int[] sides = new int[] {lengthA, lengthB, lengthC};
        int amountOfEqualSides = countEqualSides(sides);

            return switch (amountOfEqualSides) {
                case 0 -> "scalene";
                case 1 -> "isosceles";
                case 3 -> "equilateral";
                default -> "not a triangle";
            };
    }

        public int countEqualSides(int[] sides) {

           int count= 0;

            for (int i = 0; i < 2; i++) {
                for (int j = i+1; j < sides.length; j++) {
                    if (sides[i] == sides[j]) {
                        count++;
                    }
                }
                }
            return count;
        }



}
