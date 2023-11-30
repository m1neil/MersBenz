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

public class LoginActivity extends AppCompatActivity {

	private String EMAIL_PATTERN =
		"^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
		int id = databaseHelper.getUserByEmail("admin@gmail.com");
		if (id == 0) {
			User admin = new User("admin", "admin@gmail.com", "admin");
			admin.setLikeCars("1,2,3");
			databaseHelper.addUser(admin);
		}
	}

	public void login(View view) {
		EditText email = findViewById(R.id.editTextEmail);
		EditText password = findViewById(R.id.editTextPassword);

		if (TextUtils.isEmpty(email.getText().toString().trim())) {
			Toast.makeText(this, "Не заповнен email", Toast.LENGTH_SHORT).show();
			return;
		} else if (TextUtils.isEmpty(password.getText().toString().trim())) {
			Toast.makeText(this, "Не заповнен пароль", Toast.LENGTH_SHORT).show();
			return;
		}

		if (!isValidEmail(email.getText().toString().trim())) {
			Toast.makeText(this, "Ви вели не валідний e-mail", Toast.LENGTH_SHORT).show();
			return;
		} else if (password.getText().toString().trim().length() < 4) {
			Toast.makeText(this, "Пароль повинен бути мінімум 4 символи", Toast.LENGTH_SHORT).show();
			return;
		}

		DatabaseHelper db = new DatabaseHelper(LoginActivity.this);
		int idEmail = db.getUserByEmail(email.getText().toString().trim());
		if (idEmail > 0) {
			User user = db.getUserByByEmailFullInfo(idEmail);

			if (!password.getText().toString().trim().equals(user.getPassword())) {
				Toast.makeText(this, "Не вірний пароль", Toast.LENGTH_LONG).show();
				return;
			}

			SharedPreferences sharedPreferences = this.getSharedPreferences("user", Context.MODE_PRIVATE);
			SharedPreferences.Editor sharedEditor = sharedPreferences.edit();
			sharedEditor.putInt("idUser", user.getId());
			sharedEditor.apply();
			Intent intent = new Intent(LoginActivity.this, MenuCarsActivity.class);
			startActivity(intent);
			finish();

		} else {
			Toast.makeText(this, "Такий обліковий запис не знайденно", Toast.LENGTH_SHORT).show();
		}
	}

	public boolean isValidEmail(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public void goToRegistration(View view) {
		Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
		startActivity(intent);
		finish();
	}
}