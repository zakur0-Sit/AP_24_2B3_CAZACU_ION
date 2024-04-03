package org.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable
{
    private String id;
    private String title;
    private String location;
    private Map<String, Object> tags = new HashMap<>();

    protected Document(String id, String title, String location)
    {
        this.id = id;
        this.title = title;
        this.location = location;
        this.tags = new HashMap<>();
    }

    public Document() {}


    public String getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public Map<String, Object> getTags()
    {
        return tags;
    }

    public String getLocation()
    {
        return location;
    }

    @Override
    public String toString()
    {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }

    public void addTag(String key, Object obj)
    {
        tags.put(key, obj);
    }
}
