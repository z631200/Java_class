package bro;

import java.util.*;

public class GUITest {
    public static void main(String [] args){
        OperationGUI o1 = new OperationGUI();
        Student s1 = new Student("ssss", "ssss", "Jack");
        o1.addMember(s1);
        o1.addAdmin(new Admin("aaaa", "aaaa", "Sunny"));
        o1.addBook(new Book("哈利波特(1)：神秘的魔法石", "J.K.羅琳", "皇冠出版社", "奇幻小說"));
        o1.addBook(new Book("哈利波特(2)：消失的密室", "J.K.羅琳", "皇冠出版社", "奇幻小說"));
        o1.addBook(new Book("哈利波特(3)：阿茲卡班的逃犯", "J.K.羅琳", "皇冠出版社", "奇幻小說"));
        o1.addBook(new Book("哈利波特(4)：火盃的考驗", "J.K.羅琳", "皇冠出版社", "奇幻小說"));
        o1.addBook(new Book("哈利波特(5)：鳳凰會的密令", "J.K.羅琳", "皇冠出版社", "奇幻小說"));
        o1.addBook(new Book("哈利波特(6)：混血王子的背叛", "J.K.羅琳", "皇冠出版社", "奇幻小說"));
        o1.addBook(new Book("哈利波特(7)：死神的聖物", "J.K.羅琳", "皇冠出版社", "奇幻小說"));
        
        o1.addBook(new Book("紅樓夢", "曹雪芹", "世一出版社", "古典小說"));
        o1.addBook(new Book("聊齋誌異", "蒲松齡", "世一出版社", "古典小說"));
        o1.addBook(new Book("等一個人咖啡", "九把刀", "春天出版社", "愛情小說"));
        o1.addBook(new Book("月老", "九把刀", "春天出版社", "愛情小說"));
        o1.addBook(new Book("樓下的房客", "九把刀", "蓋亞文化", "驚悚小說"));
        o1.addBook(new Book("解憂雜貨店", "東野圭吾", "皇冠出版社", "懸疑小說"));
        o1.addBook(new Book("燃燒的凝視", "史蒂芬‧金", "皇冠出版社", "懸疑小說"));
        Book Test = new Book("鋼鐵人馬斯克", "艾胥黎．范思", "天下文化", "人物傳記");
        Date d1 = new Date(122, 4, 22);
        Date d2 = new Date(d1.getTime() + (7*1000 * 60 * 60 * 24));
        Test.setBorrowDate(d1);
        Test.setReturnDate(d2);
        Test.setState(true);
        o1.addBook(Test);
        s1.addBook(Test);
        o1.menu();
    }
}