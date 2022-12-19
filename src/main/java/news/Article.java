package news;

import Exceptions.AccessDeniedException;
import management.enterpreneur.Publisher;

public class Article {
    private boolean approved = false;
    private String content;
    private String title;
    private Prospect p;
    private Newspaper nsp;
    public static boolean approve(Publisher p, Article a){
        if (Newspaper.checkInfo(p, a.nsp)){
            if (a.setApproved()){
                a.nsp.addArticle(a);
                return true;
            }
            else{
                return false;
            }
        }
        else{
            throw new AccessDeniedException();
            //return false;
        }
    }
    public String getTitle(){
        return this.title;
    }
    public String getContent(){
        return this.content;
    }
    private boolean setApproved(){
        if (this.p == Prospect.BOMB || this.p == Prospect.VERYPROMISING || this.p == Prospect.PROMISING || this.p == Prospect.INTERESTING){
            approved = true;
            return true;
        }
        int i = (int)(Math.random() * 2);
        if (i > 1){
            approved = true;
            return true;
        }
        else{
            return false;
        }
    }
    //protected
    public Article(Newspaper n, String title, String content, Prospect p){
        this.nsp = n;
        this.title = title;
        this.content = content;
        this.p = p;
    }
}
