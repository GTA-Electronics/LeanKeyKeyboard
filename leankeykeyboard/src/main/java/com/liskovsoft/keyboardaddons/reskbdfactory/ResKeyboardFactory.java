package com.liskovsoft.keyboardaddons.reskbdfactory;

import android.content.Context;
import android.content.res.Resources;
import android.inputmethodservice.Keyboard;
import android.support.annotation.Nullable;
import com.liskovsoft.keyboardaddons.KeyboardBuilder;
import com.liskovsoft.keyboardaddons.KeyboardFactory;
import com.liskovsoft.keyboardaddons.KeyboardInfo;

import java.util.ArrayList;
import java.util.List;

public class ResKeyboardFactory implements KeyboardFactory {
    private final Context mContext;

    public ResKeyboardFactory(Context ctx) {
        mContext = ctx;
    }

    @Override
    public List<? extends KeyboardBuilder> getAllAvailableKeyboards(Context context) {
        List<KeyboardBuilder> result = new ArrayList<>();
        List<KeyboardInfo> infos = ResKeyboardInfo.getAllKeyboardInfos(context);

        for (final KeyboardInfo info : infos) {
            if (!info.isEnabled()) {
                continue;
            }

            result.add(createKeyboard(info.getLangCode()));
        }

        // at least one kbd should be enabled
        if (result.isEmpty()) {
            KeyboardInfo firstKbd = infos.get(0);
            result.add(createKeyboard(firstKbd.getLangCode()));
            firstKbd.setEnabled(true);
            ResKeyboardInfo.updateAllKeyboardInfos(mContext, infos);
        }

        return result;
    }

    private KeyboardBuilder createKeyboard(final String langCode) {
        return new KeyboardBuilder() {
            @Nullable
            @Override
            public Keyboard createKeyboard() {
                return new Keyboard(mContext, mContext.getResources().getIdentifier("qwerty_" + langCode, "xml", mContext.getPackageName()));
            }
        };
    }

    @Override
    public boolean needUpdate() {
        return ResKeyboardInfo.needUpdate();
    }
}
