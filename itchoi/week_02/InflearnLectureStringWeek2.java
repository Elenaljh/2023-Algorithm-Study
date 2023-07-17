import java.util.Scanner;

public class InflearnLectureStringWeek2 {
    // 5. 특정 문자 뒤집기 START
    /*public static void main(String[] args) {
        InflearnLectureStringWeek2 T = new InflearnLectureStringWeek2();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        char[] strC = str.toCharArray();

        int sLength = str.length();
        int lt = 0;
        int rt = sLength - 1;
        while (lt < rt) {
            if (!Character.isAlphabetic(strC[lt])) {
                lt++;
                continue;
            }

            if (!Character.isAlphabetic(strC[rt])) {
                rt--;
                continue;
            }

            char tempC = strC[lt];
            strC[lt] = strC[rt];
            strC[rt] = tempC;

            lt++;
            rt--;
        }

        return String.valueOf(strC);
    }*/
    // 5. 특정 문자 뒤집기 END

    // 6. 중복문자제거 START
    /*public static void main(String[] args) {
        InflearnLectureStringWeek2 T = new InflearnLectureStringWeek2();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        Set<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }

        return set.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
    }*/
    // 6. 중복문자제거 END

    // 7. 회문 문자열 START
    /*public static void main(String[] args) {
        InflearnLectureStringWeek2 T = new InflearnLectureStringWeek2();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        str = str.toLowerCase();
        int sLength = str.length();

        for (int i = 0; i < sLength; i++) {
            int compareJ = sLength - i - 1;
            if (str.charAt(i) != str.charAt(compareJ)) {
                return "NO";
            }
        }

        return "YES";
    }*/
    // 7. 회문 문자열 END

    // 8. 유효한 팰린드롬 START
    /*public static void main(String[] args) {
        InflearnLectureStringWeek2 T = new InflearnLectureStringWeek2();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int sLength = str.length();

        for (int i = 0; i < sLength; i++) {
            int compareJ = sLength - i - 1;
            if (str.charAt(i) != str.charAt(compareJ)) {
                return "NO";
            }
        }

        return "YES";
    }*/
    // 8. 유효한 팰린드롬 END

    // 9. 숫자만 추출 START
    /*public static void main(String[] args) {
        InflearnLectureStringWeek2 T = new InflearnLectureStringWeek2();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));
    }

    public int solution(String str) {
        return Integer.valueOf(str.replaceAll("[^0-9]", ""));
    }*/
    // 9. 숫자만 추출 END

    // 10. 문자거리 START
    /*public static void main(String[] args) {
        InflearnLectureStringWeek2 T = new InflearnLectureStringWeek2();
        Scanner kb = new Scanner(System.in);
        String s = kb.next();
        char t = kb.next().charAt(0);

        System.out.println(T.solution(s, t));
    }

    public int[] solution(String s,
                           char t) {
        int[] answer = new int[s.length()];

        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            if (s.charAt(i) == t) {
                answer[i] = 0;
                continue;
            }

            int lt = i;
            int rt = i;

            int targetNum = 1;
            while (lt > 0 || rt < sLength) {
                lt--;
                rt++;
                if (lt > 0 && s.charAt(lt) == t) {
                    answer[i] = targetNum;
                    break;
                }
                if (rt < sLength && s.charAt(rt) == t) {
                    answer[i] = targetNum;
                    break;
                }

                targetNum++;
            }
        }
        return answer;
    }*/
    // 10. 문자거리 END

    // 11. 문자열 압축 START
    public static void main(String[] args) {
        InflearnLectureStringWeek2 T = new InflearnLectureStringWeek2();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        int sLength = s.length();
        int j = 1;
        for (int i = 0; i < sLength; i++) {
            char sCharAt = s.charAt(i);

            if (i + 1 == sLength) {
                sb.append(sCharAt);
                if (j > 1) {
                    sb.append(j);
                }
                continue;
            }

            if (sCharAt == s.charAt(i + 1)) {
                j++;
            } else {
                sb.append(sCharAt);
                if (j > 1) {
                    sb.append(j);
                }

                j = 1;
            }
        }

        return sb.toString();
    }
    // 11. 문자열 압축 END
}
