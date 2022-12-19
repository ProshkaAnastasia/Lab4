package management.enterpreneur;

import news.Article;
import news.Newspaper;
import management.Currency;
import management.Enterpreneur;

import java.util.ArrayList;

public class Publisher extends Enterpreneur {
    private int issues;
    private String editionName;
    private ArrayList <Newspaper> news = new ArrayList<Newspaper>();
    public boolean approveArticle(Article a){
        return Article.approve(this, a);
    }
    public void makeNewspaper(int nCount, int aCount){
        for (int i = 0; i < nCount; i++){
            news.add(new Newspaper(this, issues + 1, aCount));
            issues++;
        }
    }
    public boolean print(int i, int copies){
        if (i < 0){
            i = 1;
        }
        if (i > news.size()){
            i = news.size();
        }
        i--;
        if (Newspaper.printNews(this, news.get(i), copies)){
            return true;
        }
        else{
            return false;
        }
    }
    public Newspaper getNews(int i){
        if (i < 0){
            i = 1;
        }
        if (i > news.size()){
            i = news.size();
        }
        i--;
        return news.get(i);
    }
    public Publisher(Currency budget, String name){
        super(budget);
        this.editionName = name;
    }
}
