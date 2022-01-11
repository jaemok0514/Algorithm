import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hash_exam {

    public String hash(String[] participant, String[] completion ) {
        HashMap<String, Integer> maraton = new HashMap<String, Integer>(); //key가 string 타입이고 value가 integer타입인 해시맵 생성
        for(int i = 0; i < participant.length; i++) {
            if(!maraton.containsKey(participant[i])) { //참가자 이름으로 된 키 값이 없을 때
                maraton.put(participant[i], 1);
            } else { //있을 때
                maraton.put(participant[i], maraton.get(participant[i]) + 1); //값 증가
            }
        }

        for(String n : completion) {
            maraton.put(n,maraton.get(n) - 1); //완주자 이름으로 검색하여 value 1감소
        }

        String answer = "";
        answer = getKey(maraton, 1); //answer에 value가 1인 Key를 저장
        return answer;
    }

    public static <K, V> K getKey(HashMap<K,V> map, V value) { //벨류값으로 키값 호출
        for(K key : map.keySet()){
            if(value == map.get(key)) {
                return key;
            }
        }
        return null;
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);                       //참가자 오름차순 정렬
        Arrays.sort(completion);                        //완주자 오름차순 정렬
        for (int i = 0; i < completion.length; i++) {   //완주자의 수가 더 적으므로
            if (!participant[i].equals(completion[i])) {//정렬후 양쪽 배열을 비교 했을 때, 다른게 있다면 2
                answer = participant[i];
                return answer;
            }
        }
        answer = participant[participant.length - 1];    //마지막 사람이 완주 못한 사람일 수 있으므로 로직 추가
        return answer;
    }

    public String solution_two(String[] participant, String[] completion) {
        if (participant == null || completion == null) return null;

        Map<String, Boolean> map = new HashMap<>();
        for (String s : completion) {
            map.put(s, true);
        }
        for (String s : participant) {
            if (map.get(s) == null) return s;
            else map.remove(s);
        }
        return null;
    }
}