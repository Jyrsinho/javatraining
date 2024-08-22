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


    public char[] replaceString(char[] source, char[] target, char[] replaceText){
        char [] newArrayString = new char[source.length - target.length + replaceText.length];



        for(int i = 0; i < source.length; i++){
            if (source[i] == target[0]) {
                newArrayString[i] = replaceText[0];
            }else {
                newArrayString[i] = source[i];
            }

        }

        return newArrayString;
    }
}
