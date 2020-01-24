package com.community.demo.Model;

public class Question {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..question.id
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..question.title
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..question.description
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..question.gmt_create
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..question.gmt_modified
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..question.creator
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    private Integer creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..question.comment_count
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    private Integer commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..question.view_count
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    private Integer viewCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..question.like_count
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student..question.tag
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    private String tag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..question.id
     *
     * @return the value of student..question.id
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..question.id
     *
     * @param id the value for student..question.id
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..question.title
     *
     * @return the value of student..question.title
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..question.title
     *
     * @param title the value for student..question.title
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..question.description
     *
     * @return the value of student..question.description
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..question.description
     *
     * @param description the value for student..question.description
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..question.gmt_create
     *
     * @return the value of student..question.gmt_create
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..question.gmt_create
     *
     * @param gmtCreate the value for student..question.gmt_create
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..question.gmt_modified
     *
     * @return the value of student..question.gmt_modified
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..question.gmt_modified
     *
     * @param gmtModified the value for student..question.gmt_modified
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..question.creator
     *
     * @return the value of student..question.creator
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public Integer getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..question.creator
     *
     * @param creator the value for student..question.creator
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..question.comment_count
     *
     * @return the value of student..question.comment_count
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..question.comment_count
     *
     * @param commentCount the value for student..question.comment_count
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..question.view_count
     *
     * @return the value of student..question.view_count
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..question.view_count
     *
     * @param viewCount the value for student..question.view_count
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..question.like_count
     *
     * @return the value of student..question.like_count
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..question.like_count
     *
     * @param likeCount the value for student..question.like_count
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student..question.tag
     *
     * @return the value of student..question.tag
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student..question.tag
     *
     * @param tag the value for student..question.tag
     *
     * @mbg.generated Fri Jan 17 14:23:28 CST 2020
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}