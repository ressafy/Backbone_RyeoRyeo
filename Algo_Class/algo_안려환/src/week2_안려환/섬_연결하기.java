package week2_안려환;

import java.util.*;
// 도저히 모르겠어서 해설을 보고 공부하였읍니다....
/***
class 섬_연결하기 {
    int[] parent;
    
    class Item{  // 이렇게 쓰는게 한 번에 여러 값들을 사용하기 편리해서 쓴다고 알고있습니다.
        int node1, node2, cost;
        Item(int n1, int n2, int c){
            this.node1 = n1;
            this.node2 = n2;
            this.cost = c;
        }    
    }
    
    int find(int num){  // 값이 같은지 판별하는 메서드를 만들어줍니다.
        if(parent[num] == num)
            return num;
        else
            return parent[num] = find(parent[num]); 
    }
    
    void union(int a, int b){  // 배열에 넣어주는 메서드입니다.
        parent[find(a)] = find(b);
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<Item> pq = new PriorityQueue<>((a,b) -> (a.cost - b.cost));  // 이 화살표를 처음 봤는데 저 기준으로  정렬하는 것입니다.
        parent = new int[n];  // 정수형 배열을 선언합니다.
        
        for(int i = 0; i < parent.length; i++)
            parent[i] = i;
        
        for(int i = 0; i < costs.length; i++){
            int n1 = costs[i][0];
            int n2 = costs[i][1];
            int c = costs[i][2];
            
            pq.add(new Item(n1, n2, c));
        }
        
        while(!pq.isEmpty()){  // pq 프라이오리티 큐가 빌 때까지
            Item item = pq.poll();
            
            if(find(item.node1) == find(item.node2)) continue;
            
            union(item.node1, item.node2);
            answer += item.cost;
        }
        
        
        return answer;
    }
}
***/

import java.util.Arrays;
import java.util.Comparator;   // 콤퍼레이터를 처음 보았읍니다...

class Solution {
    private int[] findParent;	//부모배열
    public int solution(int n, int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() {	//가중치를 기준으로 오름차순 정렬

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2]) {
					return o1[1] - o2[1];
				} else {
					return o1[2] - o2[2];
				}
			}
		});

		findParent = new int[n];
		for (int i = 0; i < findParent.length; i++) {	//시작은 자기자신이 부모
			findParent[i] = i;
		}

		int answer = 0;
		for (int i = 0; i < costs.length; i++) {	//출발지를 start, 도착지를 end
			int start = find(costs[i][0]);
			int end = find(costs[i][1]);
			if (start != end) { // 부모가 같지 않다면 연결이 안된 최솟값이므로
				findParent[end] = start; // 연결
				answer += costs[i][2];
			}
		}
		return answer;

    }
    	private int find(int child) {	//부모노드 값을 찾는 메서드
		if (findParent[child] == child) {
			return child;
		} else {
			return findParent[child] = find(findParent[child]);
		}
	}
}