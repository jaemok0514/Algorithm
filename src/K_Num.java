public class K_Num {
    public int[] find_k(int[] array, int[][] commands) {
        if (array == null || commands == null) return null; //입력값이 null일때
        int[] answer = new int[commands.length];
        for (int[] arr : commands) {
            int[] result = new int[arr[1] - arr[0] + 1];
            int j = 0;
            for (int i = 0; i <= arr[1] - arr[0]; i++) {
                result[i] = array[arr[0] + i - 1];
            }
            array_sort(result);
            answer[j] = result[arr[2] - 1];
            j++;
        }
        return answer;
    }

    public int[] array_sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int num = array[i];
                    array[i] = array[j];
                    array[j] = num;
                }
            }
        }
        return array;
    }
}