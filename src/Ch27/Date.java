package Ch27;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object obj) {
        if(year == ((Date) obj).getYear() && month == ((Date) obj).getMonth() && day == ((Date) obj).getDay()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return year ^ month ^ day;
    }
}
