# **VideoWallpaper**
### VideoWallpaper可以将本地mp4文件设置成手机桌面，手机桌面原来可以如此炫酷。Enjoy it O(∩_∩)O

![image](https://github.com/DingMouRen/VideoWallpaper/raw/master/screenshot/video1.gif) 　 　　　![image](https://github.com/DingMouRen/VideoWallpaper/raw/master/screenshot/video2.gif)

### build.gralde中引入
```
	compile 'com.dingmouren.videowallpaper:videowallpaper:1.0.1'
```
### 需要添加的权限
```
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
<uses-permission android:name="android.permission.SET_WALLPAPER"/>
```

### 一句代码让你的手机更酷更炫
```
 mVideoWallpaper.setToWallPaper(this,mFile.getAbsolutePath());
```

### 公共的方法

方法 | 描述
---|---
 public static void setVoiceSilence(Context context) | 设置手机桌面壁纸为静音状态
  public static void setVoiceNormal(Context context) | 设置手机桌面壁纸为有声状态
  public  void setToWallPaper(Context context,String videoPath) | 设置手机桌面动态壁纸,videoPath是本地mp4文件的路径
  
# **注意：**
* 视频文件必须是mp4格式
* mp4文件必须是本地文件
## License
```
Copyright (C) 2017 WeyYe

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License
```
