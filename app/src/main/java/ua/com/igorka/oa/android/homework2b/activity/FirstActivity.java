package ua.com.igorka.oa.android.homework2b.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import ua.com.igorka.oa.android.homework2b.R;
import ua.com.igorka.oa.android.homework2b.entity.Apple;
import ua.com.igorka.oa.android.homework2b.entity.Cherry;
import ua.com.igorka.oa.android.homework2b.entity.IFruit;


public class FirstActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
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


        return super.onOptionsItemSelected(item);
    }

    private void sendParcelableArrayOfObjects() {
        Intent intent = new Intent(this, SecondActivity.class);
        int size = 10;
        Cherry[] fruits = new Cherry[size];
        for (int i = 0; i < size; i++) {
            fruits[i] = new Cherry("Cherry"+i, i );
        }
        intent.putExtra("FRUIT",fruits);
        startActivity(intent);

    }

    private void sendParcelableObject() {
        Intent intent = new Intent(this, SecondActivity.class);
        IFruit fruit = new Cherry("Cherry", 10);
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
