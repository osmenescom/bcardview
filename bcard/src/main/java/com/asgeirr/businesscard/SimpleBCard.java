package com.asgeirr.businesscard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SimpleBCard implements Cloneable{
    private String about;
    private String backgroundImage;
    private String cardThumbnail;
    private String cardUrl;
    private String companyAddress;
    private Elem companyName;
    private String companyPhone;
    private String countryCode;
    private String dynamicLink;
    private Elem email;
    private String facebook;
    private Long id;
    private int industryCode;
    private Elem lastName;
    private String linkedin;
    private GeoPt location;
    private Elem logo;
    private Elem name;
    private int shortId;
    private boolean showAbout;
    private boolean showCompanyAddress;
    private boolean showCompanyPhone;
    private boolean showFacebook;
    private boolean showLinkedin;
    private boolean showTwitter;
    private String twitter;
    private String url;
    private Long userId;
    private Elem webSite;
    private Elem whatsApp;
    private Elem workPosition;

    public SimpleBCard(){}

    public SimpleBCard(String countryCode, String backgroundImage, String cardThumbnail, Elem name, Elem email, Elem lastName, Elem whatsApp, Elem companyName, Elem webSite, Elem workPosition, Elem logo) {
        this.countryCode = countryCode;
        this.backgroundImage = backgroundImage;
        this.cardThumbnail = cardThumbnail;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.whatsApp = whatsApp;
        this.companyName = companyName;
        this.webSite = webSite;
        this.workPosition = workPosition;
        this.logo = logo;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getCardThumbnail() {
        return cardThumbnail;
    }

    public void setCardThumbnail(String cardThumbnail) {
        this.cardThumbnail = cardThumbnail;
    }

    public String getCardUrl() {
        return cardUrl;
    }

    public void setCardUrl(String cardUrl) {
        this.cardUrl = cardUrl;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public Elem getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Elem companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDynamicLink() {
        return dynamicLink;
    }

    public void setDynamicLink(String dynamicLink) {
        this.dynamicLink = dynamicLink;
    }

    public Elem getEmail() {
        return email;
    }

    public void setEmail(Elem email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(int industryCode) {
        this.industryCode = industryCode;
    }

    public Elem getLastName() {
        return lastName;
    }

    public void setLastName(Elem lastName) {
        this.lastName = lastName;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public GeoPt getLocation() {
        return location;
    }

    public void setLocation(GeoPt location) {
        this.location = location;
    }

    public Elem getLogo() {
        return logo;
    }

    public void setLogo(Elem logo) {
        this.logo = logo;
    }

    public Elem getName() {
        return name;
    }

    public void setName(Elem name) {
        this.name = name;
    }

    public int getShortId() {
        return shortId;
    }

    public void setShortId(int shortId) {
        this.shortId = shortId;
    }

    public boolean isShowAbout() {
        return showAbout;
    }

    public void setShowAbout(boolean showAbout) {
        this.showAbout = showAbout;
    }

    public boolean isShowCompanyAddress() {
        return showCompanyAddress;
    }

    public void setShowCompanyAddress(boolean showCompanyAddress) {
        this.showCompanyAddress = showCompanyAddress;
    }

    public boolean isShowCompanyPhone() {
        return showCompanyPhone;
    }

    public void setShowCompanyPhone(boolean showCompanyPhone) {
        this.showCompanyPhone = showCompanyPhone;
    }

    public boolean isShowFacebook() {
        return showFacebook;
    }

    public void setShowFacebook(boolean showFacebook) {
        this.showFacebook = showFacebook;
    }

    public boolean isShowLinkedin() {
        return showLinkedin;
    }

    public void setShowLinkedin(boolean showLinkedin) {
        this.showLinkedin = showLinkedin;
    }

    public boolean isShowTwitter() {
        return showTwitter;
    }

    public void setShowTwitter(boolean showTwitter) {
        this.showTwitter = showTwitter;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Elem getWebSite() {
        return webSite;
    }

    public void setWebSite(Elem webSite) {
        this.webSite = webSite;
    }

    public Elem getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(Elem whatsApp) {
        this.whatsApp = whatsApp;
    }

    public Elem getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(Elem workPosition) {
        this.workPosition = workPosition;
    }

    @NonNull
    @Override
    public SimpleBCard clone() {
        try {
            SimpleBCard simpleBCard=(SimpleBCard) super.clone();
            if(companyName!=null)
                simpleBCard.setCompanyName(companyName.clone());
            if(email!=null)
                simpleBCard.setEmail(email.clone());
            if(lastName!=null)
                simpleBCard.setLastName(lastName.clone());
            if(location!=null)
                simpleBCard.setLocation(location.clone());
            if(logo!=null)
                simpleBCard.setLogo(logo.clone());
            if(name!=null)
                simpleBCard.setName(name.clone());
            if(webSite!=null)
                simpleBCard.setWebSite(webSite.clone());
            if((whatsApp!=null))
                simpleBCard.setWhatsApp(whatsApp.clone());
            if(workPosition!=null)
                simpleBCard.setWorkPosition(workPosition.clone());
            return simpleBCard;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null ) return false;
        if (!(obj instanceof SimpleBCard)) return false;
        SimpleBCard simpleBCard = (SimpleBCard) obj;
        return CommonUtils.equals(about, simpleBCard.getAbout()) &&
                CommonUtils.equals(backgroundImage, simpleBCard.getBackgroundImage()) &&
                CommonUtils.equals(cardThumbnail, simpleBCard.getCardThumbnail()) &&
                CommonUtils.equals(companyAddress, simpleBCard.getCompanyAddress()) &&
                CommonUtils.equals(companyName, simpleBCard.getCompanyName()) &&
                CommonUtils.equals(companyPhone, simpleBCard.getCompanyPhone()) &&
                CommonUtils.equals(countryCode, simpleBCard.getCountryCode()) &&
                CommonUtils.equals(dynamicLink, simpleBCard.getDynamicLink()) &&
                CommonUtils.equals(email, simpleBCard.getEmail()) &&
                CommonUtils.equals(facebook, simpleBCard.getFacebook()) &&
                CommonUtils.equals(id, simpleBCard.getId()) &&
                industryCode == simpleBCard.getIndustryCode() &&
                CommonUtils.equals(lastName, simpleBCard.getLastName()) &&
                CommonUtils.equals(linkedin, simpleBCard.getLinkedin()) &&
                CommonUtils.equals(location, simpleBCard.getLocation()) &&
                CommonUtils.equals(logo, simpleBCard.getLogo()) &&
                CommonUtils.equals(name, simpleBCard.getName()) &&
                shortId == simpleBCard.getShortId() &&
                showAbout == simpleBCard.isShowAbout() &&
                showCompanyAddress == simpleBCard.isShowCompanyAddress() &&
                showCompanyPhone == simpleBCard.isShowCompanyPhone() &&
                showFacebook == simpleBCard.isShowFacebook() &&
                showLinkedin == simpleBCard.isShowLinkedin() &&
                showTwitter == simpleBCard.isShowTwitter() &&
                CommonUtils.equals(twitter, simpleBCard.getTwitter()) &&
                CommonUtils.equals(url, simpleBCard.getUrl()) &&
                CommonUtils.equals(userId, simpleBCard.getUserId()) &&
                CommonUtils.equals(webSite, simpleBCard.getWebSite()) &&
                CommonUtils.equals(whatsApp, simpleBCard.getWhatsApp()) &&
                CommonUtils.equals(workPosition, simpleBCard.getWorkPosition());
    }
}
