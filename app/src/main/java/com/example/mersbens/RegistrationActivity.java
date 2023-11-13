package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import User.User;
import database.DatabaseHelper;

public class RegistrationActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
	}

	public void registration(View view) {
		EditText name = findViewById(R.id.editTextUserName);
		EditText email = findViewById(R.id.editTextEmail);
		EditText password = findViewById(R.id.editTextPassword);

		if (name.getText().length() == 0 || email.getText().length() == 0
			|| password.getText().length() == 0) {
			Toast.makeText(this, "Не всі поля заповнені!", Toast.LENGTH_LONG).show();
			return;
		}

		DatabaseHelper db = new DatabaseHelper(RegistrationActivity.this);
		int idEmail = db.getUserByEmail(email.getText().toString());
		if (idEmail == 0) {
			User user = new User(name.getText().toString(), email.getText().toString(), password.getText().toString());
			db.addUser(user);
			name.setText("");
			email.setText("");
			password.setText("");

		} else {
			Toast.makeText(this, "Такий обліковий запис вже існує", Toast.LENGTH_SHORT).show();
		}
	}
}