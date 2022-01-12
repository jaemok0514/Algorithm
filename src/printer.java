import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class printer {
    public int solution(int[] priorities, int location) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int pos = 1;
        for(int i = 0; i < priorities.length;i++) {
            arr.add(priorities[i]);
            map.put(i+1,i);
        }

        while(pos <= priorities.length) {
            if(arr.get(0) < Array_max(arr)) { //최댓값이 아닐때
                arr = Array_sort(arr); // 첫 번째 수가 최댓값이 아니면 제일 뒤로 보내줌
                int num = map.get(pos); // map의 첫 번째 값 저장
                for(int j=pos;j<=map.size();j++) {
                    if(j+1 > map.size()) {
                        map.put(j,num);
                    } else {
                        map.put(j,map.get(j+1));
                    }
                } //hashmap 최신화
            } else { //첫번쨰가 최댓값일때
                arr.remove(0);
                pos++;
            }
        }

        return getKey(map,location);
    }

    public int Array_max(ArrayList<Integer> arr) {
        int max = arr.get(0);
        for(int i = 1; i < arr.size(); i++) {
            if(max < arr.get(i)) {
                max = arr.get(i);
            }
        }
        return  max;
    }

    public ArrayList<Integer> Array_sort(ArrayList<Integer> arr) {
        ArrayList<Integer> newArr = new ArrayList<>();
        for(int i = 1; i < arr.size(); i++) {
            newArr.add(arr.get(i));
        }
        newArr.add(arr.get(0));
        return newArr;
    }

    public static <K, V> K getKey(Map<K,V> map, V value) { //벨류값으로 키값 호출
        for(K key : map.keySet()){
            if(value == map.get(key)) {
                return key;
            }
        }
        return null;
    }

    @Test
    void test() {
        printer print = new printer();
            int[] input1 = {2,1,3,2};
            int location1 = 2;
            int result1 = 1;
            assertEquals(result1,print.solution(input1,location1));

            int[] input2 = {1,1,9,1,1,1};
            int location2 = 0;
            int result2 = 5;
            assertEquals(result2,print.solution(input2,location2));
    }
}