package org.wordpress4j.model;

import java.util.Date;
import java.util.List;

public class CommentSearchCriteria extends SearchCriteria {

    private static final long serialVersionUID = -5004314052580565038L;
    
    private Date after;
    private Date before;
    private List<Integer> author;
    private List<Integer> authorExclude;
    private String authorEmail;
    private Integer karma;
    private CommentOrderBy orderBy;
    private List<Integer> offset;
    private Context context;
    private List<Integer> parent;
    private List<Integer> parentExclude;
    private List<Integer> post;
    private CommentStatus status;
    private String type;

    public CommentSearchCriteria() {

    }

    public Date getAfter() {
        return after;
    }

    public void setAfter(Date after) {
        this.after = after;
    }

    public Date getBefore() {
        return before;
    }

    public void setBefore(Date before) {
        this.before = before;
    }

    public List<Integer> getAuthor() {
        return author;
    }

    public void setAuthor(List<Integer> author) {
        this.author = author;
    }

    public List<Integer> getAuthorExclude() {
        return authorExclude;
    }

    public void setAuthorExclude(List<Integer> authorExclude) {
        this.authorExclude = authorExclude;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public Integer getKarma() {
        return karma;
    }

    public void setKarma(Integer karma) {
        this.karma = karma;
    }

    public CommentOrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(CommentOrderBy orderBy) {
        this.orderBy = orderBy;
    }

    public List<Integer> getOffset() {
        return offset;
    }

    public void setOffset(List<Integer> offset) {
        this.offset = offset;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<Integer> getParent() {
        return parent;
    }

    public void setParent(List<Integer> parent) {
        this.parent = parent;
    }

    public List<Integer> getParentExclude() {
        return parentExclude;
    }

    public void setParentExclude(List<Integer> parentExclude) {
        this.parentExclude = parentExclude;
    }

    public List<Integer> getPost() {
        return post;
    }

    public void setPost(List<Integer> post) {
        this.post = post;
    }

    public CommentStatus getStatus() {
        return status;
    }

    public void setStatus(CommentStatus status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
