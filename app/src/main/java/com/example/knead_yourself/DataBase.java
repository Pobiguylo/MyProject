package com.example.knead_yourself;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;

import java.io.ByteArrayOutputStream;


public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "trainings.db";
    private static final int DATABASE_VERSION = 21;
    public static final String TABLE_NAME = "TRAININGS";
    public static final String TABLE_EXERCISE = "EXERCISE";
    public static final String TABLE_IMAGE = "IMAGE";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TRAININGS_ID="TRAININGS_ID";
    public static final String COLUMN_TRAININGS_ID1="IMAGE_ID";
    public static final String COLUMN_NAME_TRAINING = "NAME";
    public static final String COLUMN_EXERCISE_NAME = "NAME";
    public static final String COLUMN_EXERCISE_DESCRIPTION = "DESCRIPTION";
    public static final String COLUMN_EXERCISE_SCORE = "SCORE";
    public static final String COLUMN_IMAGE = "IMAGE";

    DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    private static class DbBitmapUtility {
//
//        // convert from bitmap to byte array
//        public static byte[] getBytes(Bitmap bitmap) {
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
//            return stream.toByteArray();
//        }
//
//        // convert from byte array to bitmap
//        public static Bitmap getImage(byte[] image) {
//            return BitmapFactory.decodeByteArray(image, 0, image.length);
//        }
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = ("CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME_TRAINING + " TEXT); ");
        db.execSQL(query);
        String query1 = ("CREATE TABLE " + TABLE_EXERCISE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TRAININGS_ID + " INTEGER,"+
                COLUMN_EXERCISE_NAME+" TEXT,"+
                COLUMN_EXERCISE_DESCRIPTION+" TEXT,"+
                COLUMN_EXERCISE_SCORE+" INTEGER);");
        db.execSQL(query1);
//        String query2 = ("CREATE TABLE " + TABLE_IMAGE + " (" +
//                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                COLUMN_TRAININGS_ID1 + " INTEGER,"+
//                COLUMN_IMAGE+" BLOB);");
//        db.execSQL(query2);

        ContentValues cv=new ContentValues();
        ContentValues cv1 = new ContentValues();
//        ContentValues cv3=new ContentValues();
//        cv.put(COLUMN_TRAININGS_ID1, 0);
//        cv.put(COLUMN_IMAGE, DbBitmapUtility.getBytes( BitmapFactory.decodeResource(Resources.getSystem(),R.drawable.eyes)));
//        db.insert( TABLE_IMAGE, null, cv3 );


        Trainings tr1 = new Trainings("Зарядка для шеи");
        cv.put(COLUMN_NAME_TRAINING,tr1.getName());
        long trID =  db.insert(TABLE_NAME,null,cv);

        Exercise ex1 = new Exercise("Растяжка шеи",
                "Сядьте ровно, ноги поставьте на пол, а руки положите перед собой. " +
                "Держите шею ровно и постарайтесь потянуться головой вверх." +
                " Подбородок опустится вниз, но не тяните его к груди." +
                " Расслабьте плечи и почувствуйте растяжение в шее. ",
                "Повторите 10 раз",trID);
        cv1.put(COLUMN_EXERCISE_NAME,ex1.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex1.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex1.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex1.getTrID());
        tr1.add(ex1);
        long exid1 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex2 = new Exercise("Повороты шеи",
                "Опустите плечи и расслабьте руки. " +
                        "Держите шею прямо и смотрите строго вперёд." +
                        " Плавно поверните голову влево." +
                        " Взгляд должен быть параллелен полу." +
                        " Сделайте паузу, вернитесь в начальную позицию и повторите то же самое в другую сторону.",
                "Повторите 5-8 раз",trID);
        cv1.put(COLUMN_EXERCISE_NAME,ex2.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex2.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex2.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex2.getTrID());
        tr1.add(ex2);
        long exid2 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex3 = new Exercise("Наклоны в стороны",
                "Потянитесь левым ухом к левому плечу." +
                        " Не наклоняйте голову вперёд или назад." +
                        " Плечи должны оставаться опущенными, не поднимайте их навстречу ушам." +
                        " Вернитесь в начальное положение и сделайте то же самое в другую сторону.",
                "Повторите 5-8 раз",trID);
        cv1.put(COLUMN_EXERCISE_NAME,ex3.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex3.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex3.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex3.getTrID());
        tr1.add(ex3);
        long exid3 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex4 = new Exercise("Наклоны вперёд",
                "Потянитесь подбородком к груди, держа при этом спину и шею прямыми." +
                        " Не открывайте рот." +
                        " Вернитесь в начальное положение и повторите то же самое, согнув шею." +
                        " Сделайте небольшую паузу и вернитесь в начальное положение.",
                "Повторите 5 раз",trID);
        cv1.put(COLUMN_EXERCISE_NAME,ex4.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex4.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex4.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex4.getTrID());
        tr1.add(ex4);
        long exid4 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex5 = new Exercise("Наклоны назад",
                "Сядьте ровно, опустите плечи и расслабьте руки." +
                        " Держите шею прямо и смотрите вперёд." +
                        " Наклоните голову назад и потяните подбородок к потолку." +
                        " Нижняя часть подбородка должна смотреть вертикально вверх." +
                        " Не открывайте рот." +
                        " Сделайте небольшую паузу и вернитесь в исходное положение",
                "Повторите 5 раз",trID);
        cv1.put(COLUMN_EXERCISE_NAME,ex5.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex5.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex5.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex5.getTrID());
        tr1.add(ex5);
        long exid5 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex6 = new Exercise("Круговые вращения",
                "Если у вас есть проблемы с шеей, проконсультируйтесь с врачом перед выполнением этого упражнения." +
                        " Плавно вращайте головой, избегая при этом резких движений." +
                        " Если у вас есть боли в голове или спине, попробуйте «рисовать» восьмёрки." +
                        " Это более лёгкое упражнение.",
                "Повторяйте 15 секунд",trID);
        cv1.put(COLUMN_EXERCISE_NAME,ex6.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex6.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex6.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex6.getTrID());
        tr1.add(ex6);
        long exid6 = db.insert(TABLE_EXERCISE,null,cv1);

        Trainings tr2 = new Trainings("Разминка для рук и плеч");
        cv.put(COLUMN_NAME_TRAINING,tr2.getName());
        long trId1 = db.insert(TABLE_NAME,null,cv);

        Exercise ex7 = new Exercise("Вращения плечами",
                " Опустите руки, после чего начните совершать медленные и глубокие вращения плеч назад." +
                        " Взгляд направьте четко перед собой." +
                        " Выполнив определенное число вращений назад, повторите тоже самое с вращениями вперед",
                "Повторяйте 6-8 вращений",trId1);
        cv1.put(COLUMN_EXERCISE_NAME,ex7.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex7.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex7.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex7.getTrID());
        tr2.add(ex7);
        long exid7 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex8 = new Exercise("Сведение рук перед собой",
                "Находясь в положении стоя, примите Т-образную позу с разведенными врозь руками." +
                        " После этого сведите руки вперед, потягиваясь и скругляясь в области спины." +
                        " Голову можно немного наклонить." +
                        " Сделав небольшую паузу в пиковой точке, вернитесь в исходную фазу." +
                        " Упражнение позволяет не только разогреть мышцы рук, но также задействует плечи, верхнюю часть спины и шею.",
                "Повторяйте 8-10 разведений",trId1);
        cv1.put(COLUMN_EXERCISE_NAME,ex8.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex8.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex8.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex8.getTrID());
        tr2.add(ex8);
        long exid8 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex9 = new Exercise("Вращения одной рукой",
                "Рабочую руку вытяните вдоль тела, а свободной обхватите корпус." +
                        " После этого начните выполнять медленные вращения рабочей конечностью сначала вперед, а потом и назад." +
                        " Это упражнение необходимо для стимуляции и разогрева мышц и суставов плеча. В ходе работы не допускайте перекосов тела, поддерживая ровную осанку." +
                        " После окончания работы одной рукой, поменяйте сторону, следуя аналогичной технике выполнения.",
                "Повторяйте 5-6 вращений",trId1);
        cv1.put(COLUMN_EXERCISE_NAME,ex9.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex9.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex9.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex9.getTrID());
        tr2.add(ex9);
        long exid9 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex10 = new Exercise("Вращения предплечий",
                "Примите Т-образную позу, согните руки и направьте локти в разные друг от друга стороны." +
                        " После этого начните медленно вращать предплечья внутрь, избегая резких движений." +
                        " Взгляд направлен перед собой, а спина поддерживается в ровном положении." +
                        " Выполнив нужное число повторений, сделайте аналогичные вращения в другую сторону.",
                "Повторяйте 5-7 вращений",trId1);
        cv1.put(COLUMN_EXERCISE_NAME,ex10.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex10.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex10.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex10.getTrID());
        tr2.add(ex10);
        long exid10 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex11 = new Exercise("Подъём рук в стороны и перед собой",
                "Техника упражнения предельно проста." +
                        " Работа ведется в положении стоя." +
                        " Сначала поднимите руки через стороны над головой." +
                        " После этого опустите их и поднимите снова, но уже перед собой." +
                        " При каждом подъеме меняйте стороны" +
                        ". Двигайтесь неспешно и без рывков.",
                "Повторите 4-5 подъёмов",trId1);
        cv1.put(COLUMN_EXERCISE_NAME,ex11.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex11.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex11.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex11.getTrID());
        tr2.add(ex11);
        long exid11 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex12 = new Exercise("Вращение запястий",
                "Прижмите локти к корпусу, после чего начинайте медленно делать вращения сжатыми в кулак ладонями." +
                        " Сначала вращения запястий можно выполнять внутрь, после чего сменить направление в обратную сторону.",
                "Повторите 5-7 вращений",trId1);
        cv1.put(COLUMN_EXERCISE_NAME,ex12.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex12.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex12.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex12.getTrID());
        tr2.add(ex12);
        long exid12 = db.insert(TABLE_EXERCISE,null,cv1);

        Trainings tr3 = new Trainings("Зарядка для глаз");
        cv.put(COLUMN_NAME_TRAINING,tr3.getName());
        long trId2 = db.insert(TABLE_NAME,null,cv);

        Exercise ex13 = new Exercise("Жмурки",
                "Отвернитесь от монитора, закройте глаза и быстро  зажмурьтесь, не разжимая век.",
                "Повторите 10 раз",trId2);
        cv1.put(COLUMN_EXERCISE_NAME,ex13.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex13.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex13.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex13.getTrID());
        tr3.add(ex13);
        long exid13 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex14 = new Exercise("Моргалки",
                "Интенсивно поморгайте, как можно быстрее, широко открывая глаза.",
                "Повторите 10 раз",trId2);
        cv1.put(COLUMN_EXERCISE_NAME,ex14.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex14.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex14.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex14.getTrID());
        tr3.add(ex14);
        long exid14 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex15 = new Exercise("Восьмёрки",
                "Закрыв глаза, рисуйте восьмерки, сначала горизонтальные, затем вертикальные.",
                "Повторите 5-6 раз",trId2);
        cv1.put(COLUMN_EXERCISE_NAME,ex15.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex15.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex15.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex15.getTrID());
        tr3.add(ex15);
        long exid15 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex16 = new Exercise("Виски",
                "Помассируйте виски у края глаз круговыми движениями кончиками пальцев ",
                "Повторяйте 1-2 минуты",trId2);
        cv1.put(COLUMN_EXERCISE_NAME,ex16.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex16.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex16.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex16.getTrID());
        tr3.add(ex16);
        long exid16 = db.insert(TABLE_EXERCISE,null,cv1);

        Exercise ex17 = new Exercise("Взгляд",
                "Зафиксируйте взгляд на самом отдаленном предмете в пределах видимости (лучше смотреть в окно как можно дальше)," +
                        " потом медленно перевести взгляд на кончик носа.",
                "Повторяйте это упражнение 10-15 раз трижды в день",trId2);
        cv1.put(COLUMN_EXERCISE_NAME,ex17.getName());
        cv1.put(COLUMN_EXERCISE_DESCRIPTION,ex17.getDescription());
        cv1.put(COLUMN_EXERCISE_SCORE,ex17.getScore());
        cv1.put(COLUMN_TRAININGS_ID,ex17.getTrID());
        tr3.add(ex17);
        long exid17 = db.insert(TABLE_EXERCISE,null,cv1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISE);
        onCreate(db);
    }

}







