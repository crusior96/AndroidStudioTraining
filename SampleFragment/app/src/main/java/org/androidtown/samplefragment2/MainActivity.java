package org.androidtown.samplefragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Listfragment.ImageSelectionCallback{
    ListFragment listFragment;
    ViewerFragment viewerFragment;

    int[] images = {R.drawable.cat01,R.drawable.cat02,R.drawable.cat03};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        listFragment = (ListFragment)manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment)manager.findFragmentById(R.id.viewerFragment);
    }

    @Override
    public void onImageSelected(int position){
        viewerFragment.setImage(images[position]);
    }
}