package edu.umb.cs680.hw06;

import edu.umb.cs680.hw06.ModelXYZ.*;
import edu.umb.cs680.hw06.ModelABC.*;

public class PrintJob {
    public static void main(String[] args){
        PrintJobExecutor job =new ModelXYZ();
        job.execute();
        String user = "aabb";
        String pwd = "asdfgh";
        SecurityContext ctx = new SecurityContext(user);
        PrintJobExecutor job2 = new ModelABC();
        job2.execute(ctx,pwd);
    }
}