package com.asgeirr.businesscard;

import androidx.annotation.NonNull;

public class SimpleBCard implements Cloneable{
    private String countryCode;
    private String backgroundImage;
    private String cardThumbnail;
    private Elem name;
    private Elem email;
    private Elem lastName;
    private Elem whatsApp;
    private Elem companyName;
    private Elem webSite;
    private Elem workPosition;
    private Elem logo;

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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    public Elem getName() {
        return name;
    }

    public void setName(Elem name) {
        this.name = name;
    }

    public Elem getEmail() {
        return email;
    }

    public void setEmail(Elem email) {
        this.email = email;
    }

    public Elem getLastName() {
        return lastName;
    }

    public void setLastName(Elem lastName) {
        this.lastName = lastName;
    }

    public Elem getWhatsApp() {
        return whatsApp;
    }

    public void setWhatsApp(Elem whatsApp) {
        this.whatsApp = whatsApp;
    }

    public Elem getCompanyName() {
        return companyName;
    }

    public void setCompanyName(Elem companyName) {
        this.companyName = companyName;
    }

    public Elem getWebSite() {
        return webSite;
    }

    public void setWebSite(Elem webSite) {
        this.webSite = webSite;
    }

    public Elem getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(Elem workPosition) {
        this.workPosition = workPosition;
    }

    public Elem getLogo() {
        return logo;
    }

    public void setLogo(Elem logo) {
        this.logo = logo;
    }

    @NonNull
    @Override
    public SimpleBCard clone() {
        try {
            SimpleBCard simpleBCard=(SimpleBCard) super.clone();
            if(name!=null)
                simpleBCard.setName(name.clone());
            if(email!=null)
                simpleBCard.setEmail(email.clone());
            if(lastName!=null)
                simpleBCard.setLastName(lastName.clone());
            if((whatsApp!=null))
                simpleBCard.setWhatsApp(whatsApp.clone());
            if(companyName!=null)
                simpleBCard.setCompanyName(companyName.clone());
            if(webSite!=null)
                simpleBCard.setWebSite(webSite.clone());
            if(workPosition!=null)
                simpleBCard.setWorkPosition(workPosition.clone());
            if(logo!=null)
                simpleBCard.setLogo(logo.clone());
            return simpleBCard;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
