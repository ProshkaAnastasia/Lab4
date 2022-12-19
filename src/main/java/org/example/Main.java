package org.example;

import Exceptions.NegativeCurrencyException;
import Exchange.Share;
import management.*;

import management.Currency;
import management.enterpreneur.Broker;
import management.enterpreneur.Publisher;
import news.Article;
import news.Newspaper;
import news.Prospect;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        Share.renewShare.setDaemon(true);
        Share.renewShare.start();
        Currency c = new Currency(400, 0);

        Publisher p = new Publisher(c, "Fontanka");
        p.makeNewspaper(3, 6);
        p.print(1, 100);

        Article article = new Article(new Newspaper(new Publisher(c, "Times"), 1, 1), "Title", "Content", Prospect.PROMISING);
        //p.approveArticle(article);

        Share share = new Share("Giant", new Currency(9, 5));
        Broker b = new Broker(new Currency(234, 67));
        b.buyOficialShares("Giant", 55);
        Enterpreneur e = new Enterpreneur(c);
        StaffManager manager = new StaffManager(e);
        SalaryManager m = new SalaryManager(e);
        Worker w1 = new Worker("Ann", 53, 39);
        Worker.addWorker(w1);
        manager.hire(w1);
        m.changeSalary(w1, new Salary(), 8, 5);
        m.paySalary(w1);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {}
    }
}