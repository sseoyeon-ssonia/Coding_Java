import java.util.ArrayList;
import java.util.Scanner;
 
/*
 목표 : 손해보지 않는 선에서 house 최댓값 수
 서비스 제공 집의 수 : house
 운영 비용 = K*K+(K-1)*(K-1)
 서비스 이용비 = M*house
 손해보지 않는다 = (M*house)-(K*K+(K-1)*(K-1))
     
 맵 전체를 하나하나 돌지 말고, 집의 위치를 저장해두고 중심으로부터 그 집들에만 방문하자.
  
  
 */
 
public class Solution {
    // 집의 위치(행, 열)를 저장하기 위한 클래스
    static class House {
        int r, c;
 
        House(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int test = sc.nextInt();
 
        for (int t = 1; t <= test; t++) {
 
            // 도시의 길이 n
            int n = sc.nextInt();
            // 집 당 내야하는 서비스 비용 m
            int m = sc.nextInt();
 
            // 집의 위치 House를 저장하기 위한 배열리스트 houseList
            ArrayList<House> houseList = new ArrayList<>();
 
            // 맵을 입력받으면서 집(1)의 위치만 따로 리스트에 저장
            // 이 때 집은 1로 입력되므로 1인 경우 리스트에 저장하는 조건문
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (sc.nextInt() == 1) {
                        houseList.add(new House(i, j));
                    }
                }
            }
 
            // 서비스를 최대치로 제공할 수 있는 집의 수
            int maxHouse = 0;
 
            // 여기부터 시작
 
            // K는 1부터 시작해서 도시 전체를 덮을 수 있는 넉넉한 범위            
            // k의 크기가 1부터 1씩 커지면서 검사
            // 이 때, k의 최댓값은 도시 전체에 서비스할 수 있는 정도. 이는 2*n 
            for (int k = 1; k <= 2*n; k++) {
                // 운영 비용 = K*K + (K-1)*(K-1)
                int Cost = k * k + (k - 1) * (k - 1);
 
                // 도시의 모든 지점 마름모의 중심점으로 가정하며 for문 돌아
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                         
                        // 모든 조건에 맞는 집 개수를 저장해둘 변수 count
                        int count = 0;
 
                        // 저장해둔 모든 집들을 하나씩 꺼내서 중심점(r, c)과의 거리를 계산
                        for (int i = 0; i < houseList.size(); i++) {
                            House h = houseList.get(i);
 
                            int rowDiff = r - h.r;
                            if (rowDiff < 0)
                                rowDiff = -rowDiff; // 음수면 양수로 변경
 
                            int colDiff = c - h.c;
                            if (colDiff < 0)
                                colDiff = -colDiff; // 음수면 양수로 변경
 
                            // 다시말해!! distance는 마름모 중심점으로부터 해당 집까지의 거리
                            // 이 때 해당 집까지의 거리는 결국 중심점으로부터 가로거리+세로거리가 됨
                            // 왜냐면 여기서 대각선 거리 못 구하니까
                            int distance = rowDiff + colDiff;
 
                            // 거리가 k보다 작으면 마름모 영역 안에 포함
                            // 그렇다면 count 증가시켜
                            if (distance < k) {
                                count++;
                            }
                        }
 
                        // 손해 보지 않는 조건 : (집 개수 * 수익) >= 운영비용
                        if (count * m >= Cost) {
                            // max값 업데이트
                            if (count > maxHouse) {
                                maxHouse = count;
                            }
                        }
                    }
                }
            }
 
            // 결과 출력
            System.out.println("#" + t + " " + maxHouse);
             
        }
    }
}