package com.me.mygdxgame;





import android.os.*;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.me.mygdxgame.MyGdxGame01;
 
public class MainActivity  extends AndroidApplication {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        cfg.useGL20 = false;
        
        initialize(new MyGdxGame01(), cfg);
    }
}
 