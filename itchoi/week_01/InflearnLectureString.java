import java.util.Scanner;

public class InflearnLectureString {
    // 1. 문자 찾기 START
    /*public static void main(String[] args) {
        InflearnLectureString T = new InflearnLectureString();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(T.solution(str, c));
    }
    public int solution(String str, char t) {
        int answer = 0;
        t = Character.toLowerCase(t);
        for (char c : str.toLowerCase().toCharArray()) {
            if (c == t) {
                answer++;
            }
        }
        return answer;
    }*/
    // 1. 문자 찾기 END

    // 2. 대소문자 변환 START
    /*public static void main(String[] args) {
        InflearnLectureString T = new InflearnLectureString();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }
    public String solution(String str) {
        StringBuilder answer = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                answer.append(Character.toUpperCase(c));
                continue;
            }
            answer.append(Character.toLowerCase(c));
        }
        return answer.toString();
    }*/
    // 2. 대소문자 변환 END

    // 3. 문장 속 단어 START
    /*public static void main(String[] args) {
        InflearnLectureString T = new InflearnLectureString();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();
        System.out.println(T.solution(str));
    }
    public String solution(String str) {
        String[] arr = str.split(" ");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            String compareStr = arr[i];
            if (result.length() < compareStr.length()) {
                result = compareStr;
            }
        }
        return result;
    }*/
    // 3. 문장 속 단어 END

    // 4. 단어 뒤집기 START
    public static void main(String[] args) {
        InflearnLectureString T = new InflearnLectureString();
        Scanner kb = new Scanner(System.in);
        String[] str = new String[3];
        str[0] = kb.next();
        str[1] = kb.next();
        str[2] = kb.next();

        for (String s : T.solution(str)) {
            System.out.println(s);
        }
    }

    public String[] solution(String[] str) {
        String[] result = new String[str.length];


        for (int i = 0; i < str.length; i++) {
            String s = str[i];
            int sLength = s.length();
            int iLength = sLength / 2;

            char[] cArr = s.toCharArray();

            for (int j = 0; j < iLength; j++) {
                int jLength = sLength - j - 1;
                char tempC = cArr[j];
                cArr[j] = cArr[jLength];
                cArr[jLength] = tempC;
            }

            result[i] = new String(cArr);
        }

        return result;
    }
    // 4. 단어 뒤집기 END
}
