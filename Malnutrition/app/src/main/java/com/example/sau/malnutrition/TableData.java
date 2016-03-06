package com.example.sau.malnutrition;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Vighnesh on 05/03/2016.
 */
public class TableData
{
    public static final String DATABASE_NAME="malnutrition_db";
    public TableData()
    {}
    public static abstract class Child_Profile implements BaseColumns {
        public static final String TABLE_NAME = "child_profile";
        public static final String ID = "child_id";
        public static final String NAME = "name";
        public static final String AGE = "age";
        public static final String GENDER = "gender";
        public static final String MOTHER_NAME = "mother_name";
        public static final String VILLAGE = "village";
        public static final String DISTRICT = "district";
        public static final String CONTACT_NO = "contact_no";

        public static void putInformation(DatabaseOperations dop,String name, String age, String gender, String mothername, String village, String district, String contactno)
        {
            SQLiteDatabase sq=dop.getWritableDatabase();
            ContentValues cv= new ContentValues();
            cv.put(ID, "101");
            cv.put(NAME, name);
            cv.put(AGE, age);
            cv.put(GENDER, gender);
            cv.put(MOTHER_NAME, mothername);
            cv.put(VILLAGE, village);
            cv.put(DISTRICT, district);
            cv.put(CONTACT_NO, contactno);
            long k=sq.insert(TABLE_NAME, null,cv);
            Log.d("Database operations", "inserted");
        }
    }
}
