package edu.umb.cs680.hw05;

public class SecurityContext {

    private State state;
    public SecurityContext(String user){
        this.state = new LoggedOut(this);
    }

    public void changeState(State newState){
        this.state = newState;
    }
    public void login(String pwd){
        this.state.login(pwd);

    }
    public void logout(){
        this.state.logout();
    }

    public boolean isActive(){
        if(this.state instanceof LoggedIn){
            return true;
        }
        return false;
    }
    public State getState(){
        return this.state;
    }
    public static void main(String[] args){
        String user = "aabb";
        String pwd = "asdfgh";
        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd);
        System.out.println(ctx.getState() instanceof LoggedIn);
        ctx.logout();
        System.out.println(ctx.getState() instanceof LoggedIn);
    }
}
