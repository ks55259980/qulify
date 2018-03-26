package com.spoonsea.qualitytracing.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_EMPTY)
public class DataNode implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private DataNode parent;

    private String name;
    private String value;
    private int type;

    private List<DataNode> children;

    public DataNode() {
    }

    public DataNode(String name, String value, int type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public void addChildren(DataNode... children) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        for (DataNode child : children) {
            if (child != null) {
                child.setParent(this);
                this.children.add(child);
            }
        }
    }

    public DataNode getParent() {
        return parent;
    }

    public void setParent(DataNode parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<DataNode> getChildren() {
        return children;
    }

    public void setChildren(List<DataNode> children) {
        children.forEach(ch -> ch.setParent(this));
        this.children = children;
    }

}