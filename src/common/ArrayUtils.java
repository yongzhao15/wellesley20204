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

    public static String dumpArray2D(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(String.format("%5d", arr[i][j]));
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
