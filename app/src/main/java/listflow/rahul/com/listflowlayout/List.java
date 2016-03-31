package listflow.rahul.com.listflowlayout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    ArrayList<String> brands = new ArrayList<>();
    ArrayList<ArrayList<String>> products = new ArrayList<ArrayList<String>>();
    MyNestedListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list);

        brands.add("abc");
        brands.add("def");
        brands.add("ghi");
        brands.add("jkl");
        brands.add("mno");
        brands.add("abc");
        brands.add("def");
        brands.add("ghi");
        brands.add("jkl");
        brands.add("mno");
        brands.add("abc");
        brands.add("def");
        brands.add("ghi");
        brands.add("jkl");
        brands.add("mno");
        brands.add("abc");
        brands.add("def");
        brands.add("ghi");
        brands.add("jkl");
        brands.add("mno");


        products.add(new ArrayList<String>() {{
            add("111");
            add("222");
            add("333");
        }});
        products.add(new ArrayList<String>() {{
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
        }});
        products.add(new ArrayList<String>() {{
            add("777");
            add("888");
            add("999");
        }});
        products.add(new ArrayList<String>() {{
            add("101010");
            add("111111");
            add("121212");
        }});
        products.add(new ArrayList<String>() {{
            add("131313");
            add("141414");
            add("151515");
        }});
        products.add(new ArrayList<String>() {{
            add("111");
            add("222");
            add("333");
        }});
        products.add(new ArrayList<String>() {{
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
        }});
        products.add(new ArrayList<String>() {{
            add("777");
            add("888");
            add("999");
        }});
        products.add(new ArrayList<String>() {{
            add("101010");
            add("111111");
            add("121212");
        }});
        products.add(new ArrayList<String>() {{
            add("131313");
            add("141414");
            add("151515");
        }});
        products.add(new ArrayList<String>() {{
            add("111");
            add("222");
            add("333");
        }});
        products.add(new ArrayList<String>() {{
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
        }});
        products.add(new ArrayList<String>() {{
            add("777");
            add("888");
            add("999");
        }});
        products.add(new ArrayList<String>() {{
            add("101010");
            add("111111");
            add("121212");
        }});
        products.add(new ArrayList<String>() {{
            add("131313");
            add("141414");
            add("151515");
        }});
        products.add(new ArrayList<String>() {{
            add("111");
            add("222");
            add("333");
        }});
        products.add(new ArrayList<String>() {{
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
            add("444");
            add("555");
            add("666");
        }});
        products.add(new ArrayList<String>() {{
            add("777");
            add("888");
            add("999");
        }});
        products.add(new ArrayList<String>() {{
            add("101010");
            add("111111");
            add("121212");
        }});
        products.add(new ArrayList<String>() {{
            add("131313");
            add("141414");
            add("151515");
        }});

        listView = (MyNestedListView)findViewById(R.id.list);
        CustomAdapter adapter = new CustomAdapter(getApplicationContext());
        listView.setAdapter(adapter);
        /*listView.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });*/
        //setListViewHeightBasedOnChildren(listView);

    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0){}
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ListView.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    public class CustomAdapter extends BaseAdapter{

        private  LayoutInflater inflater = null;
        public Resources res;
        int i = 0;

        public CustomAdapter(Context context) {

            inflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        public int getCount() {

           return brands.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public class ViewHolder {
            public TextView text;
            public TagFlowLayout listFlowLayout;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            View vi = convertView;
            ViewHolder holder;

            if (convertView == null) {

               vi = inflater.inflate(R.layout.listitem, null);

                holder = new ViewHolder();
                holder.text = (TextView) vi.findViewById(R.id.brandtext);
                holder.listFlowLayout = (TagFlowLayout) vi.findViewById(R.id.brandlist);

                vi.setTag(holder);
            } else
                holder = (ViewHolder) vi.getTag();

            if (brands.size() <= 0) {
                holder.text.setText("No Data");

            } else {
                holder.text.setText(brands.get(position));
                getProductsAdapter(position, holder.listFlowLayout);

            }
            return vi;
        }


    }

    public void getProductsAdapter(int position, TagFlowLayout listFlow){
        final ArrayList<String> subProducts = products.get(position);
        listFlow.setAdapter( new TagAdapter<String>(subProducts) {

            @Override
            public View getView(FlowLayout parent, final int position, String s) {

                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(getApplicationContext().LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.listitem, null);
                TextView textView = (TextView) view.findViewById(R.id.brandtext);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Product " + subProducts.get(position).toString()+" clicked.", Toast.LENGTH_SHORT).show();
                    }
                });

                textView.setText(subProducts.get(position).toString());
                return view;
            }
        });
    }
}
