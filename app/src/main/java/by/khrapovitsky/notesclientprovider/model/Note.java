package by.khrapovitsky.notesclientprovider.model;

public class Note {

    private String id;
    private String note;
    private String date;

    public Note() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.note + " [Date: " + this.date + "]";
    }
}
