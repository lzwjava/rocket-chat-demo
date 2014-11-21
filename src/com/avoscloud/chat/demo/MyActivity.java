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
  View login1, login2, chatTo1, chatTo2;
  TextView textView;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    findView();
  }

  private void findView() {
    login1 = findViewById(R.id.loginUser1);
    login2 = findViewById(R.id.loginUser2);
    chatTo1 = findViewById(R.id.chatToUser1);
    chatTo2 = findViewById(R.id.chatToUser2);
    textView = (TextView) findViewById(R.id.textView);
    login1.setOnClickListener(this);
    login2.setOnClickListener(this);
    chatTo1.setOnClickListener(this);
    chatTo2.setOnClickListener(this);
  }


  @Override
  public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.loginUser1) {
      ChatService.closeSession();
      ChatService.openSession(App.userIds[0]);
      textView.setText(App.names[0] + "登录");
    } else if (id == R.id.loginUser2) {
      ChatService.closeSession();
      ChatService.openSession(App.userIds[1]);
      textView.setText(App.names[1] + "登录");
    } else if (id == R.id.chatToUser1) {
      ChatService.goUserChat(this, App.userIds[0]);
    } else if (id == R.id.chatToUser2) {
      ChatService.goUserChat(this, App.userIds[1]);
    }
  }
}
