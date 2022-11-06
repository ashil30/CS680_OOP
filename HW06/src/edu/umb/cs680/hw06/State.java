package edu.umb.cs680.hw06;

public interface State {
    public abstract void login(String pwd);
    public abstract void logout();
}