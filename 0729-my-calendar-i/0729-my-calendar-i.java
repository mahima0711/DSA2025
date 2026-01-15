class MyCalendar {

    boolean overLap(int[] booking, int start, int end) {
        return Math.max(booking[0], start) < Math.min(booking[1], end);
    }

    List<int[]> bookings;

    public MyCalendar() {

        bookings = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {

        for (int i = 0; i < bookings.size(); i++) {
            if (overLap(bookings.get(i), startTime, endTime)) {
                return false;
            }
        }

        bookings.add(new int[] {
                startTime,
                endTime
        });

        return true;

    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */