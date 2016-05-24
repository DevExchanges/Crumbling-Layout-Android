package info.devexchanges.crumblinglayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPagerFragment extends Fragment {

    private ImageView imageView;
    private TextView textView;
    private static String[] phoneTypes = {"Android", "iOS", "WindowsPhone", "BlackBerry", "Tizen", "Ubuntu phone", "Sailfish"};
    private static int[] drawables = {R.drawable.android, R.drawable.ios, R.drawable.windows_phone,
            R.drawable.blackberry, R.drawable.tizen, R.drawable.ubuntu, R.drawable.sailfish};

    public static ViewPagerFragment getInstances(int position) {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int position = getArguments().getInt("position");

        imageView = (ImageView) view.findViewById(R.id.image);
        textView = (TextView) view.findViewById(R.id.text_view);

        imageView.setImageResource(drawables[position]);
        textView.setText(phoneTypes[position]);
    }
}