package example;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {

        HashMap<Integer, Document> library= new HashMap<>();
        Date date = new Date(2010, Calendar.MARCH,11);

        Document document = new NormalDocument(1,"Some info", date);
        DocumentProxy protectedDocument = new DocumentProxy(2, "Classified info", date);

        library.put(document.getId(), document);
        library.put(protectedDocument.getId(), protectedDocument);

        User user = new User("user");
        User user2 = new User("admin");

        System.out.println(library.get(2).getContent(user));
        System.out.println(library.get(2).getContent(user2));



    }
}