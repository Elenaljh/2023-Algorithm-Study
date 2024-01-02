package blair_2023.week_21;

import java.util.HashMap;
import java.util.Map;

public class PR1124 {

    // 💛 로그인 성공?
    // https://school.programmers.co.kr/learn/courses/30/lessons/120883

    class Solution {
        public String solution(String[] id_pw, String[][] db) {
            String answer = "";

            Map<String, String> hashMap = new HashMap<String, String>();

            for (String[] strings : db) {
                hashMap.put(strings[0], strings[1]);
            }

            if (hashMap.containsKey(id_pw[0])) {
                if (hashMap.get(id_pw[0]).equals(id_pw[1])) {
                    return "login";
                } else {
                    return "wrong pw";
                }
            } else {
                return "fail";
            }
        }
    }


    // 다른 풀이
    // class Solution {
    //    public String solution(String[] id_pw, String[][] db) {
    //        String answer = "";
    //
    //        for(int i = 0; i < db.length; i++){
    //            if(db[i][0].equals(id_pw[0])){
    //                if(db[i][1].equals(id_pw[1])){
    //                    return "login";
    //                }
    //                return "wrong pw";
    //            }
    //        }
    //        return "fail";
    //    }
    //}

    // 다른 풀이 2 - [ HP ]
    // import java.util.HashMap;
    //import java.util.Map;
    //
    //class Solution {
    //    public String solution(String[] idPw, String[][] db) {
    //        return getDb(db).get(idPw[0]) != null ? getDb(db).get(idPw[0]).equals(idPw[1]) ? "login" : "wrong pw" : "fail";
    //    }
    //
    //    private Map<String, String> getDb(String[][] db) {
    //        Map<String, String> map = new HashMap<>();
    //
    //        for (String[] array : db) {
    //            map.put(array[0], array[1]);
    //        }
    //        return map;
    //    }
    //}
}
