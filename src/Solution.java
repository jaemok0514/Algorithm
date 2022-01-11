import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Solution {
    public int returnResultInt(int[] inputArray, int[] inputCondi) {
        int start_point = 0;
        int end_point = 0;
        int result_value = 0;
        for(int i = 0; i < inputCondi.length; i++) {
            switch (i) {
                case 0:
                    start_point = inputCondi[i]-1;
                    break;
                case 1:
                    end_point = inputCondi[i]-1;
                    break;
                case 2:
                    result_value = inputCondi[i];
                    break;
            }
        }
        int[] result_array = new int[end_point - start_point + 1];
        for(int i=0; i<result_array.length; i++) {
            result_array[i] = inputArray[start_point];
            start_point = start_point + 1;
        }
        result_array = selectionSorting(result_array);
        return result_array[result_value-1];
    }

    public int[] selectionSorting(int[] input) {
        boolean temp = true;
        while(temp) {
            temp = false;
            for(int i=0; i<input.length-1; i++) {
                int temp_value = 0;
                if(input[i]>input[i+1]) {
                    temp_value = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp_value;
                    temp = true;
                    break;
                }
            }
        }
        return input;
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            answer[i] = returnResultInt(array, commands[i]);
        }
        return answer;
    }

    @Test
    void test() {
        Solution test = new Solution();
        int[] input1 = {1, 5, 2, 6, 3, 7, 4};
        int[][] input2 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = {5, 6, 3};
        for(int i=0; i<result.length; i++) { //배열끼리 비교하려니 주소값이 달라서 오류 발생..
            assertEquals(result[i], test.solution(input1, input2)[i]);
        }
    }
}