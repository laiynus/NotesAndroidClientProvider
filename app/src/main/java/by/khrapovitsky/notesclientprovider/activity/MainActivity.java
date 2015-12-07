package by.khrapovitsky.notesclientprovider.activity;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import by.khrapovitsky.notesclientprovider.R;
import by.khrapovitsky.notesclientprovider.model.Note;

public class MainActivity extends AppCompatActivity {

    ListView notesListView = null;
    ArrayAdapter<Note> adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notesListView = (ListView) findViewById(R.id.notesListView);
        adapter = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, getNotes());
        notesListView.setAdapter(adapter);
    }


    private List getNotes(){
        String URL = "content://by.khrapovitsky.provider/notes";
        List<Note> noteList = new ArrayList<>();
        Uri uri = Uri.parse(URL);
        Cursor cursor = getContentResolver().query(uri, null, null, null,null);
        if (cursor.moveToFirst()) {
            do {
                Note note = new Note();
                note.setId(cursor.getString(cursor.getColumnIndex("_id")));
                note.setNote(cursor.getString(cursor.getColumnIndex("noteText")));
                note.setDate(cursor.getString(cursor.getColumnIndex("lastDateModify")));
                noteList.add(note);
            } while (cursor.moveToNext());
        }
        return noteList;
    }

}
