import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Valid {
    public boolean isAnagram(String s, String t) {
        boolean flag = false;
        int cnt = 0;

        if(string_sort(s).equals(string_sort(t))) flag = true; //문자열 동등비교 후
        return flag;
    }

    public String string_sort(String s) {  //문자열을 char[]로 만들어서 정렬 후 다시 문자열로 변환
        char[] arr = s.toCharArray();
        for(int i = 0; i<arr.length-1;i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    char c = arr[i];
                    arr[i] = arr[j];
                    arr[j] = c;
                }
            }
        }
        String array = new String(arr);
        return array;
    }
}