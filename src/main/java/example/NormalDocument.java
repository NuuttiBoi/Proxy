package example;

import java.util.Date;

public class NormalDocument implements Document{
    int id;
    String content;
    Date creationDate;
    public NormalDocument(int id, String content, Date creationDate) {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
    }

    @Override
    public String getContent(User user){
        return content;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }
}
