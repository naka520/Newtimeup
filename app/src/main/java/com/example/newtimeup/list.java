package com.example.newtimeup;

import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class list extends AppCompatActivity {
    private DataBase helper = null;

    private TextView viewTitle    = null;
    private TextView viewContents = null;
    private EditText editTitle    = null;
    private EditText editContents = null;


//    protected void onCreate(Bundle savedInstanceState) {
//        protected void onShow() {
//
//            // データベースから取得する項目を設定
//            String[] cols = {DBEntry.COLUMN_NAME_TITLE, DBEntry.COLUMN_NAME_CONTENTS};
//
//            // 読み込みモードでデータベースをオープン
//            try (SQLiteDatabase db = helper.getReadableDatabase()) {
//
//                // データを取得するSQLを実行
//                // 取得したデータがCursorオブジェクトに格納される
//                Cursor cursor = db.query(DBEntry.TABLE_NAME, cols, null,
//                        null, null, null, null, null);
//
//                // moveToFirstで、カーソルを検索結果セットの先頭行に移動
//                // 検索結果が0件の場合、falseが返る
//                if (cursor.moveToFirst()){
//
//                    // 表示用のテキスト・コンテンツに検索結果を設定
//                    viewTitle.setText(cursor.getString(0));
//                    viewContents.setText(cursor.getString(1));
//
//                    // 入力用のテキスト・コンテンツにも検索結果を設定
//                    editTitle.setText(cursor.getString(0));
//                    editContents.setText(cursor.getString(1));
//
//                } else {
//                    // 検索結果が0件の場合のメッセージを設定
//                    viewTitle.setText("データがありません");
//                    viewContents.setText("");
//
//                    editTitle.setText("");
//                    editContents.setText("");
//                }
//            }
//
//        }
//
//    }

}


