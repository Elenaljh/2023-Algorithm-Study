https://school.programmers.co.kr/learn/courses/30/lessons/17680
https://j2wooooo.tistory.com/121
https://velog.io/@dustle/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-1%EC%B0%A8-%EC%BA%90%EC%8B%9C-Java
/*
LRU란 가장 오랫동안 참조되지 않은 페이지 삭제하는것
오랫동안 참조되지 않은것 어떻게 판단할것인가. 
> 생각하다가 우선순위 큐와 hashmap을 이용해 구현하려하였다 우선순위큐로 알아서 우선순위에맞게 구현되며 참조시간 업데이트시 hashmap을 통해 O(1) 방식을 통해 업데이트 하려하였다.
LRU알고리즘을 보다가 LIST 방식을 써서 하는걸 보게되었고 이후 적용하게 되었다.

캐시크기만큼 저장할 수 있으며 순서대로 저장된다.
캐시에 없다면 5
있다면 1

ArrayList를 쓸지
LinkedList를 쓸지 고민했다. LinkedList는 get을하는데 O(n)이걸리지만 추가/삭제하는데 O(1)이걸리므로 이것을 이용하는게 더맞을거같다.
그런데 삭제를 하기위해서는 O(n)만큼 걸릴수도있다 처음부터 찾아나가기때문..

*/


import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new LinkedList<>();
        if(cacheSize == 0) {
            return cities.length * 5;
        }
        for(String city : cities) {
            city = city.toLowerCase();
            if(list.size() < cacheSize) {
                int index = list.indexOf(city);
                if(index == -1) {
                    list.add(city);
                    answer+=5;
                } else {
                    list.remove(index);
                    list.add(city);
                    answer++;
                }
            } else {
                int index = list.indexOf(city);
                if(index == -1) {
                    list.remove(0);
                    list.add(city);
                    answer+=5;
                } else {
                    list.remove(index);
                    list.add(city);
                    answer++;
                }
            }
        }
        return answer;
    }
}

