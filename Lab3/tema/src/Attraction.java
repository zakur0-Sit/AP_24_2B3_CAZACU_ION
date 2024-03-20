abstract class Attraction implements Comparable<Attraction>
{
    private String name;

    Attraction(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    @Override
    public int compareTo(Attraction o)
    {
        if(o == null)
            return 1;
        return this.name.compareTo(o.name);
    }
}
