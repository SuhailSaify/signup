package com.example.suhail.signup;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SignupActivity extends AppCompatActivity {

    List<String> str = new ArrayList<String>();
    Button showsub1;//TEMP BUTTON TO SHOW SELECTED SUBJECT


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Spinner class_spinner = (Spinner) findViewById(R.id.spinner_for_class);
        LinearLayout linear_layout_for_checkbox = null;
        SetUpClassSpinner(class_spinner);
        ClassSpinnerItemClickListner(class_spinner);


        showsub1 = (Button) findViewById(R.id.sign_in_button);//TEMP BUTTON TO SHOW SELECTED SUBJECT

        OnClickListnerButton();
    }


    //lISTNER FOR TEMP BUTTON TO SHOW SELECTED SUBJECT
    void OnClickListnerButton() {
        showsub1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showsub();
                    }
                }
        );

    }

    /* methods to handle selected subjects
        STARTS FROM HERE
     */


    public void makenull()//TO MAKE STRING NULL IF A NEW CLASS IS SELECTED FROM DROP DOWN MWNU
    {

        str.clear();
    }

    public void removesub(String r) {
        //TO REMOVE SUBJECTS THAT ARE UNCHECKED AFTER BEING CHECKED ONCE
        for (int i = 0; i < str.size(); i++) {
            if (str.get(i) == r) {
                str.remove(i);
            }


        }

    }

    public void addstr(String sub) {                                  //TO ADD SUB WHICH ARE CHECKED TO LIST
        str.add(sub);
    }

    void showsub() {
        for (int i = 0; i < str.size(); i++)         //TO SHOW SUB
        {
            Toast.makeText(this, str.get(i), Toast.LENGTH_SHORT).show();

        }


    }

     /* methods to handle selected subjects
        ENDS HERE
     */


    //METHOD TO SETUP SPINNER CONTENT
    public void SetUpClassSpinner(Spinner class_spinner) {


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.class_list,//ARRAY TAKEN FROM VALUES/STRINGS
                android.R.layout.simple_spinner_item);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        class_spinner.setAdapter(adapter);
    }


    //METHOD TO SETUP SUBJECTS ACCORDING TO SELECTED CLASS
    public void ClassSpinnerItemClickListner(Spinner class_spinner) {
        class_spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        SetUpSubjectsCheckboxes(position);//SETUP SUBJECTS ACCORDING TO SELECTED CLASS
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }


        );


    }

    void SetUpSubjectsCheckboxes(int input) {
        String[] subjects = null;

        if (input == 0) {        //WHEN NO CLASS IS SELECTED THIS MESSAGE IS SHOWN

            TextView textview = new TextView(this);
            textview.setText("Please select a class from above");//message
            LinearLayout layout;
            layout = (LinearLayout) findViewById(R.id.checkbox_subjects_layout);
            layout.removeAllViews();

            LinearLayout.LayoutParams checkparams = new LinearLayout.LayoutParams(

                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            checkparams.setMargins(10, 10, 10, 10);
            checkparams.gravity = Gravity.LEFT;
            layout.addView(textview, checkparams);
        } else {

            switch (input) {

                //sending array of subjects according to sekected class

                case 1:
                    subjects = getResources().getStringArray(R.array.ClassNurserySubjects);
                    SetCheckBoxItems(subjects);
                    break;
                case 2:
                    subjects = getResources().getStringArray(R.array.ClassLKGSubjects);
                    SetCheckBoxItems(subjects);
                    break;
                case 3:
                    subjects = getResources().getStringArray(R.array.Class1Subjects);
                    SetCheckBoxItems(subjects);
                    break;
                case 4:
                    subjects = getResources().getStringArray(R.array.Class2Subjects);

                    SetCheckBoxItems(subjects);
                    break;
                case 5:
                    subjects = getResources().getStringArray(R.array.Class3Subjects);
                    SetCheckBoxItems(subjects);
                    break;

                case 6:
                    subjects = getResources().getStringArray(R.array.Class4Subjects);
                    SetCheckBoxItems(subjects);
                    break;
                case 7:
                    subjects = getResources().getStringArray(R.array.Class5Subjects);
                    SetCheckBoxItems(subjects);
                    break;
                case 8:
                    subjects = getResources().getStringArray(R.array.Class6Subjects);
                    SetCheckBoxItems(subjects);
                    break;
                case 9:
                    subjects = getResources().getStringArray(R.array.Class7Subjects);
                    SetCheckBoxItems(subjects);
                    break;
                case 10:
                    subjects = getResources().getStringArray(R.array.Class8Subjects);
                    SetCheckBoxItems(subjects);
                    break;
                case 11:
                    subjects = getResources().getStringArray(R.array.Class9Subjects);
                    SetCheckBoxItems(subjects);
                    break;
                case 12:
                    subjects = getResources().getStringArray(R.array.Class10Subjects);
                    SetCheckBoxItems(subjects);
                    break;
                case 13:
                    subjects = getResources().getStringArray(R.array.Class11pcmSubjects);
                    SetCheckBoxItems(subjects);
                    break;
                case 14:
                    subjects = getResources().getStringArray(R.array.Class12pcmSubjects);
                    SetCheckBoxItems(subjects);
                    break;


            }


        }
    }


    //method to set and listen to checkboxes
    void SetCheckBoxItems(String[] input) {

        makenull();//this makes list of stored sub null if a new class is selected from dropdown
        LinearLayout layout;
        layout = (LinearLayout) findViewById(R.id.checkbox_subjects_layout); //layout n which checkboxes will be added
        layout.removeAllViews();

        LinearLayout.LayoutParams checkparams = new LinearLayout.LayoutParams(

                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        checkparams.setMargins(10, 10, 10, 10);
        checkparams.gravity = Gravity.LEFT;
        int i = 0;
        for (i = 0; i < input.length; i++) {   //Dynamically adding checkboxes
            CheckBox checkbox = new CheckBox(this);
            checkbox.setId(R.id.check_box_id + i);
            checkbox.setText(input[i]);
            layout.addView(checkbox, checkparams);
            int index = 0;

            checkbox.setOnCheckedChangeListener(


                    new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked) {
                                addstr(buttonView.getText().toString()); //store selected sub to list

                            } else {
                                removesub(buttonView.getText().toString()); //TO REMOVE SUBJECTS THAT ARE UNCHECKED AFTER BEING CHECKED ONCE

                            }
                        }
                    }
            );
        }


    }


}



