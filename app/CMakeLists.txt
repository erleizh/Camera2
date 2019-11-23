CMAKE_MINIMUM_REQUIRED(VERSION 3.4.1)


set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -ffast-math -o3 -funroll-loops -Wall -Wextra -Werror")


ADD_LIBRARY(jni_tinyplanet SHARED src/main/cpp/tinyplanet.cc)


ADD_LIBRARY(
jni_jpegutil
SHARED
src/main/cpp/jpegutil.cpp
src/main/cpp/jpegutil.h
src/main/cpp/jpegutilnative.cpp
)