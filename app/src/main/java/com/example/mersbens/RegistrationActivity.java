package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import User.User;
import database.DatabaseHelper;

public class RegistrationActivity extends AppCompatActivity {

	private String EMAIL_PATTERN =
		"^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
	}

	public void registration(View view) {
		EditText name = findViewById(R.id.editTextUserName);
		EditText email = findViewById(R.id.editTextEmail);
		EditText password = findViewById(R.id.editTextPassword);

		String nameString = name.getText().toString().trim();
		String emailString = email.getText().toString().trim();
		String passwordString = password.getText().toString().trim();

		if (TextUtils.isEmpty(nameString)) {
			Toast.makeText(this, "Не заповнене ім'я", Toast.LENGTH_SHORT).show();
			return;
		} else if (TextUtils.isEmpty(emailString)) {
			Toast.makeText(this, "Не заповнен email", Toast.LENGTH_SHORT).show();
			return;
		} else if (TextUtils.isEmpty(passwordString)) {
			Toast.makeText(this, "Не заповнен пароль", Toast.LENGTH_SHORT).show();
			return;
		}


//		if (name.getText().length() == 0 || email.getText().length() == 0
//			|| password.getText().length() == 0) {
//			Toast.makeText(this, "Не всі поля заповнені!", Toast.LENGTH_LONG).show();
//			return;
//		}
		if (nameString.length() < 2) {
			Toast.makeText(this, "Ім'я повино бути не меньше 2 символів", Toast.LENGTH_SHORT).show();
			return;
		} else if (!isValidEmail(emailString)) {
			Toast.makeText(this, "Ви вели не валідний e-mail", Toast.LENGTH_SHORT).show();
			return;
		} else if (passwordString.length() < 4) {
			Toast.makeText(this, "Пароль повинен бути мінімум 4 символи", Toast.LENGTH_SHORT).show();
			return;
		}



		DatabaseHelper db = new DatabaseHelper(RegistrationActivity.this);
		int idEmail = db.getUserByEmail(emailString);
		if (idEmail == 0) {
			User user = new User(nameString, emailString, passwordString);
			db.addUser(user);
			name.setText("");
			email.setText("");
			password.setText("");
			Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
			startActivity(intent);
			finish();
		} else {
			Toast.makeText(this, "Такий обліковий запис вже існує", Toast.LENGTH_SHORT).show();
		}
	}

	public boolean isValidEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public void goToLogin(View view) {
		Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
		startActivity(intent);
		finish();
	}
}