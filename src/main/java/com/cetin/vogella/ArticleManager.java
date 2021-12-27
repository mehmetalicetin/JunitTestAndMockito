package com.cetin.vogella;

/**
 * @Author mehmetali.cetin
 * @Date 2021-12-27
 */
public class ArticleManager {

    User user;
    ArticleDatabase articleDatabase;

    public ArticleManager(User user, ArticleDatabase articleDatabase) {
        this.user = user;
        this.articleDatabase = articleDatabase;
    }
}
