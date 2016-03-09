package com.weileng.self.constant;

public class MkUrl {

	public static String SERVER_ADDRESS_TEST = "http://api.beehood.com:8020/api/";

//	public static String SERVER_ADDRESS_TEST = "http://192.168.1.103:8016/api/";

	/**
	 *  检测用户是否存在
	 */
	public static String USER_IS_EXIST;
	/** 获取验证码 */
	public static String GET_CODE;
	/** 注册 */
	public static String REGISTER;
	/**
	 * 忘记密码
	 */
	public static String FORGET;
	
	/**
	 * 修改密码
	 */
	public static String MODIFY_PWD;
	/**
	 * 会员列表
	 */
	public static String MEMBER_LIST;
	/**
	 * 新增会员
	 */
	public static String ADD_MEMBER;
	/**
	 * 新增会员 放回信息
	 */
	public static String ADD_MEMBER_INFO;
	/**
	 * 删除会员
	 */
	public static String DELETE_MEMBER;
	/**
	 * 新增会员级别
	 */
	public static String ADD_MEMBER_LEVEL;
	/**
	 * 修改会员
	 */
	public static String UPDATE_MEMBER;
	
	/**
	 * 修改会员等级
	 */
	public static String UPDATE_MEMBER_LEVEL;
	/**
	 * 删除会员等级
	 */
	public static String DELETE_MEMBER_LEVEL;
	/**
	 * 会员级别列表
	 */
	public static String MEMBER_LEVEL_LIST;
	/**
	 * 根据id获取member
	 */
	public static String MEMBER_BY_ID;
	
	/**
	 * 会员充值
	 */
	public static String MEMBER_RECHARGE;
	
	/**
	 * 首页统计
	 */
	public static String HOME_TOTAL;
	
	/**
	 * 短信充值商品列表
	 */
	public static String SMS_PRODUCTS;
	
	/**
	 * 短信充值订单
	 */
	public static String SMS_ORDER;
	/**
	 * 意见反馈
	 */
	public static String FEED_BACK;
	
	/**
	 * 帮助页
	 */
	public static String MK_HELP;
	
	/**
	 * 销售列表
	 */
	public static String SALE_LIST;
	/**
	 * 销售详情
	 */
	public static String SALE_DETAIL;
	
	public static String SALE_DETAIL2;
	
	/**
	 * 设置店铺
	 */
	public static String SET_STORE;
	
	/**
	 * 行业列表
	 */
	public static String INDUSTRY;
	/**
	 * 设置
	 */
	public static String SET;
	/**
	 * 获取设置
	 */
	public static String GET;
	
	/**
	 * 通知
	 */
	public static String NOTICE;
	/**
	 * banner
	 */
	public static String BANNER;
	
	/**
	 * 获取会员信息
	 */
	public static String GET_INFO;
	
	/**
	 * 修改用户信息
	 */
	public static String UPDATE_INFO;
	/**
	 * 快速销售
	 */
	public static String QUICK_SELL;
	
	/**
	 * 会员统计
	 */
	public static String MEMBER_REPORT;
	/**
	 * 商品统计
	 */
	public static String COMMODITY_REPORT;
	/**
	 * 通过code得到商品
	 */
	public static String COMMODITY_BY_CODE;
	// 登录
	public static String USER_LOGIN;
	// 商品入库
	public static String SHOP_INTOINVENTORY;
	//添加商品类别
	public static String ADD_COMMODOTY_CLASS;
	//删除商品类别
	public static String DELETE_COMMODOTY_CLASS;
	//修改商品类别
   public static String UPDATE_COMMODOTY_CLASS;
	//库存报警列表
	public static String KC_INTOINVENTORY_LIST;
	//添加商品
	public static String ADD_GOODS;
	// 修改商品
	public static String UPDATE_GOODSMANAGER;
	// 删除商品
	public static String DELETE_GOODSMANAGER;
	// 获取商品列表
	public static String GET_COMMODITY_LIST;
	//获取商品类别
	public static String GET_COMMODITYCATEGORY_LIST;
	/**
	 * 上传图片
	 */
	public static String  UPLOAD_GOODS_IMAGE;
	//删除图片
	public static String DELETE_GOODS_IMAGE;
	/**
	 * 获取支付方式接口
	 */
    public static String  GET_PAYTYPE;
    /**
     * 商品销售
     */
    public static String  PAYFOR_GOODS;
    /**
     * 订单查询
     */
    public static String  QUERY_ORDER;

	static {
//		SERVER_ADDRESS_TEST=SERVER_ADDRESS;
		mySetUrl();// 设置地址
	}

