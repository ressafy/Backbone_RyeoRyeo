
public class CompleteBInaryTreeTest {

	public static void main(String[] args) {
		CompleteBinaryTree tree = new CompleteBinaryTree(9);
		for (int i = 0; i < 9; i++) {
			tree.add((char)('A'+i));
		}
		
		//tree.bfs();
//		tree.bfs2();
//		tree.dfs();
		tree.dfsByPreOrder(1);  // 1은 루트노드 A 를 말한다.
		System.out.println();  // A 를 가장 앞에 두겠다.
		tree.dfsByInOrder(1);  // A를 중간에 두겠다.
		System.out.println(); 
		tree.dfsByPostOrder(1); // A를 맨 뒤에 두겠다.
		System.out.println();
		
	}

}
