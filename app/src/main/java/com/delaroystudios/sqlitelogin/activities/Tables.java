package com.delaroystudios.sqlitelogin.activities;

import android.widget.TableLayout;
import android.widget.TableRow;

import com.delaroystudios.sqlitelogin.R;

import java.util.Vector;

/**
 * Created by Domi on 21.05.2017.
 */

//Klasa do przechowywania info o wydarzeniach (może kiedyś będzie czytać z bazy danych :)
public class Tables {

    public Tables() {

    }

        public static int postab3;
        public static int posList;
        public static String[] myEvent= {"", "", "", ""};//new String[20];

        public static Vector<String> vector = new Vector();

         final String[] menuItems= {"Mecz 1", "Mecz 2", "Mecz 3"};

        final String[] items = {"Podnosimy szaliki!", "Fala!", "Klaszczemy!"};

        final String[][][] mainTab= { { {"12", "00", "Szaliki!"}, {"12", "01","Fala!"}, {"12", "02","Klaszczemy!"} },
                                      { {"15", "33", "AAAAAA"}, {"15", "30","BBBBB"}, {"16", "00","CCCC"} },
                                     { {"18", "00", "DDDDDDD"}, {"19", "00","EEEEEE"}, {"9", "40","FFFFFF"} }};

}
