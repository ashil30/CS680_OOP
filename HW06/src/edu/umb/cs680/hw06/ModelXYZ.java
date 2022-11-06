package edu.umb.cs680.hw06;

public class ModelXYZ extends PrintJobExecutor {

    @Override
    void doAuthentication(){};

    @Override
    void doAccessControl() {};

    @Override
    void doPrint(){
        System.out.println("Printing");
    }

    @Override
    void doErrorHandling();


}