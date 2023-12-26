package demoasp;

import java.util.List;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.logging.*;

public class Login {
    private static final Logger LOGGER = Logger.getLogger(Login.class.getName());
    String ADMIN ="Admin";
    String CUSTOMER="Customer";
    String INSTALLER="Installer";
    List<User>users=new ArrayList<>();
    int roles;
    boolean isLogged;
    Mailing m;
    int verificationCode;
    User u;
    boolean validEmail;
    int userIndex;
    Login(User u){
        this.u=u;
        try {
            LOGGER.setUseParentHandlers(false);

            Handler[] handlers = LOGGER.getHandlers();
            for (int i = 0; i < handlers.length; i++) {
                LOGGER.removeHandler(handlers[i]);
            }

            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO);
            consoleHandler.setFormatter(new SimpleFormatter() {
                @Override
                public synchronized String format(java.util.logging.LogRecord logRecord) {
                    return logRecord.getMessage() + "\n";
                }
            });
            consoleHandler.setLevel(Level.INFO);
            LOGGER.addHandler(consoleHandler);
        }
        catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An unexpected error occurred during logger configuration", e);
        }



        User u1=new User("jomana.hamayel.jomana@gmail.com","123456", ADMIN);
        User u2=new User("jomanaeceasad@gmail.com","654321",CUSTOMER);
        User u3=new User("j.h.a.hamayel@gmail.com","987654",INSTALLER);
        User u4=new User("jamelahamayel785@gmail.com","jamela @123", ADMIN);
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        isLogged=false;
    }
    public boolean login() {

        if (emailValidator(u.getEmail())) {
        	for (int i = 0; i < users.size(); i++) {
        	    User s = users.get(i);
        	    if (u.getPassword().equals(s.getPassword()) && u.getEmail().equalsIgnoreCase(s.getEmail())) {
        	        m = new Mailing(u.getEmail());
        	        setValidEmail(true);
        	        m.sendVerificationCode();
        	        userIndex = i;
        	        return true;
        	    }
        	}
        }
        setValidEmail(false);
        return false;
    }

    public  boolean emailValidator(String email){
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
            return true;
        } catch (AddressException ex) {
            return false;
        }
    }

    public void setValidEmail(boolean validEmail) {
        this.validEmail = validEmail;
    }

    public boolean confirmLogin(int verificationCode){
        this.verificationCode=verificationCode;
        if(validEmail&&m.verificationCode==this.verificationCode){

            setLogged(true);
            return true;

        }
        return false;
    }

    public void setRoles() {
    	String type=users.get(userIndex).getType();
        if (type.equalsIgnoreCase(ADMIN)){
            roles=0;
        }
        else if (type.equalsIgnoreCase(CUSTOMER)){
            roles=1;
        }
        else if(type.equalsIgnoreCase(INSTALLER)){
            roles= 2;
        }
        else {
            roles=-1;
        }
    }
    public int getRoles() {
        return roles;
    }



    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public boolean isLogged() {
        return isLogged;
    }




    public boolean addUser(User u){
        if(emailValidator(u.getEmail())){
            users.add(u);
            return true;
        }
        return false;
    }
    public void setUser(User u){
        this.u=u;
    }
    public boolean updateUser(User oldUser,User newUser){
        boolean isUpdating=false;
        for (User s : users) {
            if (oldUser.getPassword().equals(s.getPassword()) && oldUser.getEmail().equalsIgnoreCase(s.getEmail())) {
                userIndex = users.indexOf(s);
            }
        }
        if(emailValidator(newUser.getEmail())){
            users.get(userIndex).setType(newUser.getType());
            users.get(userIndex).setPassword(newUser.getPassword());
            users.get(userIndex).setEmail(newUser.getEmail());
            isUpdating=true;
        }
        return isUpdating;
    }

    public boolean deleteUser(User u){
        for(User r : users){
            if(r.getEmail().equals(u.getEmail())&&r.getPassword().equals(u.getPassword())){
                users.remove(r);
                return true;
            }
        }
        return false;
    }
}

