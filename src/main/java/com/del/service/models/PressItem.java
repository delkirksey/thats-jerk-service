package com.del.service.models;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "pressitems")
public class PressItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String title;

    private String description;

    @NotNull
    private String itemUrl;

    @NotNull
    private String itemType;

    @NotNull
    private String itemLocation;

    private Date datePublished;

    private Boolean featured;

    public PressItem() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * @return the itemUrl
     */
    public String getItemUrl() {
        return itemUrl;
    }

    /**
     * @param itemUrl the itemUrl to set
     */
    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    /**
     * @return the itemLocation
     */
    public String getItemLocation() {
        return itemLocation;
    }

    /**
     * @param itemLocation the itemLocation to set
     */
    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    /**
     * @return the itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * @param itemType the itemType to set
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * @return the datePublished
     */
    public Date getDatePublished() {
        return datePublished;
    }

    /**
     * @param datePublished the datePublished to set
     */
    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    /**
     * @return the featured
     */
    public Boolean getFeatured() {
        return featured;
    }

    /**
     * @param featured the featured to set
     */
    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }
    
}