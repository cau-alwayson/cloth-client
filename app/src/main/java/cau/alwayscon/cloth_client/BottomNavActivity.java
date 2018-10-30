package cau.alwayscon.cloth_client;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class BottomNavActivity extends AppCompatActivity {

    private ConstraintLayout container;
    private TextView mTextMessage;
    private LinearLayout friendFrame, coordiFrame, mypageFrame;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.friend_list:
                    mTextMessage.setText(R.string.friend_list);
                    friendFrame.setVisibility(View.VISIBLE);
                    coordiFrame.setVisibility(View.GONE);
                    mypageFrame.setVisibility(View.GONE);
                    return true;
                case R.id.best_coordi:
                    mTextMessage.setText(R.string.best_coordi);
                    friendFrame.setVisibility(View.GONE);
                    coordiFrame.setVisibility(View.VISIBLE);
                    mypageFrame.setVisibility(View.GONE);
                    return true;
                case R.id.my_page:
                    mTextMessage.setText(R.string.my_page);
                    friendFrame.setVisibility(View.GONE);
                    coordiFrame.setVisibility(View.GONE);
                    mypageFrame.setVisibility(View.VISIBLE);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        container = (ConstraintLayout)findViewById(R.id.container);
        loadFragment(new FriendListFragment());

        friendFrame = findViewById(R.id.friend_frame);
        coordiFrame = findViewById(R.id.best_coordi_frame);
        mypageFrame = findViewById(R.id.mypage_frame);

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void buildFriendlist() {
        new BottomNavActivity.GetUrlContentTask().execute("http://150.95.180.235/members.php");
    }

    private class GetUrlContentTask extends AsyncTask<String, Integer, String> {
        protected String doInBackground(String... urls){
            URL url = null;
            try {
                url = new URL(urls[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                connection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            connection.setDoOutput(true);
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            try {
                connection.connect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader rd = null;
            try {
                rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            String content = "", line;
            try {
                while ((line = rd.readLine()) != null) {
                    content += line + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return content;
        }

        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(String result) {
            // this is executed on the main thread after the process is over
            // update your UI here
            System.out.println(result);
            try {
                JSONObject jsonObject = new JSONObject(result);
                
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
