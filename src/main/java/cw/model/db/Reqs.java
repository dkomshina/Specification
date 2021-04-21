package cw.model.db;


import javax.persistence.*;

@Entity
public class Reqs {

    public Reqs() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer key;

    private String id;

    private String file;

    private Integer line;

    @Column(columnDefinition = "LONGTEXT")
    private String text;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
