package ArrayString;

public class ArrayString {

    public ArrayString(){}



    public char[] substring(char[]array, int start, int length){
        if (start + length > array.length){
            throw new IllegalArgumentException("Substring requested is out of bounds");
        }
        char[] result = new char[length];

        for(int i = 0; i < length; i++){
            result[i] = array[start+i];
        }


        return result;
    }
}
