package com.dawnlight.computers;

import android.content.Context;

import com.dawnlight.AppLog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Random;

public class IdentityManager {
    private static final String UNIQUE_ID_FILE_NAME = "uniqueid";
    private static final int UID_SIZE_IN_BYTES = 8;

    private String uniqueId;

    public IdentityManager(Context c) {
        uniqueId = loadUniqueId(c);
        if (uniqueId == null) {
            uniqueId = generateNewUniqueId(c);
        }

        AppLog.info("UID is now: "+uniqueId);
    }

    public String getUniqueId() {
        return uniqueId;
    }

    private static String loadUniqueId(Context c) {
        // 2 Hex digits per byte
        char[] uid = new char[UID_SIZE_IN_BYTES * 2];
        AppLog.info("Reading UID from disk");
        try (final InputStreamReader reader =
                     new InputStreamReader(c.openFileInput(UNIQUE_ID_FILE_NAME))
        ) {
            if (reader.read(uid) != UID_SIZE_IN_BYTES * 2) {
                AppLog.severe("UID file data is truncated");
                return null;
            }
            return new String(uid);
        } catch (FileNotFoundException e) {
            AppLog.info("No UID file found");
            return null;
        } catch (IOException e) {
            AppLog.severe("Error while reading UID file");
            e.printStackTrace();
            return null;
        }
    }

    private static String generateNewUniqueId(Context c) {
        // Generate a new UID hex string
        AppLog.info("Generating new UID");
        String uidStr = String.format((Locale)null, "%016x", new Random().nextLong());

        try (final OutputStreamWriter writer =
                     new OutputStreamWriter(c.openFileOutput(UNIQUE_ID_FILE_NAME, 0))
        ) {
            writer.write(uidStr);
            AppLog.info("UID written to disk");
        } catch (IOException e) {
            AppLog.severe("Error while writing UID file");
            e.printStackTrace();
        }

        // We can return a UID even if I/O fails
        return uidStr;
    }
}
