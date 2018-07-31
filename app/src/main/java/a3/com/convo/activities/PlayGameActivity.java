package a3.com.convo.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import a3.com.convo.R;
import a3.com.convo.fragments.ConclusionFragment;
import a3.com.convo.fragments.FriendsFragment;
import a3.com.convo.fragments.GameFragment;
import a3.com.convo.fragments.ModeFragment;

public class PlayGameActivity extends AppCompatActivity {
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.play_game_fragment, new FriendsFragment());
        ft.commit();
    }

    public void goToFriends() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.play_game_fragment, new FriendsFragment());
        fragmentTransaction.commit();
    }

    public void goToMode(String selectedFriend){
        ModeFragment modeFrag = new ModeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.play_game_fragment, modeFrag);
        fragmentTransaction.commit();
        modeFrag.setFriend(selectedFriend);
    }

    public void goToGame(String selectedFriend) {
        GameFragment gameFrag = new GameFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.play_game_fragment, gameFrag);
        fragmentTransaction.commit();
        gameFrag.setFriend(selectedFriend);
    }

    public void goToConclusion(ArrayList<String> topicsDiscussed) {
        ConclusionFragment endFrag = new ConclusionFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.play_game_fragment, endFrag);
        fragmentTransaction.commit();
        endFrag.setDiscussedTopics(topicsDiscussed);
    }
}
