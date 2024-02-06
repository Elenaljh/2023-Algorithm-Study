package 수업;

public class CompleteBinaryTreeTest {
    public static void main(String[] args) {
        CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(10);
        for (int i = 0; i < 10; i++) {
            tree.add((char)(65+i));
        }

        tree.bfs();
    }
}
