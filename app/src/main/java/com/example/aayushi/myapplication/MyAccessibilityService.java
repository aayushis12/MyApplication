package com.example.aayushi.myapplication;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

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
       // Log.i("event-----------", accessibilityEvent.toString());
//        Log.i("source------",accessibilityEvent.getSource().toString());
        AccessibilityNodeInfo nodeInfo=accessibilityEvent.getSource();
        if(nodeInfo==null)return;
        List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText("Go Online");
                //nodeInfo.findAccessibilityNodeInfosByViewId
                    //    ("com.example.aayushi.firstapp:id/button");
       // Log.i("list------------", list.toString());
        for(AccessibilityNodeInfo node: list){
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }
    }

    @Override
    public void onInterrupt() {

    }
}
