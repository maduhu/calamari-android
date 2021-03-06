package com.cephmonitor.cephmonitor.layout.fragment;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.cephmonitor.cephmonitor.R;
import com.cephmonitor.cephmonitor.layout.ColorTable;
import com.cephmonitor.cephmonitor.layout.component.card.HealthBaseCard;
import com.cephmonitor.cephmonitor.layout.component.card.HealthIopsCard;
import com.cephmonitor.cephmonitor.layout.component.card.HealthPoolsCard;
import com.cephmonitor.cephmonitor.layout.component.card.HealthUsageCard;
import com.cephmonitor.cephmonitor.layout.component.container.FractionAbleRelativeLayout;
import com.cephmonitor.cephmonitor.model.app.theme.custom.manager.ThemeManager;
import com.cephmonitor.cephmonitor.model.app.theme.custom.prototype.DesignSpec;
import com.resourcelibrary.model.logic.RandomId;
import com.resourcelibrary.model.view.WH;

public class HealthLayout extends FractionAbleRelativeLayout {
    public ScrollView cardContainer;
    public LinearLayout cardList;
    public HealthBaseCard healthCard;
    public HealthBaseCard osdCard;
    public HealthBaseCard monCard;
    public HealthPoolsCard poolsCard;
    public HealthBaseCard hostsCard;
    public HealthBaseCard pgStatusCard;
    public HealthUsageCard usageCard;
    public HealthIopsCard iopsCard;

    private Context context;
    private WH ruler;
    private DesignSpec designSpec;

    public HealthLayout(Context context) {
        super(context);
        this.context = context;
        this.ruler = new WH(context);
        this.designSpec = ThemeManager.getStyle(getContext());

        setId(RandomId.get());
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        setLayoutParams(params);

        addView(cardContainer = cardContainer());
        cardContainer.addView(cardList = cardList());
        cardList.addView(healthCard = healthCard());
        cardList.addView(cardDivider());
        cardList.addView(osdCard = osdCard());
        cardList.addView(cardDivider());
        cardList.addView(monCard = monCard());
        cardList.addView(cardDivider());
        cardList.addView(poolsCard = poolsCard());
        cardList.addView(cardDivider());
        cardList.addView(hostsCard = hostsCard());
        cardList.addView(cardDivider());
        cardList.addView(pgStatusCard = pgStatusCard());
        cardList.addView(cardDivider());
        cardList.addView(usageCard = usageCard());
        cardList.addView(cardDivider());
        cardList.addView(iopsCard = iopsCard());
    }

    private ScrollView cardContainer() {
        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        params.addRule(ALIGN_PARENT_TOP);

        ScrollView v = new ScrollView(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);

        return v;
    }

    private LinearLayout cardList() {
        ScrollView.LayoutParams params = new ScrollView.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);

        LinearLayout v = new LinearLayout(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setOrientation(LinearLayout.VERTICAL);
        v.setGravity(Gravity.CENTER_HORIZONTAL);
        v.setPadding(
                ruler.getW(designSpec.getMargin().getLeftRightTwo()),
                ruler.getW(designSpec.getMargin().getTopBottomTwo()),
                ruler.getW(designSpec.getMargin().getLeftRightTwo()),
                ruler.getW(designSpec.getMargin().getTopBottomTwo()));

        return v;
    }

    private HealthBaseCard healthCard() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;

        HealthBaseCard v = new HealthBaseCard(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setIcon(R.drawable.icon013);
        v.setArrow(R.drawable.icon014);
        v.setTitle(context.getResources().getString(R.string.health_card_health));
        v.setLeftText(context.getResources().getString(R.string.health_card_warnings));
        v.setRightText(context.getResources().getString(R.string.health_card_errors));
        v.setCenterText(context.getResources().getString(R.string.health_card_ago));
        v.setCenterValueText(getResources().getString(R.string.health_card_status_ok));
        v.setCompareMode(false);
        v.setChangeCenterValueColor(true);
        v.setValue(0, 0);

        return v;
    }

    private HealthBaseCard osdCard() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;

