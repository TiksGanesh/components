package com.example.ganeshtikone.componets;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener,
        DatePickerDialog.OnDateSetListener {

    private static final String TAG = SignInActivity.class.getSimpleName();

    private EditText editTextFirst ;
    private EditText editTextMiddleName ;
    private EditText editTextLastName ;
    private EditText editTextMobile ;
    private EditText editTextDateOfBirth;
    private EditText editTextRandom;

    private CheckBox checkBoxTerms ;
    private Button buttonSignUp ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initUI();
        addListenerOnRandomEditText();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Log.e(TAG, "onCreate function called");
    }


    /**
     * Handle text change on randome edit text
     */
    private void addListenerOnRandomEditText() {

        editTextRandom.addTextChangedListener(new RandomTextWatcher());


    }

    private void initUI() {


        editTextFirst = findViewById(R.id.editTextFirstName);
        editTextMiddleName = findViewById(R.id.editTextMiddleName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextDateOfBirth =  findViewById(R.id.editTextDateOfBirth);
        editTextDateOfBirth.setOnClickListener(this);

        editTextRandom = findViewById(R.id.editTextRandom);

        checkBoxTerms = findViewById(R.id.checkboxTerms);
        buttonSignUp = findViewById(R.id.buttonSignup);
        buttonSignUp.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart function called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume function called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause function called");
    }

    @Override
    protected void onStop() {

        Log.e(TAG, "onStop function called");
        super.onStop();
    }


    @Override
    protected void onDestroy() {

        Log.e(TAG, "onDestroy function called");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.e(TAG, "onRestart    function called");
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();


        if (R.id.buttonSignup == id){
            startDashboardActivity();
        }else if (R.id.editTextDateOfBirth == id){
            openDatePicker();
        }


    }

    /**
     * Open Date Picker
     */
    private void openDatePicker() {

        Calendar calendar = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE));

        datePickerDialog.show();
    }


    /**
     *  Start Dashboard Activity
     */
    private void startDashboardActivity() {

        String fName = editTextFirst.getText().toString();
        String mName = editTextMiddleName.getText().toString();
        String lName = editTextLastName.getText().toString();
        String mobile = editTextMobile.getText().toString();


        Bundle bundle = new Bundle();
        bundle.putString("first_name",fName);
        bundle.putString("middle_name",mName);
        bundle.putString("last_name",lName);
        bundle.putString("mobile",mobile);

        // Explicit Intent
        // Class: Intent  Context, Class
        Intent dashboardActivityIntent = new Intent(SignInActivity.this,
                DashboardActivity.class);

        // Add Bundle object to Intent object
        dashboardActivityIntent.putExtras(bundle);

        startActivity(dashboardActivityIntent); // Activity // Service // Broadcast Receiver

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

        month = month+1;
        String result =year +"/"+month+"/"+dayOfMonth;
        editTextDateOfBirth.setText(result);
        //Log.e(TAG, result);
    }


    private class RandomTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Log.e(TAG,"Before Text Change");
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // Code
            editTextRandom.removeTextChangedListener(this);

            String input = charSequence.toString();
            if (TextUtils.isDigitsOnly(input)){
                editTextRandom.setText(charSequence);
            }else {
                editTextRandom.setText("");
            }

            editTextRandom.addTextChangedListener(this);

        }

        @Override
        public void afterTextChanged(Editable editable) {
            // Code
            Log.e(TAG,"After Text Change");
        }
    }

}











