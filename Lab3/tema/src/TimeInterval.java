public class TimeInterval<T extends Comparable<T>>
{
    private T start;
    private T finish;

    public TimeInterval(T start, T finish)
    {
        this.start = start;
        this.finish = finish;
    }

    public T getStart() {
        return start;
    }

//    public void setStart(T start) {
//        this.start = start;
//    }
//
//    public T getFinish() {
//        return finish;
//    }
//
//    public void setFinish(T finish) {
//        this.finish = finish;
//    }

    @Override
    public String toString() {
        return "TimeInterval{" +
                "start=" + start +
                ", finish=" + finish +
                '}';
    }
}