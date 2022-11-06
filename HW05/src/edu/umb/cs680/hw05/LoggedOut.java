package edu.umb.cs680.hw05;

public class LoggedOut implements State {
    private SecurityContext ctx;

    public LoggedOut(SecurityContext ctx){
        this.ctx=ctx;
    }

    @Override
    public void login(String pwd) {
        if ( Authenticator.authenticate(ctx, pwd)){
            ctx.changeState(new LoggedIn(ctx));
        }
        else{
            System.out.println("Auth Failed");
        }
    }

    @Override
    public void logout() {

    }


}