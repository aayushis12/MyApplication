package com.example.aayushi.myapplication;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class MyAccessibilityService extends AccessibilityService {

    private AccessibilityServiceInfo info;

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.i("service connected","service");
        info = new AccessibilityServiceInfo();
        info.eventTypes=AccessibilityEvent.TYPES_ALL_MASK;
        info.notificationTimeout=100;
        info.feedbackType=AccessibilityEvent.TYPES_ALL_MASK;
        info.packageNames = new String[]{"com.example.aayushi.firstapp"};
        setServiceInfo(info);
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Log.i("event-----------", accessibilityEvent.toString());
    }

    @Override
    public void onInterrupt() {

    }
}
