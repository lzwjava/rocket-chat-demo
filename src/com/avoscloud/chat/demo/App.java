package com.avoscloud.chat.demo;

import android.app.Application;
import com.avos.avoscloud.AVInstallation;
import com.avos.avoscloud.AVOSCloud;
import com.avoscloud.chat.contrib.service.ChatService;
import com.avoscloud.chat.contrib.service.UserHelper;

/**
 * Created by lzw on 14/11/22.
 */
public class App extends Application {
  public static String[] avatarUrls = new String[]{"http://ac-x3o016bx.qiniudn.com/TNAq1qc35KD650hVF3ahU1lbFZhEmzcT2OdI28Qr",
      "http://ac-x3o016bx.qiniudn.com/3aRUu3nxaN6hyJyJ3tMbxnG6scAGEeCK41uFYo1c"};
  public static String[] names = new String[]{"张三", "李四"};
  public static String[] userIds = new String[]{"1", "2"};

  @Override
  public void onCreate() {
    super.onCreate();
    AVOSCloud.initialize(this, "xcalhck83o10dntwh8ft3z5kvv0xc25p6t3jqbe5zlkkdsib", "m9fzwse7od89gvcnk1dmdq4huprjvghjtiug1u2zu073zn99");
    AVInstallation.getCurrentInstallation().saveInBackground();
    //AVOSCloud.setDebugLogEnabled(true);

    ChatService.init(this, new UserHelper() {
      @Override
      public String getDisplayName(String userId) {
        if (userId.equals(userIds[0])) {
          return names[0];
        } else {
          return names[1];
        }
      }

      @Override
      public String getDisplayAvatarUrl(String userId) {
        if (userId.equals(userIds[0])) {
          return avatarUrls[0];
        } else {
          return avatarUrls[1];
        }
      }
    });
    ChatService.showIconAtChatRoom = false;
    ChatService.useSignature = false;
  }
}
