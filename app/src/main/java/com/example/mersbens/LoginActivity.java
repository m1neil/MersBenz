package com.example.mersbens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import User.User;
import database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	public void login(View view) {
		EditText email = findViewById(R.id.editTextEmail);
		EditText password = findViewById(R.id.editTextPassword);

		if (email.getText().length() == 0
			|| password.getText().length() == 0) {
			Toast.makeText(this, "Не всі поля заповнені!", Toast.LENGTH_LONG).show();
			return;
		}

		DatabaseHelper db = new DatabaseHelper(LoginActivity.this);
		int idEmail = db.getUserByEmail(email.getText().toString());
		if (idEmail > 0) {
			User user = db.getUserByByEmailFullInfo(idEmail);

			if (!password.getText().toString().equals(user.getPassword())) {
				Toast.makeText(this, "Не вірний пароль", Toast.LENGTH_LONG).show();
				return;
			}

			String info = "Info: id: " + user.getId() + " name: " + user.getName() + " email: " + user.getEmail() +
				" password: " + user.getPassword() + " like car: " + user.getLikeCars();
			Toast.makeText(this, info, Toast.LENGTH_LONG).show();

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
}