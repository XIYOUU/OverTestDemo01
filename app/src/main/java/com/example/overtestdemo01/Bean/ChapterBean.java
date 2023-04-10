package com.example.overtestdemo01.Bean;
/*章节实体类，保存一级分类的实体*/
public class ChapterBean {
    String title;           //标题
    int num;                //题目的总数量
    int chose_num;          //做题数量

    public ChapterBean(String title, int num, int chose_num) {
        this.title = title;
        this.num = num;
        this.chose_num = chose_num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getChose_num() {
        return chose_num;
    }

    public void setChose_num(int chose_num) {
        this.chose_num = chose_num;
    }
}
