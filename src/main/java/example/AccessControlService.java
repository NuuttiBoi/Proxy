package example;

import java.nio.file.AccessDeniedException;

public class AccessControlService {

    private static AccessControlService instance = null;

    public static AccessControlService getInstance(){
        if(instance==null){
            instance = new AccessControlService();
        }
        return instance;
    }


    public boolean isAllowed(int documentId, String username) throws Exception {
        Exception AccessDeniedException = new Exception();
        if(username.equals("admin")){
            return true;
        } else
            throw AccessDeniedException;
    }
}
