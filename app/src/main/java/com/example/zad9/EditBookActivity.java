package com.example.zad9;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class EditBookActivity extends AppCompatActivity {

    public static final String EXTRA_EDIT_BOOK_TITLE = "com.example.zad9.EDIT_BOOK_TITLE";
    public static final String EXTRA_EDIT_BOOK_AUTHOR = "com.example.zad9.EDIT_BOOK_AUTHOR";
    public static final String EXTRA_BOOK_KEY = "book_id";

    private EditText editTitleEditText;
    private EditText editAuthorEditText;

    BookViewModel bookViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);

        editTitleEditText = findViewById(R.id.edit_book_title);
        editAuthorEditText = findViewById(R.id.edit_book_author);

        if (getIntent().getExtras() != null) {
            editTitleEditText.setText(getIntent().getExtras().getString(EXTRA_EDIT_BOOK_TITLE));
            editAuthorEditText.setText(getIntent().getExtras().getString(EXTRA_EDIT_BOOK_AUTHOR));
        }

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editTitleEditText.getText()) || TextUtils.isEmpty(editAuthorEditText.getText())){
                    setResult(RESULT_CANCELED, replyIntent);
                }
                else if (getIntent().getExtras() != null) {

                    String title = editTitleEditText.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_BOOK_TITLE, title);
                    String author = editAuthorEditText.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_BOOK_AUTHOR, author);
                    replyIntent.putExtra(EXTRA_BOOK_KEY, getIntent().getExtras().getString(EXTRA_BOOK_KEY));
                    setResult(RESULT_OK, replyIntent);
                }
                else {
                    String title = editTitleEditText.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_BOOK_TITLE, title);
                    String author = editAuthorEditText.getText().toString();
                    replyIntent.putExtra(EXTRA_EDIT_BOOK_AUTHOR, author);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }



}