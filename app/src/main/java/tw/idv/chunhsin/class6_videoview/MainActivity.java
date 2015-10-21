package tw.idv.chunhsin.class6_videoview;

import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
    }

    void findviews(){
        videoView = (VideoView)findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(MainActivity.this);
        Uri uri = Uri.parse("android.resource://tw.idv.chunhsin.class6_videoview/"+R.raw.hitchhikers);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        //videoView.start();

        //videoView.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MediaController mediaController = new MediaController(MainActivity.this);
            Uri uri = Uri.parse("android.resource://tw.idv.chunhsin.class6_videoview/R.raw.littlemonster");
            videoView.setVideoURI(uri);
            videoView.setMediaController(mediaController);
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void videoPlay(View view){
        videoView.start();
    }

    public void videoPause(View view){
        videoView.pause();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
