package com.example.app.test;

import com.example.core.BaseApplication;
import com.example.core.utils.Utils;

/**
 * @author jty
 * @date 2020-08-28
 */
public class TestJava {

    public static void main(String[] args) {
        BaseApplication.currentApplication();
        Utils.INSTANCE.toast("");
        Utils.INSTANCE.toast("", 1);

    }
}
