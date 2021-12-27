package com.cetin.vogella;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-24
 */
public class DataBase {

    int uniqueId;

    public boolean isAvailable(){
        return false;
    }

    public int getUniqueId(){
        return uniqueId;
    }

    public void setUniqueId(int uniqueId){
        this.uniqueId = uniqueId;
    }
}
