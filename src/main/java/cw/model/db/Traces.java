package cw.model.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Traces {

    public Traces() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer key;

    private String parentDoc;

    private String parent;

    private String child;

    public String getParentDoc() {
        return parentDoc;
    }

    public void setParentDoc(String parentDoc) {
        this.parentDoc = parentDoc;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }
}
