package com.tm.mid.client.service;

import com.tm.mid.client.exception.TMMIDConversionException;
import com.tm.mid.client.exception.TMMIDServiceInaccessible;
import com.tm.mid.client.pojo.Company;
import com.tm.mid.client.pojo.CompanyCategoryMap;
import com.tm.mid.client.utils.JSONUtil;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by BigP on 9/17/14.
 */

public class JSONUtilTest {

    private JSONUtil jsonUtil;

    public JSONUtilTest() {
        jsonUtil = new JSONUtil();
    }


    @Test
    public void getCompanyByMid() throws TMMIDConversionException, TMMIDServiceInaccessible {
        MarketPlaceInfoClient getterService = new MarketPlaceInfoClientImpl("http://localhost:8081/api/");
        Company company = getterService.getCompanyByMid(3);
        org.junit.Assert.assertEquals(company.getMid().intValue(), 3);
    }

    @Test
    public void getAllWhiteListedCompaniesList() throws TMMIDConversionException, TMMIDServiceInaccessible {
        MarketPlaceInfoClient getterService = new MarketPlaceInfoClientImpl("http://localhost:8081/api/");
        List<Integer> company = getterService.getAllWhiteListedCompanies();
        org.junit.Assert.assertEquals(company.size(), 3);
    }

