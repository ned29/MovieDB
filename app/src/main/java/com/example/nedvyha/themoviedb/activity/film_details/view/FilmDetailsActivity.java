package com.example.nedvyha.themoviedb.activity.film_details.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nedvyha.themoviedb.R;
import com.example.nedvyha.themoviedb.activity.film_details.FilmDetailsUseCase;
import com.example.nedvyha.themoviedb.activity.film_details.presenter.FilmDetailsPresenter;
import com.example.nedvyha.themoviedb.data.FilmDetails;
import com.example.nedvyha.themoviedb.data.FilmDetailsInfo;
import com.example.nedvyha.themoviedb.utils.StringNames;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

public class FilmDetailsActivity extends AppCompatActivity implements FilmDetailsUseCase.View {

    @BindView(R.id.poster_image_details)
    ImageView poster;

    @BindView(R.id.title_details)
    TextView title;

    @BindView(R.id.overview_details)
    TextView overview;

    @BindView(R.id.budget)
    TextView budget;

    @BindView(R.id.language)
    TextView language;

    @BindView(R.id.date)
    TextView data;

    @BindView(R.id.runtime)
    TextView runtime;

    @BindView(R.id.btn_star)
    Button btnStar;

    private Realm realm;

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Nullable
    private FilmDetailsUseCase.Presenter presenter;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realm = Realm.getInstance(getBaseContext());
        ButterKnife.bind(this);

        this.setTitle(StringNames.getTitle());

        bundle = getIntent().getExtras();

        Typeface captureFontType = Typeface.createFromAsset(getAssets(), "Capture_it.ttf");
        Typeface brushFontType = Typeface.createFromAsset(getAssets(), "PlayfairDisplay-Black.otf");

        title.setText(bundle.getString("title"));
        title.setTypeface(captureFontType);
        overview.setText(bundle.getString("overview"));
        overview.setTypeface(brushFontType);
        Glide.with(this)
                .load(bundle.getString("poster"))
                .centerCrop()
                .crossFade()
                .into(poster);

        try {
            TimeUnit.MILLISECONDS.sleep(350);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        budget.setText("Budget :  " + FilmDetails.getBudget() + " million");
        language.setText("Language :  " + FilmDetails.getLanguage());
        data.setText("Data :  " + FilmDetails.getRelease_date());
        runtime.setText("Runtime :  " + FilmDetails.getRuntime() + " min");
        budget.setTypeface(brushFontType);
        language.setTypeface(brushFontType);
        data.setTypeface(brushFontType);
        runtime.setTypeface(brushFontType);

        presenter = new FilmDetailsPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_revert) {
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btn_star)
    void setFavourite() {
        realm.beginTransaction();
        FilmDetailsInfo filmDetails = realm.createObject(FilmDetailsInfo.class);
        filmDetails.setTitle(bundle.getString("title"));
        realm.commitTransaction();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
