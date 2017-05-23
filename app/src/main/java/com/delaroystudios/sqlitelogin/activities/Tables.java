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

        final int[] timehour = {17, 8, 13};
        final int[] timemin1 = {0, 3, 0};
        final int[] timemin2 = {1, 3, 0};
        final String[] items = {"Podnosimy szaliki!", "Fala!", "Klaszczemy!"};

        final String[][][] mainTab= { { {"23", "40", "Szaliki!"}, {"18", "00","XXXXXX"}, {"19", "00","VVVVVV"} },
                                      { {"12", "00", "AAAAAA"}, {"13", "00","BBBBB"}, {"14", "00","CCCC"} },
                                     { {"18", "00", "DDDDDDD"}, {"19", "00","EEEEEE"}, {"9", "40","FFFFFF"} }};

}
