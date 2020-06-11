package com.asgeirr.businesscard;

public class SimpleBCardBuilder {
    private String backgroundImage;
    private String cardThumbnail;
    private SimpleElem companyName;
    private String countryCode;
    private SimpleElem email;
    private SimpleElem logo;
    private SimpleElem name;
    private SimpleElem webSite;
    private SimpleElem whatsApp;
    private SimpleElem lastName;
    private SimpleElem workPosition;

    public SimpleBCardBuilder setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public SimpleBCardBuilder setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
        return this;
    }

    public SimpleBCardBuilder setCardThumbnail(String cardThumbnail) {
        this.cardThumbnail = cardThumbnail;
        return this;
    }

    public SimpleBCardBuilder setName(SimpleElem name) {
        this.name = name;
        return this;
    }

    public SimpleBCardBuilder setEmail(SimpleElem email) {
        this.email = email;
        return this;
    }

    public SimpleBCardBuilder setWhatsApp(SimpleElem whatsApp) {
        this.whatsApp = whatsApp;
        return this;
    }

    public SimpleBCardBuilder setCompanyName(SimpleElem companyName) {
        this.companyName = companyName;
        return this;
    }

    public SimpleBCardBuilder setWebSite(SimpleElem webSite) {
        this.webSite = webSite;
        return this;
    }

    public SimpleBCardBuilder setWorkPosition(SimpleElem workPosition) {
        this.workPosition = workPosition;
        return this;
    }

    public SimpleBCardBuilder setLogo(SimpleElem logo) {
        this.logo = logo;
        return this;
    }

    public SimpleBCard createBCard() {
        return new SimpleBCard(countryCode, backgroundImage, cardThumbnail, name, email, whatsApp, companyName, webSite, workPosition, logo);
    }
}