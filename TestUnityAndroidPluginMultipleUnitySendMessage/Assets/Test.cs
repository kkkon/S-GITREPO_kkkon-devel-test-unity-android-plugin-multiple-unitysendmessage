using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Test : MonoBehaviour
{

    // Use this for initialization
    void Start()
    {
#if UNITY_ANDROID && !UNITY_EDITOR
        var javaObj = new AndroidJavaObject("jp.ne.sakura.kkkon.android.test.unitysendmessage.UnitySendMessageMultiple");
        if ( null != javaObj )
        {
            javaObj.CallStatic("message", "test");
        }
#endif
    }

    // Update is called once per frame
    void Update()
    {

    }

    void OnGUI()
    {
        if ( GUI.Button(new Rect(30,30,240,80), "sendSameThread" ) )
        {
#if UNITY_ANDROID && !UNITY_EDITOR
            var javaObj = new AndroidJavaObject("jp.ne.sakura.kkkon.android.test.unitysendmessage.UnitySendMessageMultiple");
            if ( null != javaObj )
            {
                javaObj.CallStatic("sendSameThread", "GameObject", "onCallback", "test");
            }
#endif
        }
        if ( GUI.Button(new Rect(30,160,240,80), "sendSameThreadMultiple" ) )
        {
#if UNITY_ANDROID && !UNITY_EDITOR
            var javaObj = new AndroidJavaObject("jp.ne.sakura.kkkon.android.test.unitysendmessage.UnitySendMessageMultiple");
            if ( null != javaObj )
            {
                javaObj.CallStatic("sendSameThreadMultiple", "GameObject", "onCallback", "test");
            }
#endif
        }


        if ( GUI.Button(new Rect(30,330,240,80), "sendFromThread" ) )
        {
#if UNITY_ANDROID && !UNITY_EDITOR
            var javaObj = new AndroidJavaObject("jp.ne.sakura.kkkon.android.test.unitysendmessage.UnitySendMessageMultiple");
            if ( null != javaObj )
            {
                javaObj.CallStatic("sendFromThread", "GameObject", "onCallback", "test");
            }
#endif
        }
        if ( GUI.Button(new Rect(30,460,240,80), "sendFromThreadMultiple" ) )
        {
#if UNITY_ANDROID && !UNITY_EDITOR
            var javaObj = new AndroidJavaObject("jp.ne.sakura.kkkon.android.test.unitysendmessage.UnitySendMessageMultiple");
            if ( null != javaObj )
            {
                javaObj.CallStatic("sendFromThreadMultiple", "GameObject", "onCallback", "test");
            }
#endif
        }


        if ( GUI.Button(new Rect(30,630,240,80), "sendFromThreadWait" ) )
        {
#if UNITY_ANDROID && !UNITY_EDITOR
            var javaObj = new AndroidJavaObject("jp.ne.sakura.kkkon.android.test.unitysendmessage.UnitySendMessageMultiple");
            if ( null != javaObj )
            {
                javaObj.CallStatic("sendFromThreadWait", "GameObject", "onCallback", "test");
            }
#endif
        }
        if ( GUI.Button(new Rect(30,760,240,80), "sendFromThreadMultipleWait" ) )
        {
#if UNITY_ANDROID && !UNITY_EDITOR
            var javaObj = new AndroidJavaObject("jp.ne.sakura.kkkon.android.test.unitysendmessage.UnitySendMessageMultiple");
            if ( null != javaObj )
            {
                javaObj.CallStatic("sendFromThreadMultipleWait", "GameObject", "onCallback", "test");
            }
#endif
        }
    }


    public void onCallback(string value)
    {
        Debug.Log( string.Format("{0} val={1}",System.DateTime.Now.ToString(),value) );
    }

}
