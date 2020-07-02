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
                .setCardThumbnail("1")
                .setCountryCode("52")
                .setLogo(new SimpleElemBuilder()
                        .setWidth(19.96f)
                        .setHeight(35.97f)
                        .setxPosition(11.57f)
                        .setyPosition(32.37f)
                        .createElem())
                .setName(new SimpleElemBuilder()
                        .setHeight(11.51f)
                        .setxPosition(41.71f)
                        .setyPosition(23.02f)
                        .setColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWorkPosition(new SimpleElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.71f)
                        .setyPosition(34.53f)
                        .setColor("707070")
                        .setFont("7")
                        .createElem())
                .setWhatsApp(new SimpleElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.71f)
                        .setyPosition(58.27f)
                        .setColor("707070")
                        .setIconType(1)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setEmail(new SimpleElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.71f)
                        .setyPosition(68.70f)
                        .setColor("707070")
                        .setIconType(2)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
                .setWebSite(new SimpleElemBuilder()
                        .setHeight(7.55f)
                        .setxPosition(41.71f)
                        .setyPosition(79.85f)
                        .setColor("707070")
                        .setIconType(3)
                        .setIconColor("0059C1")
                        .setFont("7")
                        .createElem())
//                .setBackgroundImage("file:///android_asset/bg_card1.png")
//                .setBackgroundImage("/storage/emulated/0/Download/images (1).jpeg")
                .createBCard();
        return simpleBCard;
    }
}