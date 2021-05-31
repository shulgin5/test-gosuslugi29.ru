package utils;

public class Utils {
    public static Object[][] concatenateOfArrays(Object[][] first, Object[][] second) {
        int sizeNewArray = first.length + second.length;
        Object[][] newArray = new Object[sizeNewArray][2];
        System.arraycopy(first, 0, newArray, 0, first.length);
        System.arraycopy(second, 0, newArray, first.length, second.length);
        return newArray;
    }
}
