import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class printer {
    public int solution(int[] priorities, int location) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] result = new int[priorities.length];
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
        return map.get(priorities[location]);
    }

    public int Array_max(ArrayList<Integer> arr) {
        int max = arr.get(0);
        for(int i = 0; i < arr.size()-1; i++) {
            for( int j = i + 1 ; j < arr.size(); j++) {
                if (arr.get(i) < arr.get(j)) {
                    max = arr.get(j);
                }
            }
        }
        return  max;
    }

    public ArrayList<Integer> Array_sort(ArrayList<Integer> arr) {
        ArrayList<Integer> newArr = new ArrayList<>();
        for(int i = 0; i < arr.size()-1; i++) {
            newArr.add(arr.get(i+1));
        }
        newArr.add(arr.get(arr.size()));
        return newArr;
    }
}
