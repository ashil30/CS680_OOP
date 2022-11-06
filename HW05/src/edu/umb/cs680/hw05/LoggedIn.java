package edu.umb.cs680.hw05;

public class LoggedIn implements State {

    private SecurityContext ctx;

    public LoggedIn(SecurityContext ctx){
        this.ctx = ctx;
    }


    @Override
    public void login(String pwd) {
        if (!ctx.isActive()){
            ctx.changeState(new LoggedOut(ctx));
            ctx.login(pwd);
        }

    }

    @Override
    public void logout() {
        ctx.changeState(new LoggedOut(ctx));
    }

}
