import java.io.*;
import java.util.*;
public class B15552 {
    public static void main(String[] args) throws IOException {
        // 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        // 테스트케이스 수 받기
        int T = Integer.parseInt(br.readLine());
        
        // A와 B를 T번 입력받기
        for (int i = 0; i < T; i++) {
            // 스페이스 단위로 끊어서 인식하기 위해 tokenizer에 입력 전달
            st = new StringTokenizer(br.readLine());
            bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
        }
        bw.close();
    }
}

// https://m.blog.naver.com/ka28/221850826909 참고해서 완벽하게 학습하기