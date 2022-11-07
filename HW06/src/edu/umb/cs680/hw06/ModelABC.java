package edu.umb.cs680.hw06;

public class ModelABC extends PrintJobExecutor {

    @Override
    public void doAuthentication(String pwd, SecurityContext ctx){
        ctx.login(pwd);
        if(!(ctx.getState() instanceof LoggedIn)){
            doErrorHandling();
        }
    };

    @Override
    public void doAccessControl() {};

    @Override
    public void doPrint(){
        if(ctx.getState() instanceof LoggedIn) {
            System.out.println("Printing");
        }
    }

    @Override
    public void doErrorHandling(){
        throw new Exception("Error occured");
    };


}