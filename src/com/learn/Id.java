package com.learn;

public class Id {
    private String NationalId;
    private String pass;
    private String name;
    private int cell;

    public Id(String nationalId, String pass, String name, int cell) {
        NationalId = nationalId;
        this.pass = pass;
        this.name = name;
        this.cell = cell;
    }

    public String getNationalId() {
        return NationalId;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public int getCell() {
        return cell;
    }
    public boolean CheckPass(String pass){return true;}
    public boolean CheckNationalId(String id){
        id=id.toUpperCase();
        if(id.length()>9){
            for(int i=0;i<id.length();i++){
                if(id.charAt(i)>='1'&&id.charAt(i)<='9')
                    return true;
            }
        }
        else
            System.out.println("please enter a valid ID");
            return false;
    }
}
