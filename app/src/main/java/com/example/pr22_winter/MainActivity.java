package com.example.pr22_winter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GridAdapter mAdapter;

    int GRID_SIZE = 6;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView mGrid = (GridView) findViewById(R.id.field);
        mGrid.setNumColumns(GRID_SIZE);
        mGrid.setEnabled(true);

        mAdapter = new GridAdapter(this, GRID_SIZE, GRID_SIZE);
        mGrid.setAdapter(mAdapter);

        mGrid.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                mAdapter.checkOpenCells ();
                mAdapter.openCell (position);

                if (mAdapter.checkGameOver())
                    Toast.makeText (getApplicationContext(), "Игра закончена", Toast.LENGTH_SHORT).show();
            }
        });
    }

}