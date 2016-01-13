package com.mantra.mfs100;

import android.graphics.Bitmap;

public final class mfs100api {
	static {
		//System.loadLibrary("MFSISO");		
		System.loadLibrary("iengine_ansi_iso");
		System.loadLibrary("MFS100V9");
	}
	
	public final static native long MFS100LoadFirmware(long fd,String FirmwarePath,int pcbversion);
	public final static native long MFS100Init(int latentThreshold, int Xfer_Size, String FirmwarePath, long fd, byte[] serial);
	public final static native int MFS100Uninit(long fd);
	public final static native int MFS100GetInitErrorCode();
	public final static native int MFS100GetVersion();
	public final static native int MFS100StartXcan(long fd, int NoOfFrames,int TimeOut);
	public final static native int MFS100StopXcan(long fd);
	public final static native int MFS100GetPreviewFrame(long fd, byte[] Frame);
	public final static native int MFS100GetFinalFrame(long fd, byte[] Frame);
	public final static native int MFS100GetPreviewBitmapData(long fd,byte[] Frame, Bitmap bmp);
	public final static native int MFS100GetFinalBitmapData(long fd,byte[] Frame, Bitmap bmp);
	public final static native int MFS100GetWidth(long fd);
	public final static native int MFS100GetHeight(long fd);
	public final static native int MFS100DeviceConnected(long fd);
	public final static native int MFS100RotateImage(long fd,int Direction);
	public final static native int MFS100GetContrast(long fd);
	public final static native int MFS100GetQuality(long fd);
	public final static native int MFS100ExtractISOTemplate(long fd,byte[] RawImage, byte[] Iso_19794_2_Template);
	public final static native int MFS100ExtractANSITemplate(long fd,byte[] RawImage, byte[] Ansi_19794_2_Template);
	public final static native int MFS100ExtractISOImage(long fd,byte[] RawImage,byte[] ISOImage, byte FingerPosition);
	public final static native int MFS100MatchISO(long fd,byte[] probeTemplate,byte[] galleryTemplate, int maxRotation);
	public final static native int MFS100MatchANSI(long fd,byte[] probeTemplate,byte[] galleryTemplate, int maxRotation);
	
	//Error Codes
	private static final int  MFS100_E_SUCCESS =	0;	//No error. (Success)
    public static final int  MFS100_E_LOAD_SCANNER_LIBRARY  = 1301; 	//Error on loading scanner Library
    public static final int  MFS100_E_CAPTURE_FAILED = 1302; 	//Capturing is timeout or Aborted
    public static final int  MFS100_E_EXTRACTION_FAILED = 1303; 	//Extraction is failed
    public static final int  MFS100_E_NOT_GOOD_IMAGE = 1304; 	//Input image is not good
    public static final int  MFS100_E_SPOOF_FINGER = 1305; 	//latent finger found
    public static final int  MFS100_E_ALREADY_INITIALIZED = 1306;	//Already Initialized	
    public static final int  MFS100_E_NO_DEVICE = 1307;	//Device Not Found
    public static final int  MFS100_E_ALREADY_START_STOP = 1308;	//Device Already Started or Already Stopped
    public static final int  MFS100_E_NOT_INITIALIZED = 1309;	//Device Not Initialized
    public static final int  MFS100_E_OTHER_DEVICE_ERROR = 1310;	//Other Device Related Error			
    public static final int  MFS100_E_ALREADY_UNINITIALIZED = 1311;	//Already Initialized	
    public static final int  MFS100_E_UNHANDLED_EXCEPTIONS = 1312;	//unhandled Exceptions
    public static final int  MFS100_E_NO_SERIAL = 1313;	//no Serial no in device
    public static final int  MFS100_E_CORRUPT_SERIAL = 1314;	//serial no corrupted
    public static final int  MFS100_E_INVALIDPARAM = 1315; 	//invalid parameters
    public static final int  MFS100_E_LATENT_FINGER = 1316; 	//latent finger found
    public static final int  MFS100_E_LOAD_FIRMWARE_FAILED = 1317; 	//load firmware failed
    
