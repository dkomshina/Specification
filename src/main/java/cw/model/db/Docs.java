package cw.model.db;


import javax.persistence.*;

@Entity
public class Docs {

    public Docs(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer key;

    private String file;

    private String name;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
