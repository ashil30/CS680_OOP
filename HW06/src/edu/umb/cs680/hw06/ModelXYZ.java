package edu.umb.cs680.hw06;

public class ModelXYZ extends PrintJobExecutor {

    @Override
    public void doAuthentication(){};

    @Override
    public void doAccessControl() {};

    @Override
    public void doPrint(){
        System.out.println("Printing");
    }

    @Override
    public void doErrorHandling(){};


}