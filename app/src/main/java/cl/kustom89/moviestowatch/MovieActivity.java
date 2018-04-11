package cl.kustom89.moviestowatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

import cl.kustom89.moviestowatch.models.Movie;

public class MovieActivity extends AppCompatActivity {
    CheckBox checkBox;
    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_movie );
        long id= getIntent().getLongExtra( MainActivity.MOVIE_ID,0 );
        movie=Movie.findById( Movie.class,id );

        CheckBox checkBox=findViewById( R.id.movieCb );
        getSupportActionBar().setTitle( movie.getName() );
    }

    @Override
    protected void onPause() {
        super.onPause();
        movie.setWatched( checkBox.isChecked() );
        movie.save();
    }
}
