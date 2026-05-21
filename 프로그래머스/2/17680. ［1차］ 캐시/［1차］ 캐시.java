import java.util.*;

class Solution {

    //DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.
    //적당한 캐시 크기 선정
    //입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다.
    //그냥 하나씩 타고 들어가서 도시 이름 비교하고 업데이트하면 분명 시간초과날텐데
    //시간복잡도에 영향 미치는 요소는
    //도시 이름 길이 / 캐시 크기
    //접두사 비교 필요하므로 트라이
    //혹은 set? LRU를 가정한 상황에서 어떤 것을 교체할지


    public int solution(int cacheSize, String[] cities) { //캐시 크기 cacheSize, 도시이름 배열 cities
        int answer = 0;

        List<String> cityDB = new ArrayList<>();

        if(cacheSize==0) return cities.length*5;

        for(int i = 0;i<cities.length;i++){
            //캐시에 있는지 조회
            String nowCity = cities[i];
            nowCity = nowCity.toLowerCase();

            if(cityDB.contains(nowCity)){ //캐시에 있다면

                cityDB.remove(nowCity); //현재 위치에서 삭제
                cityDB.add(nowCity); // 맨 뒤에 삽입
                answer++;

            }else{ //캐시에 없다면

                if(cityDB.size()<cacheSize){//현재 크기가 캐시 크기보다 작다면 그냥 넣을 수 있음
                    cityDB.add(nowCity);
                }else{//현재 크기가 캐시 크기보다 같거나 크다면 맨 앞 삭제하고 앞으로 한 칸씩 땡기고 넣어야됨
                    cityDB.remove(cityDB.get(0));
                    cityDB.add(nowCity);
                }
                answer+=5;

            }

        }

        return answer;
    }
}