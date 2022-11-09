package chainOfResponsibility;

/**
 * PROBLEM: Build a auth middleware which perform the following steps in order
 * 1. check username
 * 2. check password
 * 3. check role is admin
 * 
 * SOLUTION: Build a handler class for each auth step and link the steps through
 * next step in each step object(form a chain of handlers).
 * 
 * Base Handler class - defining the linking logic and declares the abstract
 * methods
 * Concrete handler class - executes the step specific logic and
 * triggeres the next step once completed
 * Client - manages the linking of steps in order and starts the initial call in
 * the chain.
 */

// Base handler class
abstract class AuthMiddleware {
    public AuthMiddleware next;

    // chain of Auth middleware - check username, check password, check role
    public static AuthMiddleware linkStepsByOrder(AuthMiddleware first, AuthMiddleware... chain) {
        AuthMiddleware head = first;
        for (AuthMiddleware middleware : chain) {
            head.next = middleware;
            head = middleware;
        }
        return first;
    }

    public abstract boolean check(String userName, String password, String role);

    protected boolean checkNext(String userName, String password, String role) {
        if (next == null) {
            return true;
        }
        return next.check(userName, password, role);
    }
}

// Concrete handler 1
class UsernameAuthMiddleWare extends AuthMiddleware {
    public boolean check(String userName, String password, String role) {
        if (userName == "username") {
            System.out.println("username check pass..");
            return checkNext(userName, password, role);
        }
        return false;
    }
}

// Concrete handler 2
class PasswordAuthMiddleWare extends AuthMiddleware {
    public boolean check(String userName, String password, String role) {
        if (password == "pass") {
            System.out.println("password check pass..");
            return checkNext(userName, password, role);
        }
        return false;
    }
}

// Concrete handler 3
class RoleAuthMiddleWare extends AuthMiddleware {
    public boolean check(String userName, String password, String role) {
        if (role == "admin") {
            System.out.println("role check pass..");
            return checkNext(userName, password, role);
        }
        return false;
    }
}

// client class
class Server {
    AuthMiddleware authmiddleware;

    Server() {
        authmiddleware = AuthMiddleware.linkStepsByOrder(new UsernameAuthMiddleWare(),
                new PasswordAuthMiddleWare(),
                new RoleAuthMiddleWare());
    }

    public void checkAuthDetails(String userName, String password, String role) {
        boolean isCheckPass = authmiddleware.check(userName, password, role);
        if (isCheckPass) {
            System.out.println("user authenticated");
        } else {
            System.out.println("user authenticate fail");
        }
    }
}

// start of client code
public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        Server server = new Server();
        server.checkAuthDetails("username", "pass", "admin");
    }
}
// end of client code

// OUTPUT
// username check pass..
// password check pass..
// role check pass..
// user authenticated