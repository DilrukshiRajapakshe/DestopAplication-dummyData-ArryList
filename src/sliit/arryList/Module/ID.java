package sliit.arryList.Module;

public  class ID {

    static  int size;
    static String IDtext="SH00";

    public ID(int size) {
        size=size;
    }

    public ID() {
    }

    public String idGenaraer(){
        size=size+1;
        String converID= Integer.toString(size);
        String rearID=IDtext+converID;
        return  rearID;
    }
}
