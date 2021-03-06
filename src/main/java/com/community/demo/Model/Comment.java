package com.community.demo.Model;

public class Comment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..comment.id
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..comment.parent_id
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..comment.type
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..comment.commentator
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    private Integer commentator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..comment.gmt_create
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..comment.gmr_modified
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    private Long gmrModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..comment.like_count
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..comment.comment
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    private String comment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..comment.comment_count
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    private Integer commentCount;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..comment.id
     *
     * @return the value of student..comment.id
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..comment.id
     *
     * @param id the value for student..comment.id
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..comment.parent_id
     *
     * @return the value of student..comment.parent_id
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..comment.parent_id
     *
     * @param parentId the value for student..comment.parent_id
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..comment.type
     *
     * @return the value of student..comment.type
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..comment.type
     *
     * @param type the value for student..comment.type
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..comment.commentator
     *
     * @return the value of student..comment.commentator
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public Integer getCommentator() {
        return commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..comment.commentator
     *
     * @param commentator the value for student..comment.commentator
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public void setCommentator(Integer commentator) {
        this.commentator = commentator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..comment.gmt_create
     *
     * @return the value of student..comment.gmt_create
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..comment.gmt_create
     *
     * @param gmtCreate the value for student..comment.gmt_create
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..comment.gmr_modified
     *
     * @return the value of student..comment.gmr_modified
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public Long getGmrModified() {
        return gmrModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..comment.gmr_modified
     *
     * @param gmrModified the value for student..comment.gmr_modified
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public void setGmrModified(Long gmrModified) {
        this.gmrModified = gmrModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..comment.like_count
     *
     * @return the value of student..comment.like_count
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..comment.like_count
     *
     * @param likeCount the value for student..comment.like_count
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..comment.comment
     *
     * @return the value of student..comment.comment
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public String getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..comment.comment
     *
     * @param comment the value for student..comment.comment
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..comment.comment_count
     *
     * @return the value of student..comment.comment_count
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..comment.comment_count
     *
     * @param commentCount the value for student..comment.comment_count
     *
     * @mbg.generated Fri Feb 14 10:16:00 CST 2020
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}