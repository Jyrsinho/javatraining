package ArrayString;

public class ArrayString {

    public ArrayString(){}



    public char[] substring(char[]oldArray, int start, int length){
        if(start+ length > oldArray.length){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        char[] newArrayString = new char[length+1];

        for (int i = 0; i < length; i++) {
            newArrayString[i] = oldArray[start];
            start++;
        }
        newArrayString[length] = 0;
        return newArrayString;
    }


    public int[] findSubStringIndexes(char[] source,  char[] target){
        int[] indexes = new int[target.length];

        return indexes;
    }


    public char[] replaceString(char[] source, char[] target, char[] replaceText){

        char [] newArrayString = new char[source.length - target.length + replaceText.length];

        int[] targetIndexes = findSubStringIndexes(source, target);

        int n = 0;

        for(int i = 0; i < source.length; i++){
            if (i == targetIndexes[n]) {
                newArrayString[i] = replaceText[i];
                n++;
            }
            newArrayString[i] = source[i];


        }

        return newArrayString;
    }
}
