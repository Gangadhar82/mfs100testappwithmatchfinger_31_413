/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mantra.mfs100;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.Random;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.AvoidXfermode.Mode;
import android.os.Environment;
import android.preference.PreferenceManager;

/**
 * 
 * @author MAHESH
 */
public class CommonMethods {

	
	@SuppressLint("SimpleDateFormat")
	public static void writeLog(String strLog) {

		try {
			boolean isNewFile = false;
			String Dir = Environment.getExternalStorageDirectory().getPath()
					+ "/MFS100";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHH");
			String FileNameFormate = dateFormat.format(new Date());
			String FileName = Dir + "/Log_" + FileNameFormate + ".txt";

			SimpleDateFormat logTimeFormat = new SimpleDateFormat(
					"yyyy-MM-dd-HH-mm-ss");
			String logTime = logTimeFormat.format(new Date());
			File dir = new File(Dir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File logFile = new File(FileName);
			if (!logFile.exists()) {
				isNewFile = true;
				logFile.createNewFile();
			}
			FileOutputStream fOut;
			OutputStreamWriter myOutWriter;
			fOut = new FileOutputStream(logFile, true);
			myOutWriter = new OutputStreamWriter(fOut);
			if (isNewFile) {
				myOutWriter.append(logTime + "\n" + strLog);
			} else {
				myOutWriter.append("\n" + logTime + "\n" + strLog);
			}
			myOutWriter.flush();
			myOutWriter.close();
		} catch (Exception ex) {

		}

	}

}
