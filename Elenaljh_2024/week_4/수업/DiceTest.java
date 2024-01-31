package 수업;

import java.util.Arrays;
import java.util.Scanner;

//주사위 던지기 (던지는 횟수는 6번 이하)
public class DiceTest {

    static int N, numbers[];
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("주사위 던지는 횟수: ");
        N = sc.nextInt(); //주사위 던지는 횟수
        numbers = new int[N]; //던져진 주사위 눈 저장할 배열
        System.out.print("주사위 던지기 모드(1은 중복순열, 2는 순열, 3은 중복조합, 4는 조합): ");
        int mode = sc.nextInt(); //주사위 던지기 모드
        switch (mode) {
            case 1: //중복순열
                dice1(0);
                break;
            case 2: //순열: 중복 관리
                isSelected = new boolean[7]; //주사위눈이 사용되었는지 여부 관리
                dice2(0); //맨 처음에 한번도 던진적 없으니 그냥 cnt = 0으로 입력
                break;
            case 3: //중복조합
                dice3(0,1);
                break;
            case 4: //조합
                dice4(0,1);
                break;
        }
    }

    //중복순열 : 중복을 허용하므로 isSelected 없어도 됨
    private static void dice1(int cnt) { //주사위 던지기, 인자: 몇번째 주사위인가
        //기저 조건
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        //유도 파트
        for (int i = 0; i <= 6; i++) { //모든 주사위 눈의 수를 시도
            numbers[cnt] = i; //cnt번째 던진 주사위의 눈 i //얘는 cnt번째에 계속 값이 업데이트됨. 따라서 따로 값을 취소할 필요 X
            dice1(cnt+1); //다음 주사위 던지러 가기
        }
    }

    //만약 고정된 수가 아니라 입력된 수(input[])로 순열(중복X)을 만들어야 한다면?
    private static void inputPerm(int cnt, int[] input) { //주사위 던지기, 인자: 몇번째 주사위인가
        //기저 조건
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        //isSelected 배열의 크키 = input 크기로 맞추면 된다
        //input에 들어있는 원소의 자리를 isSelected에 대응시킨다! (자리로 관리)
        //isSelected[i] == true인 경우 input[i]가 순열에 포함됨
        //유도 파트
        for (int i = 0; i <= input.length; i++) { //모든 주사위 눈의 수를 시도
            if (isSelected[i]) { //앞선 시도에서 input[i]를 이미 뽑았다면
                continue; //한번 더 숫자 뽑기
            }
            numbers[cnt] = input[i]; //cnt번째에 뽑은 숫자(input[i])를 numbers[cnt]에 저장 //얘는 cnt번째에 계속 값이 업데이트됨. 따라서 따로 값을 취소할 필요 X
            isSelected[i] = true;
            dice2(cnt+1); //다음 주사위 던지러 가기
            isSelected[i] = false; //다음턴 주사위 던지고 되돌아왔을 때 false로 만들어줘야 함! (원상복구)

        }
    }

    //순열 -> 중복x, 순서가 중요하므로 IsSelected로 이미 뽑힌 숫자 체크하면서 진행함
    private static void dice2(int cnt) { //주사위 던지기, 인자: 몇번째 주사위인가
        //기저 조건
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        //유도 파트
        for (int i = 0; i <= 6; i++) { //모든 주사위 눈의 수를 시도
            if (isSelected[i]) { //앞선 주사위에서 i가 이미 나왔다면
                continue; //주사위게임 한판 더
            }
            numbers[cnt] = i; //cnt번째 던진 주사위의 눈 i //얘는 cnt번째에 계속 값이 업데이트됨. 따라서 따로 값을 취소할 필요 X
            isSelected[i] = true;
            dice2(cnt+1); //다음 주사위 던지러 가기
            isSelected[i] = false; //다음턴 주사위 던지고 되돌아왔을 때 false로 만들어줘야 함! (원상복구)

        }
    }

    //중복 조합 - isSelected[] 필요 없음
    private static void dice3(int cnt, int start) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        //시작점부터 가능한 끝까지 선택하는 시도
        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i; //선택한 수 저장
            dice4(cnt+1, i); //다음회차에는 현재 선택한 수와 같거나 더 큰 수만 뽑을 수 있다
        }
    }


    //조합
    private static void dice4(int cnt, int start) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        //시작점부터 가능한 끝까지 선택하는 시도
        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i; //선택한 수 저장
            dice4(cnt+1, i+1); //다음회차에는 현재 선택한 수보다 큰 수만 뽑을 수 있다
        }
    }

}
