package com.asgeirr.businesscard;

public class BCardBuilder {
    private String backgroundImage;
    private String cardThumbnail;
    private Elem companyName;
    private String countryCode;
    private Elem email;
    private Elem lastName;
    private Elem logo;
    private Elem name;
    private Elem webSite;
    private Elem whatsApp;
    private Elem workPosition;

    public BCardBuilder setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public BCardBuilder setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
        return this;
    }

    public BCardBuilder setCardThumbnail(String cardThumbnail) {
        this.cardThumbnail = cardThumbnail;
        return this;
    }

    public BCardBuilder setName(Elem name) {
        this.name = name;
        return this;
    }

    public BCardBuilder setEmail(Elem email) {
        this.email = email;
        return this;
    }

    public BCardBuilder setLastName(Elem lastName) {
        this.lastName = lastName;
        return this;
    }

    public BCardBuilder setWhatsApp(Elem whatsApp) {
        this.whatsApp = whatsApp;
        return this;
    }

    public BCardBuilder setCompanyName(Elem companyName) {
        this.companyName = companyName;
        return this;
    }

    public BCardBuilder setWebSite(Elem webSite) {
        this.webSite = webSite;
        return this;
    }

    public BCardBuilder setWorkPosition(Elem workPosition) {
        this.workPosition = workPosition;
        return this;
    }

    public BCardBuilder setLogo(Elem logo) {
        this.logo = logo;
        return this;
    }

    public BCard createBCard() {
        return new BCard(countryCode, backgroundImage, cardThumbnail, name, email, lastName, whatsApp, companyName, webSite, workPosition, logo);
    }
}