	// 设置地址 后面的方法我们可以调用这个方法
	public static void mySetUrl() {
		
		USER_IS_EXIST = SERVER_ADDRESS_TEST + "account/check/";
		GET_CODE = SERVER_ADDRESS_TEST + "account/ValidateCode/";
		REGISTER = SERVER_ADDRESS_TEST + "account/Register";
		FORGET=SERVER_ADDRESS_TEST+"account/ForgetPwd";
		MEMBER_LIST=SERVER_ADDRESS_TEST+"member/List";
		ADD_MEMBER = SERVER_ADDRESS_TEST + "member/Add";
		ADD_MEMBER_INFO = SERVER_ADDRESS_TEST + "member/AddMember";
		UPDATE_MEMBER = SERVER_ADDRESS_TEST +  "member/Update";
		ADD_MEMBER_LEVEL= SERVER_ADDRESS_TEST + "member/Level/Add";
		UPDATE_MEMBER_LEVEL= SERVER_ADDRESS_TEST + "member/Level/Update";
		DELETE_MEMBER_LEVEL=SERVER_ADDRESS_TEST+"member/Level/Delete";
		MEMBER_LEVEL_LIST=SERVER_ADDRESS_TEST+"member/Level/list";
		MEMBER_BY_ID=SERVER_ADDRESS_TEST+"member/";
		DELETE_MEMBER=SERVER_ADDRESS_TEST+"member/Delete";
		MEMBER_RECHARGE=SERVER_ADDRESS_TEST+"member/Recharge";
		HOME_TOTAL=SERVER_ADDRESS_TEST+"report/home/total";
		SMS_PRODUCTS=SERVER_ADDRESS_TEST+"sys/Sms/products";
		FEED_BACK=SERVER_ADDRESS_TEST+"sys/feedback/add";
		SMS_ORDER=SERVER_ADDRESS_TEST+"sys/Sms/Order/Create";
		//MK_HELP="http://192.168.1.103:8017/help_index.html";
		MK_HELP="http://help.beehood.com:8021/help_index.html";
		SALE_DETAIL=SERVER_ADDRESS_TEST+"sale/";
		SALE_LIST=SERVER_ADDRESS_TEST+"sale/list";
		SET_STORE=SERVER_ADDRESS_TEST+"sys/store/set";
		INDUSTRY=SERVER_ADDRESS_TEST+"sys/Industry/list";
		SET=SERVER_ADDRESS_TEST+"sys/set";
		GET=SERVER_ADDRESS_TEST+"sys/get";
		NOTICE=SERVER_ADDRESS_TEST+"sys/msg/notices";
		BANNER=SERVER_ADDRESS_TEST+"sys/Banner/get";
		GET_INFO=SERVER_ADDRESS_TEST+"sys/user/get";
		UPDATE_INFO=SERVER_ADDRESS_TEST+"sys/user/update";
		QUICK_SELL=SERVER_ADDRESS_TEST+"sale/QuickSale";
		SALE_DETAIL2=SERVER_ADDRESS_TEST+"sale/get/";
		MODIFY_PWD=SERVER_ADDRESS_TEST+"sys/user/pwd";
		MEMBER_REPORT=SERVER_ADDRESS_TEST+"report/member/total";
		COMMODITY_REPORT=SERVER_ADDRESS_TEST+"report/product/total";
		COMMODITY_BY_CODE=SERVER_ADDRESS_TEST+"product/barcode/";
		// 登录
		USER_LOGIN = SERVER_ADDRESS_TEST + "account/Login";
		// 商品入库
		SHOP_INTOINVENTORY = SERVER_ADDRESS_TEST + "product/InStorage";
		// 添加商品类别
		ADD_COMMODOTY_CLASS = SERVER_ADDRESS_TEST + "product/Category/Add";
		// 删除商品类别
		DELETE_COMMODOTY_CLASS = SERVER_ADDRESS_TEST
				+ "product/Category/Delete";
		// 修改商品类别
		UPDATE_COMMODOTY_CLASS = SERVER_ADDRESS_TEST
				+ "product/Category/Update";
		// 库存报警列表
		KC_INTOINVENTORY_LIST = SERVER_ADDRESS_TEST + "product/Alarm/Stocks";
		// 添加商品
		ADD_GOODS = SERVER_ADDRESS_TEST + "product/Add";
		// 修改商品
		UPDATE_GOODSMANAGER = SERVER_ADDRESS_TEST + "product/Update";
		//删除商品
		DELETE_GOODSMANAGER=SERVER_ADDRESS_TEST+"product/Delete";
		// 获取商品列表
		GET_COMMODITY_LIST = SERVER_ADDRESS_TEST + "product/List";
		// 获取商品类别
		GET_COMMODITYCATEGORY_LIST = SERVER_ADDRESS_TEST
				+ "product/Category/list";
		//上传图片接口
		UPLOAD_GOODS_IMAGE=SERVER_ADDRESS_TEST+"file/Upload";
		//删除图片
		DELETE_GOODS_IMAGE=SERVER_ADDRESS_TEST+"file/Delete";
		//获取支付方式
		GET_PAYTYPE=SERVER_ADDRESS_TEST+"sys/Payment/list";
		//销售
		PAYFOR_GOODS=SERVER_ADDRESS_TEST+"sale/Confirm";
		/**
		 * 查询订单
		 */
		QUERY_ORDER=SERVER_ADDRESS_TEST+"order/QueryOrder";
		
	}
}
