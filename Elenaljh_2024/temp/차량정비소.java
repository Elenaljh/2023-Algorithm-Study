import java.io.*;
import java.util.*;
public class 차량정비소 {
    static class Customer {
        public int receptionNum;
        public int repairNum;
        public int arrivalTime;

        public Customer(int arrivalTime) {
            this.arrivalTime = arrivalTime;
        }
    }
    static Queue<Customer> receptionQ;
    static Queue<Customer> repairQ;
    static int[][] receptionDesk, repairDesk;
    static Customer[] customers, receptionAssigned;
    static int N, M, K, time, customersLeft;
    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        //테스트케이스
        for (int test = 1; test <= T; test++) {
            //변수 입력받기
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            customersLeft = K;

            //자료구조 초기화
            receptionQ = new ArrayDeque<>();
            repairQ = new ArrayDeque<>();
            receptionDesk = new int[3][N + 1]; //0행: 작업시간, 1행: 점유여부, 2행: 잔여시간
            repairDesk = new int[3][M + 1];
            customers = new Customer[K + 1];
            receptionAssigned = new Customer[N+1];

            //데이터 입력받기 (작업시간)
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) receptionDesk[0][i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) repairDesk[0][i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                int arrival = Integer.parseInt(st.nextToken());
                customers[i] = new Customer(arrival);
            }

            //시간흐름 + 고객방문 구현
            while (customersLeft > 0) {  //내 코드에서는 반복문 종료조건 설정하는 것이 결정적인 요소였음...ㅜㅜ
                //접수데스크 고객 배정
                //i초에 들어온 고객 배정
                for (int k = 1; k <= K; k++) {
                    if (customers[k].arrivalTime == time) {
                        receptionQ.add(customers[k]);
                    }
                }

                //큐에 있는 고객 배정
                while (!receptionQ.isEmpty()) {
                    if (!assignReception()) break;
                }

                //정비데스크 고객 배정
                while (!repairQ.isEmpty()) {
                    if (!assignRepair()) break;
                }

                //시간 흐름
                timePass();
                time++;
            }

            //고객 번호 저장
            int answer = 0;
            for (int i = 1; i <= K; i++) {
                Customer c = customers[i];
                if (c.receptionNum == A && c.repairNum == B) {
                    answer += i;
                }
            }
            if (answer == 0) answer = -1;

            sb.append("#").append(test).append(" ").append(answer).append("\n");

        }

        System.out.println(sb);

    }

    static boolean assignReception() { //남은 데스크가 있다면 최대한 많은 인원 넣기...
        int emptyDesk = -1;
        for (int i = 1; i <= N; i++) {
            if (receptionDesk[1][i]==0) {
                emptyDesk = i;
                break;
            }
        }

        if (emptyDesk == -1) {
            return false;
        }

        Customer customer = receptionQ.poll();
        customer.receptionNum = emptyDesk;
        receptionAssigned[emptyDesk] = customer;
        receptionDesk[1][emptyDesk] = 1;
        return true;
    }

    static boolean assignRepair() {
        int emptyDesk = -1;
        for (int i = 1; i <= M; i++) {
            if (repairDesk[1][i]==0) {
                emptyDesk = i;
                break;
            }
        }

        if (emptyDesk == -1) {
            return false;
        }

        Customer customer = repairQ.poll();
        customer.repairNum = emptyDesk;
        customersLeft--;
        repairDesk[1][emptyDesk] = 1;
        return true;
    }

    static void timePass() {
        //접수 시간 경과
        for (int i = 1; i <= N; i++) {
            if (receptionDesk[1][i] == 1) {
                if(++receptionDesk[2][i] == receptionDesk[0][i]) {
                    Customer c = receptionAssigned[i];
                    repairQ.add(c);
                    receptionDesk[2][i] = 0;
                    receptionDesk[1][i] = 0;
                }
            }
        }

        //수리 시간 경과
        for (int i = 1; i <= M; i++) {
            if (repairDesk[1][i] == 1) {
                if (++repairDesk[2][i] == repairDesk[0][i]) {
                    repairDesk[1][i] = 0;
                    repairDesk[2][i] = 0;
                }
            }
        }
    }
}
