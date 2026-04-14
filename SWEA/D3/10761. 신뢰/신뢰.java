import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
 
            Queue<Integer> O = new ArrayDeque<>();
            Queue<Integer> B = new ArrayDeque<>();
            Queue<Character> buttonRobot = new ArrayDeque<>();
 
            st = new StringTokenizer(br.readLine());
 
            int n = Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i++) {
                char robot = st.nextToken().charAt(0);
                int button = Integer.parseInt(st.nextToken());
 
                buttonRobot.add(robot);
                if (robot == 'B')
                    B.add(button);
                else
                    O.add(button);
 
            }
 
            // input 끝
 
            int time = 0;
 
            int OLoc = 1;
            int BLoc = 1; // 오렌지, 블루 현재 위치
 
            while (!buttonRobot.isEmpty()) {
                char robot = buttonRobot.poll();
 
                if (robot == 'O') {
                    int Target = O.poll();
                    int tempTime = Math.abs(Target - OLoc) + 1;
                    time += tempTime;
                    OLoc = Target;
 
                    // B 처리
                    if (!B.isEmpty()) {
                         
                        int BTarget = B.peek();
                        int BDiff = Math.abs(BTarget-BLoc);
 
                        if(BDiff <= tempTime) {
                            BLoc = BTarget;
                        }else {
                            if(BTarget>BLoc) {
                                BLoc+=tempTime;
                            }else {
                                BLoc-=tempTime;
                            }
                        }
                         
                    }
 
                }
 
                else {
                    int Target = B.poll();
                    int tempTime = Math.abs(Target - BLoc) + 1;
                    time += tempTime;
                    BLoc = Target;
 
                    if (!O.isEmpty()) {
                        // O 처리
                        int OTarget = O.peek();
                        int ODiff = Math.abs(OTarget-OLoc);
 
                        if(ODiff <= tempTime) {
                            OLoc = OTarget;
                        }else {
                            if(OTarget>OLoc) {
                                OLoc+=tempTime;
                            }else {
                                OLoc-=tempTime;
                            }
                        }
                         
                    }
 
                }
 
            }
 
            System.out.println("#" + tc + " " + time);
 
        } // tc 끝
 
    } // main 끝
}