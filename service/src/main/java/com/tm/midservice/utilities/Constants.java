package com.tm.midservice.utilities;


import com.tm.midservice.db.constants.EnumWidgetType;
import com.tm.midservice.db.dto.CompanyCategoryMap;
import com.tm.midservice.db.dto.TMWRSClient;

import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Constants {

    public static final DateFormat DATE_FORMAT = getISTDateFormat();

    private static DateFormat getISTDateFormat() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        sd.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
        return sd;
    }

    // Customer ids to be ignored
    public static final Set<String> DEFAULT_CID_STRING_SET = new HashSet<String>(Arrays.asList("guest", "undefined", "null", "0", ""));

    public static final String BUILD_FILENAMES_PATH = "/var/output/data/txtfiles/";
    public static final Set<String> BUILD_FILENAMES_SET = new HashSet<String>(Arrays.asList(
            "130101/0", "130101/1", "130101/2", "130101/3", "130101/4",
            "130111/0", "130111/1", "130111/2", "130111/3",
            "130725/0", "130725/1", "130725/2", "130725/4", "130725/5",
            "130805/0", "130805/1", "130805/2", "130805/4", "130805/5",
            "130915/0", "130915/1", "130915/2", "130915/3", "130915/4", "130915/5", "130915/11", "130915/12",
            "131105/0", "131105/1", "131105/2", "131105/4", "131105/5",
            "131225/0", "131225/1", "131225/2", "131225/3", "131225/4", "131225/5",
            "140115/0", "140115/1", "140115/2", "140115/4", "140115/5",
            "140125/0", "140125/1", "140125/2", "140125/4", "140125/5",
            "140130/0", "140130/1", "140130/2", "140130/3", "140130/4", "140130/5",
            "140215/0", "140215/1", "140215/2", "140215/4", "140215/5",
            "140225/0", "140225/1", "140225/2", "140225/4", "140225/5",
            "140405/0", "140405/1", "140405/2", "140405/4", "140405/5",
            "140505/0", "140505/1", "140505/2", "140505/4", "140505/5",
            "140315/0", "140315/1", "140315/2", "140315/4", "140315/5",
            "140710/0", "140710/1", "140710/2", "140710/4", "140710/5",
            "140625/0", "140625/1", "140625/2", "140625/4", "140625/5",
            "140715/0", "140715/1", "140715/2", "140715/4", "140715/5"
    ));

    // Default category for BestSellers and NewArrivals
    public static final String DEFAULT_CATEGORY = "DEF";


    public static final Map<String, String> MARKETPLACE_ID_MAP = getMarketplaceIdMap();

    /**
     * Local function for creating mapping between marketplace name and id
     *
     * @return an unmodifable map for mapping between mid name and mid index
     */
    private static Map<String, String> getMarketplaceIdMap() {
        Map<String, String> midMap = new HashMap<String, String>(64);
        midMap.put("130101", "tmdemo.com");
        midMap.put("130111", "juvalia.in");
        midMap.put("130611", "fabfurnish.com");
        midMap.put("130725", "yebhi.com");
        midMap.put("130805", "yepme.com");
        midMap.put("130915", "shopclues.com");
        midMap.put("131025", "shop.irctc.com");
        midMap.put("131105", "healthkart.com");
        midMap.put("131215", "getitbazaar.com");
        midMap.put("131225", "purplle.com");
        midMap.put("140105", "gamexs.com");
        midMap.put("140115", "zansaar.com");
        midMap.put("140125", "babyoye.com");
        midMap.put("140130", "bluestone.com");
        midMap.put("140205", "bookadda.com");
        midMap.put("140210", "tradus.com");
        midMap.put("140215", "lenskart.com");
        midMap.put("140225", "shopping.indiatimes.com");
        midMap.put("140230", "firstcry.com");
        midMap.put("140305", "sportskeeda.com");
        midMap.put("140310", "homeshop18.com");
        midMap.put("140315", "freecharge.com");
        midMap.put("140320", "mysmartprice.com");
        midMap.put("140325", "utsavfashion.com");
        midMap.put("140330", "cbazaar.com");
        midMap.put("140405", "discountshop.com");
        midMap.put("140410", "elitify.com");
        midMap.put("140505", "solidarium.com");
        midMap.put("140510", "enchanteddiamonds.com");
        midMap.put("140515", "supplyhog.com");
        midMap.put("140520", "caratlane.com");
        midMap.put("140525", "shopintoit.com");
        midMap.put("140805", "teamanco.com");
        midMap.put("140610", "shopeando.com");
        midMap.put("140615", "bluegape.com");
        midMap.put("140620", "ekstop.com");
        midMap.put("140625", "yatra.com");
        midMap.put("140525", "shopintoit.com");
        midMap.put("140630", "totspot.me");
        midMap.put("140705", "invino.com");
        midMap.put("140710", "healthgenie.in");
        midMap.put("140715", "paytm.com");
        midMap.put("140801", "goodearth.in");
        midMap.put("140802", "luggageonline.com");
        midMap.put("140808", "sonoma.com.br");

        return Collections.unmodifiableMap(midMap);
    }

    public static final Map<String, EnumSet<EnumWidgetType>> WIDGET_WHITELIST_MAP = getWidgetWhitelistMap();

    private static Map<String, EnumSet<EnumWidgetType>> getWidgetWhitelistMap() {

        EnumSet<EnumWidgetType> tier1 = EnumSet.of(EnumWidgetType.NEW_ARRIVALS,
                EnumWidgetType.CATALOG_SIMS,
                EnumWidgetType.PURCHASE_SIMS,
                EnumWidgetType.VIEW_SIMS);
        EnumSet<EnumWidgetType> tier2 = EnumSet.of(EnumWidgetType.BEST_SELLERS,
                EnumWidgetType.RECENTLY_VIEWED_ITEMS,
                EnumWidgetType.RECENT_HISTORY_FOOTER,
                EnumWidgetType.RECS_PAGE,
                EnumWidgetType.CSC_WIDGET,
                EnumWidgetType.PPR_WIDGET,
                EnumWidgetType.CATEGORY_RECS, EnumWidgetType.PR_WIDGET);
        EnumSet<EnumWidgetType> tier3 = EnumSet.of(EnumWidgetType.EPPR_WIDGET,
                EnumWidgetType.ERP_WIDGET,
                EnumWidgetType.HBAN_WIDGET);
        tier2.addAll(tier1);
        tier3.addAll(tier2);

        Map<String, EnumSet<EnumWidgetType>> midMap = new HashMap<String, EnumSet<EnumWidgetType>>(6);
        midMap.put("130101", tier3);
        midMap.put("130111", tier2);
        midMap.put("130725", tier3);
        midMap.put("130915", tier3);
        midMap.put("130805", tier1);
        midMap.put("131105", tier2);
        midMap.put("131225", tier3);
        midMap.put("140115", tier1);
        midMap.put("140125", tier3);
        midMap.put("140130", tier3);
        midMap.put("140215", tier3);
        midMap.put("140225", tier1);
        midMap.put("140405", tier3);
        midMap.put("140505", tier3);
        midMap.put("140315", tier3);
        midMap.put("140710", tier2);
        midMap.put("140625", tier3);
        midMap.put("140715", tier3);
        return Collections.unmodifiableMap(midMap);
    }

    public static final BufferedImage TRACKING_PIXEL = getTrackingPixel();

    private static BufferedImage getTrackingPixel() {
        BufferedImage pixel = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        pixel.setRGB(0, 0, (0xFF));
        return pixel;
    }

    public static final Map<String, Map<String, String>> MID_CATEGORY_NAME_MAP = getCategoryName();

    private static Map<String, Map<String, String>> getCategoryName() {
        Map<String, Map<String, String>> midMap = new HashMap<String, Map<String, String>>(5);
        Map<String, String> juvaliaMap = new HashMap<String, String>(16);
        juvaliaMap.put("EAR", "Earrings");
        juvaliaMap.put("HBD", "Hairbands");
        juvaliaMap.put("ANK", "Anklets");
        juvaliaMap.put("COM", "Combos");
        juvaliaMap.put("NEC", "Necklaces");
        juvaliaMap.put("WRI", "Wristlets");
        juvaliaMap.put("HAC", "Hair Combs");
        juvaliaMap.put("HAI", "Hairbands");
        juvaliaMap.put("BRA", "Bracelets");
        juvaliaMap.put("RIN", "Rings");
        juvaliaMap.put("CHM", "Charms");
        juvaliaMap.put("CHN", "Chains");
        juvaliaMap.put("BRO", "Brooches");
        juvaliaMap.put("PEN", "Pendants");
        midMap.put("130111", juvaliaMap);

        Map<String, String> demoMap = new HashMap<String, String>(4);
        demoMap.put("Mobile", "Mobiles");
        demoMap.put("Apparel", "Apparels");
        demoMap.put("MobileAccessories", "Mobile Accessories");
        midMap.put("130101", demoMap);

        Map<String, String> yebhiMap = new HashMap<String, String>(9);
        yebhiMap.put("S", "Shoes and Clothing");
        yebhiMap.put("H", "Home and Kitchen");
        yebhiMap.put("J", "Jewellery");
        yebhiMap.put("L", "Lifestyle");
        yebhiMap.put("B", "Beauty and Wellness");
        yebhiMap.put("M", "Mobile Store");
        yebhiMap.put("E", "Electronics");
        yebhiMap.put("T", "Toys and Games");
        midMap.put("130725", yebhiMap);

        Map<String, String> yepmeMap = Collections.<String, String>emptyMap();
        midMap.put("130805", yepmeMap);

        Map<String, String> shopCluesMap = Collections.<String, String>emptyMap();
        midMap.put("130915", shopCluesMap);

        Map<String, String> healthkartMap = Collections.<String, String>emptyMap();
        midMap.put("131105", healthkartMap);

        Map<String, String> purplleMap = Collections.<String, String>emptyMap();
        midMap.put("131225", purplleMap);

        Map<String, String> bluestoneMap = Collections.<String, String>emptyMap();
        midMap.put("140130", bluestoneMap);

        Map<String, String> discountshopMap = Collections.<String, String>emptyMap();
        midMap.put("140405", discountshopMap);

        Map<String, String> solidariumpMap = Collections.<String, String>emptyMap();
        midMap.put("140505", solidariumpMap);

        Map<String, String> freechargeMap = Collections.<String, String>emptyMap();
        midMap.put("140315", freechargeMap);

        Map<String, String> yatraMap = Collections.<String, String>emptyMap();
        midMap.put("140625", yatraMap);

        Map<String, String> paytmMap = Collections.<String, String>emptyMap();
        midMap.put("140715", paytmMap);

        return Collections.unmodifiableMap(midMap);
    }

    public static final Map<String, Map<String, Double>> MID_CATEGORY_POPULARITY_MAP = getDefaultPopularityMap();

    private static Map<String, Map<String, Double>> getDefaultPopularityMap() {
        Map<String, Map<String, Double>> midMap = new HashMap<String, Map<String, Double>>(2);
        Map<String, Double> juvaliaMap = new LinkedHashMap<String, Double>(9);
        juvaliaMap.put("NEC", 0.000000000008);
        juvaliaMap.put("EAR", 0.000000000007);
        juvaliaMap.put("RIN", 0.000000000006);
        juvaliaMap.put("WRI", 0.000000000005);
        juvaliaMap.put("HBD", 0.000000000004);
        juvaliaMap.put("BRA", 0.000000000003);
        juvaliaMap.put("CHM", 0.000000000002);
        juvaliaMap.put("PEN", 0.000000000001);
        midMap.put("130111", juvaliaMap);

        Map<String, Double> demoMap = new LinkedHashMap<String, Double>(4);
        demoMap.put("Mobile", 0.000000000009);
        demoMap.put("Apparel", 0.000000000007);
        demoMap.put("MobileAccessories", 0.000000000006);
        midMap.put("130101", demoMap);

        Map<String, Double> yebhiMap = new LinkedHashMap<String, Double>(10);
        yebhiMap.put("S", 0.000000000009);
        yebhiMap.put("H", 0.000000000007);
        yebhiMap.put("J", 0.000000000006);
        yebhiMap.put("L", 0.000000000005);
        yebhiMap.put("B", 0.000000000004);
        yebhiMap.put("M", 0.000000000003);
        yebhiMap.put("E", 0.000000000002);
        yebhiMap.put("T", 0.000000000001);
        midMap.put("130725", yebhiMap);

        Map<String, Double> shopCluesMap = new LinkedHashMap<String, Double>(10);
        shopCluesMap.put("Electronics", 0.000000000009);
        shopCluesMap.put("Home Appliances", 0.000000000008);
        shopCluesMap.put("Fashion", 0.000000000007);
        shopCluesMap.put("Gifts Flowers", 0.000000000006);
        shopCluesMap.put("Books Stationery", 0.000000000005);
        shopCluesMap.put("Photography", 0.000000000004);
        shopCluesMap.put("Footwear", 0.000000000003);
        shopCluesMap.put("Computers", 0.000000000002);
        shopCluesMap.put("Beauty Perfumes", 0.000000000001);
        midMap.put("130915", shopCluesMap);

        Map<String, Double> healthkartMap = new LinkedHashMap<String, Double>(10);
        healthkartMap.put("Nutrition", 0.000000000009);
        healthkartMap.put("Beauty", 0.000000000008);
        healthkartMap.put("Personal Care", 0.000000000007);
        healthkartMap.put("Sports & Fitness", 0.000000000006);
        healthkartMap.put("Health Devices", 0.000000000005);
        healthkartMap.put("Diabetes", 0.000000000004);
        healthkartMap.put("Eye", 0.000000000003);
        healthkartMap.put("Parenting", 0.000000000002);
        healthkartMap.put("Home & Kitchen", 0.000000000001);
        midMap.put("131105", healthkartMap);

        Map<String, Double> purplleMap = new LinkedHashMap<String, Double>(10);
        purplleMap.put("Hair", 0.000000000009);
        purplleMap.put("Skin", 0.000000000008);
        purplleMap.put("Body", 0.000000000007);
        purplleMap.put("Eyes", 0.000000000006);
        purplleMap.put("Deodorants", 0.000000000005);
        purplleMap.put("Men", 0.000000000004);
        purplleMap.put("Lips", 0.000000000003);
        purplleMap.put("Nails", 0.000000000002);
        purplleMap.put("Face", 0.000000000001);
        midMap.put("131225", purplleMap);

        Map<String, Double> yepmeMap = new LinkedHashMap<String, Double>(10);
        yepmeMap.put("29", 0.000000000009);
        yepmeMap.put("130", 0.000000000008);
        yepmeMap.put("50", 0.000000000007);
        yepmeMap.put("116", 0.000000000006);
        yepmeMap.put("32", 0.000000000005);
        yepmeMap.put("58", 0.000000000004);
        yepmeMap.put("39", 0.000000000003);
        yepmeMap.put("40", 0.000000000002);
        yepmeMap.put("117", 0.000000000001);
        midMap.put("130805", yepmeMap);


        Map<String, Double> bluestoneMap = new LinkedHashMap<String, Double>(10);
        bluestoneMap.put("2", 0.000000000009);
        bluestoneMap.put("3", 0.000000000008);
        bluestoneMap.put("1", 0.000000000007);
        bluestoneMap.put("4", 0.000000000006);
        bluestoneMap.put("11", 0.000000000005);
        bluestoneMap.put("6", 0.000000000004);
        bluestoneMap.put("5", 0.000000000003);
        bluestoneMap.put("14", 0.000000000002);
        bluestoneMap.put("10", 0.000000000001);
        midMap.put("140130", bluestoneMap);

        Map<String, Double> solidariumMap = new LinkedHashMap<String, Double>(10);
        solidariumMap.put("ambientes", 0.000000000006);
        solidariumMap.put("mulheres", 0.000000000005);
        solidariumMap.put("criancas", 0.000000000004);
        solidariumMap.put("artesanato", 0.000000000003);
        solidariumMap.put("casamento", 0.000000000002);
        solidariumMap.put("homens", 0.000000000001);
        midMap.put("140505", solidariumMap);

        Map<String, Double> freechargeMap = new LinkedHashMap<String, Double>(10);
        freechargeMap.put("Food", 0.000000000005);
        freechargeMap.put("Entertainment", 0.000000000004);
        freechargeMap.put("Care", 0.000000000003);
        freechargeMap.put("Travel", 0.000000000002);
        freechargeMap.put("Store", 0.000000000001);
        midMap.put("140315", freechargeMap);

        return Collections.unmodifiableMap(midMap);
    }

    public static final Map<String, EnumWidgetType> RHF_RECS_MAP = getDefaultRhfRecsMap();

    private static Map<String, EnumWidgetType> getDefaultRhfRecsMap() {
        Map<String, EnumWidgetType> midMap = new HashMap<String, EnumWidgetType>(12);
        midMap.put("130101", EnumWidgetType.CATALOG_SIMS);
        midMap.put("130111", EnumWidgetType.CATALOG_SIMS);
        midMap.put("130725", EnumWidgetType.VIEW_SIMS);
        midMap.put("130805", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("130915", EnumWidgetType.VIEW_SIMS);
        midMap.put("131105", EnumWidgetType.VIEW_SIMS);
        midMap.put("140115", EnumWidgetType.VIEW_SIMS);
        midMap.put("131225", EnumWidgetType.VIEW_SIMS);
        midMap.put("140125", EnumWidgetType.VIEW_SIMS);
        midMap.put("140130", EnumWidgetType.VIEW_SIMS);
        midMap.put("140215", EnumWidgetType.VIEW_SIMS);
        midMap.put("140225", EnumWidgetType.VIEW_SIMS);
        midMap.put("140405", EnumWidgetType.VIEW_SIMS);
        midMap.put("140505", EnumWidgetType.VIEW_SIMS);
        midMap.put("140315", EnumWidgetType.VIEW_SIMS);
        midMap.put("140710", EnumWidgetType.VIEW_SIMS);
        midMap.put("140625", EnumWidgetType.VIEW_SIMS);
        midMap.put("140715", EnumWidgetType.VIEW_SIMS);
        return Collections.unmodifiableMap(midMap);
    }

    public static final Map<String, EnumWidgetType> PPR_RECS_MAP = getDefaultPprRecsMap();

    private static Map<String, EnumWidgetType> getDefaultPprRecsMap() {
        Map<String, EnumWidgetType> midMap = new HashMap<String, EnumWidgetType>(12);
        midMap.put("130101", EnumWidgetType.CATALOG_SIMS);
        midMap.put("130725", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("130805", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("130915", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("131105", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("140115", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("131225", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("140125", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("140130", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("140215", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("140225", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("140405", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("140505", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("140315", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("140710", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("140625", EnumWidgetType.PURCHASE_SIMS);
        midMap.put("140715", EnumWidgetType.PURCHASE_SIMS);
        return Collections.unmodifiableMap(midMap);
    }

    public static final Set<String> FILTER_DISABLED_MID = getFilterDisabledMids();

    private static Set<String> getFilterDisabledMids() {
        return Collections.unmodifiableSet(new HashSet<String>(Arrays.asList(new String[]{"140315"})));
    }


    public static List<CompanyCategoryMap> createcategoryMap() {
        Map<String, Map<String, String>> map = MID_CATEGORY_NAME_MAP;
        List<CompanyCategoryMap> categoryMapList = new ArrayList<>();
        for (Map.Entry<String, Map<String, String>> stringMapEntry : map.entrySet()) {
            String mid = stringMapEntry.getKey();
            Map<String, String> catMap = stringMapEntry.getValue();
            Map<String, Double> catPopMap = MID_CATEGORY_POPULARITY_MAP.get(mid);
            if (catMap != null && catMap.size() > 0) {
                for (Map.Entry<String, String> catMapEntry : catMap.entrySet()) {
                    CompanyCategoryMap companyCategoryMap = new CompanyCategoryMap();
                    companyCategoryMap.setMid(Integer.parseInt(mid));
                    companyCategoryMap.setCatKey(catMapEntry.getKey());
                    companyCategoryMap.setCatValue(catMapEntry.getValue());
                    Double score = catPopMap.get(catMapEntry.getKey());
                    if (score == null) {
                        score = 0.0;
                    }
                    companyCategoryMap.setPriority(score);
                    categoryMapList.add(companyCategoryMap);
                }
            } else if (catPopMap != null && catPopMap.size() > 0){
                for (Map.Entry<String, Double> catPopMapEntry : catPopMap.entrySet()) {
                    CompanyCategoryMap companyCategoryMap = new CompanyCategoryMap();
                    companyCategoryMap.setMid(Integer.parseInt(mid));
                    companyCategoryMap.setCatKey(catPopMapEntry.getKey());
                    companyCategoryMap.setCatValue(catPopMapEntry.getKey());
                    companyCategoryMap.setPriority(catPopMapEntry.getValue());
                    categoryMapList.add(companyCategoryMap);
                }

            }
        }
        return categoryMapList;
    }

    public static void main(String args[]) {
        System.out.println(tmwrsClients().size());
        System.out.println(tmwrsClients());
        System.out.println(BUILD_FILENAMES_SET.contains("130101/0"));
    }

    public static List<TMWRSClient> tmwrsClients(){
        Map<String, EnumSet<EnumWidgetType>> midTierMap = WIDGET_WHITELIST_MAP;
        List<TMWRSClient> tmwrsClients = new ArrayList<>();
        for (Map.Entry<String, EnumSet<EnumWidgetType>> midWidgetEntry : midTierMap.entrySet()) {
            TMWRSClient tmwrsClient = new TMWRSClient();
            String mid = midWidgetEntry.getKey();
            int tierId, rhfWidgetId = 5, pprWidgetId = 4;
            boolean isRecFilterDisabled = false, isUrlFilterDisabled = false;
            EnumSet<EnumWidgetType> tierWIdget = midWidgetEntry.getValue();
            if(tierWIdget.contains(EnumWidgetType.HBAN_WIDGET)){
                tierId = 3;
            } else if(!tierWIdget.contains(EnumWidgetType.HBAN_WIDGET) && tierWIdget.contains(EnumWidgetType.PPR_WIDGET)){
                tierId = 2;
            } else {
                tierId = 1;
            }
            if(RHF_RECS_MAP.get(mid) != null) {
                rhfWidgetId = RHF_RECS_MAP.get(mid).getWidgetId();
            }

            if(PPR_RECS_MAP.get(mid) != null) {
                pprWidgetId = PPR_RECS_MAP.get(mid).getWidgetId();
            }

            if(FILTER_DISABLED_MID.contains(mid)){
                isRecFilterDisabled = true;
            }

            tmwrsClient.setTierId(tierId);
            tmwrsClient.setMid(Integer.parseInt(mid));
            tmwrsClient.setPprRecWidgetId(pprWidgetId);
            tmwrsClient.setRhfRecWidgetId(rhfWidgetId);
            tmwrsClient.setRecFilterDisabled(isRecFilterDisabled);
            tmwrsClient.setUrlFilterDisabled(isUrlFilterDisabled);
            String fileSet = "";
            for (int i = 0 ; i < 16; i ++){
                String fileName = mid.concat("/").concat(String.valueOf(i));
                System.out.println(BUILD_FILENAMES_SET.contains(fileName));
                if (BUILD_FILENAMES_SET.contains(fileName)){
                    if(fileSet == ""){
                        fileSet = fileSet + String.valueOf(i);
                    } else {
                        fileSet = fileSet + ":" + String.valueOf(i);
                    }
                }
            }
            tmwrsClient.setWidgetFiles(fileSet);
            tmwrsClients.add(tmwrsClient);

        }
        return tmwrsClients;
    }


   }

