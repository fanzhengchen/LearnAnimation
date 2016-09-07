package com.fzc.animationlearn.activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import com.fzc.animationlearn.R;
import com.fzc.animationlearn.activity.model.Dog;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.RealmResults;
import rx.functions.Action1;

/**
 * Created by fanzhengchen on 9/7/16.
 */
public class ActivityRealm extends ActivityBase {

    @BindView(R.id.add_user)
    Button addUser;
    @BindView(R.id.query_user)
    Button queryUser;
    @BindView(R.id.name_edit_text)
    EditText nameEditText;
    @BindView(R.id.age_edit_text)
    EditText ageEditText;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, ActivityRealm.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.add_user)
    public void addData() {
        realm.beginTransaction();
        Dog dog = realm.createObject(Dog.class);
        dog.setAge(Integer.parseInt(ageEditText.getText().toString()));
        dog.setName(nameEditText.getText().toString());
        realm.commitTransaction();
    }

    @OnClick(R.id.query_user)
    public void query() {
        realm.where(Dog.class)
                .findAll()
                .asObservable()
                .subscribe(new Action1<RealmResults<Dog>>() {
                    @Override
                    public void call(RealmResults<Dog> dogs) {
                        for (Dog dog : dogs) {
                            Logger.d(dog);
                        }
                    }
                });
    }
}
