package cn.condition.demo;

public class LinuxListService implements ListService{

    @Override
    public String showListLine() {
        return "ls";
    }

}