/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniproj;

/**
 *
 * @author Noufr
 */



public class Book {


    private String btitle;
    private String book_id;
    private String bauthor;
    private String bpublisher;
    private String bpublish_year;
    private String bstate;
    private String imgBookSource;
    private String bprice;
    
    public Book(){}
            
    public Book(String btitle, String book_id, String bauthor, String bpublisher, String bpublish_year, String bstate, String imgBookSource){
    this.btitle= btitle;
    this.book_id = book_id;
    this.bauthor = bauthor;
    this.bpublisher = bpublisher;
    this.bpublish_year = bpublish_year;
    this.bstate = bstate;
    this.imgBookSource = imgBookSource;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getBpublisher() {
        return bpublisher;
    }

    public void setBpublisher(String bpublisher) {
        this.bpublisher = bpublisher;
    }

    public String getBpublish_year() {
        return bpublish_year;
    }

    public void setBpublish_year(String bpublish_year) {
        this.bpublish_year = bpublish_year;
    }

    public String getBstate() {
        return bstate;
    }

    public void setBstate(String bstate) {
        this.bstate = bstate;
    }

    public String getImgBookSource() {
        return imgBookSource;
    }

    public void setImgBookSource(String imgBookSource) {
        this.imgBookSource = imgBookSource;
    }

    public String getBprice() {
        return bprice;
    }

    public void setBprice(String bprice) {
        this.bprice = bprice;
    }

    
 
    

}  

