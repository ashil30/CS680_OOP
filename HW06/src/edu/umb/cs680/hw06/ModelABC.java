package edu.umb.cs680.hw06;

public class ModelABC extends PrintJobExecutor {

    @Override
    void doAuthentication(String pwd, SecurityContext ctx){
        ctx.login(pwd);
        if(!(ctx.getState() instanceof LoggedIn)){
            doErrorHandling();
        }
    };

    @Override
    void doAccessControl() {};

    @Override
    void doPrint(){
        if(ctx.getState() instanceof LoggedIn) {
            System.out.println("Printing");
        }
    }

    @Override
    void doErrorHandling(){
        throw new Exception("Error occured");
    };


}