package com.mep.database.entity;

import java.io.Serializable;
import java.util.Date;

public class Archive implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column archive.archive_id
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    private Integer archiveId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column archive.post_id
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    private Integer postId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column archive.year
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    private String year;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column archive.month
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    private String month;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column archive.created_date
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    private Date createdDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column archive.updated_date
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    private Date updatedDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column archive.archive_id
     *
     * @return the value of archive.archive_id
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column archive.archive_id
     *
     * @param archiveId the value for archive.archive_id
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column archive.post_id
     *
     * @return the value of archive.post_id
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column archive.post_id
     *
     * @param postId the value for archive.post_id
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column archive.year
     *
     * @return the value of archive.year
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public String getYear() {
        return year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column archive.year
     *
     * @param year the value for archive.year
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column archive.month
     *
     * @return the value of archive.month
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public String getMonth() {
        return month;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column archive.month
     *
     * @param month the value for archive.month
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column archive.created_date
     *
     * @return the value of archive.created_date
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column archive.created_date
     *
     * @param createdDate the value for archive.created_date
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column archive.updated_date
     *
     * @return the value of archive.updated_date
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column archive.updated_date
     *
     * @param updatedDate the value for archive.updated_date
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table archive
     *
     * @mbg.generated Sun Jul 16 17:56:51 MMT 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", archiveId=").append(archiveId);
        sb.append(", postId=").append(postId);
        sb.append(", year=").append(year);
        sb.append(", month=").append(month);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append("]");
        return sb.toString();
    }
}