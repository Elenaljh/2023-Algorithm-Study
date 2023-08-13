import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            int num = tangerine[i];
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
		Collections.sort(list,Collections.reverseOrder());
        int index = 0;
        while(k > 0) {
            k -= list.get(index);
            answer++;
            index++;
        }
        return answer;
    }
}

//많은거부터 다 쓰면 최소 값을 구할 수 있음
