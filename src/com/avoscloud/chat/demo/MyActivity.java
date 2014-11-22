package com.avoscloud.chat.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.avoscloud.chat.contrib.service.ChatService;

public class MyActivity extends Activity implements View.OnClickListener {
  /**
   * Called when the activity is first created.
   */
  View chatTo1, chatTo2, logout;
  TextView textView;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    findView();
    String userId = getIntent().getStringExtra(LoginActivity.USER_ID);
    if (userId.equals(App.userIds[0])) {
      chatTo1.setVisibility(View.GONE);
      chatTo2.setVisibility(View.VISIBLE);
      textView.setText(App.names[0] + "登录");
      ChatService.openSession(App.userIds[0]);
    } else {
      ChatService.openSession(App.userIds[1]);
      textView.setText(App.names[1] + "登录");
      chatTo1.setVisibility(View.VISIBLE);
      chatTo2.setVisibility(View.GONE);
    }
  }

  private void findView() {
    chatTo1 = findViewById(R.id.chatToUser1);
    chatTo2 = findViewById(R.id.chatToUser2);
    textView = (TextView) findViewById(R.id.textView);
    logout = findViewById(R.id.logout);
    chatTo1.setOnClickListener(this);
    chatTo2.setOnClickListener(this);
  }


  @Override
  public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.chatToUser1) {
      ChatService.goUserChat(this, App.userIds[0]);
    } else if (id == R.id.chatToUser2) {
      ChatService.goUserChat(this, App.userIds[1]);
    } else {
      ChatService.closeSession();
    }
  }
}
