class RoomEndTimes {

    long endTime;
    int idx;

    RoomEndTimes(long endTime, int idx) {
        this.endTime = endTime;
        this.idx = idx;
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            availableRooms.add(i);
        }

        int count[] = new int[n];

        PriorityQueue<RoomEndTimes> occupiedRooms = new PriorityQueue<RoomEndTimes>(
                (a, b) -> {
                    if (a.endTime == b.endTime) {
                        return Integer.compare(a.idx, b.idx);
                    }

                    return Long.compare(a.endTime , b.endTime);
                });

        for (int i = 0; i < meetings.length; i++) {
            int startTime = meetings[i][0];
            int endTime = meetings[i][1];

            while (!occupiedRooms.isEmpty()) {
                if (startTime >= occupiedRooms.peek().endTime) {
                    RoomEndTimes rETD = occupiedRooms.poll();
                    availableRooms.add(rETD.idx);
                } else {
                    break;
                }
            }

            if (availableRooms.isEmpty()) {
                RoomEndTimes minEndtime = occupiedRooms.poll();
                occupiedRooms.add(new RoomEndTimes(minEndtime.endTime + (endTime - startTime), minEndtime.idx));
                count[minEndtime.idx] += 1;
            } else {
                int room = availableRooms.poll();
                count[room] += 1;
                occupiedRooms.add(new RoomEndTimes(endTime, room));
            }

        }

        int maxRoomCountIdx = 0;

        for (int i = 0; i < n; i++) {
            if (count[i] > count[maxRoomCountIdx])
                maxRoomCountIdx = i;
        }

        return maxRoomCountIdx;
    }
}