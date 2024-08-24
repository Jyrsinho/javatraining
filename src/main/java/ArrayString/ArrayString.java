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


    /**
     * checks whether two arrays have equal content
     * @param array1 are to be checked
     * @param array2 are to be checked
     * @return true if arrays have equal content
     */
    public boolean arraysAreEqual(char[] array1, char[] array2) {
        if(array1.length != array2.length){
            return false;
        }

        for(int i = 0; i < array1.length; i++){
            if(array1[i] != array2[i]){
                return false;
            }
        }
        return true;
    }



    public char[] replaceString(char[] source, char[] target, char[] replaceText){

        // this only applies if there is only one instance of target in the source
        // needs to be updated when there are several istances of target array in source array
        char [] newArrayString = new char[source.length - target.length + replaceText.length+1];

        char[] substring;
        int newArrayIndex = 0;
        int sourceArrayIndex = 0;

        for (int i = newArrayIndex; i < newArrayString.length; i++) {
            //check whether substring of sourcearray arraysAreEqual with targetarray we are looking for
            substring = substring(source, i, target.length);
            if (arraysAreEqual(substring, target)){
                //add characters from replaceText to newArrayString
                for (char c : replaceText) {
                    newArrayString[i] = c;
                    newArrayIndex++;
                }
            } else {
                newArrayString[newArrayIndex] = source[sourceArrayIndex];
                sourceArrayIndex++;
                newArrayIndex++;
            }
        }

        newArrayString[newArrayString.length-1] = 0;

        return newArrayString;
    }
}
