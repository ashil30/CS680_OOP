package edu.umb.cs680.hw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecurityContextTest {

    @Test
    public void loginTest(){
        String user = "aabb";
        String pwd = "asdfgh";
        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd);
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void LogoutTest(){
        String user = "aabb";
        String pwd = "asdfgh";
        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd);
        ctx.logout();
        assertEquals(false, ctx.getState() instanceof LoggedIn);
    }

    @Test
    public void loggedOutTest(){
        String user = "aabb";
        String pwd = "asdfgh";

        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd);
        ctx.logout();
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

    @Test
    public void loggedOutTestFalse(){
        String user = "aabb";
        String pwd = "asdfgh";

        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd);

        assertEquals(false, ctx.getState() instanceof LoggedOut);
    }
}
