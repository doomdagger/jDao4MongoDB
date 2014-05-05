package com.fan1tuan.util.gen;

import com.fan1tuan.business.support.enums.*;
import com.fan1tuan.dao.impl.AreaDao;
import com.fan1tuan.dao.impl.DishCommentDao;
import com.fan1tuan.dao.impl.ShopDao;
import com.fan1tuan.dao.support.common.UUIDGenerator;
import com.fan1tuan.pojos.*;
import com.fan1tuan.util.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Li He on 2014/5/4.
 *
 * @author Li He
 */
@Component("dataGenerator")
public class DataGenerator {
    @Autowired
    private AreaDao areaDao;
    @Autowired
    private ShopDao shopDao;
    @Autowired
    private DishCommentDao dishCommentDao;

    public static <T> T randomElement(List<T> list) {

        return list.get(randomInt(list.size()));

    }

    public static <T> T randomElement(T[] array) {
        return array[randomInt(array.length)];
    }

    /**
     * 传入一个int值，返回小于此整型值的任意值，最小值为0
     *
     * @param celling celling value
     * @return random integer lower than celling value
     */
    public static int randomInt(int celling) {

        return (int) (Math.random() * celling);

    }

    public static int randomInt() {

        return randomInt(1000);

    }

    public static boolean randomBool() {

        return randomInt(2) == 0;

    }

    /**
     * 传入一个int值，返回小于此整型值的任意值，最小值为0
     *
     * @param celling celling value
     * @return random double lower than celling value
     */
    public static double randomDouble(int celling) {

        return Math.random() * celling;

    }

    public static double randomDouble() {

        return randomDouble(1000);

    }

    /**
     * 主入口方法，生成假数据
     */
    public void generateData() {

        areaDao.addMultiMix(genAreas());

        shopDao.addMultiMix(genShops(100));

    }

    /**
     * 清空数据
     */
    public void clearData(){

        areaDao.dropCollection();

        shopDao.dropCollection();
    }

    public List<ShopTag> genShopTags() {

        ShopTag fuTag = new ShopTag();
        fuTag.setName("在线支付");
        fuTag.setAlias("付");
        fuTag.setDescription("该餐厅支持在线支付");
        fuTag.setType(ShopTagType.AFFAIR_TAG.ordinal());

        ShopTag piaoTag = new ShopTag();
        piaoTag.setName("开具发票");
        piaoTag.setAlias("票");
        piaoTag.setDescription("该餐厅支持开发票，开票订单金额10元起，请在下单时填写好发票抬头");
        piaoTag.setType(ShopTagType.AFFAIR_TAG.ordinal());

        ShopTag newTag = new ShopTag();
        newTag.setName("新店开张");
        newTag.setAlias("新");
        newTag.setDescription("该餐厅为新店，刚刚入驻");
        newTag.setType(ShopTagType.AFFAIR_TAG.ordinal());

        ShopTag hotTag = new ShopTag();
        hotTag.setName("人气店铺");
        hotTag.setAlias("热");
        hotTag.setDescription("该餐厅为当月人气餐厅，光顾人次爆棚");
        hotTag.setType(ShopTagType.RANK_TAG.ordinal());

        ShopTag saleTag = new ShopTag();
        saleTag.setName("销量惊人");
        saleTag.setAlias("销");
        saleTag.setDescription("该餐厅为当月销售旺铺，售出美食量爆棚");
        saleTag.setType(ShopTagType.RANK_TAG.ordinal());

        ShopTag goodTag = new ShopTag();
        goodTag.setName("好评如潮");
        goodTag.setAlias("评");
        goodTag.setDescription("该店铺在取得不错的销售量的同时，赢得了大家的一致好评");
        goodTag.setType(ShopTagType.RANK_TAG.ordinal());

        return Arrays.asList(goodTag, saleTag, hotTag, newTag, piaoTag, fuTag);
    }

    public List<String> genShopTastes() {

        return Arrays.asList("奶茶", "中式", "西式", "港式", "烧烤", "日式", "韩式", "甜点", "汉堡");

    }

    public List<CouponItem> genCouponItems(int num) {

        List<CouponItem> items = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            CouponItem item = new CouponItem();
            item.setCode(UUIDGenerator.generateUUID());
            item.setExchangeCode(UUIDGenerator.generateUUID());
            item.setExchanged(false);
            item.setExpireDate(DateUtil.getEndOfMonth(new Date()));
            item.setFaceValue(randomInt(15) + 1);
            item.setUsed(false);
            item.setValid(true);

            items.add(item);
        }

