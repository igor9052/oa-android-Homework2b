package ua.com.igorka.oa.android.homework2b.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import ua.com.igorka.oa.android.homework2b.R;
import ua.com.igorka.oa.android.homework2b.entity.IFruit;


public class SecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        if (intent.getParcelableArrayExtra("FRUIT") != null) {
            printParcelableArray(intent);
        } else if (intent.getParcelableExtra("FRUIT") != null) {
            printParcelableData(intent);
        } else if (intent.getSerializableExtra("FRUIT") != null) {
            printSerializableData(intent);
        }
    }

    private void printParcelableArray(Intent intent) {
        Parcelable[] fruits = intent.getParcelableArrayExtra("FRUIT");
        StringBuilder result = new StringBuilder();
        for (Parcelable item : fruits) {
            result.append(item);
            result.append("\n");
        }
        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(result);
    }

    private void printParcelableData(Intent intent) {
        IFruit fruit = (IFruit) intent.getParcelableExtra("FRUIT");
        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(fruit.toString());
    }

    private void printSerializableData(Intent intent) {
        IFruit fruit = (IFruit) intent.getSerializableExtra("FRUIT");
        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(fruit.toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
