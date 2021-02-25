package org.androidtown.samplelistview;

public class CharacterItem {
    String name;
    String point;
    String classname;
    int level;

    public CharacterItem(String name, String point){
        this.name = name;
        this.point = point;
    }

    public CharacterItem(String name, String point, String classname, int level){
        this.name = name;
        this.point = point;
        this.classname = classname;
        this.level = level;
    }

    public int getLevel(){
        return level;
    }

    public void setLevel(){
        this.level = level;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    public String getPoint(){
        return point;
    }

    public void setPoint(){
        this.point = point;
    }

    public String getClassname(){
        return classname;
    }

    public void setClassname(){
        this.classname = classname;
    }
}
