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


public class ThirdActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_third, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.return_serializable) {
            returnSerializableObject();
            return true;
        }
        if (id == R.id.return_parcelable) {
            returnParcelableObject();
            return true;
        }
        if (id == R.id.return_parcelable_array) {
            returnParcelableArray();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void returnParcelableArray() {
        Intent intent = new Intent();
        int size = 10;
        Cherry[] fruits = new Cherry[size];
        for (int i = 0; i < size; i++) {
            fruits[i] = new Cherry("Cherry"+i, i );
        }
        intent.putExtra("result", fruits);
        setResult(FirstActivity.PARCELABLE_ARRAY_OBJECT, intent);
        finish();
    }

    private void returnParcelableObject() {
        Intent intent = new Intent();
        IFruit fruit = new Cherry("Cherry", 20);
        intent.putExtra("result", fruit);
        setResult(FirstActivity.PARCELABLE_OBJECT, intent);
        finish();
    }

    private void returnSerializableObject() {
        Intent intent = new Intent();
        IFruit fruit = new Apple("Apple", 20);
        intent.putExtra("result", fruit);
        setResult(FirstActivity.SERIALIZABLE_OBJECT, intent);
        finish();
    }
}
