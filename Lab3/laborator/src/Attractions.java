
public abstract class Attractions implements Comparable<Attractions>
{
    private String name;

    public Attractions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Attractions o) {
        if(o == null)
            return 1;
        return this.name.compareTo(o.name);
    }
}