        HealthBaseCard v = new HealthBaseCard(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setIcon(R.drawable.icon015);
        v.setArrow(R.drawable.icon014);
        v.setTitle(context.getResources().getString(R.string.health_card_osd));
        v.setLeftText(context.getResources().getString(R.string.health_card_warnings));
        v.setRightText(context.getResources().getString(R.string.health_card_errors));
        v.setCenterText(context.getResources().getString(R.string.health_card_in_and_up));
        v.setCenterValueText("0 / 0");
        v.setValue(0, 0);

        return v;
    }

    private HealthBaseCard monCard() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;

        HealthBaseCard v = new HealthBaseCard(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setIcon(R.drawable.icon016);
        v.setArrow(R.drawable.icon014);
        v.setTitle(context.getResources().getString(R.string.health_card_mon));
        v.setLeftText(context.getResources().getString(R.string.health_card_warnings));
        v.setRightText(context.getResources().getString(R.string.health_card_errors));
        v.setCenterText(context.getResources().getString(R.string.health_card_quorum));

        v.setValue(0, 0);
        v.setCenterValueText("0 / 0");

        return v;
    }

    private HealthPoolsCard poolsCard() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;

        HealthPoolsCard v = new HealthPoolsCard(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setIcon(R.drawable.icon017);
        v.setArrow(R.drawable.icon014);
        v.setTitle(context.getResources().getString(R.string.health_card_pools));
        v.setLeftText(context.getResources().getString(R.string.health_card_warnings));
        v.setRightText(context.getResources().getString(R.string.health_card_errors));
        v.setCenterText(context.getResources().getString(R.string.health_card_active));
        v.setCenterValueText("0");
        v.setValue(0, 0);

        return v;
    }

    private HealthBaseCard hostsCard() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;

        HealthBaseCard v = new HealthBaseCard(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setIcon(R.drawable.icon018);
        v.setArrow(R.drawable.icon014);
        v.setTitle(context.getResources().getString(R.string.health_card_hosts));
        v.setLeftText(context.getResources().getString(R.string.health_card_mon));
        v.setRightText(context.getResources().getString(R.string.health_card_osd));
        v.setCenterText(context.getResources().getString(R.string.health_card_reporting));
        v.setCompareMode(false);
        v.setChangeTwoValueColor(false, false);

        v.setValue(0, 0);
        v.setCenterValueText("0");

        return v;
    }

    private HealthBaseCard pgStatusCard() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;

        HealthBaseCard v = new HealthBaseCard(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setIcon(R.drawable.icon020);
        v.setArrow(R.drawable.icon014);
        v.setTitle(context.getResources().getString(R.string.health_card_pg));
        v.setLeftText(context.getResources().getString(R.string.health_card_Working));
        v.setRightText(context.getResources().getString(R.string.health_card_Dirty));
        v.setCenterText(context.getResources().getString(R.string.health_card_clean));

        v.setCenterValueText("0");
        v.setValue(0, 0);

        return v;
    }

    private HealthUsageCard usageCard() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;

        HealthUsageCard v = new HealthUsageCard(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setIcon(R.drawable.icon028);
        v.setArrow(R.drawable.icon014);
        v.setTitle(context.getResources().getString(R.string.health_card_usage));
        v.setLeftText(context.getResources().getString(R.string.health_card_used));
        v.setRightText(context.getResources().getString(R.string.health_card_available));
        v.setRightTextColor(ColorTable._8DC41F);
        v.setCompareMode(false);

        v.setLongValue(0, 0);

        return v;
    }

    private HealthIopsCard iopsCard() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;

        HealthIopsCard v = new HealthIopsCard(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setIcon(R.drawable.icon029);
        v.setArrow(R.drawable.icon014);
        v.setTitle(context.getResources().getString(R.string.health_card_iops));
        v.setCompareMode(false);

        return v;
    }

    private View cardDivider() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                ruler.getW(designSpec.getMargin().getTopBottomTwo()));
        params.weight = 1;

        View v = new LinearLayout(context);
        v.setLayoutParams(params);
        return v;
    }
}
