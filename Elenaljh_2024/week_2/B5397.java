import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

class B5397 {
    public static void main(String[] args) throws IOException{
        //테스트 케이스 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            List<Character> ll = new LinkedList<>();
            ListIterator it = ll.listIterator();
            //입력부
            String strInput = br.readLine();
            //구현부
            for(char c: strInput.toCharArray()){

                if(c=='<'){
                    if(it.hasPrevious())it.previous();
                }
                else if(c=='>'){
                    if(it.hasNext())it.next();
                }
                else if(c=='-'){
                    if(it.hasPrevious()){
                        it.previous();
                        it.remove();
                    }
                }else{
                    it.add(c);
                }
            }
            //출력부
            for(char c:ll){
                System.out.print(c);
            }
            System.out.println();
        }


    }
}