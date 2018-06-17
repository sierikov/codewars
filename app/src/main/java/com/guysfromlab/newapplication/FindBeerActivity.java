package com.guysfromlab.newapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class FindBeerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }
    public void onClickFindBeer (View view) {
        TextView brands = (TextView) findViewById(R.id.brands);
    }
}
