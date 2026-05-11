import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, maxCnt, startRoom; //크기 n, 최대 몇 개 방 이동, 출발 방 번호
    static int[][] map;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int tc = 1;tc<=t;tc++){

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map=new int[n][n];

        maxCnt=0;
        startRoom=-1;

        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){//시작점
                int nowCnt = 1;
                int r = i;
                int c = j;

                while(true){
                    boolean flag=false;
                    for(int d = 0;d<4;d++){
                        int nr = r+dr[d];
                        int nc = c+dc[d];

                        if(nr<0 || nr>=n || nc<0 || nc>=n || map[nr][nc]!=map[r][c]+1){
                            continue;
                        }

                        flag=true;
                        nowCnt++;
                        r=nr;
                        c=nc;
                        break;


                    }
                    if(!flag) break;

                }
                if(nowCnt>maxCnt){
                    maxCnt=nowCnt;
                    startRoom=map[i][j];
                }else if(nowCnt==maxCnt){
                    startRoom=Math.min(startRoom,map[i][j]);
                }
            }
        }

        System.out.println("#"+tc+" "+startRoom+" "+maxCnt);

        }//tc 끝
    }//main 끝

}
