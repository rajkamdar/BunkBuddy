package weekender.bunkbuddy;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Raj Kamdar on 07-01-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION=1;
    //DBName
    public static final String DATABASE_NAME="BunkBuddyDB";

    //Table Names
    public static final String TABLE_SUBJECTS="Subjects";
    public static final String TABLE_INSTRUCTORS="Instructors";
    public static final String TABLE_LECTURES_CONDUCTED="Lectures_Conducted";
    public static final String TABLE_LECTURES_SCHEDULED="Lectures_Scheduled";

    //Subjects columns
    public static final String SUBJECTS_ID="Sub_ID";
    public static final String SUBJECTS_NAME="Sub_Name";
    public static final String SUBJECTS_INST_ID="Inst_ID";
    public static final String SUBJECTS_REQ_ATTENDANCE="Req_Attendance";

    //Instructors Columns
    public static final String INSTRUCTORS_ID="Inst_ID";
    public static final String INSTRUCTORS_NAME="Inst_Name";

    //Lectures_Conducted Columns
    public static final String LC_ID="LC_ID";
    public static final String LC_SUB_ID="Sub_ID";
    public static final String LC_Attended="Attended";

    //Lectures-Scheduled Columns
    public static final String LS_ID="LS_ID";
    public static final String LS_DAY="Day";
    public static final String LS_SubID="Sub_ID";
    public static final String LS_TIME="Time";

    //Create Table Statements
    public static final String CREATE_SUBJECTS="CREATE TABLE "+TABLE_SUBJECTS+" ("+SUBJECTS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT "+SUBJECTS_NAME+" TEXT "+SUBJECTS_INST_ID+" INTEGER "+SUBJECTS_REQ_ATTENDANCE+" INTEGER)";
    public static final String CREATE_INSTRUCTORS="CREATE TABLE "+TABLE_INSTRUCTORS+" ("+INSTRUCTORS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT "+INSTRUCTORS_NAME+" TEXT )";
    public static final String CREATE_LECTURES_CONDUCTED="CREATE TABLE "+TABLE_LECTURES_CONDUCTED+" ("+LC_ID+" INTEGER PRIMARY KEY AUTOINCREMENT "+LC_SUB_ID+" INTEGER "+LC_Attended+" TEXT )";
    public static final String CREATE_LECTURES_SCHEDULED="CREATE TABLE "+TABLE_LECTURES_SCHEDULED+" ("+LS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT "+LS_DAY+" TEXT "+LS_SubID+" INTEGER "+LS_TIME+" DATETIME)";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Execute queries to create tables
        sqLiteDatabase.execSQL(CREATE_SUBJECTS);
        sqLiteDatabase.execSQL(CREATE_INSTRUCTORS);
        sqLiteDatabase.execSQL(CREATE_LECTURES_CONDUCTED);
        sqLiteDatabase.execSQL(CREATE_LECTURES_SCHEDULED);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //During upgrade first delete
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLE_SUBJECTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLE_INSTRUCTORS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLE_LECTURES_CONDUCTED);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS"+TABLE_LECTURES_SCHEDULED);

        //Then create again
        onCreate(sqLiteDatabase);
    }
}
