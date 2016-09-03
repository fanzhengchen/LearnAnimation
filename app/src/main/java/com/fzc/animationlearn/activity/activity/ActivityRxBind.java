package com.fzc.animationlearn.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.fzc.animationlearn.R;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by fanzhengchen on 9/3/16.
 */
public class ActivityRxBind extends AppCompatActivity {

    @BindView(R.id.rx_button)
    Button mRxButton;
    @BindView(R.id.rx_auto_complete_text_view)
    AutoCompleteTextView mRxAutoCompleteTextView;

    private ArrayAdapter mAdapter;
    private final List<String> mData = new ArrayList<>();
    private final Set<String> mWords = new HashSet<>();

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, ActivityRxBind.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_bind);
        ButterKnife.bind(this);
        initRxViews();
    }

    private void initRxViews() {

        RxView.clicks(mRxButton)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        onClickRxButton();
                    }
                });
//        addData("", 0);
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mData);
        mRxAutoCompleteTextView.setAdapter(mAdapter);
        mRxAutoCompleteTextView.setThreshold(1);
        mRxAutoCompleteTextView.setDropDownHeight(300);

        RxTextView.textChanges(mRxAutoCompleteTextView)
                .subscribe(new Action1<CharSequence>() {
                    @Override
                    public void call(CharSequence charSequence) {
                        String word = charSequence.toString();
                        if (!mWords.contains(word)) {
                            Log.d("text changes ", word);
                            mWords.add(word);
                            mAdapter.add(word);
                        }
                    }
                });
    }

    private void addData(String word, int length) {
        if (length > 3) {
            return;
        }
        if (length > 0) {
            mData.add(word);
        }

        for (int i = 0; i < 26; ++i) {
            char ch = (char) ('A' + i);
            addData(word + ch, length + 1);
        }
    }

    private void onClickRxButton() {
        Toast.makeText(this, "RxButton", Toast.LENGTH_SHORT).show();
    }
}