    @Test
    public void getCompanyList() throws TMMIDConversionException, TMMIDServiceInaccessible {
        MarketPlaceInfoClient getterService = new MarketPlaceInfoClientImpl("http://localhost:8081/api/");
        List<CompanyCategoryMap> company = getterService.getAllCompanyCategoryMap();
        //[{"id":1,"mid":130915,"catKey":"Electronics","catValue":"Electronics","priority":9.0E-12},{"id":2,"mid":130915,"catKey":"Home Appliances","catValue":"Home Appliances","priority":8.0E-12},{"id":3,"mid":130915,"catKey":"Fashion","catValue":"Fashion","priority":7.0E-12},{"id":4,"mid":130915,"catKey":"Gifts Flowers","catValue":"Gifts Flowers","priority":6.0E-12},{"id":5,"mid":130915,"catKey":"Books Stationery","catValue":"Books Stationery","priority":5.0E-12},{"id":6,"mid":130915,"catKey":"Photography","catValue":"Photography","priority":4.0E-12},{"id":7,"mid":130915,"catKey":"Footwear","catValue":"Footwear","priority":3.0E-12},{"id":8,"mid":130915,"catKey":"Computers","catValue":"Computers","priority":2.0E-12},{"id":9,"mid":130915,"catKey":"Beauty Perfumes","catValue":"Beauty Perfumes","priority":1.0E-12},{"id":10,"mid":130111,"catKey":"EAR","catValue":"Earrings","priority":7.0E-12},{"id":11,"mid":130111,"catKey":"HAI","catValue":"Hairbands","priority":0.0},{"id":12,"mid":130111,"catKey":"COM","catValue":"Combos","priority":0.0},{"id":13,"mid":130111,"catKey":"PEN","catValue":"Pendants","priority":1.0E-12},{"id":14,"mid":130111,"catKey":"HAC","catValue":"Hair Combs","priority":0.0},{"id":15,"mid":130111,"catKey":"ANK","catValue":"Anklets","priority":0.0},{"id":16,"mid":130111,"catKey":"BRO","catValue":"Brooches","priority":0.0},{"id":17,"mid":130111,"catKey":"NEC","catValue":"Necklaces","priority":8.0E-12},{"id":18,"mid":130111,"catKey":"RIN","catValue":"Rings","priority":6.0E-12},{"id":19,"mid":130111,"catKey":"WRI","catValue":"Wristlets","priority":5.0E-12},{"id":20,"mid":130111,"catKey":"CHM","catValue":"Charms","priority":2.0E-12},{"id":21,"mid":130111,"catKey":"CHN","catValue":"Chains","priority":0.0},{"id":22,"mid":130111,"catKey":"BRA","catValue":"Bracelets","priority":3.0E-12},{"id":23,"mid":130111,"catKey":"HBD","catValue":"Hairbands","priority":4.0E-12},{"id":24,"mid":131105,"catKey":"Nutrition","catValue":"Nutrition","priority":9.0E-12},{"id":25,"mid":131105,"catKey":"Beauty","catValue":"Beauty","priority":8.0E-12},{"id":26,"mid":131105,"catKey":"Personal Care","catValue":"Personal Care","priority":7.0E-12},{"id":27,"mid":131105,"catKey":"Sports \u0026 Fitness","catValue":"Sports \u0026 Fitness","priority":6.0E-12},{"id":28,"mid":131105,"catKey":"Health Devices","catValue":"Health Devices","priority":5.0E-12},{"id":29,"mid":131105,"catKey":"Diabetes","catValue":"Diabetes","priority":4.0E-12},{"id":30,"mid":131105,"catKey":"Eye","catValue":"Eye","priority":3.0E-12},{"id":31,"mid":131105,"catKey":"Parenting","catValue":"Parenting","priority":2.0E-12},{"id":32,"mid":131105,"catKey":"Home \u0026 Kitchen","catValue":"Home \u0026 Kitchen","priority":1.0E-12},{"id":33,"mid":140505,"catKey":"ambientes","catValue":"ambientes","priority":6.0E-12},{"id":34,"mid":140505,"catKey":"mulheres","catValue":"mulheres","priority":5.0E-12},{"id":35,"mid":140505,"catKey":"criancas","catValue":"criancas","priority":4.0E-12},{"id":36,"mid":140505,"catKey":"artesanato","catValue":"artesanato","priority":3.0E-12},{"id":37,"mid":140505,"catKey":"casamento","catValue":"casamento","priority":2.0E-12},{"id":38,"mid":140505,"catKey":"homens","catValue":"homens","priority":1.0E-12},{"id":39,"mid":140315,"catKey":"Food","catValue":"Food","priority":5.0E-12},{"id":40,"mid":140315,"catKey":"Entertainment","catValue":"Entertainment","priority":4.0E-12},{"id":41,"mid":140315,"catKey":"Care","catValue":"Care","priority":3.0E-12},{"id":42,"mid":140315,"catKey":"Travel","catValue":"Travel","priority":2.0E-12},{"id":43,"mid":140315,"catKey":"Store","catValue":"Store","priority":1.0E-12},{"id":44,"mid":130805,"catKey":"29","catValue":"29","priority":9.0E-12},{"id":45,"mid":130805,"catKey":"130","catValue":"130","priority":8.0E-12},{"id":46,"mid":130805,"catKey":"50","catValue":"50","priority":7.0E-12},{"id":47,"mid":130805,"catKey":"116","catValue":"116","priority":6.0E-12},{"id":48,"mid":130805,"catKey":"32","catValue":"32","priority":5.0E-12},{"id":49,"mid":130805,"catKey":"58","catValue":"58","priority":4.0E-12},{"id":50,"mid":130805,"catKey":"39","catValue":"39","priority":3.0E-12},{"id":51,"mid":130805,"catKey":"40","catValue":"40","priority":2.0E-12},{"id":52,"mid":130805,"catKey":"117","catValue":"117","priority":1.0E-12},{"id":53,"mid":130725,"catKey":"T","catValue":"Toys and Games","priority":1.0E-12},{"id":54,"mid":130725,"catKey":"E","catValue":"Electronics","priority":2.0E-12},{"id":55,"mid":130725,"catKey":"B","catValue":"Beauty and Wellness","priority":4.0E-12},{"id":56,"mid":130725,"catKey":"S","catValue":"Shoes and Clothing","priority":9.0E-12},{"id":57,"mid":130725,"catKey":"L","catValue":"Lifestyle","priority":5.0E-12},{"id":58,"mid":130725,"catKey":"M","catValue":"Mobile Store","priority":3.0E-12},{"id":59,"mid":130725,"catKey":"H","catValue":"Home and Kitchen","priority":7.0E-12},{"id":60,"mid":130725,"catKey":"J","catValue":"Jewellery","priority":6.0E-12},{"id":61,"mid":131225,"catKey":"Hair","catValue":"Hair","priority":9.0E-12},{"id":62,"mid":131225,"catKey":"Skin","catValue":"Skin","priority":8.0E-12},{"id":63,"mid":131225,"catKey":"Body","catValue":"Body","priority":7.0E-12},{"id":64,"mid":131225,"catKey":"Eyes","catValue":"Eyes","priority":6.0E-12},{"id":65,"mid":131225,"catKey":"Deodorants","catValue":"Deodorants","priority":5.0E-12},{"id":66,"mid":131225,"catKey":"Men","catValue":"Men","priority":4.0E-12},{"id":67,"mid":131225,"catKey":"Lips","catValue":"Lips","priority":3.0E-12},{"id":68,"mid":131225,"catKey":"Nails","catValue":"Nails","priority":2.0E-12},{"id":69,"mid":131225,"catKey":"Face","catValue":"Face","priority":1.0E-12},{"id":70,"mid":130101,"catKey":"Mobile","catValue":"Mobiles","priority":9.0E-12},{"id":71,"mid":130101,"catKey":"MobileAccessories","catValue":"Mobile Accessories","priority":6.0E-12},{"id":72,"mid":130101,"catKey":"Apparel","catValue":"Apparels","priority":7.0E-12},{"id":73,"mid":140130,"catKey":"2","catValue":"2","priority":9.0E-12},{"id":74,"mid":140130,"catKey":"3","catValue":"3","priority":8.0E-12},{"id":75,"mid":140130,"catKey":"1","catValue":"1","priority":7.0E-12},{"id":76,"mid":140130,"catKey":"4","catValue":"4","priority":6.0E-12},{"id":77,"mid":140130,"catKey":"11","catValue":"11","priority":5.0E-12},{"id":78,"mid":140130,"catKey":"6","catValue":"6","priority":4.0E-12},{"id":79,"mid":140130,"catKey":"5","catValue":"5","priority":3.0E-12},{"id":80,"mid":140130,"catKey":"14","catValue":"14","priority":2.0E-12},{"id":81,"mid":140130,"catKey":"10","catValue":"10","priority":1.0E-12}]
        System.out.println(company.size());
    }

