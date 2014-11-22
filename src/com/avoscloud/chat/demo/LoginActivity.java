package com.avoscloud.chat.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.avos.avoscloud.AVUser;

/**
 * Created by lzw on 14/11/22.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
  public static final String USER_ID = "userId";
  View login1, login2;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login_layout);
    login1 = findViewById(R.id.loginUser1);
    login2 = findViewById(R.id.loginUser2);
    login1.setOnClickListener(this);
    login2.setOnClickListener(this);
  }

  void goMainActivity(String userId) {
    Intent intent = new Intent(this, MyActivity.class);
    intent.putExtra(USER_ID, userId);
    startActivity(intent);
  }

  @Override
  public void onClick(View v) {
    if (v.getId() == R.id.loginUser1) {
      goMainActivity(App.userIds[0]);
    } else {
      goMainActivity(App.userIds[1]);
    }
  }
}