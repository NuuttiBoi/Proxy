package example;

import java.util.Date;

public class DocumentProxy implements Document{
    private class ProtectedDocument implements Document{
        int id;
        Date creationDate;
        String content;
        public ProtectedDocument(int id, String content, Date creationDate){
            this.id = id;
            this.content = content;
            this.creationDate = creationDate;
        }
        @Override
        public int getId() {
            return 0;
        }

        @Override
        public Date getCreationDate() {
            return null;
        }
        public String getContent(User user){
            return content;
        }
    }
    private Document document;
    private AccessControlService accessControlService = AccessControlService.getInstance();
    private User user;
    int id;
    Date creationDate;
    String content;

    public DocumentProxy(int id, String content, Date creationDate)
    {
        this.id = id;
        this.content = content;
        this.creationDate = creationDate;
        this.document = new ProtectedDocument(this.id,this.content, this.creationDate);
    }

    @Override
    public String getContent(User user) throws Exception {
        if(accessControlService.isAllowed(document.getId(), user.getName())){
            return document.getContent(user);
        } else
            return "no";
    }

    @Override
    public int getId() {
        return id;
    }

    public Date getCreationDate(){
        return creationDate;
    }

}
