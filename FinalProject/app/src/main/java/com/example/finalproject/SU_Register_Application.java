package com.example.finalproject;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SU_Register_Application extends Application {
    ExecutorService srv = Executors.newCachedThreadPool();
}
