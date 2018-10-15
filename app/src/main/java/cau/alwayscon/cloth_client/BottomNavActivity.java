package cau.alwayscon.cloth_client;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BottomNavActivity extends AppCompatActivity {

    private FrameLayout mMainFrame;
    private BottomNavigationView mMainNav;

    private FriendlistFragment friendlistFragment;
    private BestcodiFragment bestcodiFragment;
    private MypageFragment mypageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);


        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        friendlistFragment = new FriendlistFragment();
        bestcodiFragment = new BestcodiFragment();
        mypageFragment = new MypageFragment();

        setFragment(friendlistFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_friendlist :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(friendlistFragment);
                        return true;

                    case R.id.nav_bestcodi :
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(bestcodiFragment);
                        return true;

                    case R.id.nav_mypage :
                        mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(mypageFragment);
                        return true;

                        default:
                            return false;
                }
            }
        });



    }

    private void setFragment(Fragment fragment) {

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }

}
