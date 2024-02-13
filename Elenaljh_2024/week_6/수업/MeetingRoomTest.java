package 수업;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomTest {
    static class Meeting implements Comparable<Meeting>{
        int start, end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            //종료시간이 같은 경우 시작시간이 빠른 순서대로 정렬
            return this.end != o.end ? this.end - o.end : this.start - o.start;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Meeting[] meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
        }

        //정렬
        Arrays.sort(meetings);

        //회의 선택을 최대로 하고, 선택된 회의들의 내용을 출력
        List<Meeting> list = new ArrayList<>();
        list.add(meetings[0]); //첫회의는 무조건 선택
        for (int j = 0; j < N; j++) {
            if (list.get(list.size()-1).end <= meetings[j].start) {
                list.add(meetings[j]);
            }
        }

        System.out.println(list.size()); //총 회의 개수
        for (Meeting meeting : list) {
            System.out.println(meeting);
        }
    }
}