    public static final int  MFS100_E_NOFINGERPRINT = 1102; 	//User structure contains no fingerprints (void user).
    public static final int  MFS100_E_BLANKIMAGE = 1114; 	//Image is blank or contains non-recognizable fingerprint.
    public static final int  MFS100_E_BADIMAGE = 1115; 	//Invalid image or unsupported image format.
    public static final int  MFS100_E_ERROR_FILE = 1117;	//cannot read/write to file
    public static final int  MFS100_E_BADINDEX = 1119; 	//Fingerprint index is not valid.
    public static final int  MFS100_E_MEMORY = 1120; 	//Memory allocation failed.
    public static final int  MFS100_E_NULLPARAM = 1121; 	//Null input parameter provided
    public static final int  MFS100_E_OTHER = 1122; 	//Other unspecified error.
    public static final int  MFS100_E_NOIMAGE = 1123; 	//Image not available.
    public static final int  MFS100_E_INTERNAL = 1124; 	//Unspecified internal error occurred.
    public static final int  MFS100_E_BADLICENSE = 1129; 	//License is not valid, or no license was found.
    public static final int  MFS100_E_EXPIREDLICENSE = 1130; 	//License has expired.
    public static final int  MFS100_E_MISSINGDLL = 1131; 	//At least one required DLL could not be loaded.
    public static final int  MFS100_E_BADFORMAT = 1132; 	//Unsupported format.
    public static final int  MFS100_E_BADVALUE = 1133; 	//Invalid value provided.
    public static final int  MFS100_E_NOT_IMPLEMENTED = 1134; 	//Function Not Implemented.
    public static final int  MFS100_E_INVALID_TEMPLATE = 1135; 	//Invalid tempalte.
    public static final int  MFS100_E_READ_ONLY = 1136;	//value cannot be modified.
    public static final int  MFS100_E_NOT_DEFINED = 1137;	//value is not defined
    public static final int  MFS100_E_NULL_TEMPLATE = 1138;	//tempalte is null
    public static final int  MFS100_E_SYNC_PROBLEM = 1139; //Sync problem
    
	    public static String ErrorString;
	    
	    public static int CheckError(int returnValue)
	    {
	    	ErrorString="None";
	        if(!(returnValue>1100 && returnValue<1400))
	            return 0;
	        
	         switch (returnValue) {
	            case 0: return 0;
	            case 1301:  ErrorString = "Error on Loading Scanner Library"; return -1;
	            case 1302:  ErrorString = "Capturing is timeout or Aborted"; return -1;
	            case 1303:  ErrorString = "Extraction is failed"; return -1;
	            case 1304:  ErrorString = "Input image is not good"; return -1;
	            case 1305:  ErrorString = "latent finger found"; return -1;
	            case 1306:  ErrorString = "Already Initialized"; return -1;
	            case 1307:  ErrorString = "Device Not Found"; return -1;
	            case 1308:  ErrorString = "Device Already Started or Already Stopped"; return -1;
	            case 1309:  ErrorString = "Device Not Initialized"; return -1;
	            case 1310:  ErrorString = "Other Device Related Error"; return -1;
	            case 1311:  ErrorString = "Already UnInitialized"; return -1;
	            case 1312:  ErrorString = "unhandled Exceptions"; return -1;
	            case 1313:  ErrorString = "no Serial no in device"; return -1;
	            case 1314:  ErrorString = "serial no corrupted"; return -1;
	            case 1315:  ErrorString = "invalid parameters"; return -1;
	            case 1316:  ErrorString = "latent finger found"; return -1;
	            case 1317:  ErrorString = "Load firmware failed"; return -1;
	            
	            case 1102:  ErrorString = "User structure contains no fingerprints (void user)"; return -1;
	            case 1114:  ErrorString = "Image is blank or contains non-recognizable fingerprint"; return -1;
	            case 1115:  ErrorString = "Invalid image or unsupported image format"; return -1;
	            case 1117:  ErrorString = "cannot read/write to file"; return -1;    
	            case 1119:  ErrorString = "Fingerprint index is not valid"; return -1;
	            case 1120:  ErrorString = "Memory allocation failed"; return -1;
	            case 1121:  ErrorString = "Null input parameter provided"; return -1;
	            case 1122:  ErrorString = "Other unspecified error"; return -1;
	            case 1123:  ErrorString = "Image not available"; return -1;
	            case 1124:  ErrorString = "Unspecified internal error occurred"; return -1;
	            case 1129:  ErrorString = "License is not valid, or no license was found"; return -1;
	            case 1130:  ErrorString = "License has expired"; return -1;
	            case 1131:  ErrorString = "At least one required DLL could not be loaded."; return -1;
	            case 1132:  ErrorString = "Unsupported format"; return -1;
	            case 1133:  ErrorString = "Invalid value provided"; return -1;
	            case 1134:  ErrorString = "Function Not Implemented"; return -1;
	            case 1135:  ErrorString = "Invalid tempalte"; return -1;
	            case 1136:  ErrorString = "value cannot be modified"; return -1;
	            case 1137:  ErrorString = "value is not defined"; return -1;
	            case 1138:  ErrorString = "tempalte is null"; return -1;
	            case 1139:  ErrorString = "Sync Problem"; return -1;
	            default: ErrorString = "Unknown Error";
	                     return -1;
	        }
	    }
}
