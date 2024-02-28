package 스터디;

import java.util.*;
import java.io.*;
public class SW2477_차량정비소 {
    static class Customer {
        public int receiptNumber, repairNumber, customerNumber;

        public Customer(int customerNumber) {
            this.customerNumber = customerNumber;
        }
    }
    static int N, M, K, A, B, receipt[], repair[];
    static int[] receiptTime, repairTime;
    static boolean[] personInRepair;
    static Customer[] personInReceipt;
    static Queue<Customer> receiptQueue = new ArrayDeque<>();
    static Queue<Customer> repairQueue = new ArrayDeque<>();
    static Customer[] customerArrival;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); //접수 창구 수 (i번째 직원의 처리 시간: ai)
            M = Integer.parseInt(st.nextToken()); //정비 창구 수 (i번째 직원의 처리 시간: bi)
            K = Integer.parseInt(st.nextToken()); //방문 고객 수 (k번째 고객이 정비소에 도착하는 시간: tk)
            A = Integer.parseInt(st.nextToken()); //지갑 두고간 고객이 이용한 접수창구번호
            B = Integer.parseInt(st.nextToken()); //지갑 두고간 고객이 이용한 정비창구번호
            receipt = new int[N+1];
            repair = new int[M+1];
            customerArrival = new Customer[1001];
            receiptTime = new int[N+1];
            repairTime = new int[M+1];
            personInReceipt = new Customer[N+1];
            personInRepair = new boolean[M+1];
            Customer[] customers = new Customer[K+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) receipt[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) repair[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                int index = Integer.parseInt(st.nextToken());
                customerArrival[index] = new Customer(i);
                customers[i] = customerArrival[index];
            }

            for (int time = 0; time < 1000; time++) {
                if (customerArrival[time] != null) {
                    Customer customer = customerArrival[time];
                    arrangeReceipt(customer);
                } else {
                    if (!receiptQueue.isEmpty()) {
                        arrangeReceipt(null);
                    }
                }
                if (!repairQueue.isEmpty()) {
                    arrageRepair();
                }
                receiptTimePass();
                repairTimePass();
            }

            int answer = 0;
            for (int i = 1; i < K+1; i++) {
                Customer c = customers[i];
                if (c.receiptNumber == A && c.repairNumber == B) {
                    answer+=i;
                }
            }

            sb.append("#").append(testCase).append(" ").append(answer).append("\n");

        }
        System.out.println(sb);
    }

    static void arrangeReceipt(Customer c) { //점유 여부 판단
        int receiptNum = -1;
        for (int i = 1; i <= N; i++) {
            if (personInReceipt[i] == null) {
                receiptNum = i;
                break;
            }
        }

        if (receiptNum == -1) { //모든 창구가 다 찬 경우
            if (c!=null)receiptQueue.add(c);
            return;
        }

        //비어있는 창구가 있는 경우
        if (receiptQueue.isEmpty()) { //대기자가 없는 경우
            c.receiptNumber = receiptNum; //해당 창구에 배정
            personInReceipt[receiptNum] = c;
        } else { //대기자가 있는 경우
            if (c != null) receiptQueue.add(c); //대기열에 손님 배정
            Customer newC = receiptQueue.poll();
            newC.receiptNumber = receiptNum;
            personInReceipt[receiptNum] = newC;
        }
        receiptTime[receiptNum] = receipt[receiptNum];

    }

    static void arrageRepair() {
        int repairNum = -1;
        for (int i = 1; i <= M; i++) {
            if (!personInRepair[i]) {
                repairNum = i;
                break;
            }
        }

        if (repairNum != -1) {
            Customer c = repairQueue.poll();
            personInRepair[repairNum] = true;
            c.repairNumber = repairNum;
            repairTime[repairNum] = repair[repairNum];
        }

    }

    static void receiptTimePass() {
        for (int i = 1; i <= N; i++) {
            if (personInReceipt[i] != null) {
                receiptTime[i]--;
                if (receiptTime[i] == 0) {
                    Customer c = personInReceipt[i];
                    repairQueue.add(c);
                    personInReceipt[i] = null;
                }
            }
        }
    }

    static void repairTimePass() {
        for (int i = 1; i <= M; i++) {
            if (personInRepair[i]) {
                repairTime[i]--;
                if (repairTime[i] == 0) {
                    personInRepair[i] = false;
                }
            }
        }
    }
}
