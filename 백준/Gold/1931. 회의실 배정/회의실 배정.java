
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1. 종료시간이 가장 빠른 것부터
	//1-1. 종료시간이 같다면 현재 시간과 가장 가까운 것부터
//2. 종료시간에 맞춰 현재 시간 업데이트

class meetingTime implements Comparable<meetingTime>{
	int start;
	int end;
	
	public meetingTime(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public int compareTo(meetingTime other) {
		if(this.end!=other.end) {
			return this.end-other.end;
		}
		else {
			return this.start-other.start;
		}
	}
	
	
}


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		PriorityQueue<meetingTime> meeting = new PriorityQueue<>();
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meeting.add(new meetingTime(start,end));
		}
		
		//회의 정렬완료
		
		//회의 개수 계산
		int nowTime=0;
		int meetingCnt = 0;
		for(int i = 0;i<n;i++) {
			meetingTime nowMeeting = meeting.poll();
			
			int startNow = nowMeeting.start;
			int endNow = nowMeeting.end;
			
			if(nowTime<=startNow) {
				nowTime=endNow;
				meetingCnt++;
			}else {
				continue;
			}
		}
		
		System.out.println(meetingCnt);
		
		
		
	}
}
