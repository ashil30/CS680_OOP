package edu.umb.cs680.hw06;

public abstract class PrintJobExecutor{

    public final void execute(SecurityContext ctx, String pwd){

        doAuthentication(String pwd,SecurityContext ctx);
        doAccessControl();
        doPrint();
        doErrorHandling();
        System.out.println("executed");
    }

    public abstract void doAuthentication( String pwd, SecurityContext ctx){

    }
    public abstract void doAccessControl();
    public abstract void doPrint();
    public abstract void doErrorHandling();
}
