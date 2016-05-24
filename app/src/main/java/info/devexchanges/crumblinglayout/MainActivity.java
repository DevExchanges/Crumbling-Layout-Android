package info.devexchanges.crumblinglayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cleveroad.splittransformation.SquareViewPagerIndicator;
import com.cleveroad.splittransformation.TransformationAdapterWrapper;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SquareViewPagerIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.pager);
        indicator = (SquareViewPagerIndicator) findViewById(R.id.indicator);

        //Initializing an adapter and wrap it to TransformationAdapterWrapper
        SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager());
        TransformationAdapterWrapper wrapper = TransformationAdapterWrapper
                .wrap(this, adapter) //wrap existing page adapter
                .rows(10) //number of rows to split image.
                .columns(7) // number of columns to split image
                .marginTop(getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin))
                .build(); //initializing

        viewPager.setAdapter(wrapper);
        viewPager.setPageTransformer(false, wrapper); //never forget this important line!
        indicator.initializeWith(viewPager); //attaching indicator with ViewPager
    }

    private static class SimplePagerAdapter extends FragmentStatePagerAdapter {

        public SimplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ViewPagerFragment.getInstances(position);
        }

        @Override
        public int getCount() {
            return 7;
        }
    }
}
