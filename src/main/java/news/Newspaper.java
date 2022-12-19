package news;

import management.enterpreneur.Publisher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Newspaper {
    private int issueNumber;
    private int copies = 0;
    private static Map<Newspaper, Publisher> owner = new HashMap<Newspaper, Publisher>();
    private ArrayList<Article> art = new ArrayList<Article>();
    private ArrayList<Article> nAppArt = new ArrayList<Article>();
    public static boolean checkInfo(Publisher p, Newspaper n){
        if (owner.get(n) == p){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean printNews(Publisher p, Newspaper n, int copies){
        if (owner.get(n) == p){
            class Printer{
                public void print(){
                    System.out.println("List of contents:");
                    int j = 1;
                    for (var i : n.art){
                        System.out.println(Integer.toString(j) + i.getTitle() + " ----- " + Integer.toString(j));
                        j++;
                    }
                    for (var i : n.art){
                        System.out.println(i.getTitle() + "\n");
                        System.out.println(i.getContent());
                    }
                }
            }
            Printer printer = new Printer();
            printer.print();
            n.copies += copies;
            return true;
        }
        else{
            return false;
        }
    }
    public Newspaper(Publisher p, int issueNumber, int aCounter){
        super();
        this.issueNumber = issueNumber;
        owner.put(this, p);
        for (int i = 0; i < aCounter; i++){
            makeArticle("Article", "Content");
        }
        while (art.size() == 0)
            for (int i = 0; i < nAppArt.size(); ){
                if(!Article.approve(owner.get(this), nAppArt.get(i))){
                    i++;
                }
            }
    }
    public void makeArticle(String title, String content){
        Article a = new Article(this, title, content, Prospect.randProspect());
        addNArt(a);
    }
    protected void addArticle(Article a){
        art.add(a);
        if (nAppArt.contains(a)){
            nAppArt.remove(a);
        }
    }
    public void addNArt(Article a){
        nAppArt.add(a);
    }
}
