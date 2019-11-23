### 从 AndroidStudio 编译 Google Camera2

#### 1. 下载源码

[https://android.googlesource.com/platform/packages/apps/Camera2/](https://android.googlesource.com/platform/packages/apps/Camera2/)

下载源码并选择主分支

```shell
git clone https://android.googlesource.com/platform/packages/apps/Camera2
git checkout android10-release
```

#### 2. 源码分析

- 目录结构

  ```shell
  .
  ├── Android.mk								
  ├── AndroidManifest.xml
  ├── CleanSpec.mk
  ├── OWNERS
  ├── assets
  │   └── fonts
  ├── jni
  │   ├── Android.mk
  │   ├── NOTICE
  │   ├── jpegutil.cpp
  │   ├── jpegutil.h
  │   ├── jpegutilnative.cpp
  │   └── tinyplanet.cc
  ├── proguard-project.txt
  ├── proguard.flags
  ├── project.properties
  ├── res
  │   ├── color
  │   ├── drawable
  │   ├── layout
  │   ├── menu
  │   ├── raw
  │   ├── values
  │   └── xml
  ├── res_p
  │   ├── drawable-hdpi
  │   ├── drawable-mdpi
  │   ├── drawable-xhdpi
  │   ├── drawable-xxhdpi
  │   ├── mipmap-anydpi
  │   ├── mipmap-hdpi
  │   ├── mipmap-mdpi
  │   ├── mipmap-xhdpi
  │   ├── mipmap-xxhdpi
  │   ├── mipmap-xxxhdpi
  │   └── values
  ├── src
  │   ├── android
  │   └── com
  ├── src_pd
  │   └── com
  ├── src_pd_gcam
  │   └── com
  ├── tests
  │   ├── Android.mk
  │   ├── AndroidManifest.xml
  │   ├── exiftool_parser
  │   ├── res
  │   └── src
  └── version.mk														# see doc/app 版本号含义.md
  ```

- ....

#### 3. 移植到AndroidStudio

- [commit 记录](https://github.com/lll-01/Camera2/commits/0e6d4976aac29abf50bd05c79bb06d238273b676)

  ```
  添加 gradle 构建系统
  将res移动到app/src/main/res
  使用google camera2 Manifest 替换自动生成的 Manifest
  将 res_p 文件夹添加到 gradle 配置中
  将 src 移动到app/src/main/java/
  将字体文件移动到 src/main/assets/
  修复 Duplicate resources 编译错误
  修复 failed linking file resources. 编译错误
  添加 google guava 依赖
  合并 src_pd 到 src 下
  合并 src_pd_gcam 到 src 下
  添加 Glide 依赖
  添加 jsr305 依赖，修改guava 版本
  添加 localbroadcastmanager 依赖
  添加 android/platform/frameworks/ex 依赖
  添加 platform/external/xmp_toolkit 依赖
  添加 findbugs:jsr305
  删除src_pd , src_pd_gcam
  ```

  

#### 4. 永不完成的TODO LIST

- 将Android.mk 转成 cmake  (一些c代码根本就没编译到 apk 里面 - - !, 但是还能正常运行)
- 让测试用例在AndroidStudio 里面跑起来


