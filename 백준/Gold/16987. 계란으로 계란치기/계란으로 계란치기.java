

import java.util.Scanner;

public class Main {
	static int n; //계란 수
	static int[][] eggsInfo; //계란 내구도 무게 정보
	static int maxCnt; //깰 수 있는 최대 계란 수
	static int[][] nowEgg; //계란 상태 두는 임시 변수
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n=sc.nextInt(); //계란 수
		eggsInfo = new int[n][2]; //[][0] : 내구도 [][1] : 무게
		nowEgg = new int[n][2];
		maxCnt=0;
		
		
		for(int i = 0;i<n;i++) {
			nowEgg[i][0] = eggsInfo[i][0]=sc.nextInt();
			nowEgg[i][1] = eggsInfo[i][1]=sc.nextInt();			
		}
		
		
		eggCnt(0);
		
		System.out.println(maxCnt);
		
	}
	
	static void eggCnt(int idx) {
		//종료조건
		if(idx == n) {
			int tempCnt = 0;
			for(int i = 0;i<n;i++) {
				if(nowEgg[i][0]<=0) {
					tempCnt++;
				}
			}

			maxCnt=Math.max(tempCnt, maxCnt);
			return;
		}

		//가지치기
		//손에 든 계란이 깨졌으면 다음 계란으로
		if(nowEgg[idx][0]<=0) {
			eggCnt(idx+1);
			return;
		}


		//재귀파트
		//나를 제외한 다른 누군가 하나를 선택해서 무조건 치고 넘어감
		//칠 수 있는 계란이 있는지 확인
		boolean flag= false;

		for(int i = 0; i<n;i++) {
			if(i==idx)continue; //자기 자신은 못 침
			if(nowEgg[i][0]<=0)continue; //이미 깨진 계란 못 깸

			//여기로 왔으면 계란 깰 수 있다는 얘기
			flag = true;
			nowEgg[i][0]-=eggsInfo[idx][1];
			nowEgg[idx][0]-=eggsInfo[i][1];
			eggCnt(idx+1);
			//상태복구
			nowEgg[i][0]+=eggsInfo[idx][1];
			nowEgg[idx][0]+=eggsInfo[i][1];
		}
		if(!flag){
			eggCnt(idx+1);
		}
		
		
		
	}
}
