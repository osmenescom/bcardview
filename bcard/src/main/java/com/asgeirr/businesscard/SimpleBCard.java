package com.asgeirr.businesscard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SimpleBCard implements Cloneable {
    protected String backgroundImage;
    protected String cardThumbnail;
    protected Elem companyName;
    protected String countryCode;
    protected Elem email;
    protected int industryCode;
    protected Elem logo;
    protected Elem name;
    protected Elem webSite;
    protected Elem whatsApp;
    protected Elem workPosition;

    public SimpleBCard() {
    }

    public SimpleBCard(String countryCode, String backgroundImage, String cardThumbnail, Elem name, Elem email, Elem whatsApp, Elem companyName, Elem webSite, Elem workPosition, Elem logo) {
        this.countryCode = countryCode;
        this.backgroundImage = backgroundImage;
        this.cardThumbnail = cardThumbnail;
        this.name = name;
        this.email = email;
        this.whatsApp = whatsApp;
        this.companyName = companyName;
        this.webSite = webSite;
        this.workPosition = workPosition;
        this.logo = logo;
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

    public Elem getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Elem companyName) {
        this.companyName = companyName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Elem getEmail() {
        return email;
    }

    public void setEmail(Elem email) {
        this.email = email;
    }

    public int getIndustryCode() {
        return industryCode;
    }

    public void setIndustryCode(int industryCode) {
        this.industryCode = industryCode;
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
        return CommonUtils.equals(backgroundImage, simpleBCard.getBackgroundImage()) &&
                CommonUtils.equals(cardThumbnail, simpleBCard.getCardThumbnail()) &&
                CommonUtils.equals(companyName, simpleBCard.getCompanyName()) &&
                CommonUtils.equals(countryCode, simpleBCard.getCountryCode()) &&
                CommonUtils.equals(email, simpleBCard.getEmail()) &&
                industryCode == simpleBCard.getIndustryCode() &&
                CommonUtils.equals(logo, simpleBCard.getLogo()) &&
                CommonUtils.equals(name, simpleBCard.getName()) &&
                CommonUtils.equals(webSite, simpleBCard.getWebSite()) &&
                CommonUtils.equals(whatsApp, simpleBCard.getWhatsApp()) &&
                CommonUtils.equals(workPosition, simpleBCard.getWorkPosition());
    }
}
