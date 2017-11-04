package training.nurse.nursetraining.Models;

/**
 * Created by phmima on 11/4/2017.
 */

public class Chapter {
    private String text;
    private String photo;
    private String title;
    private String video;
    private String procedure;
    private String next;
    private String back;

    public String getText(){ return text;}
    public String getPhoto() {return photo;}
    public String getTitle() {return title;}
    public String getNext() {return next;}
    public String getBack() {return back;}

    public void setText(String text) {this.text = text;}
    public void setPhoto(String photo) {this.photo = photo;}
    public void setTitle(String title) {this.title = title;}
    public void setNext(String next) {this.next = next;}
    public void setBack(String back) {this.back = back;}
}
