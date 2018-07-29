package jp.ne.sakura.kkkon.android.test.unitysendmessage;

import android.util.Log;

import com.unity3d.player.UnityPlayer;

/**
 * Created by kkkon on 2018/07/29.
 */

public class UnitySendMessageMultiple
{
    private static final String TAG = "UnitySendMessageMulti";

    public static void message(final String message)
    {
        Log.d( TAG, "message: UnitySendMessage before" );
        Log.d( TAG, message );
        Log.d( TAG, "message: UnitySendMessage after" );
    }

    public static void sendSameThread(final String gameObjName, final String methodName, final String value)
    {
        Log.d( TAG, "sendSameThread: UnitySendMessage before" );
        UnityPlayer.UnitySendMessage(gameObjName, methodName, value);
        Log.d( TAG, "sendSameThread: UnitySendMessage after" );
    }
    public static void sendSameThreadMultiple(final String gameObjName, final String methodName, final String value)
    {
        for ( int count = 1; count <= 5; ++count )
        {
            Log.d( TAG, "sendSameThreadMultiple: UnitySendMessage before" );
            UnityPlayer.UnitySendMessage(gameObjName, methodName, value + count);
            Log.d( TAG, "sendSameThreadMultiple: UnitySendMessage after" );
        }
    }



    public static void sendFromThread(final String gameObjName, final String methodName, final String value)
    {
        (new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                Log.d( TAG, "sendFromThread: UnitySendMessage before" );
                UnityPlayer.UnitySendMessage(gameObjName, methodName, value);
                Log.d( TAG, "sendFromThread: UnitySendMessage after" );
            }
        })).start();
    }
    public static void sendFromThreadMultiple(final String gameObjName, final String methodName, final String value)
    {
        (new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for ( int count = 1; count <= 5; ++count )
                {
                    Log.d( TAG, "sendFromThreadMultiple: UnitySendMessage before" );
                    UnityPlayer.UnitySendMessage(gameObjName, methodName, value + count);
                    Log.d( TAG, "sendFromThreadMultiple: UnitySendMessage after" );
                }
            }
        })).start();
    }


    public static void sendFromThreadWait(final String gameObjName, final String methodName, final String value)
    {
        (new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep( 15*1000 );
                }
                catch ( InterruptedException e )
                {
                    Log.d( TAG, "sendFromThreadMultiple: UnitySendMessage", e );
                }
                Log.d( TAG, "sendFromThread: UnitySendMessage before" );
                UnityPlayer.UnitySendMessage(gameObjName, methodName, value);
                Log.d( TAG, "sendFromThread: UnitySendMessage after" );
            }
        })).start();
    }
    public static void sendFromThreadMultipleWait(final String gameObjName, final String methodName, final String value)
    {
        (new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep( 15*1000 );
                }
                catch ( InterruptedException e )
                {
                    Log.d( TAG, "sendFromThreadMultiple: UnitySendMessage", e );
                }
                for ( int count = 1; count <= 5; ++count )
                {
                    Log.d( TAG, "sendFromThreadMultiple: UnitySendMessage before" );
                    UnityPlayer.UnitySendMessage(gameObjName, methodName, value + count);
                    Log.d( TAG, "sendFromThreadMultiple: UnitySendMessage after" );
                }
            }
        })).start();
    }

}
