package mchehab.com.gridviewviewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private GridViewAdapter gridViewAdapter;

    private ArrayList<String> listImageURLs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addImageURLs();

        gridView = findViewById(R.id.gridView);
        gridViewAdapter = new GridViewAdapter(this, listImageURLs);
        gridView.setAdapter(gridViewAdapter);

        setGridViewItemClickListener();
    }

    private void setGridViewItemClickListener(){
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            bundle.putStringArrayList("imageURLs", listImageURLs);
            Intent intent = new Intent(this, ImageActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }

    private void addImageURLs(){
        listImageURLs.add("http://i.dailymail.co.uk/i/pix/2016/04/12/23/3319F89C00000578-3536787-image-m-19_1460498410943.jpg");
        listImageURLs.add("https://www.w3schools.com/css/img_forest.jpg");
        listImageURLs.add("https://www.w3schools.com/css/trolltunga.jpg");
        listImageURLs.add("https://www.w3schools.com/css/pineapple.jpg");
        listImageURLs.add("https://cdn.arstechnica.net/wp-content/uploads/2016/02/5718897981_10faa45ac3_b-640x624.jpg");
        listImageURLs.add("https://www.w3schools.com/css/paris.jpg");
        listImageURLs.add("https://www.w3schools.com/css/paris.jpg");
        listImageURLs.add("https://www.w3schools.com/css/trolltunga.jpg");
        listImageURLs.add("https://www.w3schools.com/css/lights600x400.jpg");
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-11.jpg");
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-15.jpg");
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-19.jpg");
        listImageURLs.add("https://cdn.spacetelescope.org/archives/images/thumb700x/heic1509a.jpg");
        listImageURLs.add("http://wallpaper-gallery.net/images/image/image-12.jpg");
        listImageURLs.addAll(listImageURLs);
    }

}
