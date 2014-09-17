package com.tm.midservice.db.constants;

import com.tm.midservice.db.dto.Tier;

import java.util.EnumSet;

/**
 * Created by Nihal on 9/13/14.
 */
public enum EnumTierType {


    TIER1("tier1", 0),
    TIER2("tier2", 1),
    TIER3("tier3", 2);

    private String name;
    private int id;

    private EnumTierType(String name, int tierId) {
        this.name = name;
        this.id = tierId;
    }


    static EnumSet<EnumWidgetType> tier1 = EnumSet.of(EnumWidgetType.NEW_ARRIVALS,
            EnumWidgetType.CATALOG_SIMS,
            EnumWidgetType.PURCHASE_SIMS,
            EnumWidgetType.VIEW_SIMS);

    static EnumSet<EnumWidgetType> tier2 = EnumSet.of(EnumWidgetType.BEST_SELLERS,
            EnumWidgetType.RECENTLY_VIEWED_ITEMS,
            EnumWidgetType.RECENT_HISTORY_FOOTER,
            EnumWidgetType.RECS_PAGE,
            EnumWidgetType.CSC_WIDGET,
            EnumWidgetType.PPR_WIDGET,
            EnumWidgetType.CATEGORY_RECS, EnumWidgetType.PR_WIDGET);

    static EnumSet<EnumWidgetType> tier3 = EnumSet.of(EnumWidgetType.EPPR_WIDGET,
            EnumWidgetType.ERP_WIDGET,
            EnumWidgetType.HBAN_WIDGET);


    public static EnumSet<EnumWidgetType> getWidgetSetByTierId(int id) {
        for (EnumTierType e : values()) {
            if (id == 1) {
                return tier1;
            } else if (id == 2) {
                tier2.addAll(tier1);
                return tier2;
            } else if (id == 3) {
                tier2.addAll(tier1);
                tier3.addAll(tier2);
                return tier3;
            }
        }
        return null;
    }

    public static EnumTierType getTierType(int id) {
        for (EnumTierType e : EnumTierType.values()) {
            if (e.id == id) {
                return e;
            }
        }
        return null;
    }

    public Tier asTier() {
        Tier tier = new Tier();
        tier.setId(this.id);
        tier.setName(this.name);
        return tier;
    }
}
