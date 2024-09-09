package ArrayString;

public class ArrayString {

    public ArrayString(){}


    public char[] append(char[] array,char a){
        int oldLength = array[0];
        int newLength = oldLength+1;
        char[] newArray = new char[newLength+1];
        newArray[0] = (char) (newLength);

        for(int i = 1; i < array.length; i++){
            newArray[i] = array[i];
        }
        newArray[newLength] = a;

        return newArray;
    }


    public char[] concatenate(char[] array1,char[] array2){
        int newLength = array1[0] + array2[0];
        char[] newArray = new char[newLength+1];
        newArray[0] = (char) newLength;

        int oldArrayIndex = 1;
        int newArrayIndex = 1;

        while (oldArrayIndex < array1[0]+1) {
            newArray[newArrayIndex] = array1[oldArrayIndex];
            oldArrayIndex++;
            newArrayIndex++;
        }

        oldArrayIndex =1;

        while (oldArrayIndex < array2[0]+1) {
            newArray[newArrayIndex] = array2[oldArrayIndex];
            oldArrayIndex++;
            newArrayIndex++;
        }

        return newArray;
    }


    public char charAt(char[] array, int index){
        return array[index];
    }


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


    public char[] copyAndIncreaseArraySize(char[] oldArray, int spaceToAdd){
        char[] newArrayString = new char[oldArray.length + spaceToAdd];
        int index = 0;

        while(oldArray[index] != 0){
            newArrayString[index] = oldArray[index];
            index++;
        }

        return newArrayString;
    }



    public char[] replaceString(char[] source, char[] target, char[] replace){

        int spaceToAdd = replace.length - target.length ;
        char [] newArrayString = new char[source.length];

        char[] substring;
        int newArrayIndex = 0;
        int sourceArrayIndex = 0;

        while (source[sourceArrayIndex] != 0){
            //check whether substring of sourcearray arraysAreEqual with targetarray we are looking for
            substring = substring(source, sourceArrayIndex, target.length-1);
            if (arraysAreEqual(substring, target)){
                newArrayString = copyAndIncreaseArraySize(newArrayString, spaceToAdd);
                int replaceTextIndex = 0;
                sourceArrayIndex += target.length-1;
                //assing characters from replace to newArrayString
                while (replace[replaceTextIndex] != 0)    {
                    newArrayString[newArrayIndex] = replace[replaceTextIndex];
                    newArrayIndex++;
                    replaceTextIndex++;
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
