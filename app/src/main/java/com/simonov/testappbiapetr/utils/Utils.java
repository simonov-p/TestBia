package com.simonov.testappbiapetr.utils;

import android.content.Context;
import android.media.MediaScannerConnection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

import timber.log.Timber;

/**
 * Created by simon on 25.03.2018.
 */

public class Utils {
    public static boolean copyDbToSdCard(Context context) {
        try {
            File sd = context.getExternalFilesDir(null);

            if (sd != null && sd.canWrite()) {
                File currentDB = new File(context.getDatabasePath(Constants.DB.DB_NAME) + ".db");
                File backupDB = new File(sd, Constants.DB.DB_NAME + ".db");

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();

                    MediaScannerConnection.scanFile(context, new String[]{backupDB.getAbsolutePath()}, null, null);
                    MediaScannerConnection.scanFile(context, new String[]{backupDB.getParentFile().getAbsolutePath()}, null, null);
                    Timber.v("Db success copied to %s", backupDB.getPath());
                    return true;
                }
            } else {
                Timber.e("Can't copy db to sdcard");
            }
        } catch (Exception e) {
            Timber.e(e, "Can't copy db to sdcard");
        }
        return false;
    }
}
