import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B12891 {
    static int myArr[];//검사용 배열
    static int checkArr[]; //조건배열
    static int checkSecret;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int S = Integer.parseInt(st.nextToken()); //문자열길이
        int P = Integer.parseInt(st.nextToken()); //비번길이
        int Result = 0;
        char A[] = new char[S]; //전체문자배열
        myArr = new int[4];
        checkArr = new int[4];
        checkSecret = 0; //조건배열과 문자가 맞아떨어질 때마다 +1 (총 4가 되면 good)

        A = bf.readLine().toCharArray(); // 전체문자배열 받기
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken()); //4개 숫자 차례로 checkArr에 저장
            if(checkArr[i] == 0) {
                checkSecret++; //해당 문자가 0개 필요한거면 이미 해당 문자는 만족된 조건
            }
        }

        for(int i = 0; i < P; i++) { //부분문자열 처음 받을 때 세팅
            Add(A[i]); //함수 정의
        }

        if(checkSecret == 4) Result++;

        //슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            int j = i-P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSecret == 4) Result++;
        }

        System.out.println(Result);
        bf.close();
    }

    private static void Remove(char c) {
        switch(c) {
            case 'A':
                if(myArr[0] == checkArr[0]) checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]) checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]) checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch(c) {
        case 'A':
            myArr[0]++;
            if(myArr[0] == checkArr[0]) checkSecret++;
            break;
        case 'C':
            myArr[1]++;
            if(myArr[1] == checkArr[1]) checkSecret++;
            break;
        case 'G':
            myArr[2]++;
            if(myArr[2] == checkArr[2]) checkSecret++;
            break;
        case 'T':
            myArr[3]++;
            if(myArr[3] == checkArr[3]) checkSecret++;
            break;
        }
    }
}