    //Generic Object conversion Test

    @Test(expected = TMMIDConversionException.class)
    public void convertCompanyWithException() throws TMMIDConversionException {
        CompanyCategoryMap actual = jsonUtil.getObjectFromJson(CompanyCategoryMap.class, "{\"id\":6,\"name\":\"abc\",\"usersCount\":10,\"mid\":3,\"createdAt\":\"2014-09-15 19:02 PM IST\",\"updatedAt\":\"2014-09-15 19:02 PM IST\",\"active\":true,\"searchFeatureEnabled\":true,\"analyticsFeatureEnabled\":false,\"currency\":\"abc\",\"domain\":null,\"source\":\"unknown\",\"sourceDomain\":null,\"tierId\":1}");
//        CompanyCategoryMap expected = new CompanyCategoryMap(6, "abc", 10, 3, );
        // Assert.assertEquals(actual, expected);
    }

    @Test
    public void convertCompanyWithActualJson() throws TMMIDConversionException {
        Company company = jsonUtil.getObjectFromJson(Company.class, "{\"id\":6,\"name\":\"abc\",\"usersCount\":10,\"mid\":3,\"createdAt\":\"2014-09-15 19:02 PM IST\",\"updatedAt\":\"2014-09-15 19:02 PM IST\",\"active\":true,\"searchFeatureEnabled\":true,\"analyticsFeatureEnabled\":false,\"currency\":\"abc\",\"domain\":null,\"source\":\"unknown\",\"sourceDomain\":null,\"tierId\":1}");
    }

    @Test(expected = TMMIDConversionException.class)
    public void convertCompanyWithWrongJson() throws TMMIDConversionException {
        Company company = jsonUtil.getObjectFromJson(Company.class, "{\"id\":6,\"name\":\"abc\",\"usersCount\":10,\"mid\":3,\"createdAt\":\"2014-09-15 19:02 PM IST\",\"updatedAt\":\"2014-09-15 19:02 PM IST\",\"active\":true,\"searchFeatureEnabled\":true,\"analyticsFeatureEnabled\":false,\"currency\":\"abc\",\"domain\":null,\"source\":\"unknown\",\"sourceDomain\":null,\"tierId\":1}");
    }


}
