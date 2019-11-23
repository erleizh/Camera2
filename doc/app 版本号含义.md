### app 版本号含义

`Mmbbbtad`

- `M`-主版本（一个或多个数字）

- `m`-次要版本（精确到1位数字）

- `bbb`-手动指定的内部版本号（3位数字）

- `t`-构建类型（1位数字）。当前有效值为

  - 0：中文版
  - 1：构建服务器

- `a`-设备架构（精确到1位数字）。当前有效值为：

  - 0 : non-native
  - 1 : armv5te
  - 3 : armv7-a
  - 5 : mips
  - 7 : x86

- `d`-资产密度（精确到1位数字）。当前有效值为：

  - 0：all densities
  - 2：mdpi
  - 4：hdpi
  - 6：xhdpi

    

Mmbbb是手动指定的。在构建过程中会自动设置tad。
对于客户端jar，版本代码与目标体系结构和密度无关：Mmbbbt00
注意：拱形比密度更重要，因为x86设备支持运行中的ARM
代码处于仿真模式，因此所有x86版本必须高于所有ARM版本，以确保
我们向这些设备提供了真正的x86代码。
历史：
2.0.001-工厂ROM和0天OTA 4.4（KK）
2.0.002-4.4 MR1系统映像
手动指定以下内容。请注意，base_version_minor必须为1位数，并且
base_version_build必须正好是3位数字。


以上内容来自 [android10-release/version.mk](https://android.googlesource.com/platform/packages/apps/Camera2/+/refs/heads/android10-release/version.mk)