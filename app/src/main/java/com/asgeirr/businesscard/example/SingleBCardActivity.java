package com.asgeirr.businesscard.example;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.asgeirr.businesscard.BCardView;
import com.asgeirr.businesscard.ScreenShotCallback;
import com.asgeirr.businesscard.SimpleBCard;
import com.asgeirr.businesscard.SimpleBCardBuilder;
import com.asgeirr.businesscard.SimpleElemBuilder;

public class SingleBCardActivity extends AppCompatActivity {

    private BCardView bcview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_b_card);
        bcview = findViewById(R.id.SingleBCard_bcview);
        SimpleBCard simpleBCard = createDummyBCard1();
        bcview.load(simpleBCard);
    }

    public void onClick(View view) {
        ScreenShotCallback callback = new ScreenShotCallback() {
            @Override
            public void finish(String path) {
                Log.d("", "");
            }
        };
        bcview.takeBcScreenShot(callback);
    }

    private SimpleBCard createDummyBCard1() {
        SimpleBCard simpleBCard = new SimpleBCardBuilder()
                .setBackgroundImage("https://lh3.googleusercontent.com/8gaDSCIMIhUYap5y_0i-IFKPurhkzTFWmVD896ZZ1tcExn2DGuo8-3Nxzi4CuwEh_is0uQqVHXhovLnuWeuBADd_fD0CGY61")
//                .setCardThumbnail("https://lh3.googleusercontent.com/byCFdLg-Br-aBbSWwuo4whvcsEhSIrcjkpJ-OF0UvEvchKacAku4X_FgwmVjzO_zCTcaKuRAl55B4d9FHxU-PUGItw4agocGDw")
                .setCompanyName(new SimpleElemBuilder()
                        .setHeight(7.48f)
                        .setWidth(23.65f)
                        .setxPosition(35.95f)
                        .setyPosition(43.59f)
                        .setText("inmobiliaria801")
                        .setColor("F6DF47")
                        .createElem())
                .setCountryCode("")
                .setEmail(new SimpleElemBuilder()
                        .setHeight(7.48f)
                        .setWidth(47.78f)
                        .setxPosition(28.18f)
                        .setyPosition(84.19f)
                        .setColor("FFFFFF")
                        .setIconType(2)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .setText("maplander.may@gmail.com")
                        .createElem())
                .setLogo(new SimpleElemBuilder()
                        .setWidth(19.96f)
                        .setHeight(35.94f)
                        .setxPosition(11.55f)
                        .setyPosition(32.27f)
                        .setThumbnail("https://lh3.googleusercontent.com/0HXddXEdPPc1JR62fFs8ffXjQnSpahLC_BcGY-Q5UHBCQwNEXEfndYmOYHCRiH-rnSaJDotV7acZ7OwkoxqJ_AGo_2ofH3XuF8Vuj7vtfEC8")
                        .createElem())
                .setName(new SimpleElemBuilder()
                        .setHeight(11.48f)
                        .setWidth(31.23f)
                        .setxPosition(34.38f)
                        .setyPosition(22.79f)
                        .setColor("429AD5")
                        .setFont("7")
                        .setText("Mayra Flores")
                        .createElem())
                .setWebSite(new SimpleElemBuilder()
                        .setHeight(0f)
                        .setWidth(0f)
                        .setxPosition(41.71f)
                        .setyPosition(79.85f)
                        .setColor("707070")
                        .setIconType(3)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new SimpleElemBuilder()
                        .setHeight(7.48f)
                        .setWidth(3.88f)
                        .setxPosition(41.68f)
                        .setyPosition(57.90f)
                        .setColor("707070")
                        .setIconType(1)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .setText("whatsapp")
                        .createElem())
                .setWorkPosition(new SimpleElemBuilder()
                        .setHeight(7.48f)
                        .setWidth(30.22f)
                        .setxPosition(41.68f)
                        .setyPosition(34.44f)
                        .setColor("FFFFFF")
                        .setFont("7")
                        .setText("Agente inmobiliario")
                        .createElem())
//                .setBackgroundImage("file:///android_asset/bg_card1.png")
//                .setBackgroundImage("/storage/emulated/0/Download/images (1).jpeg")
                .createBCard();
        return simpleBCard;
    }
}