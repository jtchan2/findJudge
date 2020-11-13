import java.util.*;

public class Judge{

	public int findJudge(int N, int [][] trust){
		int [] trusts= new int[N+1];
		int [] trusted= new int[N+1];

		for(int i=0; i<trust.length; i++){
			int a= trust[i][0];
			int b= trust[i][1];

			trusts[a]--;
			trusted[b]++;
		}
		int numJudges=0;
		int judgeIndex= -1;

		for(int j=1; j< N+1; j++){
			if(trusted[j]==N-1&& trusts[j]==0){
				judgeIndex = j;
				numJudges++;
				//else just added
			}
			if(numJudges>1){
				return -1;
			}
		}
		return judgeIndex;
	}

	public static void main(String args[]){
		Judge judge= new Judge();
		int [][] p1= {{1,2}};
		int [][] p2= {{1,3},{2,3}};
		int [][] p3= {{1,3},{2,3},{3,1}};
		int [][] p4= {{1,2},{2,3}};
		int [][] p5= {{1,3},{1,4},{2,3},{2,4},{4,3}};
		int [][] p6= {{1,1}};
		int [][] p7= {};
		System.out.println(judge.findJudge(2,p1));
		System.out.println(judge.findJudge(3,p2));
		System.out.println(judge.findJudge(3,p3));
		System.out.println(judge.findJudge(3,p4));
		System.out.println(judge.findJudge(4,p5));
		System.out.println(judge.findJudge(1,p6));
		System.out.println(judge.findJudge(1,p7));

	}
}