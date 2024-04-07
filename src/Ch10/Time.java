package Ch10;

public class Time {

    public static void main(String[] args) {
        Time a = new Time();
        Time b = new Time(555550050);
        a.printTime();
        b.printTime();
    }
    private long currentTime = 0;

    private long hour = 0;

    private long minute = 0;

    private long second = 0;

    public Time(){
        currentTime = System.currentTimeMillis();
        hour = currentTime / 3600000;
        minute = (currentTime % 3600000) / 60000;
        second = (currentTime % 60000) / 1000;
    }

    public Time(long currentTime){
        this.currentTime = currentTime;
        hour = currentTime / 3600000;
        minute = (currentTime % 3600000) / 60000;
        second = (currentTime % 60000) / 1000;
    }

    public Time(long hour, long minute, long second){
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        currentTime = hour * 3600000 + minute * 60000 + second * 1000;
    }

    public void setTime(long elapseTime){
        currentTime = elapseTime;
        hour = currentTime / 3600000;
        minute = (currentTime % 3600000) / 60000;
        second = (currentTime % 60000) / 1000;
    }

    public long getHour(){
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getSecond() {
        return second;
    }

    public void printTime(){
        System.out.println(hour + ":" + minute + ":" + second);
    }

}
