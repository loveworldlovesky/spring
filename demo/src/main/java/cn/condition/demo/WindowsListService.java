package cn.condition.demo;

public class WindowsListService implements ListService{

    @Override
    public String showListLine() {
        return "dir";
    }

}