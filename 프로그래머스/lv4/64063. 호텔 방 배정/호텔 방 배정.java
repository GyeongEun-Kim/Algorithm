import java.util.*;
class Solution {
    static HashMap<Long,Long> hotel;
    public long[] solution(long k, long[] room_number) {
        hotel = new HashMap<>();
        List<Long> answer = new ArrayList<>();
        for (int i=0;i<room_number.length;i++) {
            long assign = findEmptyRoom(room_number[i]);
            answer.add(assign);
        }

        return answer.stream().mapToLong(i->i).toArray();
    }
    public long findEmptyRoom(long room_number) {
        if (!hotel.containsKey(room_number)) {
            //맵에 키가 없으면 == 아직 배정안된방 == 바로 배정할 수 있음
            hotel.put(room_number,room_number+1);
            return room_number;
        }
        else {
            long empty = findEmptyRoom(hotel.get(room_number));
            hotel.put(empty, empty+1);
            hotel.put(room_number,empty+1);
            return empty;
        }
    }
}