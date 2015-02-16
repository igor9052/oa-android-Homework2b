package ua.com.igorka.oa.android.homework2b.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import ua.com.igorka.oa.android.homework2b.R;
import ua.com.igorka.oa.android.homework2b.entity.Apple;
import ua.com.igorka.oa.android.homework2b.entity.Cherry;
import ua.com.igorka.oa.android.homework2b.entity.IFruit;


public class FirstActivity extends ActionBarActivity {

    public static final int SERIALIZABLE_OBJECT = 100;
    public static final int PARCELABLE_OBJECT = 200;
    public static final int PARCELABLE_ARRAY_OBJECT = 300;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        textView = (TextView)findViewById(R.id.text);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_send_serializable_object) {
            sendSerializableObject();
            return true;
        }
        if (id == R.id.action_send_parcelable_object) {
            sendParcelableObject();
            return true;
        }
        if (id == R.id.action_send_parcelable_array) {
            sendParcelableArrayOfObjects();
            return true;
        }
        if (id == R.id.action_get_serializable_object) {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivityForResult(intent, SERIALIZABLE_OBJECT);
            return true;
        }
        if (id == R.id.action_get_parcelable_object) {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivityForResult(intent, PARCELABLE_OBJECT);
            return true;
        }
        if (id == R.id.action_get_parcelable_array) {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivityForResult(intent, PARCELABLE_ARRAY_OBJECT);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != resultCode) {
            return;
        }
        IFruit fruit = null;
        switch (resultCode) {
            case SERIALIZABLE_OBJECT:
                fruit = (IFruit) data.getSerializableExtra("result");
                break;
            case PARCELABLE_OBJECT:
                fruit = (IFruit) data.getParcelableExtra("result");
                break;
            case PARCELABLE_ARRAY_OBJECT:
                printParcelableObject(data);
                return;
        }
        if (fruit == null) {
            return;
        }
        textView.setText(fruit.toString());
    }

    private void printParcelableObject(Intent data) {
        Parcelable[] fruits = data.getParcelableArrayExtra("result");
        StringBuilder result = new StringBuilder();
        for (Parcelable item : fruits) {
            result.append(item);
            result.append("\n");
        }
        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(result);
    }

    private void sendParcelableArrayOfObjects() {
        Intent intent = new Intent(this, SecondActivity.class);
        int size = 10;
        Cherry[] fruits = new Cherry[size];
        for (int i = 0; i < size; i++) {
            fruits[i] = new Cherry("Cherry"+i, "unknown", i );
        }
        intent.putExtra("FRUIT",fruits);
        startActivity(intent);

    }

    private void sendParcelableObject() {
        Intent intent = new Intent(this, SecondActivity.class);
        IFruit fruit = new Cherry("Cherry", "unknown", 10);
        intent.putExtra("FRUIT", (android.os.Parcelable) fruit);
        startActivity(intent);
    }

    private void sendSerializableObject() {
        Intent intent = new Intent(this, SecondActivity.class);
        IFruit fruit = new Apple("Apple", 10);
        intent.putExtra("FRUIT", fruit);
        startActivity(intent);
    }




}
