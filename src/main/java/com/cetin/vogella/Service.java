package com.cetin.vogella;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-24
 */
public class Service {
    private DataBase database;

    public Service(DataBase database) {
        this.database = database;
    }

    public boolean query(String query){
        return database.isAvailable();
    }

    @Override
    public String toString() {
        return "Using database with id: "+String.valueOf(database.getUniqueId());
    }
}
