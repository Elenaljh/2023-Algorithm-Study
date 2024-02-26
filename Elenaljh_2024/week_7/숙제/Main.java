package 숙제;
import java.util.*;
import java.io.*;
public class Main {

    static class Mountain {
        public long startX;
        public long endX;
        public boolean contains = false;
        public boolean containedBy = false;

        public Mountain(long startX, long endX) {
            this.startX = Long.min(startX, endX);
            this.endX = Long.max(startX, endX);
        }

        public void containsOther(Mountain o) {
            if (this.startX < o.startX && this.endX > o.endX) {
                this.contains = true;
            }
        }

        public void containedByOther(Mountain o) {
            if (this.startX > o.startX && this.endX < o.endX) {
                this.containedBy = true;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long N = Long.parseLong(br.readLine());
        long[][] input = new long[2][(int)N];
        List<Mountain> list = new ArrayList<>();
        long answer1 = 0, answer2 = 0; //각각 다른 봉우리에 의해 포함되지 않는 봉우리 개수, 다른 봉우리를 포함하지 않는 봉우리 개수

        //자료받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            input[0][i] = Long.parseLong(st.nextToken());
            input[1][i] = Long.parseLong(st.nextToken());
        }


        //봉우리 여부 판별하기
        for (int i = 0; i <= N-4; i++) {
            //왼쪽 판별
            if (input[0][i] != input[0][i+1]) break;
            if (input[1][i] * input[1][i+1] > 0) break;
            if (input[0][i+2] != input[0][i+3]) break;
            if (input[1][i+2] * input[1][i+3] > 0) break;

            list.add(new Mountain(input[0][i], input[0][i+2]));
            i = i+3;
        }

//		System.out.println();
//		System.out.println("저장된 봉우리 정보");
//		for (Mountain m : list) {
//			System.out.println(m.startX + " " + m.endX);
//		}

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                list.get(i).containsOther(list.get(j));
                list.get(i).containedByOther(list.get(j));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            Mountain m = list.get(i);
            if (!m.contains) answer2++;
            if (!m.containedBy) answer1++;
        }

//		System.out.println();
//		System.out.println("정답 출력");
        System.out.println(answer1 + " " + answer2);
    }
}
