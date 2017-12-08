package mchehab.com.gridviewviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private List<Fragment> listFragments = new ArrayList<>();
    private List<String> listImageURLs = new ArrayList<>();

    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        getArguments();
        createFragments();

        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), listFragments);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(position);
    }

    private void getArguments(){
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            listImageURLs = bundle.getStringArrayList("imageURLs");
            position = bundle.getInt("position");
        }
    }

    private void createFragments(){
        for(int i=0;i<listImageURLs.size();i++){
            Bundle bundle = new Bundle();
            bundle.putString("imageURL", listImageURLs.get(i));
            ImageFragment imageFragment = new ImageFragment();
            imageFragment.setArguments(bundle);
            listFragments.add(imageFragment);
        }
    }
}