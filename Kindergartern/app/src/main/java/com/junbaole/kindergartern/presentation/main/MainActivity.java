package com.junbaole.kindergartern.presentation.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.junbaole.kindergartern.R;
import com.junbaole.kindergartern.databinding.ActivityMainBinding;
import com.junbaole.kindergartern.presentation.base.BaseFragment;
import com.junbaole.kindergartern.presentation.base.BaseFragmentActivity;

public class MainActivity extends BaseFragmentActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        onAfterCreate();
        mainBinding.mainTabs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tab1:
                        break;
                    case R.id.tab2:
                        break;
                    case R.id.tab3:
                        break;
                    case R.id.tab4:
                        break;
                    case R.id.tab5:
                        break;
                }
            }
        });
    }


    @Override
    public int getFragmentContentId() {
        return R.id.fragment_container;
    }

    @Override
    protected BaseFragment getFirstFragment() {
        return null;
    }
}