        return items;
    }

    public List<Dish> genDishes(int num) {

        List<String> dishCategories = genDishCategories();
        List<DishTag> dishTags = genDishTags();
        List<Dish> dishes = new ArrayList<Dish>();

        String[] description = new String[]{"完美的菜", "这是汇聚中华美食的完美的菜", "这个菜是我们店铺的极品菜"};
        String[] names = new String[]{"扬州炒饭", "牛肉堡", "好吃的堡", "鱼肉炒饭", "A套餐", "虾堡", "牛肉拌饭", "土豆煲仔饭", "蜂蜜柚子茶", "焦糖布丁", "地三鲜盖饭", "红烧茄子盖饭", "鸡蛋炒饭", "尖椒豆腐皮饭", "腊肉炒饭", "西红柿鸡蛋饭", "炝炒圆白菜饭", "什锦炒饭", "地三鲜饭", "尖椒火腿饭", "泡椒鸭血饭", "洋葱鸡蛋饭", "肉沫豆腐饭", "肉沫雷果红饭", "土豆肉丝饭", "芹菜肉丝饭", "辣子鸡丁饭", "酸菜肉丝饭", "酸豇豆肉沫饭", "青椒肉丝", "香菇鸡丝炒河粉", "香菇鸡丝饭", "鱼香猪肝饭", "木耳肉片饭", "油菜肉片", "泡椒肉丝饭", "泡菜肉丝饭", "洋葱肉片饭", "溜肉片饭"};

        int index = 0;
        while (index++ < num) {
            Dish dish = new Dish();
            dish.setSaleVolume(0);
            dish.setAvatar(""); //默认头像
            dish.setAvgCommentLevel(0);
            dish.setCommentLevel(0);
            dish.setCommentNum(0);
            dish.setCreateTime(new Date());
            dish.setDescription(randomElement(description));
            dish.setDishCategory(randomElement(dishCategories));
            dish.setDishId(UUIDGenerator.generateUUID());

            int startIndex = randomInt(dishTags.size() / 2);
            int endIndex = randomInt(dishTags.size() - startIndex) + startIndex + 1;


            dish.setDishTags(dishTags.subList(startIndex, endIndex));
            dish.setFeature(randomBool());
            dish.setName(randomElement(names));
            dish.setOriginalPrice(randomInt(45) + 2);
            dish.setPrice(dish.getOriginalPrice() + 5);

            dish.setStatus(DishStatus.valueOf(randomInt(5)).ordinal());

            dishes.add(dish);
        }

        return dishes;

    }

    public List<Shop> genShops(int num) {

        List<Shop> shops = new ArrayList<Shop>();
        String[] cities = new String[]{"大连", "济南", "成都", "广州", "北京", "青岛", "沈阳", "澳门", "香港", "吉林", "长春", "营口", "上海", "杭州"};
        String[] districts = new String[]{"中山区", "旅顺口区", "沙河口区", "西岗区", "市中区", "皇姑区", "大东区", "历下区", "长清区", "于洪区", "甘井子区", "开发区", "高新区"};
        String[] roads = new String[]{"兴发路", "中山路", "经三路", "纬二路", "北陵大街", "南京街", "威海路", "经一路", "黄河路", "西安路"};

        String announcement = "桂林米粉以 其独特的风味远近闻名。其做工考究，先将上好大米磨成浆，装袋滤干，揣成粉团煮熟后压榨成圆根或片状即成。 圆的称米粉，片状的称切粉，通称米粉，其特点是洁白、细嫩、软滑、爽口。其吃法多样。最讲究卤水的制作，其工艺各家有异，大致以猪、牛骨、罗汉果和各式佐料熬煮而成，香味浓郁。卤水的用料和做法不同，米粉的风味也不同。大致有牛腩粉、三鲜粉、原汤粉、卤菜粉、酸辣粉、马肉米粉等。";

        String description = "优惠活动提前知悉，饿了么朝阳门吃货群QQ群194037715 欢迎大家拍砖，加群并积极发言好礼相送火热夏天饿了么与你同在，让饿了么火一样的热情给您提供最优质的网络订餐服务享受网络订餐的快捷与便利★为了让您及时用餐，请提前40分钟订餐，理解万岁★";

        List<Area> areas = genAreas();
        List<ShopTag> shopTags = genShopTags();
        List<String> phones = new ArrayList<>();
        phones.add("18842627767");
        phones.add("18876765576");
        List<String> shopTastes = genShopTastes();

        String[] names = new String[]{"饭醉团火", "阿福盖浇饭", "小馋猫米粉", "无明缘米粉", "KHC", "上海小吃", "小辣椒", "西北面食", "不差钱炒冷面", "私房牛肉饭", "杨国富麻辣烫", "万里香", "美味烤肉饭", "淼淼烤肉饭", "福记川菜", "香十里", "鑫海汇", "双龙活鱼锅", "蜀九香", "水晶烤肉", "北京烤鸭", "果木烤鸭", "梦福楼", "麻辣村川菜", "成都小吃"};

        String[] closeReason = new String[]{"餐厅已打烊", "餐厅已休假", "餐厅太忙不接受新订单", "美食已售罄"};

        int index = 0;
        while (index++ < num) {
            Shop shop = new Shop();
            shop.setLocation(randomLocation(randomElement(areas).getLocation()));
            shop.setAddress(randomElement(cities) + randomElement(districts) + randomElement(roads));
            shop.setAnnouncement(announcement);
            shop.setAvailableForOrder(randomBool());
            shop.setAvatar("");  //先采用默认头像机制
            shop.setAvgCommentLevel(0);
            shop.setAvgDeliveryTime(0);
            shop.setAvgPersonCost(0);
            shop.setCloseTime(DateUtil.getEndOfDay(new Date()));
            shop.setCommentLevel(0);
            shop.setCommentNum(0);
            shop.setCouponItems(genCouponItems(randomInt(10)));
            shop.setCreateTime(new Date());
            shop.setDescription(description);
            shop.setDishes(genDishes(randomInt(30) + 10));
            shop.setName(randomElement(names));
            shop.setOpenTime(DateUtil.getStartOfDay(new Date()));

            shop.setOrderType(OrderType.valueOf(randomInt(2)).ordinal());
            shop.setShopType(ShopType.valueOf(randomInt(2)).ordinal());

            shop.setPhoneNumbers(phones);

            shop.setPopularity(0);
            shop.setPriceForDelivery(randomInt(20));
            shop.setRadius(randomInt(5000) + 1500);
            shop.setSaleVolume(0);
            shop.setShopSales(new ArrayList<ShopSale>());

            int startIndex = randomInt(shopTags.size() / 2);
            int endIndex = randomInt(shopTags.size() - startIndex) + startIndex + 1;

            shop.setShopTags(shopTags.subList(startIndex, endIndex));
            shop.setShopTastes(Arrays.asList(randomElement(shopTastes)));

            shop.setSupportDelivery(randomBool());
            shop.setUnavailableReason(randomElement(closeReason));


            shops.add(shop);
        }

        return shops;

    }

    public List<DishTag> genDishTags() {

        DishTag dishTag = new DishTag();
        dishTag.setName("送加多宝");
        dishTag.setAlias("宝");
        dishTag.setDescription("购买此套餐或美食送加多宝一瓶");
        dishTag.setType(DishTagType.SALE_TAG.ordinal());

        DishTag dishTag1 = new DishTag();
        dishTag1.setName("打折促销");
        dishTag1.setAlias("折");
        dishTag1.setDescription("此菜品正在打折促销，以低于原价的价格销售");
        dishTag1.setType(DishTagType.SALE_TAG.ordinal());

        DishTag dishTag2 = new DishTag();
        dishTag2.setName("畅销菜品");
        dishTag2.setAlias("销");
        dishTag2.setDescription("此菜品为该店铺的畅销美食");
        dishTag2.setType(DishTagType.RANK_TAG.ordinal());

        DishTag dishTag3 = new DishTag();
        dishTag3.setName("辛辣菜品");
        dishTag3.setAlias("辣");
        dishTag3.setDescription("此菜品味道较辣");
        dishTag3.setType(DishTagType.TASTE_TAG.ordinal());

        return Arrays.asList(dishTag, dishTag1, dishTag2, dishTag3);
    }

    public List<String> genDishCategories() {

        return Arrays.asList("盖饭", "田园时蔬", "汤羹", "炒饭", "米线", "面条", "炒饼炒面", "粉条", "河粉", "精美凉菜", "经典热菜", "锅锅飘香", "精美干锅", "板上飘香");

    }

    public List<Area> genAreas() {

        Area djtue = new Area();
        djtue.setLocation(new double[]{121.17031, 38.800286});
        djtue.setName("大连交通大学（东院）");
        djtue.setRadius(2000);

        Area djtuw = new Area();
        djtuw.setLocation(new double[]{121.162854, 38.798079});
        djtuw.setName("大连交通大学（西院）");
        djtuw.setRadius(2000);

        Area dkju = new Area();
        dkju.setLocation(new double[]{121.159629, 38.789108});
        dkju.setName("大连科技大学");
        dkju.setRadius(2000);

        Area dlmu = new Area();
        dlmu.setLocation(new double[]{121.320489, 38.810001});
        dlmu.setName("大连医科大学");
        dlmu.setRadius(2000);

        Area dflu = new Area();
        dflu.setLocation(new double[]{121.315602, 38.818913});
        dflu.setName("大连外国语大学");
        dflu.setRadius(2000);

        Area dlut = new Area();
        dlut.setLocation(new double[]{121.537043, 38.888651});
        dlut.setName("大连理工大学");
        dlut.setRadius(2000);


        return Arrays.asList(djtue, djtuw, dkju, dlmu, dflu, dlut);

    }

    public double[] randomLocation(double[] location) {

        double longtitude = location[0];
        double latitude = location[1];

        double changeOne = randomDouble(8) / 1000;
        double changeTwo = randomDouble(8) / 1000;

        if (randomBool()) {
            longtitude += changeOne;
        } else {
            longtitude -= changeOne;
        }

        if (randomBool()) {
            latitude += changeTwo;
        } else {
            latitude -= changeTwo;
        }
        return new double[]{longtitude, latitude};

    }

}
