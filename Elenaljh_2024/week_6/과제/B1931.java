package 과제;

import java.io.*;
import java.util.*;
/*
회의실 배정
https://www.acmicpc.net/problem/1931
 */
public class B1931 {
    static class Meeting implements Comparable<Meeting> {
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            } else {
                return this.end - o.end;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetings);
        int count = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (end <= meetings[i].start) {
                count++;
                end = meetings[i].end;
            }
        }
        System.out.println(count);
    }
}
