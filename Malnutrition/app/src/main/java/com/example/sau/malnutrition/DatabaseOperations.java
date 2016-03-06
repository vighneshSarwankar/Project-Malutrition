package com.example.sau.malnutrition;

/**
 * Created by Vighnesh on 05/03/2016.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.sau.malnutrition.TableData.*;

public class DatabaseOperations extends SQLiteOpenHelper
{
    public static final int database_version=3;
    public String CREATE_CHILD_TABLE="CREATE TABLE "+ Child_Profile.TABLE_NAME+"("+Child_Profile.ID+" TEXT,"+Child_Profile.NAME+" TEXT,"+Child_Profile.AGE+" NUMERIC,"+Child_Profile.GENDER+" TEXT,"+Child_Profile.MOTHER_NAME+" TEXT,"+Child_Profile.VILLAGE+" TEXT,"+Child_Profile.DISTRICT+" TEXT,"+Child_Profile.CONTACT_NO+" INTEGER);";
    public DatabaseOperations(Context context) {
        super(context, TableData.DATABASE_NAME, null, database_version);
        Log.d("DatabaseOperations","Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb)
    {
        sdb.execSQL(CREATE_CHILD_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
