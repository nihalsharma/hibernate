package com.tm.midservice.db.constants;

import com.tm.midservice.db.dto.WidgetType;

import java.util.*;

/**
 * Created by Nihal on 9/11/14.
 */
public enum EnumWidgetType {

    API("api", 0),
    BEST_SELLERS("bs", 1),
    NEW_ARRIVALS("na", 2),
    CATALOG_SIMS("csims", 3),
    PURCHASE_SIMS("psims", 4),
    VIEW_SIMS("vsims", 5),
    RECENTLY_VIEWED_ITEMS("rvi", 6),
    RECENT_HISTORY_FOOTER("rhf", 7),
    RECS_PAGE("rp", 8),
    CSC_WIDGET("csc", 9),
    PPR_WIDGET("ppr", 10),
    HBAN_WIDGET("hban", 11),
    BANNER_CATALOG("bcat", 12),
    CATEGORY_RECS("cr", 13),
    EPPR_WIDGET("eppr", 14),
    ERP_WIDGET("erp", 15),
    PR_WIDGET("pr", 16);

    public final static int MAX_VALUE = 16;
    public final static int MIN_VALUE = 0;

    private String fWidgetName;
    private int fWidgetId;

    private EnumWidgetType(String widgetName, int widgetId) {
        fWidgetName = widgetName;
        fWidgetId = widgetId;
    }

    public String getWidgetName() {
        return fWidgetName;
    }

    public int getWidgetId() {
        return fWidgetId;
    }

    public String getWidgetIdString() {
        return Integer.toString(fWidgetId);
    }

    public WidgetType asWidgetType() {
        WidgetType widgetType = new WidgetType();
        widgetType.setId(this.fWidgetId);
        widgetType.setName(this.fWidgetName);
        return widgetType;
    }

    public static EnumWidgetType getById(int id) {
        for (EnumWidgetType e : values()) {
            if (e.fWidgetId == id) return e;
        }
        return null;
    }

    public static List<WidgetType> getAll() {
        List<WidgetType> widgetTypes = new ArrayList<WidgetType>();
        for (EnumWidgetType e : values()) {
            widgetTypes.add(e.asWidgetType());
        }
        return widgetTypes;
    }
}
