package common;

public class ArrayUtils {
    public static String dumpArray(int[] arr) {
        if (arr == null || arr.length == 0) {  return "";  }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        for(int i = 1; i < arr.length; i++ ) {
            sb.append(", " + arr[i]);
        }

        return sb.toString();
    }

}
