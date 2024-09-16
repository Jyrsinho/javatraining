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
        return "equilateral";

    }


        public static void main(String[] args) {
        TriangleAnalyzer analyzer = new TriangleAnalyzer(10, 10, 10);
        }
}
